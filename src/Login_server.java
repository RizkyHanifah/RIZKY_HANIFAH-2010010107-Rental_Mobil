/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Database.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rizky Hanifah
 */
public class Login_server extends javax.swing.JFrame {

    ResultSet rs;
    KoneksiDatabase con;
    String id_user;
    String hak;

    /**
     * Creates new form display
     */
    public Login_server() {
        con = new KoneksiDatabase(new Database.Parameter().HOST_DB, new Database.Parameter().USERNAME_DB, new Database.Parameter().PASSWORD_DB);
        initComponents();
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlass1 = new usu.widget.glass.PanelGlass();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        btn_login = new usu.widget.ButtonGlass();
        btn_close = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 204));
        setUndecorated(true);
        setSize(new java.awt.Dimension(600, 297));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGlass1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelGlass1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 35, 205, -1));

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        panelGlass1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 73, 205, -1));

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/key_login.png"))); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        panelGlass1.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 100, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close_delete.png"))); // NOI18N
        btn_close.setText("Keluar");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        panelGlass1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel1.setText("PASSWORD");
        panelGlass1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 76, 77, -1));

        jLabel3.setText("USERNAME");
        panelGlass1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 38, 77, -1));

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 320, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass2ActionPerformed
    }//GEN-LAST:event_buttonGlass2ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        try {
            rs = con.querySelectAll("user", "username='" + txt_username.getText() + "' and password='" + txt_password.getText() + "'");
            while (rs.next()) {
                id_user = rs.getString("id_user");

                hak = rs.getString("type");
            }
        } catch (SQLException ex) {
        }

        if (id_user != null) {

            this.dispose();
            if (hak.equals("Admin")) {
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                Home h = new Home();
                h.setVisible(true);
                h.admin();
            } else {
                JOptionPane.showMessageDialog(this, "Login Berhasil");
                Home h = new Home();
                h.setVisible(true);
                h.user();
            }


        } else {
            JOptionPane.showMessageDialog(this, "Login Gagal, Coba Lagi!!");
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Login_server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_close;
    private usu.widget.ButtonGlass btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}