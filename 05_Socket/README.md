# Module 05 — Networking

## Sub-programs

### 1. TCP ChatApp
**Path:** `TCP/01_ChatApp/src/App.java`
**Path:** `TCP/01_ChatApp/src/Server.java`
**Path:** `TCP/01_ChatApp/src/Client.java`

```java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
```

```java
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        try {

            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sysIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg;

            while (true) {

                msg = socketIn.readLine();
                System.out.println("Client: " + msg);

                System.out.print("You: ");
                msg = sysIn.readLine();
                socketOut.println(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ss.close();
            s.close();
        }
    }
}
```

```java
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        try {
            BufferedReader socketIn = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream(), true);
            BufferedReader sysIn = new BufferedReader(
                    new InputStreamReader(System.in));

            String msg;
            while (true) {
                System.out.print("You: ");
                msg = sysIn.readLine();
                socketOut.println(msg);

                msg = socketIn.readLine();
                System.out.println("Server: " + msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

    }
}
```

### 2. UDP Demo
**Path:** `UDP/01_UDP_Demo/src/App.java`
**Path:** `UDP/01_UDP_Demo/src/Server.java`

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class App {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        String message = "Hello, UDP Server!";

        byte[] sbuffer = message.getBytes();

        InetAddress serverAddress = InetAddress.getByName("localhost");
        DatagramPacket sendPacket = new DatagramPacket(sbuffer, sbuffer.length, serverAddress, 5000);

        clientSocket.send(sendPacket);
        clientSocket.close();
    }
}
```

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(5000);
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            System.out.println("Server is wating for a packet...");
            serverSocket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received message: " + receivedMessage);
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 3. URL FetchSiteContent
**Path:** `URL/01_FetchSiteContent/src/App.java`
**Path:** `URL/01_FetchSiteContent/src/InetAddressExample.java`

```java
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class App {
    public static void main(String[] args) throws Exception {
        String page = "index.html";
        try {
            URL u = new URL("http://www.example.com");
            URLConnection uc = u.openConnection();
            uc.connect();

            InputStream in = uc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            BufferedWriter writer = new BufferedWriter(new FileWriter(page));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            in.close();
            br.close();
            writer.close();
            System.out.println("Page Downloaded successfully. " + page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

```java
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        InetAddress[] add = InetAddress.getAllByName("www.google.com");
        for (InetAddress address : add) {
            System.out.println("IPV4 address : " + address.getHostAddress());
        }
    }
}
```

### 4. SMTP GMAIL (VS Code Project)
**Path:** `mail/01_SMTP_GMAIL/src/App.java`

```java
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
```

### 5. SMTP GMAIL (Maven Project)
**Path:** `mail/gmail_smtp/src/main/java/com/example/Main.java`

```java
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
```
