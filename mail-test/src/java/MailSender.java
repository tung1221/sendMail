
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tung
 */
public class MailSender {
    public boolean sendMail(){
        boolean test = false;
        
        
        Properties pr = new Properties();
        pr.put("mail.smtp.auth", true);
        pr.put("mail.smtp.starttls.enable",true);
        pr.put("mail.smtp.port", "587");
        pr.put("mail.smtp.host", "smtp.gmail.com");
        
        
        //session
        Session session = Session.getDefaultInstance(pr, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ntung7584@gmail.com", "tung123456t");
            }
        });
 
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tungnthe161867@fpt.edu.vn"));
            message.setSubject("Testing Subject");
            message.setText("Welcome to gpcoder.com");
             
            // send message
            Transport.send(message);
             
            System.out.println("Message sent successfully");
            test =true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return test;
    }
    
    public static void main(String[] args) {
        MailSender send = new MailSender();
        boolean test =send.sendMail();
        if(test){
            System.out.println("send successfull");
        }else{
            System.out.println("Failed");
        }
               
    }
}
