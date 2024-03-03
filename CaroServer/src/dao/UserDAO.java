/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DAO{

    public UserDAO() {
        super();
    }
    public User verifyUser(User user) {
        try {
            String sSQL = "select * from \"user\" where username =? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
           /*hoặc như vầy cũng đúng
           PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                  + "FROM \"user\"\n"
                   + "WHERE username = ?\n"
                    + "AND password = ?");
            */
           /*hoặc như vầy  sai chỗ không truy cập được bảng user (có thể lúc đầu sai định dạng chữ tiếng việt nên không nhận dạng đươc)
           PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                  + "FROM user\n"
                   + "WHERE username = ?\n"
                    + "AND password = ?");
            */
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        //rs.getString(4),  //avatar
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        (rs.getInt(8) != 0),
                        (rs.getInt(9) != 0)
//                        getRank(rs.getInt(1))
                );    
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByID(int ID) {
        try {
            String sSQL = "select * from \"user\" where ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
  
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                      
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        (rs.getInt(8) != 0),
                        (rs.getInt(9) != 0)

                );
                        
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(User user) {
        try {
            String sSQL = "insert into \"user\"(username, password, nickname) values(?,?,?)";   //, avatar   ,?
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
       
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNickname());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean checkDuplicated(String username){
        try {
            String sSQL = "select * from \"user\" where username=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
          
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
//    public boolean checkIsBanned(User user)

    
//    public void updateBannedStatus(User user,boolean ban)

    public void updateToOnline(int ID) {
        try {
            String sSQL = "update \"user\" set IsOnline =1 where ID =?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
   
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateToOffline(int ID) {
        try {
            String sSQL = "update \"user\" set IsOnline =0 where ID =?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateToPlaying(int ID){
        try {
            String sSQL = "update \"user\" set IsPlaying =1 where ID =?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
  
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateToNotPlaying(int ID){
        try {
            String sSQL = "update \"user\" set IsPlaying =0 where ID =?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<User> getListFriend(int ID) {
        List<User> ListFriend = new ArrayList<>();
        try {
            String sSQL = "SELECT \"user\".ID, \"user\".nickname, \"user\".IsOnline, \"user\".IsPlaying FROM \"user\" WHERE \"user\".ID IN (SELECT ID_User1 FROM friend WHERE ID_User2=?) OR \"user\".ID IN (SELECT ID_User2 FROM friend WHERE ID_User1=?)";
                    
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, ID);
            preparedStatement.setInt(2, ID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ListFriend.add(new User(rs.getInt(1),
                        rs.getString(2),
                        (rs.getInt(3)==1),
                        (rs.getInt(4))==1));
            }
            ListFriend.sort(new Comparator<User>(){
                @Override
                public int compare(User o1, User o2) {
                    if(o1.getIsOnline()&&!o2.getIsOnline())
                        return -1;
                    if(o1.getIsPlaying()&&!o2.getIsOnline())
                        return -1;
                    if(!o1.getIsPlaying()&&o1.getIsOnline()&&o2.getIsPlaying()&&o2.getIsOnline())
                        return -1;
                    return 0;
                }
                
            });
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ListFriend;
    }

    public boolean checkIsFriend(int ID1, int ID2) {
        try {
            String sSQL = "SELECT friend.ID_User1 FROM friend where (ID_User1 =? AND ID_User2=?) OR (ID_User1=? AND ID_User2=?)";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, ID1);
            preparedStatement.setInt(2, ID2);
            preparedStatement.setInt(3, ID2);
            preparedStatement.setInt(4, ID1);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public void addFriendShip(int ID1, int ID2){
        try {
            String sSQL = "insert into friend (ID_User1, ID_User2) values (?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
       
            preparedStatement.setInt(1, ID1);
            preparedStatement.setInt(2, ID2);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void removeFriendship(int ID1, int ID2){
        try {
            String sSQL = "DELECTE FROM friend WHERE (ID_User1 =?  AND ID_User2=?) OR (ID_User1 =?  AND ID_User2=?)";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
      
            preparedStatement.setInt(1, ID1);
            preparedStatement.setInt(2, ID2);
            preparedStatement.setInt(3, ID2);
            preparedStatement.setInt(4, ID1);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public int getRank(int ID) 

//    public List<User> getUserStaticRank() 

    public void makeFriend(int ID1, int ID2) {
        try {
            String sSQL = "INSERT INTO friend(ID_User1, ID_User2) values(?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);

            preparedStatement.setInt(1, ID1);
            preparedStatement.setInt(2, ID2);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getNumberOfWin(int ID) {
        try {
            String sSQL = "SELECT \"user\".numberOfWin FROM \"user\" WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
 
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    public int getNumberOfDraw(int ID) {
        try {
            String sSQL = "SELECT \"user\".numberOfDraw FROM \"user\" WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    
    public void addDrawGame(int ID){
        try {
            String sSQL = "UPDATE \"user\" SET \"user\".numberOfDraw=? WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, new UserDAO().getNumberOfDraw(ID)+1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addWinGame(int ID){
        try {
            String sSQL = "UPDATE \"user\" SET \"user\".numberOfWin=? WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, new UserDAO().getNumberOfWin(ID)+1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getNumberOfGame(int ID) {
        try {
            String sSQL = "SELECT \"user\".numberOfGame FROM \"user\" WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
      
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    public void addGame(int ID) {
        try {
            String sSQL = "UPDATE \"user\" SET \"user\".numberOfGame=? WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
   
            preparedStatement.setInt(1, new UserDAO().getNumberOfGame(ID) + 1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void decreaseGame(int ID){
        try {
            String sSQL = "UPDATE \"user\" SET \"user\".numberOfGame=? WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
    
            preparedStatement.setInt(1, new UserDAO().getNumberOfGame(ID) - 1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getNickNameByID(int ID) {
        try {
            String sSQL = "SELECT \"user\".nickname FROM \"user\" WHERE \"user\".ID=?";
            PreparedStatement preparedStatement = con.prepareStatement(sSQL);
   
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
