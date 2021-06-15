/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class ResetPassword {
    public static void reset() throws MessagingException{
        
       
    JFrame frame=new JFrame(); //creating JFrame
    
    String email=JOptionPane.showInputDialog(frame,"GIVE Email");//taking email from the user
    
   String code = javaMail.sendMail(email);//sending verification code to the email
   
   String userCode=JOptionPane.showInputDialog(frame,"GIVE CONFIRMATION CODE");//taking verification code from the user
   System.out.println("usercode "+userCode);
   
   // We checked usercode and code are equal or not
   if((userCode.equals(code)))
   {
   
       System.out.println("matched code");
      // String password=JOptionPane.showInputDialog(frame,"GIVE NEW PASSWORD");//taking new password from user
      String password="";
 
JPasswordField pf = new JPasswordField();//Creating JPasswordField

int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);//sending message

if (okCxl == JOptionPane.OK_OPTION) {
    
    password = new String(pf.getPassword());//taking passeord from user
    
  System.err.println("You entered: " + password);
}
       
       try {
           
           Connection connection =DriverManager.getConnection("jdbc:mysql://localhost/javadb","root","");//Connecting to the database
           
           String sql="update staff set password='"+password+"'where email='"+email+"'";//sql command to change password
           
           PreparedStatement statement=connection.prepareStatement(sql);//
           
           statement.execute();
           JOptionPane.showMessageDialog(frame,"Password changed\n","",JOptionPane.INFORMATION_MESSAGE);//givng message to the user
           
       } catch (SQLException ex) {
           Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
}
}

