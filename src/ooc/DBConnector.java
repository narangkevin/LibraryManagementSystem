/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kevin
 */
public class DBConnector {
    Connection conn = null;
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String db_URL = "jdbc:mysql://localhost:3306/aulms";
    
    static final String USER = "root";
    static final String PASS = "root123";
    
    public static Connection connectDB() {
        
        try {
            Class.forName(JDBC_DRIVER); 
            Connection con = DriverManager.getConnection(db_URL,USER,PASS);
            return con;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
