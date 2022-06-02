/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author eslim
 */
public class connection {
    public Connection con = null;
    
    public static Connection Connect(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc://localhost:3306/prueba","root","");
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return conn;
    }
}
