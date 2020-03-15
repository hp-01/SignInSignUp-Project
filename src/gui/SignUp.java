package gui;

import static database.Database.closeConnection;
import static database.Database.createConnection;
import static database.Database.emailInDB;
import static database.Database.imageNullInDB;
import static database.Database.signINDB;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import validater.DateVerify;
import validater.EmailVerify;
import static validater.JavaMailUtil.sendMail;
import validater.PasswordVerify;
import static validater.Random6.randomValue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author harsh
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    String Email, Firstname, Date, Password, Repassword, Lastname, Username, Errors = "", Vericode;
    static String vericode = randomValue();
    Border border;
    NoConnection nc = new NoConnection();

    public SignUp() {
        this.border = BorderFactory.createLineBorder(Color.red, 2);
        initComponents();
        jPanel3.setVisible(false);
        setIcon();
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
        jLabel1 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        repassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jError = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 13, 375, -1));

        firstname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, 415, 38));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("First name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, 415, 36));

        lastname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 415, 38));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Last name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 415, 36));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 150, 40));

        email.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 415, 38));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Email-ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 415, 36));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel3.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 415, 38));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Username");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 415, 36));

        dob.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel3.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, 415, 38));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Date of Birth");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, 90, 36));

        password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 244, 415, 38));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("In format (YYYY/MM/DD)");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 320, 36));

        repassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel3.add(repassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 415, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Retype Password");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 415, 36));

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, 40));

        jError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jError.setForeground(new java.awt.Color(255, 0, 0));
        jError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 420, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Password");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, 120, 36));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("It should contain 8 charcters with 2 numbers");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 320, 36));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 500));

        setSize(new java.awt.Dimension(457, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //To check connection
        try {
            if (!createConnection()) {
                nc.setVisible(true);
            }
        } catch (ClassNotFoundException e) {
        };
        //To verify firstname
        if (firstname.getText().trim().equals("")) {
            firstname.setBorder(border);
        } else {
            firstname.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }
        //To verify lastname
        if (lastname.getText().trim().equals("")) {
            lastname.setBorder(border);
        } else {
            lastname.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }
        //To verify email first and then in DB 
        if (EmailVerify.isValid(email.getText()) && !firstname.getText().equals("") && !lastname.getText().equals("")) {
            email.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            firstname.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            lastname.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            try {
                if (!emailInDB(email.getText()) && sendMail(email.getText(), vericode)) {
                    String a = JOptionPane.showInputDialog(this, "Email has been sent to verify you");
                    if (a.equals(vericode)) {
                        jPanel1.setVisible(false);
                        jPanel3.setVisible(true);
                        Email = email.getText();
                    }
                    if (!a.equals(vericode)) {
                        JOptionPane.showMessageDialog(this, "Wrong verification code");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Email already exist");
                    email.setBorder(border);
                }

            } catch (Exception ex) {
                System.out.println("Not connected to Database");
            }
        } else {
            email.setBorder(border);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InsertValues();
        if (Username.equals("")) {
            username.setBorder(border);
        } else {
            username.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }
        if (!DateVerify.isValid(Date) || Date.equals("")) {
            dob.setBorder(border);
        } else {
            dob.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }
        if (!PasswordVerify.isValid(Password)) {
            password.setBorder(border);
        } else {
            password.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        }
        if (!Repassword.equals(Password)) {
            repassword.setBorder(border);
        }
        if (Verify() && Repassword.equals(Password)) {
            try {
                if (signINDB(Firstname, Lastname, Email, Username, Date, Password, Repassword)) {
                    imageNullInDB(Email);
                    JOptionPane.showMessageDialog(this, "Sign Up successful..");
                    HomeForm hf = new HomeForm();
                    hf.setVisible(true);
                    this.dispose();
                    this.setVisible(false);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed

    }//GEN-LAST:event_firstnameActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField dob;
    public javax.swing.JTextField email;
    public javax.swing.JTextField firstname;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jError;
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
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JTextField lastname;
    public javax.swing.JPasswordField password;
    public javax.swing.JPasswordField repassword;
    public javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    public boolean Verify() {
        return EmailVerify.isValid(Email) && DateVerify.isValid(Date) && PasswordVerify.isValid(Password)
                && !Firstname.equals("") && !Lastname.equals("") && !Username.equals("");
    }

    public void InsertValues() {
        Firstname = firstname.getText().trim();
        Lastname = lastname.getText().trim();
        Email = email.getText().trim();
        Username = username.getText().trim();
        Date = dob.getText().trim();
        Password = password.getText().trim();
        Repassword = repassword.getText().trim();
    }

}
