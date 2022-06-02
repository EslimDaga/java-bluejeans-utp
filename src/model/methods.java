/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author eslim
 */
public class methods {
    public static boolean InsertUser(user x){
        Connection conn = connection.Connect();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO USERS (firstname,lastname,email,username,password)";
        
        try {
            ps = conn.prepareStatement(query);
            
            ps.setString(1, x.getFirstname());
            ps.setString(2,x.getLastname());
            ps.setString(3,x.getEmail());
            ps.setString(4,x.getUsername());
            ps.setString(5,x.getPassword());
            
            //Ejectuta la consulta
            ps.execute();
            conn.close();
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    
    public static boolean Login(String username, String password){
        Connection cnn = connection.Connect();
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        String query = "SELECT username, password FROM USERS WHERE username = ? and password = ?";
        
        try {
            ps = cnn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2,password);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cnn.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
