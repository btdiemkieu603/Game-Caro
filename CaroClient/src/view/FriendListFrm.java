/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.Client;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import model.User;

/**
 *
 * @author Admin
 */
public class FriendListFrm extends javax.swing.JFrame {
    private List<User> listFriend;
    private boolean isClicked;
    private Thread thread;
    DefaultTableModel defaultTableModel;
    /**
     * Creates new form FriendListFrm
     */
    public FriendListFrm() {
        initComponents();
        defaultTableModel = (DefaultTableModel) jTableListFriend.getModel();
        this.setTitle("Caro Game");
        this.setIconImage(new ImageIcon("assets/image/caroicon.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        isClicked = false;
        requestUpdate();
        startThread();
    }
    
    public void stopAllThread(){
       isClicked=true;
    }
    
    public void startThread(){
        thread = new Thread() {
            @Override
            public void run() {
                while (Client.friendListFrm.isDisplayable()&&!isClicked) {
                    try {
                        System.out.println("Xem danh sách bạn bè đang chạy!");
                        requestUpdate();
                        Thread.sleep(7000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }
    public void requestUpdate(){
        try {
            Client.socketHandle.write("view-friend-list,");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    public void updateFriendList(List<User> friends){
        listFriend = friends;
        defaultTableModel.setRowCount(0);
        ImageIcon icon;
        for(User friend : listFriend){
            if(!friend.isIsOnline()){
                icon = new ImageIcon("assets/icon/Noonline.PNG");
            }
            else if(friend.isIsPlaying()){
                icon = new ImageIcon("assets/icon/đấu.PNG");
            }
            else{
                icon = new ImageIcon("assets/icon/đấu_online.PNG");
            }
            defaultTableModel.addRow(new Object[]{
                ""+friend.getID(),
                friend.getNickname(),
                icon
            });
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblTitle = new javax.swing.JLabel();
        btnTroVe = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Object[][] rows = {
        };
        String[] columns = {"ID","Nickname",""};
        DefaultTableModel model = new DefaultTableModel(rows, columns){
            @Override
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0: return String.class;
                    case 1: return String.class;
                    case 2: return ImageIcon.class;
                    default: return Object.class;
                }
            }
        };
        jTableListFriend = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(445, 522));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(15, 20, 155));

        jlblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitle.setText("Danh sách bạn bè");

        btnTroVe.setText("X");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        jTableListFriend.setBackground(new java.awt.Color(220, 240, 255));
        jTableListFriend.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTableListFriend.setModel(model);
        jTableListFriend.setRowHeight(60);
        jTableListFriend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListFriendMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableListFriend);
        if (jTableListFriend.getColumnModel().getColumnCount() > 0) {
            jTableListFriend.getColumnModel().getColumn(0).setMinWidth(60);
            jTableListFriend.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableListFriend.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableListFriend.getColumnModel().getColumn(1).setMinWidth(240);
            jTableListFriend.getColumnModel().getColumn(1).setPreferredWidth(240);
            jTableListFriend.getColumnModel().getColumn(1).setMaxWidth(240);
            jTableListFriend.getColumnModel().getColumn(2).setMinWidth(120);
            jTableListFriend.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableListFriend.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTroVe))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnTroVe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(428, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        Client.closeView(Client.View.FRIENDLIST);
        Client.openView(Client.View.HOMEPAGE);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void jTableListFriendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListFriendMouseClicked
        try {
            if(jTableListFriend.getSelectedRow()==-1) return;
            User friend = listFriend.get(jTableListFriend.getSelectedRow());
            if(!friend.isIsOnline()){
                throw new Exception("Người chơi không online");
            }
            if(friend.isIsPlaying()){
                throw new Exception("Người chơi đang trong trận đấu");
            }
            isClicked = true;
            int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thách đấu người bạn này không", "Xác nhận thách đầu", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                Client.closeAllViews();
                Client.openView(Client.View.GAMENOTICE, "Thách đấu", "Đang chờ phản hồi từ đối thủ");
                Client.socketHandle.write("duel-request,"+friend.getID());
            }
            else{
                isClicked = false;
                startThread();
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_jTableListFriendMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTroVe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableListFriend;
    private javax.swing.JLabel jlblTitle;
    // End of variables declaration//GEN-END:variables
}