package gui;


import static database.Database.closeConnection;
import static database.Database.createConnection;
import static database.Database.emailInDB;
import static database.PasswordChecker.passwordChecker;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import validater.EmailVerify;


public class HomeForm extends javax.swing.JFrame {

     WelcomeUser wu;
     NoConnection nc = new NoConnection();
     Border border = BorderFactory.createLineBorder(Color.RED, 2);
     Border borderg = BorderFactory.createLineBorder(Color.GREEN,2);
     String Email;
    public HomeForm() {
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jError = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 13, 375, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 415, 36));

        jError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jError.setForeground(new java.awt.Color(0, 51, 255));
        jError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jError.setText("  Forgot Password?");
        jError.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jErrorMouseClicked(evt);
            }
        });
        jPanel1.add(jError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 420, 20));

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sign Up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 150, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, 415, 36));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("   New User? Please Sign In");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 420, 30));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 150, 40));

        email.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 20)); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 145, 410, 38));

        password.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 20)); // NOI18N
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 410, 38));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SignUp su = new SignUp();
        su.setVisible(true);
        su.jPanel3.setVisible(false);
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (!createConnection()) {
                nc.setVisible(true);
                closeConnection();
            }
        } catch (Exception e) {
        };
        Boolean notinDB = false;
        if (!email.getText().equals("")) {
            Email = email.getText().trim();
            notinDB = emailInDB(Email);
        }
        Boolean correctemail = EmailVerify.isValid(Email);
        if (!correctemail) {
            email.setBorder(border);
        } else {
            email.setBorder(borderg);
        }
        if (password.getText().equals("")) {
            password.setBorder(border);
        } else {
            password.setBorder(borderg);
        }
        if (notinDB && EmailVerify.isValid(Email)) {
            if (!password.getText().equals("")) {
                if (passwordChecker(Email, password.getText().trim())) {
                    password.setBorder(borderg);
                    createWelcome();
                } else {
                    password.setBorder(border);
                }
            }
        }
        if (!notinDB && correctemail) {
            email.setBorder(border);
            password.setBorder(border);
            int a = JOptionPane.showConfirmDialog(this, "Your email address has not been registered\nPlease sign up");
            if (a == JOptionPane.YES_OPTION) {
                SignUp su = new SignUp();
                su.setVisible(true);
                this.dispose();
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jErrorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jErrorMouseClicked
        ForgotPassword fp = new ForgotPassword();
        fp.setVisible(true);
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jErrorMouseClicked

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField email;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jError;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }

    private void createWelcome() {
        wu = new WelcomeUser();
        wu.getData(email.getText().trim());
        try {
            wu.userProfileIcon();
        } catch (Exception e) {
            System.out.println("Nothing On DP");
        }
        wu.setVisible(true);
        this.dispose();
        this.setVisible(false);    
    }
    
}
