/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javax.swing.JFrame;
import model.User;

import view.CreateRoomPasswordFrm;
import view.FindRoomFrm;
import view.FriendListFrm;
import view.FriendRequestFrm;
import view.GameClientFrm;
import view.GameNoticeFrm;

import view.HomePageFrm;
import view.JoinRoomPasswordFrm;
import view.LoginFrm;
import view.RoomFrm;
import view.RegisterFrm;
import view.RoomListFrm;


import view.WaitingRoomFrm;

/**
 *
 * @author Admin
 */
public class Client {
    public enum View{
        LOGIN,
        REGISTER,
        HOMEPAGE,
        ROOMLIST,
        FRIENDLIST,
        FINDROOM,
        WAITINGROOM,
        GAMECLIENT,
        CREATEROOMPASSWORD,
        JOINROOMPASSWORD,
        COMPETITORINFO,
        ROOM,
        GAMENOTICE,
        FRIENDREQUEST,

    }
    public static User user;
    
    //Danh sách giao diện
    public static LoginFrm loginFrm;
    public static RegisterFrm registerFrm;
    public static HomePageFrm homePageFrm;
    public static RoomListFrm roomListFrm;
    public static FriendListFrm friendListFrm;
    public static FindRoomFrm findRoomFrm;
    public static WaitingRoomFrm waitingRoomFrm;
    public static GameClientFrm gameClientFrm;
    public static CreateRoomPasswordFrm createRoomPasswordFrm;
    public static JoinRoomPasswordFrm joinRoomPasswordFrm;

    public static RoomFrm roomFrm;
    public static GameNoticeFrm gameNoticeFrm;
    public static FriendRequestFrm friendRequestFrm;

    //Thiết lập socket
    public static SocketHandle socketHandle;
    
    public Client() {
    }

    public static JFrame getVisibleJFrame(){
        if(roomListFrm!=null&&roomListFrm.isVisible())
            return roomListFrm;
        if(friendListFrm!=null&&friendListFrm.isVisible()){
            return friendListFrm;
        }
        if(createRoomPasswordFrm!=null&&createRoomPasswordFrm.isVisible()){
            return createRoomPasswordFrm;
        }
        if(joinRoomPasswordFrm!=null&&joinRoomPasswordFrm.isVisible()){
            return joinRoomPasswordFrm;
        }
        if(roomFrm!=null&&roomFrm.isVisible()){
            return roomFrm;
        }
        return homePageFrm;
    }
    public void initView(){
        
        loginFrm = new LoginFrm();
        loginFrm.setVisible(true);
        socketHandle = new SocketHandle();
        socketHandle.run();
    }
    
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm = new LoginFrm();
                    loginFrm.setVisible(true);
                    break;
                case REGISTER:
                    registerFrm = new RegisterFrm();
                    registerFrm.setVisible(true);
                    break;
                case HOMEPAGE:
                    homePageFrm = new HomePageFrm();
                    homePageFrm.setVisible(true);
                    break;
                case ROOMLIST:
                    roomListFrm = new RoomListFrm();
                    roomListFrm.setVisible(true);
                    break;
                case FRIENDLIST:
                    friendListFrm = new FriendListFrm();
                    friendListFrm.setVisible(true);
                    break;
                case FINDROOM:
                    findRoomFrm = new FindRoomFrm();
                    findRoomFrm.setVisible(true);
                    break;
                case WAITINGROOM:
                    waitingRoomFrm = new WaitingRoomFrm();
                    waitingRoomFrm.setVisible(true);
                    break;
                
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm = new CreateRoomPasswordFrm();
                    createRoomPasswordFrm.setVisible(true);
                    break;
                case ROOM:
                    roomFrm = new RoomFrm();
                    roomFrm.setVisible(true);
                    break;

            }
        }
    }
    public static void openView(View viewName, int arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm = new JoinRoomPasswordFrm(arg1, arg2);
                    joinRoomPasswordFrm.setVisible(true);
                    break;
                case FRIENDREQUEST:
                    friendRequestFrm = new FriendRequestFrm(arg1, arg2);
                    friendRequestFrm.setVisible(true);
            }
        }
    }
    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP){
        if(viewName != null){
            switch(viewName){
                case GAMECLIENT:
                    gameClientFrm = new GameClientFrm(competitor, room_ID, isStart, competitorIP);
                    gameClientFrm.setVisible(true);
                    break;
            }
        }
    }

    public static void openView(View viewName, String arg1, String arg2){
        if(viewName != null){
            switch(viewName){
                case GAMENOTICE:
                    gameNoticeFrm = new GameNoticeFrm(arg1, arg2);
                    gameNoticeFrm.setVisible(true);
                    break;
                case LOGIN:
                    loginFrm = new LoginFrm(arg1, arg2);
                    loginFrm.setVisible(true);
            }
        }
    }
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case LOGIN:
                    loginFrm.dispose();
                    break;
                case REGISTER:
                    registerFrm.dispose();
                    break;
                case HOMEPAGE:
                    homePageFrm.dispose();
                    break;
                case ROOMLIST:
                    roomListFrm.dispose();
                    break;
                case FRIENDLIST:
                    friendListFrm.stopAllThread();
                    friendListFrm.dispose();
                    break;
                case FINDROOM:
                    findRoomFrm.stopAllThread();
                    findRoomFrm.dispose();
                    break;
                case WAITINGROOM:
                    waitingRoomFrm.dispose();
                    break;
                case GAMECLIENT:
                    gameClientFrm.stopAllThread();
                    gameClientFrm.dispose();
                    break;
                case CREATEROOMPASSWORD:
                    createRoomPasswordFrm.dispose();
                    break;
                case JOINROOMPASSWORD:
                    joinRoomPasswordFrm.dispose();
                    break;

                case ROOM:
                    roomFrm.dispose();
                    break;
                case GAMENOTICE:
                    gameNoticeFrm.dispose();
                    break;
                case FRIENDREQUEST:
                    friendRequestFrm.dispose();
                    break;

            }
            
        }
    }
    
    public static void closeAllViews(){
        if(loginFrm!=null) loginFrm.dispose();
        if(registerFrm!=null) registerFrm.dispose();
        if(homePageFrm!=null) homePageFrm.dispose();
        if(roomListFrm!=null) roomListFrm.dispose();
        if(friendListFrm!=null){
            friendListFrm.stopAllThread();
            friendListFrm.dispose();
        } 
        if(findRoomFrm!=null){
            findRoomFrm.stopAllThread();
            findRoomFrm.dispose();
        } 
        if(waitingRoomFrm!=null) waitingRoomFrm.dispose();
        if(gameClientFrm!=null){
            gameClientFrm.stopAllThread();
            gameClientFrm.dispose();
        } 
        if(createRoomPasswordFrm!=null) createRoomPasswordFrm.dispose();
        if(joinRoomPasswordFrm!=null) joinRoomPasswordFrm.dispose();

        if(roomFrm!=null) roomFrm.dispose();
        if(gameNoticeFrm!=null) gameNoticeFrm.dispose();
        if(friendRequestFrm!=null) friendRequestFrm.dispose();

    }
    public static void main(String[] args) {
        new Client().initView();
    }
}
