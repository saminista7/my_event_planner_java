/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;

import com.sun.java.accessibility.util.EventID;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class EventManager extends javax.swing.JFrame {

    /**
     * Creates new form EditEvent
     */
    public EventManager() {
        initComponents();
        fillCombo();
        showTable("EventID");
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
            photographer.addItem(id+". "+name);
            
            
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
            musician.addItem(id+". "+name);
                     
            }
            
            
            pst= connection.prepareStatement("select * from Decorator");
            rs= pst.executeQuery();
            
            while(rs.next()){
            int id= rs.getInt("Decorator_ID");
            String name= rs.getString("Name");
            String price= rs.getString("Price");
            decorator.addItem(id+". "+name);
                     
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
            type.addItem(id+". "+name);
                     
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
            theme.addItem(id+". "+name+" - "+ color);
                     
            }
            
        }catch(Exception e){
        
        }
    }
    
    
    
    public void showTable(String sort)
    {
        PreparedStatement pst;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=MyEventPlanner;selectMethod=cursor", "sa", "123456");
            pst = connection.prepareStatement("SELECT E.EventID, E.EventName, Date, C.Name, C.Phone, C.Address, TY.TypeName,TH.ThemeName, GuestNumber, MEN.Cuisine, E.Description,\n" +
"MEN.Price, P.Name, P.Price, D.Name, D.Price, MUS.Name, MUS.Price, C.Cus_ID, TY.TypeID, TH.ThemeID, TH.Color, P.Photographer_ID, D.Decorator_ID, MUS.Musician_ID, MEN.MenuID \n" +
"FROM Event as E\n" +
"JOIN Customer C ON C.Cus_ID = E.CustomerID\n" +
"full JOIN Photographer P ON P.Photographer_ID = E.PhotographerID\n" +
"JOIN Decorator D ON D.Decorator_ID = E.DecoratorID\n" +
"full JOIN Musician MUS ON MUS.Musician_ID = E.MusicianID\n" +
"JOIN Theme TH ON TH.ThemeID = E.ThemeID\n" +
"JOIN Type TY ON TY.TypeID = E.TypeID\n" +
"JOIN Menu MEN ON MEN.MenuID = E.MenuID\n" +
"ORDER BY "+sort);
            //ResultSet rs = pst.executeQuery();
             ResultSet rs = pst.executeQuery();
             ResultSetMetaData RSM = rs.getMetaData();
             
             int c;
             c = 10;
             DefaultTableModel DF = (DefaultTableModel)jTable1.getModel();
             DF.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v2 = new Vector();
             for(int i = 1; i<=c; i++)
             {
                 v2.add(rs.getString("EventID"));
                 v2.add(rs.getString("EventName"));
                 v2.add(rs.getString("Date"));
                 v2.add(rs.getString("TypeID")+". "+rs.getString("TypeName"));
                 v2.add(rs.getString(21)+". "+rs.getString("ThemeName")+" - "+rs.getString(22));
                 v2.add(rs.getString(19)+ ". "+ rs.getString("Name") +" - "+rs.getString("Address"));
                 System.out.println((rs.getString(19)+ ". "+ rs.getString("Name") +" - "+rs.getString("Address")));
                 //v2.add(rs.getString("Phone"));
                 //v2.add(rs.getString("Address"));
                 v2.add(rs.getString("GuestNumber"));
                 v2.add(rs.getString(26)+". "+rs.getString("Cuisine")+ " - "+ rs.getString("Price")+" tk");
                 v2.add(rs.getString("Description"));
                 if(rs.getString(23)!=null)
                 v2.add(rs.getString(23)+ ". "+ rs.getString(13));
                 else v2.add("NULL");
                 v2.add(rs.getString(24)+ ". "+ rs.getString(15));
                 
                 if(rs.getString(25)!=null)
                 v2.add(rs.getString(25)+ ". "+ rs.getString(17));
                 else v2.add("NULL");
                 
                 
             }
             DF.addRow(v2);
             }
             
        } catch (Exception ex) {
            //Logger.getLogger(BookCrud.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        type = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        customer = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        decorator = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        photographer = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        musician = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        menu = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        theme = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        eID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Event Title");

        jLabel2.setText("Event Date");

        jLabel3.setText("Event Type");

        jLabel4.setText("Number of Guests");

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Customer");

        jButton3.setText("+");

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Decorator");

        jLabel7.setText("Photographer");

        jLabel8.setText("Musician");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel9.setText("General Info");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel10.setText("Menu");

        jLabel11.setText("Cuisine");

        jLabel13.setText("Description");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel12.setText("Theme");

        jButton5.setText("+");

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

        jButton6.setForeground(new java.awt.Color(255, 204, 153));
        jButton6.setText("Show");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Event ID", "Event Name", "Date", "Type", "Theme", "Customer", "Guest Number", "Menu", "Menu Description", "Photographer", "Decorator", "Musician"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setText("Event ID");

        eID.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addContainerGap(1281, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(56, 56, 56)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(64, 64, 64)
                        .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(55, 55, 55)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(78, 78, 78)
                        .addComponent(theme, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(decorator, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(44, 44, 44)
                        .addComponent(photographer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jCheckBox1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(70, 70, 70)
                        .addComponent(musician, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jCheckBox2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(68, 68, 68)
                            .addComponent(eID))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(59, 59, 59)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(357, 357, 357)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(eID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(theme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6))
                            .addComponent(decorator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(photographer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(musician, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(25, 25, 25)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jButton7)))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Variables
        ConnectMSSQL cnObj= new ConnectMSSQL();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat day= new SimpleDateFormat("yyyyMMdd");
        //int dayID= Integer.parseInt(day.format(jDateChooser1.getDate()));
        String date = sdf.format(jDateChooser1.getDate());
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
            
            //String query="INSERT into Event ( EventName, Date, ThemeID, PhotographerID, TypeID, MenuID, DecoratorID, CustomerID, MusicianID, GuestNumber ) values('"+title+"','"+date+"','"+themeID+"','"+pID+"','"+typeID+"','"+menuID+"','"+dID+"','"+cID+"','"+musID+"','"+numOfGuests+"')";
            String query="Update Event Set EventName='"+title+"', Date='"+date+"',ThemeID='"+themeID+"', PhotographerID='"+pID+"', TypeID='"+typeID+"', MenuID='"+menuID+"', CustomerID='"+cID+"', DecoratorID='"+dID+"', MusicianID='"+musID+"', GuestNumber='"+numOfGuests+"', Description='"+desc+"' where EventID='"+eID.getText()+"'";
            if(jCheckBox1.isSelected()&&jCheckBox2.isSelected()){
            }
            else if(!jCheckBox1.isSelected()){
                query="Update Event Set EventName='"+title+"', Date='"+date+"',ThemeID='"+themeID+"', PhotographerID=NULL, TypeID='"+typeID+"', MenuID='"+menuID+"', CustomerID='"+cID+"', DecoratorID='"+dID+"', MusicianID='"+musID+"', GuestNumber='"+numOfGuests+"', Description='"+desc+"' where EventID='"+eID.getText()+"'";
            }else if(!jCheckBox2.isSelected()){
                query="Update Event Set EventName='"+title+"', Date='"+date+"',ThemeID='"+themeID+"', PhotographerID='"+pID+"', TypeID='"+typeID+"', MenuID='"+menuID+"', CustomerID='"+cID+"', DecoratorID='"+dID+"', MusicianID=NULL, GuestNumber='"+numOfGuests+"', Description='"+desc+"' where EventID='"+eID.getText()+"'";
            }else query="Update Event Set EventName='"+title+"', Date='"+date+"',ThemeID='"+themeID+"', PhotographerID=NULL, TypeID='"+typeID+"', MenuID='"+menuID+"', CustomerID='"+cID+"', DecoratorID='"+dID+"', MusicianID=NULL, GuestNumber='"+numOfGuests+"', Description='"+desc+"' where EventID='"+eID.getText()+"'";
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
        JOptionPane.showMessageDialog(this, "Event Updated");
        showTable("EventID");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Events().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if(jCheckBox1.isSelected()){
            photographer.setEnabled(true);
        }else {photographer.setEnabled(false);
            System.out.println("inside click");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        //        if(jCheckBox1.isSelected()){
            //            photographer.setEnabled(true);
            //        }else {photographer.setEnabled(false);
            //            System.out.println("inside click");
            //        }
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        if(jCheckBox2.isSelected()){
            musician.setEnabled(true);
        }else{ musician.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
        //        if(jCheckBox2.isSelected()){
            //            musician.setEnabled(true);
            //        }else musician.setEnabled(false);
    }//GEN-LAST:event_jCheckBox2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        showTable("EventID");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        //Date date = sdf.format(jDateChooser1.setDate((Date) d1.getValueAt(SelectIndex, 2)));
        eID.setText(d1.getValueAt(SelectIndex, 0).toString());
        jTextField1.setText(d1.getValueAt(SelectIndex, 1).toString());
        
        try {
            jDateChooser1.setDate(sdf.parse((String) d1.getValueAt(SelectIndex, 2)));
        } catch (ParseException ex) {
            Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String desc=d1.getValueAt(SelectIndex, 6).toString();
        if(desc.isEmpty()) desc="";
        type.setSelectedItem(d1.getValueAt(SelectIndex, 3).toString());
        theme.setSelectedItem(d1.getValueAt(SelectIndex, 4).toString());
        customer.setSelectedItem(d1.getValueAt(SelectIndex, 5).toString());
        jTextField2.setText(desc);
        menu.setSelectedItem(d1.getValueAt(SelectIndex, 7).toString());
        jTextArea1.setText(d1.getValueAt(SelectIndex, 8).toString());
        if(d1.getValueAt(SelectIndex, 9).toString().equals("NULL")) {jCheckBox1.setSelected(false);
            //photographer.setEnabled(false);
        }
        else{ jCheckBox1.setSelected(true);
        //photographer.setEnabled(true);
        }
        photographer.setSelectedItem(d1.getValueAt(SelectIndex, 9).toString());
        if(d1.getValueAt(SelectIndex, 11).toString().equals("NULL")) {
            jCheckBox2.setSelected(false);
        }
        else{ 
            jCheckBox2.setSelected(true);
        }
        musician.setSelectedItem(d1.getValueAt(SelectIndex, 11).toString());
        decorator.setSelectedItem(d1.getValueAt(SelectIndex, 10).toString());
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        //Variables
        ConnectMSSQL cnObj= new ConnectMSSQL();

        //Time COnvertion

        //connection
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=MyEventPlanner;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();
            statement.executeQuery("delete from Event where EventID='"+eID.getText()+"'");

        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Deleted");
        showTable("EventID");
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    private String getFirstWord(String text) {

        int index = text.indexOf('.');

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
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EventManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EventManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customer;
    private javax.swing.JComboBox<String> decorator;
    private javax.swing.JTextField eID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
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
