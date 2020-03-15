/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class UserData {
    public static String[] getAllUserData(String Email) {
          try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
          String q = "select * from userdatatest where email=?";
          String pw = null;
          PreparedStatement stm =con.prepareStatement(q);
          stm.setString(1,Email);
          ResultSet rs = stm.executeQuery();
          ResultSetMetaData md = rs.getMetaData();
          int col = md.getColumnCount();
          String[] userinformation = new String[7];
            while (rs.next()) {
                for(int i=1;i<=col;i++) userinformation[i-1] = rs.getString(i);
            }
            return userinformation;
        }
      catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PasswordChecker.class.getName()).log(Level.SEVERE, null, ex);
      }
        return null;
    }
    
    public static void main(String[] args) {
        String[] userinfo;
        userinfo = getAllUserData("harshpan01@gmail.com");
        for(int i=0;i<=6;i++) System.out.println(userinfo[i]);
    }
}
