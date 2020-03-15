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
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsh
 */
public class PasswordChecker {
  public static void main(String[] args)
  {
     /* try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
          System.out.println("Connection Created");
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter emailid name");
          String email = sc.next();
          String q = "select password from userdatatest where email=?";
          PreparedStatement stm =con.prepareStatement(q);
          stm.setString(1,email);
           ResultSet rs = stm.executeQuery();
           String str = "";
            while (rs.next()) {
                str += rs.getString(1);
            }
            System.out.println(str);
        }
      catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PrintRecord.class.getName()).log(Level.SEVERE, null, ex);
      }*/
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter email");
      String email = sc.next();
      System.out.println("Enter password");
      String password = sc.next();
      if(passwordChecker(email,password)) System.out.println("Login successful");
      else System.out.println("Login unsuccessful");
  }
  
  public static boolean passwordChecker(String email,String password)
  {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
          String q = "select password from userdatatest where email=?";
          String pw = null;
          PreparedStatement stm =con.prepareStatement(q);
          stm.setString(1,email);
          ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                pw = rs.getString(1);
            }
            if(password.equals(pw)) return true;
        }
      catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(PasswordChecker.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;

  }
}
