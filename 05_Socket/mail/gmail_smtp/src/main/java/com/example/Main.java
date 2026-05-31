package com.example;

// import java.net.Authenticator;
// import java.net.PasswordAuthentication;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Main {
    public static void main(String[] args) {
        String to = "ronishg0602@gmail.com";
        String subject = "Test Email from JAVA SMTP";
        String body = "Test Body";
        new SendEmail(to, subject, body);

    }
}

class SendEmail {
    SendEmail(String to, String subject, String body) {
        // Code to send email using Gmail API
        String from = "ronishunofficial@gmail.com";
        // String gmail_password = System.getenv("GMAIL_PASSWORD");
        String gmail_password = "ujpe fkwj rwli";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with the Gmail SMTP server
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, gmail_password);
            }
        });

        try {
            // create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
