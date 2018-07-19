/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvelsgroup;

/**
 *
 * @author Anirudh
 */
import java.io.File;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;
import javax.activation.*;


public class Email{
    
    private static final String password = "pranav@viit";
    private static final String from = "pranav.acharekar@viit.ac.in";
    private static final String sub = "INVOICE";
        
    
    public static void send(String receiverEmail , String urlOfInvoice){
        
        String bodyOfMail = "Attached is the invoice of your purchase :-)" ;
      //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }
        });    
        
      //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiverEmail));    
         message.setSubject(sub);    
         message.setText(bodyOfMail);    
         //attachment
         
         Multipart multipart = new MimeMultipart();

        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText(bodyOfMail);

        MimeBodyPart attachmentBodyPart= new MimeBodyPart();
        DataSource source = new FileDataSource(urlOfInvoice); // ex : "C:\\test.pdf"
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName("INVOICE.pdf"); // ex : "test.pdf"

        multipart.addBodyPart(textBodyPart);  // add the text part
        multipart.addBodyPart(attachmentBodyPart); // add the attachement part

        message.setContent(multipart);

         
         
         Transport.send(message);    
         System.out.println("Mail sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    

    }  
 
}   
