/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */

public class CreateEvent extends javax.swing.JFrame {

    /**
     * Creates new form CreateEvent
     */
    //public Connection connection;
    //public int pID, mID, dID, tID, mID, cID;
    ArrayList<PhotoTemp> p;
    
    public CreateEvent() {
        initComponents();
        Toolkit toolkit= getToolkit();
        Dimension size= toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2- getHeight()/2);
        fillCombo();
        
    }
    
    public void fillCombo(){
        //public Connection connection;
        PreparedStatement pst;
        ResultSet rs;
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Hey");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MyEventPlanner;selectMethod=cursor", "sa", "123456");
            pst= connection.prepareStatement("select * from Photographer");
            rs= pst.executeQuery();
            
            while(rs.next()){
            
            String name= rs.getString("Name");
            int price= rs.getInt("Price");
            int exp=rs.getInt("Experience");
            int id= rs.getInt("Photographer_ID");
            photographer.addItem(id+". "+name+" - "+exp + " years"+ " - "+price + " tk");
            
            
//            PhotoTemp photo1= new PhotoTemp(id, name, price, exp);
//            //PhotoTemp photo1= new PhotoTemp();
//            photo1.setID(id);
//            photo1.setName(name);
//            photo1.setExperience(exp);
//            photo1.setPrice(price);
//            p.add(id, photo1);
            
            
            }
            
            
            
            
            pst= connection.prepareStatement("select * from Musician");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("Musician_ID");
            String name= rs.getString("Name");
            String price= rs.getString("Price");
            musician.addItem(id+". "+name+" - "+price + " tk");
                     
            }
            
            
            pst= connection.prepareStatement("select * from Decorator");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("Decorator_ID");
            String name= rs.getString("Name");
            String price= rs.getString("Price");
            decorator.addItem(id+". "+name+" - "+price + " tk");
                     
            }
            
            
            pst= connection.prepareStatement("select * from Customer");
            rs= pst.executeQuery();
            
            while(rs.next()){
            String name= rs.getString("Name");
            String address= rs.getString("Address");
            int id= rs.getInt("Cus_ID");
            customer.addItem(id+". "+name + " - " +address);
                     
            }
            
            
            
            pst= connection.prepareStatement("select * from Type");
            rs= pst.executeQuery();
            
            while(rs.next()){
            String name= rs.getString("TypeName");
            //String address= rs.getString("Address");
            int id= rs.getInt("TypeID");
            type.addItem(id+".  "+name);
                     
            }
            
            
            pst= connection.prepareStatement("select * from Menu");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("MenuID");
            int price= rs.getInt("Price");
            String name= rs.getString("Cuisine");
            //String address= rs.getString("Address");
            //int id= rs.getInt("Cus_ID");
            menu.addItem(id+". "+name+" - "+ price+ " tk");
                     
            }
            
            pst= connection.prepareStatement("select * from Theme");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("ThemeID");
            int price= rs.getInt("Price");
            String name= rs.getString("ThemeName");
            String color= rs.getString("Color");
            //String address= rs.getString("Address");
            //int id= rs.getInt("Cus_ID");
            theme.addItem(id+". "+name+" - "+ color + " - " + price+ " tk");
                     
            }
            
        }catch(Exception e){
        
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
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        customer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        theme = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        decorator = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        photographer = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        musician = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        menu = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(759, 792));
        setPreferredSize(new java.awt.Dimension(1366, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(551, 551));
        jPanel1.setPreferredSize(new java.awt.Dimension(759, 792));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(102, 0, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/event/planner/back_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 153));
        jLabel9.setText("General Info");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 270, 46));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 153));
        jLabel1.setText("Event Title");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 153));
        jLabel2.setText("Event Date");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 153));
        jLabel5.setText("Customer");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        customer.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 160, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 153));
        jLabel3.setText("Event Type");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        type.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 160, 20));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 153));
        jLabel12.setText("Theme");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        theme.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(theme, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 160, -1));

        jLabel14.setText("Stage Image Here");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 153));
        jLabel6.setText("Decorator");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 58, -1));

        decorator.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(decorator, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 166, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 153));
        jLabel7.setText("Photographer");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        photographer.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(photographer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 166, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 153));
        jLabel8.setText("Musician");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        musician.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(musician, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 166, -1));

        jButton4.setBackground(new java.awt.Color(255, 204, 153));
        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 40, -1));

        jButton3.setBackground(new java.awt.Color(255, 204, 153));
        jButton3.setText("+");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 204, 153));
        jButton5.setText("+");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 40, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 204, 153));
        jCheckBox1.setSelected(true);
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(255, 204, 153));
        jCheckBox2.setSelected(true);
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseClicked(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 530, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 153));
        jLabel10.setText("Menu");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 153));
        jLabel4.setText("Number of Guests");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jTextField2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 180, -1));

        menu.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 180, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 153));
        jLabel11.setText("Cuisine");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 153));
        jLabel13.setText("Description");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        jTextArea1.setBackground(new java.awt.Color(255, 204, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 180, 110));

        jButton1.setBackground(new java.awt.Color(255, 204, 153));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 51));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 180, 60));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 153));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/event/planner/Asset 3.png"))); // NOI18N
        jLabel15.setText("Create Event");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jDateChooser1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 792));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    //Variables
        ConnectMSSQL cnObj= new ConnectMSSQL();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat day= new SimpleDateFormat("yyyyMMdd");
        //int dayID= Integer.parseInt(day.format(jDateChooser1.getDate()));
        String date = sdf.format(jDateChooser1.getDate());
        //String date = sdf.format(jDateChooser1.getDate());
        String title= jTextField1.getText();
        int cID= Integer.parseInt(getFirstWord(customer.getSelectedItem().toString()));
        int typeID= Integer.parseInt(getFirstWord(type.getSelectedItem().toString()));
        int themeID= Integer.parseInt(getFirstWord(theme.getSelectedItem().toString()));
        int numOfGuests= Integer.parseInt(jTextField2.getText());
        int dID= Integer.parseInt(getFirstWord(decorator.getSelectedItem().toString()));
        int musID= Integer.parseInt(getFirstWord(musician.getSelectedItem().toString()));
        int pID= Integer.parseInt(getFirstWord(photographer.getSelectedItem().toString()));
        int menuID= Integer.parseInt(getFirstWord(menu.getSelectedItem().toString()));
        String desc=jTextArea1.getText();
        //System.out.println("hehe " + p.get(id).getID());
        System.out.println("cID:  "+cID);
//      int menuID= Integer.parseInt(jTextField3.getText());
        
//Time COnvertion        
//        float startTime, endTime;
//        if(jComboBox3.getSelectedItem().toString().equals("pm")) startTime=(float) jSpinField1.getValue()+12+(float) jSpinField2.getValue()/60;
//        else startTime=(float) jSpinField1.getValue()+(float) jSpinField2.getValue()/60;
//        if(jComboBox4.getSelectedItem().toString().equals("pm")) endTime=(float) jSpinField4.getValue()+12+(float) jSpinField3.getValue()/60;
//        else endTime=(float) jSpinField1.getValue()+(float) jSpinField2.getValue()/60;
        
        boolean gotResults;
        
//connection
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MyEventPlanner;selectMethod=cursor", "sa", "123456");       
            
            Statement statement = connection.createStatement();
//            gotResults = statement.execute(date);
//            ResultSet resultSet=null;
//            if(!gotResults){
//             System.out.println("No results returned");
//             } else {
//                resultSet = statement.getResultSet();
//             }


            //statement.executeQuery("INSERT into Event (EventDate) values('"+date+"')");
            //statement.executeQuery("INSERT into Event (  EventName, EventCategory, Priority, StartTime, EndTime ) values('"+jTextField1.getText()+"','"+jComboBox2.getSelectedItem().toString()+"','"+jComboBox1.getSelectedItem().toString()+"','"+startTime+"','"+endTime+"')");
            
            
            String query="INSERT into Event ( EventName, Date, ThemeID, PhotographerID, TypeID, MenuID, DecoratorID, CustomerID, MusicianID, GuestNumber, Description ) values('"+title+"','"+date+"','"+themeID+"','"+pID+"','"+typeID+"','"+menuID+"','"+dID+"','"+cID+"','"+musID+"','"+numOfGuests+"','"+desc+"')";
            if(jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
            }
            else if(!jCheckBox1.isSelected()){
                query="INSERT into Event ( EventName, Date, ThemeID, TypeID, MenuID, DecoratorID, CustomerID, MusicianID, GuestNumber, Description ) values('"+title+"','"+date+"','"+themeID+"','"+typeID+"','"+menuID+"','"+dID+"','"+cID+"','"+musID+"','"+numOfGuests+",'"+desc+"')";
            }else if(!jCheckBox2.isSelected()){
                query="INSERT into Event ( EventName, Date, ThemeID, PhotographerID, TypeID, MenuID, DecoratorID, CustomerID, GuestNumber, Description ) values('"+title+"','"+date+"','"+themeID+"','"+pID+"','"+typeID+"','"+menuID+"','"+dID+"','"+cID+"','"+numOfGuests+"','"+desc+")";
            }else query="INSERT into Event ( EventName, Date, ThemeID, TypeID, MenuID, DecoratorID, CustomerID, GuestNumber, Description ) values('"+title+"','"+date+"','"+themeID+"','"+typeID+"','"+menuID+"','"+dID+"','"+cID+"','"+numOfGuests+",'"+desc+"')";
            statement.executeQuery(query);
            
//            while (resultSet.next()) {
//                
//                System.out.println("Customer NAME:" + 
//                        resultSet.getString("FirstName"));
//                
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Event Created");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new User().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
//        if(jCheckBox1.isSelected()){
//            photographer.setEnabled(true);
//        }else {photographer.setEnabled(false);
//            System.out.println("inside click");
//        }
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if(jCheckBox1.isSelected()){
            photographer.setEnabled(true);
        }else {photographer.setEnabled(false);
            System.out.println("inside click");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
//        if(jCheckBox2.isSelected()){
//            musician.setEnabled(true);
//        }else musician.setEnabled(false);
    }//GEN-LAST:event_jCheckBox2MouseClicked

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        if(jCheckBox2.isSelected()){
            musician.setEnabled(true);
        }else{ musician.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox2ItemStateChanged
    private String getFirstWord(String text) {

        int index = text.indexOf('.');

        if (index > -1) { // Check if there is more than one word.

            return text.substring(0, index).trim(); // Extract first word.

        } else {

            return text; // Text is the first word itself.
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JComboBox<String> decorator;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> menu;
    private javax.swing.JComboBox<String> musician;
    private javax.swing.JComboBox<String> photographer;
    private javax.swing.JComboBox<String> theme;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
