package view;


import controller.Client;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class HomePageFrm extends javax.swing.JFrame {
    /**
     * Creates new form GiaoDienChinhFrm
     */
    public HomePageFrm() {
        initComponents();
        this.setTitle("Caro Game");
        this.setIconImage(new ImageIcon("assets/image/caroicon.png").getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        jlblShowNickName.setText(Client.user.getNickname());
        jlblShowNumberOfWin.setText(Integer.toString(Client.user.getNumberOfwin()));
        jlblShowNumberOfGame.setText(Integer.toString(Client.user.getNumberOfGame()));
//        jlblAvatar.setIcon(new ImageIcon("assets/avatar/"+Client.user.getAvatar()+".jpg"));
        btnSendMessage.setIcon(new ImageIcon("assets/image/send2.png"));
        txtAreaShowMessage.setEditable(false);
        if(Client.user.getNumberOfGame()==0){
            jlblShowTiLeThang.setText("-");
        }
        else{
            jlblShowTiLeThang.setText(String.format("%.0f", (float)Client.user.getNumberOfwin()/Client.user.getNumberOfGame()*100)+"%");
        }
        jlblShowNumberOfOver.setText(String.format("%.0f",(float)Client.user.getNumberOfGame()-Client.user.getNumberOfwin()-Client.user.getNumberOfDraw()));
        jlblShowNumberOfDraw.setText(""+Client.user.getNumberOfDraw());
        jlblShowDiem.setText(""+(Client.user.getNumberOfDraw()*5+Client.user.getNumberOfwin()*10));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlblTitle = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlblNickName = new javax.swing.JLabel();
        jlblShowNickName = new javax.swing.JLabel();
        jlblNumberOfGame = new javax.swing.JLabel();
        jlblShowNumberOfGame = new javax.swing.JLabel();
        jlblNumberOfWin = new javax.swing.JLabel();
        jlblShowNumberOfWin = new javax.swing.JLabel();
        jlblNumberOfDraw = new javax.swing.JLabel();
        jlblShowNumberOfDraw = new javax.swing.JLabel();
        jlblTiLeThang = new javax.swing.JLabel();
        jlblShowTiLeThang = new javax.swing.JLabel();
        jlblDiem = new javax.swing.JLabel();
        jlblShowDiem = new javax.swing.JLabel();
        jlblNumberOfOver = new javax.swing.JLabel();
        jlblShowNumberOfOver = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRoom = new javax.swing.JButton();
        btnListFriend = new javax.swing.JButton();
        btnChoiNhanh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaShowMessage = new javax.swing.JTextArea();
        txtInputMessage = new javax.swing.JTextField();
        btnSendMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(15, 20, 155));

        jlblTitle.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        jlblTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblTitle.setText("Game Caro ");

        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát Game");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jlblNickName.setText("NickName");
        jlblNickName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jlblNickNameAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jlblShowNickName.setText("{day la Nick name}");

        jlblNumberOfGame.setText("Số ván đã chơi");

        jlblShowNumberOfGame.setText("{day la so van da choi}");

        jlblNumberOfWin.setText("Số ván thắng");

        jlblShowNumberOfWin.setText("{day la so van thang}");

        jlblNumberOfDraw.setText("Số ván hòa");

        jlblShowNumberOfDraw.setText("{day la so van hoa}");

        jlblTiLeThang.setText("Tỉ lệ thắng");

        jlblShowTiLeThang.setText("{day la ti le thang}");

        jlblDiem.setText("Điểm");

        jlblShowDiem.setText("{day la diem}");

        jlblNumberOfOver.setText("Số ván thua");

        jlblShowNumberOfOver.setText("{day la so van thua}");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlblNickName)
                        .addGap(45, 45, 45)
                        .addComponent(jlblShowNickName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(174, 174, 174))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNumberOfGame, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblNumberOfWin)
                            .addComponent(jlblNumberOfDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblTiLeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblNumberOfOver, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlblShowNumberOfDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(167, 167, 167))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlblShowNumberOfWin, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlblShowNumberOfGame, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(158, 158, 158))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblShowDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblShowTiLeThang))
                                .addContainerGap())
                            .addComponent(jlblShowNumberOfOver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNickName)
                    .addComponent(jlblShowNickName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNumberOfGame)
                    .addComponent(jlblShowNumberOfGame))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblShowNumberOfWin)
                    .addComponent(jlblNumberOfWin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblShowNumberOfOver)
                    .addComponent(jlblNumberOfOver, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNumberOfDraw)
                    .addComponent(jlblShowNumberOfDraw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTiLeThang)
                    .addComponent(jlblShowTiLeThang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblShowDiem)
                    .addComponent(jlblDiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnRoom.setText("Danh sách phòng");
        btnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomActionPerformed(evt);
            }
        });

        btnListFriend.setText("Danh sách bạn bè");
        btnListFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListFriendActionPerformed(evt);
            }
        });

        btnChoiNhanh.setText("Chơi nhanh");
        btnChoiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoiNhanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChoiNhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnChoiNhanh)
                .addGap(18, 18, 18)
                .addComponent(btnRoom)
                .addGap(18, 18, 18)
                .addComponent(btnListFriend)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(220, 240, 255));

        txtAreaShowMessage.setColumns(20);
        txtAreaShowMessage.setRows(5);
        txtAreaShowMessage.setText("<<Tin nhắn và tin tức>>\n");
        jScrollPane1.setViewportView(txtAreaShowMessage);

        txtInputMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInputMessageKeyPressed(evt);
            }
        });

        btnSendMessage.setText("Gửi");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtInputMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSendMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInputMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnSendMessage))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblTitle)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(btnExit))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlblNickNameAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jlblNickNameAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblNickNameAncestorMoved

    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomActionPerformed
//        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.ROOM);
    }//GEN-LAST:event_btnRoomActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            Client.socketHandle.write("offline,"+Client.user.getID());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.LOGIN);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnListFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListFriendActionPerformed
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.FRIENDLIST);
    }//GEN-LAST:event_btnListFriendActionPerformed

    private void btnSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMessageActionPerformed
        sendMessage();
    }//GEN-LAST:event_btnSendMessageActionPerformed

    private void txtInputMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputMessageKeyPressed
        if(evt.getKeyCode() == 10){
            sendMessage();
        }
    }//GEN-LAST:event_txtInputMessageKeyPressed

    private void btnChoiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoiNhanhActionPerformed
        // TODO add your handling code here:
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.FINDROOM);
    }//GEN-LAST:event_btnChoiNhanhActionPerformed

    /**
     * @param args the command line arguments
     */
    private void sendMessage(){
        try {
            if (txtInputMessage.getText().isEmpty()) {
                throw new Exception("Vui lòng nhập nội dung tin nhắn");
            }
            String temp = txtAreaShowMessage.getText();
            temp += "Tôi: " + txtInputMessage.getText() + "\n";
            txtAreaShowMessage.setText(temp);
            Client.socketHandle.write("chat-server," + txtInputMessage.getText());
            txtInputMessage.setText("");
            txtAreaShowMessage.setCaretPosition(txtAreaShowMessage.getDocument().getLength()); //dat vi tri (cua dau nhay) tại chieu dai hien tai
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public void addMessage(String message){
        String temp = txtAreaShowMessage.getText();
        temp+=message+"\n";
        txtAreaShowMessage.setText(temp);
        txtAreaShowMessage.setCaretPosition(txtAreaShowMessage.getDocument().getLength());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoiNhanh;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnListFriend;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRoom;
    private javax.swing.JButton btnSendMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblDiem;
    private javax.swing.JLabel jlblNickName;
    private javax.swing.JLabel jlblNumberOfDraw;
    private javax.swing.JLabel jlblNumberOfGame;
    private javax.swing.JLabel jlblNumberOfOver;
    private javax.swing.JLabel jlblNumberOfWin;
    private javax.swing.JLabel jlblShowDiem;
    private javax.swing.JLabel jlblShowNickName;
    private javax.swing.JLabel jlblShowNumberOfDraw;
    private javax.swing.JLabel jlblShowNumberOfGame;
    private javax.swing.JLabel jlblShowNumberOfOver;
    private javax.swing.JLabel jlblShowNumberOfWin;
    private javax.swing.JLabel jlblShowTiLeThang;
    private javax.swing.JLabel jlblTiLeThang;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextArea txtAreaShowMessage;
    private javax.swing.JTextField txtInputMessage;
    // End of variables declaration//GEN-END:variables
}