/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Billing extends javax.swing.JFrame {
    public int serviceCharge=5000;
    public int totalPrice=0;
    /**
     * Creates new form Billing
     */
    public Billing() {
        initComponents();
        Toolkit toolkit= getToolkit();
        Dimension size= toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2- getHeight()/2);
        fillForm();
    }
    
    public void fillForm(){
        //public Connection connection;
        PreparedStatement pst;
        ResultSet rs;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MyEventPlanner;selectMethod=cursor", "sa", "123456");
            pst= connection.prepareStatement("select Price from Photographer where Photographer_ID=(Select PhotographerID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            int price= rs.getInt("Price");
            totalPrice+=price;
            jTextField6.setText(price+" tk");            
            
            }
            
            
            
            
            pst= connection.prepareStatement("select Price from Musician where Musician_ID="
                    + "(Select MusicianID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            int price= rs.getInt("Price");
            totalPrice+=price;
            jTextField7.setText(price+" tk");            
            
            }
            
            
            
            
            pst= connection.prepareStatement("select Price from Decorator where Decorator_ID="
                    + "(Select DecoratorID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            int price= rs.getInt("Price");
            totalPrice+=price;
            jTextField4.setText(price+" tk");            
            
            }
            
            
            
            
            pst= connection.prepareStatement("Select MAX(EventID) from Event");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt(1);
            jTextField2.setText(String.valueOf(id));            
            
            }
            
            
            
            pst= connection.prepareStatement("select Name from Customer where Cus_ID="
                    + "(Select CustomerID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            String Name= rs.getString("Name");
            jTextField1.setText(Name);            
            }
            
            
            
            
            pst= connection.prepareStatement("select Price from Theme where ThemeID="
                    + "(Select ThemeID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            int price= rs.getInt("Price");
            totalPrice+=price;
            jTextField5.setText(price+" tk");            
            
            }
            
            int MenuPrice=0, GuestNumber=0, CateringPrice;
            
            pst= connection.prepareStatement("select Price from Menu where MenuID="
                    + "(Select MenuID from Event where EventID in (Select MAX(EventID) from Event))");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            MenuPrice= rs.getInt("Price");            
            
            }
            //System.out.println(MenuPrice+" lol");
            
            pst= connection.prepareStatement("select GuestNumber from\n" +
"                    Event where EventID in (Select MAX(EventID) from Event)");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            
            GuestNumber= rs.getInt("GuestNumber");            
            
            }
            CateringPrice=GuestNumber*MenuPrice;
            //System.out.println(CateringPrice+" lol");
            //System.out.println(GuestNumber+" glol");
            jTextField3.setText(String.valueOf(CateringPrice+ " tk"));
            totalPrice+=CateringPrice;
            jTextField8.setText(String.valueOf(serviceCharge)+" tk");
            totalPrice+=serviceCharge;
            
        }catch(Exception e){
        
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    Connection connection;
    PreparedStatement pst;  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 0, 51));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/event/planner/Asset 3.png"))); // NOI18N
        jLabel1.setText("Receipt");

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 153));
        jLabel2.setText("Customer Name: ");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 153));
        jLabel3.setText("Event ID: ");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 153));
        jLabel4.setText("Catering Price");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 153));
        jLabel5.setText("Decorator Price");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 153));
        jLabel6.setText("Theme Price:");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 153));
        jLabel7.setText("Photographer Price:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 153));
        jLabel8.setText("Musician Price:");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 153));
        jLabel9.setText("Service Charge:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 153));
        jLabel10.setText("Total Payment:");

        jTextField1.setBackground(new java.awt.Color(255, 204, 153));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(255, 204, 153));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(255, 204, 153));

        jTextField4.setBackground(new java.awt.Color(255, 204, 153));

        jTextField5.setBackground(new java.awt.Color(255, 204, 153));

        jTextField6.setBackground(new java.awt.Color(255, 204, 153));

        jTextField7.setBackground(new java.awt.Color(255, 204, 153));

        jTextField8.setBackground(new java.awt.Color(255, 204, 153));

        jTextField9.setBackground(new java.awt.Color(255, 204, 153));

        jButton2.setBackground(new java.awt.Color(255, 204, 153));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 51));
        jButton2.setText("Calculate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(255, 204, 153));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Make Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 97, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField9.setText(String.valueOf(totalPrice)+" tk");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Paid_Due_Page fromtwo = new Paid_Due_Page();
        fromtwo.txtid.setText(jTextField1.getText());
        fromtwo.txtpayment.setText(jTextField9.getText());
        fromtwo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    private String getFirstWord(String text) {

        int index = text.indexOf(' ');

        if (index > -1) { // Check if there is more than one word.

            return text.substring(0, index).trim(); // Extract first word.

        } else {

            return text; // Text is the first word itself.
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
