
import Database.KoneksiDatabase;
import Database.ResultSetTable;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizky Hanifah
 */
public class Laporan_Peminjam extends javax.swing.JInternalFrame {
    
    ResultSet rs;
    KoneksiDatabase con;
    

    /**
     * Creates new form Form_mobil
     */
    public Laporan_Peminjam() {
        
        con =new KoneksiDatabase(new Database.Parameter().HOST_DB,new Database.Parameter().USERNAME_DB,new Database.Parameter().PASSWORD_DB);
        initComponents();
        loadTabel(); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Print = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepeminjam = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Print.setForeground(new java.awt.Color(255, 255, 255));
        btn_Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        btn_Print.setText("Print ");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 170, 40));

        tablepeminjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Nik", "Nik", "Alamat", "Telp", "Email"
            }
        ));
        tablepeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepeminjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepeminjam);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 940, 220));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Laporan Peminjam");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablepeminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepeminjamMouseClicked
      
    }//GEN-LAST:event_tablepeminjamMouseClicked

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        cetak();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PrintActionPerformed

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
            java.util.logging.Logger.getLogger(Form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_mobil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Form_mobil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_Print;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablepeminjam;
    // End of variables declaration//GEN-END:variables



  

    private void loadTabel() {
        String namaKolom[] = {"id_peminjam","nama","nik","alamat","telp","email"};
        rs=con.querySelect(namaKolom,"tb_peminjam");
        tablepeminjam.setModel(new ResultSetTable(rs));
    }


    public void cetak() {
        try {
            tablepeminjam.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Data Peminjam"), null);
        } catch (PrinterException ex) {
            Logger.getLogger(Form_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

   
}
