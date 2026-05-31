// import java.util.Properties;
// import jakarta.mail.*;
// import jakarta.mail.internet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class App {

    public static void main(String[] args) throws Exception {
        // new SendEmail("ronishg0602@gmail.com", "Test Email from JAVA SMTP", "Test
        // Body");
        String to = "ronishg0602@gmail.com";
        String subject = "Test Email from JAVA SMTP";
        String body = "Test Body";
        new SendEmail(to, subject, body);

    }
}

class SendEmail {
    private Properties config;

    SendEmail(String to, String subject, String body) {

        config = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }

        String fromEmail = config.getProperty("gmail.from");
        String password = config.getProperty("gmail.password");
        String smtpHost = config.getProperty("smtp.host");
        String smtpPort = config.getProperty("smtp.port");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Create a session with the Gmail SMTP server
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
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
