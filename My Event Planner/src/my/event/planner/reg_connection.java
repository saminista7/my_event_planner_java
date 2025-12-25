/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.event.planner;
import java.sql.*;


/**
 *
 * @author user
 */
public class reg_connection {
    
    static final String Db_URL = "jdbc:sqlserver://localhos/MyEventPlanner";
    static final  String USER = "root";
    static final String PASS = "";
    
    
    public static Connection connectreg(){
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //open connection
            conn = DriverManager.getConnection(Db_URL,USER,PASS);
            return conn;
        }catch(Exception ex){
             System.out.println("There were errors while connecting to info.");
            return null;
        
        }
        
        
    
}
}