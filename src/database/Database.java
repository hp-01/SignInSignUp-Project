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
import java.sql.Statement;
/**
 *
 * @author harsh
 */
public class Database {
   static Connection con;
   public static boolean createConnection() throws ClassNotFoundException
   {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8850");
            return true;
        } 
        catch(SQLException sq)
        {
            return false;
        }
   }
   
   public static boolean signInDB(String profilefor, String fullname, String gender, String dob, String religion, String lookingfor, String interest, String email, String contact, String nickname, String password, String repassword) throws ClassNotFoundException
   {
       try {
           createConnection();
           String query = "insert into UserInfo values(?,?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1,profilefor);
           ps.setString(2,fullname);
           ps.setString(3,gender);
           ps.setString(4,dob);
           ps.setString(5,religion);
           ps.setString(6,lookingfor);
           ps.setString(7,interest);
           ps.setString(8,email);
           ps.setString(9,contact);
           ps.setString(10,nickname);
           ps.setString(11,password);
           ps.setString(12,repassword);
           ps.executeUpdate();
           con.close();
           return true;
       } 
       catch (SQLException ex) {
           System.out.println("Account already exist for the given email");
           return false;
       }
   }
   
   public static boolean loginInDB(String email,String password)
   {
          try {
          createConnection();
          String q = "select password from userdatatest where email=?";
          String pw = null;
          PreparedStatement stm =con.prepareStatement(q);
          stm.setString(1,email);
          ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                pw = rs.getString(1);
            }
            if(password.equals(pw))
            {
                con.close();
                return true;
            }  
        }
      catch (ClassNotFoundException | SQLException ex) {
          System.out.println("Wrong Password");
          return false;
      }
       return false;     
   }
   
    public static boolean emailInDB(String email)
    {
        try 
        {
          createConnection();
          String query = "select email from userdatatest where email=?";
          String em = "";
          PreparedStatement ps = con.prepareStatement(query);
          ps.setString(1,email);
          ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                em = rs.getString(1);
            }
          if(em.equals(email)) return true;
        }
        catch(SQLException sq)
        {
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("Email doesn't exist");
            return false;
        }
       return false;
    }
    
    public static boolean signINDB(String firstname,String lastname,String email,String username,String dob,String password,String repassword) throws ClassNotFoundException{
        try {
                createConnection();
                String q = "insert into userdatatest values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(q) ;
                    ps.setString(1,firstname);
                    ps.setString(2,lastname);
                    ps.setString(3,email);
                    ps.setString(4,username);
                    ps.setString(5,dob);
                    ps.setString(6,password);
                    ps.setString(7,repassword);
                    ps.executeUpdate();
                    con.close();
                    return true;
        } 
        catch(SQLException sq)
        {
            System.out.println("Error");
            return false;   
        }
    }
    
    public static void imageNullInDB(String email)
    {
        try
        {
            createConnection();
            Statement st;
            st = con.createStatement();
            st.executeUpdate("insert into imageDB values('"+email+"',NULL)");
        }
        catch(ClassNotFoundException e)
        {
            
        } catch (SQLException e) {
       }
    }
    
    public static void closeConnection()
    {
       try {
           con.close();
       } catch (SQLException ex) {
          
       }
    }
}
