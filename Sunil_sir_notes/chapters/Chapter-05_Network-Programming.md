# Chapter 5_Network Programming

> *Source: Sunil Sir's Lecture Notes — B.Sc. CSIT (Tribhuvan University)*

---

## Unit 5: Network Programming

*Source: `Unit 5.docx`*

> 📷 *This document contains images/diagrams — see the original .docx for visual content*

### Unit 5 (Network Programming)

Transmission control protocol (TCP) and user datagram protocol (UDP) are foundational pillars of the internet, enabling different types of data transmission from a network source to the destination. **TCP is more reliable**, while UDP prioritizes **speed and efficiency**.

### What Is TCP (Transmission Control Protocol)?

The transmission control protocol (TCP) is defined as a **connection-oriented** communication protocol that allows computing devices and applications to **send data via a network and verify its delivery**, forming one of the crucial pillars of the global internet.
TCP relies on a three-way handshake (synchronization, synchronization acknowledgment, and final acknowledgment)
Each **TCP segment** contains a **header and data**. The TCP header contains **many more fields** than the UDP header

### Step 1: Establish connection

When two computers want to send data to each other over TCP, they first need to establish a connection using a **three-way handshake.**

![Figure](images/Ch05_001.png)

The first computer sends a packet with the SYN bit set to 1 (SYN = "synchronize?"). The second computer sends back a packet with the ACK bit set to 1 (ACK = "acknowledge!") plus the SYN bit set to 1. The first computer replies back with an ACK.

### Step 2: Send packets of data

When a packet of data is sent over TCP, the recipient must always acknowledge what they received.

![Figure](images/Ch05_002.jpeg)

The first computer sends a packet with data and a sequence number. The second computer acknowledges it by setting the ACK bit and increasing the acknowledgement number by the length of the received data.

### Step 3: Close the connection

Either computer can close the connection when they no longer want to send or receive data.

![Figure](images/Ch05_003.png)

A computer initiates closing the connection by sending a packet with the FIN bit set to 1 (FIN = finish). The other computer replies with an ACK and another FIN. After one more ACK from the initiating computer, the connection is closed.

### UDP Protocol

User datagram protocol (UDP) is a message-oriented communication protocol that allows computing devices and applications to send data via a network without verifying its delivery, which is best suited to real-time communication and broadcast systems. 


![Figure](images/Ch05_004.png)

UDP enables continuous data transmission (i.e., response) without acknowledging or confirming the connection
As with TCP, its purpose is to send and receive messages, so its functioning is similar to the transmission control protocol. What is distinctive about UDP is that it is **not connection-based**. In this case, “**connectionless**” refers to the fact that no connection is established before communication occurs. 
Furthermore, **it does not ensure the delivery of the data packets from the server**. It is commonly referred to as the “**fire-and-forget**” protocol because it is not concerned about whether or not the client receives the data.
In most cases, **UDP is faster than TCP** because it does not assure delivery of the packets as TCP does.
The UDP protocol is not suitable for sending **, **viewing a web page, or downloading a file. However, it is preferred mainly for real-time applications like broadcasting or multitasking network traffic.

### Ports:

A network port which is provided by the **Transport Layer** protocols of Internet Protocol suite, such as Transmission Control Protocol (TCP) and User Diagram Protocol (UDP) is a number which serving **endpoint** communication between two computers.
Data transmitted over the Internet is accompanied by addressing information that identifies the computer and the port for which it is destined. The computer is identified by its **32-bit IP address**, which IP uses to deliver data to the right computer on the network. **Ports** are identified by a **16-bit number**, which **TCP and UDP use to deliver **the data to the right application.
1. IP address : 
An Internet Protocol address (IP address) is the logical address of our network hardware by which other devices identify it in a network. IP address stands for Internet Protocol address which is an unique number or a numerical representation that uniquely identifies a specific interface on the network. Each device that is connected to internet an IP address is assigned to it for its unique identification.
Addresses in IPv4 are 32-bits long example, 
 
```java
12.244.233.165
And Addresses in IPv6 are 128-bits example,
2001:0db8:0000:0000:0000:ff00:0042:7879
2. Port Number : 
Port number is the part of the addressing information used to identify the senders and receivers of messages in computer networking. Different port numbers are used to determine what protocol incoming traffic should be directed to. Port number identifies a specific process to which an Internet or other network message is to be forwarded when it arrives at a server. Ports are identified for each protocol and It is considered as a communication endpoint.
Difference Between IP Address and Port Number
```

**Network Classes in JDK**

What is a Socket in Java?
A **socket **in  is one endpoint of a two-way communication link between two programs running on the network. A **socket** is bound to a port number so that the TCP layer can identify the application that data is destined to be sent to.

![Figure](images/Ch05_005.png)

Sockets provide the communication mechanism between two computers using TCP. A client program creates a socket on its end of the communication and attempts to connect that socket to a server.
When the connection is made, the server creates a socket object on its end of the communication. The client and the server can now communicate by writing to and reading from the socket.
The **java.net.Socket** class represents a socket, and the **java.net.ServerSocket** class provides a mechanism for the server program to listen for clients and establish connections with them.

### Socket Programming in Java

Now that you know, what is Socket in Java, let’s move further and understand how does client communicates with the server and how the server responds back.
Client Side Programming
In the case of client-side programming, the client will first wait for the server to start. Once the server is up and running, it will send the requests to the server. After that, the client will wait for the response from the server. So, this is the whole logic of client and server communication. Now let’s understand the client side and server side programming in detail.
In order to initiate a client’s request, you need to follow the below mentioned steps:
Establish a Socket Connection 
To connect to another machine we need a socket connection. A socket connection means the two machines have information about each other’s network location (IP Address) and TCP port. The **java.net.Socket** class represents a Socket. To open a socket: 
```java
Socket socket = new Socket(“127.0.0.1”, 5000)
The first argument – IP address of Server. (127.0.0.1  is the IP address of localhost, where code will run on the single stand-alone machine).
The second argument – TCP Port. (Just a number representing which application to run on a server. For example, HTTP runs on port 80. Port number can be from 0 to 65535)
```

```java
Communication
To communicate over a socket connection, streams are used to both input and output the data.
Closing the connection
The socket connection is closed explicitly once the message to the server is sent.
Write a simple client and server socket program to read data from client and print in server.
```

**Client.java**
```java
import java.net.*;
import java.io.*;
public class client {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("localhost",4999);
        PrintWriter pr=new PrintWriter(s.getOutputStream());
        pr.println("hello");
        pr.flush();
        s.close();
    }
}
```

**Server Programming**

### 1.Establish a Socket Connection

To write a server application two sockets are needed. 
A **ServerSocket** which waits for the client requests (when a client makes a new Socket())
A plain old Socket to use for communication with the client.
2.Communication
getOutputStream() method is used to send the output through the socket.
3.Close the Connection 
After finishing,  it is important to close the connection by closing the socket as well as input/output streams.
```java
// File Name server.java
```

```java
import java.net.*;
import java.io.*;
public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(4999);
        Socket s=ss.accept();
        System.out.println("Client Connected");
        InputStreamReader in=new InputStreamReader(s.getInputStream());
        BufferedReader bf=new BufferedReader(in);
```

```java
        String str=bf.readLine();
        System.out.println("Client: "+str);
        s.close();
        ss.close();
    }
}
```

**Output:**
```java
Client Connected
Client: hello
```

**InetAddress Class:**
The **java.net.InetAddress** class is Java’s high-level representation of an IP address, both IPv4 and IPv6.
The **InetAddress** class is used to encapsulate both the numerical IP address and the domain name for that address.  Example:www.*google.com*
There are two types of address: **Unicast**, **Multicast and Broadcast**
A **unicast** address represents a single device in the network. A **multicast** address represents a group of devices in the network. A **broadcast** address represents all devices in the network. If a device want to share the information only with a single device, it uses the unicast address of that device.

![Figure](images/Ch05_006.png)

### Unicast


![Figure](images/Ch05_007.png)

### Broadcast:


![Figure](images/Ch05_008.png)

An IP Address is represented by 32bit 
InetAddress can handle both IPv4(32bit) and IPv6 (128bit)

### Steps to Create new InetAddress Object

Create a java file named: **InetAddressExample.java**
```java
Add header import java.net.*;
Declare object of InetAddress with calling getByName(“google.com”) static method.
InetAddress address = InetAddress.getByName("www.google.com");
Print the result using
System.out.println(address);
You can also do a reverse lookup by IP address. For example, if you want the hostname for the address 208.201.239.100, pass the dotted quad address to InetAddress.getByName()
InetAddress address = InetAddress.getByName("208.201.239.100"); System.out.println(address.getHostName());
Output: 208.201.239.100
```

**Example 1. Find the address of the local machine**
```java
    public static void main(String[] args)
    {
       try {
        InetAddress address = InetAddress.getLocalHost();
         System.out.println(address);
        }
       catch (UnknownHostException ex) {
        System.out.println("Could not find localhost");
        }
    }
```

**Output:**
DESKTOP-3EMMN99/192.168.1.68
If, for some reason, you need all the addresses of a host, call **getAllByName()** instead, which returns an array:
```java
InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        for (InetAddress address : addresses)
        {
        System.out.println(address);
        }
Output:
www.google.com/142.250.192.164
www.google.com/2404:6800:4002:816:0:0:0:2004
```

**Java URL**
The **Java URL** class represents an URL. URL is an acronym for Uniform Resource Locator. It points to a resource on the World Wide Web. For example:
https://samriddhicollege.edu.np/bsccsit-college-in-bhaktapur-nepal/
*Protocol**   **Domain**                    **File*

### URL (Uniform Resource Locator)

It is string of characters but it refers to just the **address.**

![Figure](images/Ch05_009.png)

E.g.  Address:

The **URL** Class is the simplest way for a java program to locate and retrieve information form the network.
It consists of multiple parts including protocols, IP address, path and port to locate the information and the mechanism for retrieving it.
URLs use protocol such as http:// and ftp:// to identify the resource
The syntax of a URL is: 

### protocol://userInfo@host:port/path?query#fragment


![Figure](images/Ch05_010.png)

A URL contains many information:
**Protocol:** In this case, http is the protocol.
**Server name or IP Address:** In this case, **www.samriddhicollege.com** is the server name.
**Port Number:** It is an optional attribute. If we write http//ww.samriddhicollege.com:80/bsccsit/ , 80 is the port number. If port number is not mentioned in the URL, it returns -1.
**File Name or directory name:** In this case, index.jsp is the file name.

### Constructors of Java URL class

URL(String spec)
Creates an instance of a URL from the String representation.

### URL(String protocol, String host, int port, String file)

Creates an instance of a URL from the given protocol, host, port number, and file.
**URL(String protocol, String host, int port, String file, URLStreamHandler handler)**
Creates an instance of a URL from the given protocol, host, port number, file, and handler.

### URL(String protocol, String host, String file)

Creates an instance of a URL from the given protocol name, host name, and file name.

### URL(URL context, String spec)

Creates an instance of a URL by parsing the given spec within a specified context.

### URL(URL context, String spec, URLStreamHandler handler)

Creates an instance of a URL by parsing the given spec with the specified handler within a given context.

### Commonly used methods of Java URL class

The java.net.URL class provides many methods. The important methods of URL class are given below.

### Example of Java URL class

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
```

```java
        try{
            URL url=new URL("http://www.samriddhicollege.com/jbsccsit-college-in-bhaktapur-nepal");
```

```java
            System.out.println("Protocol: "+url.getProtocol());
            System.out.println("Host Name: "+url.getHost());
            System.out.println("Port Number: "+url.getPort());
            System.out.println("File Name: "+url.getFile());
```

```java
            }catch(Exception e){System.out.println(e);}
```

```java
    }
}
Output:
Protocol: http
Host Name: www.samriddhicollege.com
Port Number: -1
File Name: /jbsccsit-college-in-bhaktapur-nepal
```

***Example:***
```java
public static void main(String[] args) throws MalformedURLException {
```

```java
        String baseurl="https://samriddhicollege.edu.np/wp-content/uploads/2019/09/";
        String relativeUrl="Networking_Programming-Syllabus.zip";
        URL baseUrl=new URL(baseurl);
        URL resolvedRelativeUrl=new URL(baseUrl, relativeUrl);
        System.out.println("BaseUrl:"+baseurl);
        System.out.println("Relative Url:"+relativeUrl);
        System.out.println("Resolved Relative Url:"+resolvedRelativeUrl);
        }
```

```java
Output:
BaseUrl:https://samriddhicollege.edu.np/wp-content/uploads/2019/09/
Relative Url:Networking_Programming-Syllabus.zip
Resolved Relative Url:https://samriddhicollege.edu.np/wp-content/uploads/2019/09/Networking_Programming-Syllabus.zip
```

**Splitting a URL into Pieces:**
URLs are composed of five pieces:
The scheme, also known as the protocol
The authority
The path 
The fragment identifier, also known as the section or ref 
The query string
For example, in the URL **http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc**, the **scheme** is http, the **authority** is www.ibiblio.org, the **path** is / javafaq/books/jnp/index.html, the **fragment** identifier is toc, and the **query string** is isbn=1565922069. However, not all URLs have all these pieces. For instance, the URL http://www.faqs.org/rfcs/rfc3986.html has a scheme, an authority, and a path, but no fragment identifier or query string. 
The **authority** may further be divided into the user info, the host, and the port. For example, in the URL http://admin@www.blackstar.com:8080/, the authority is **ad min@www.blackstar.com:8080**. This has the user info admin, the host www.black‐ star.com, and the port 8080.

Read-only access to these parts of a URL is provided by nine public methods: **getFile(), getHost(), getPort(), getProtocol(), getRef(), getQuery(), getPath(), getUserInfo(), and getAuthority().**

### Example:

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
       String url="ftp://mp3:mp3@138.247.121.61:21000/c%3a/";
       try {
        URL u = new URL(url);
        System.out.println("The URL is " + u);
        System.out.println("The scheme is " + u.getProtocol());
        System.out.println("The user info is " + u.getUserInfo());
        String host = u.getHost();
        if (host != null) {
        int atSign = host.indexOf('@');
        if (atSign != -1) host = host.substring(atSign+1);
        System.out.println("The host is " + host);
        } else {
        System.out.println("The host is null.");
        }
        System.out.println("The port is " + u.getPort());
        System.out.println("The path is " + u.getPath());
        System.out.println("The ref is " + u.getRef());
        System.out.println("The query string is " + u.getQuery());
        } catch (MalformedURLException ex) {
        System.err.println(url + " is not a URL I understand.");
        }
        System.out.println();
    }
}
```

**Output:**
```java
The URL is ftp://mp3:mp3@138.247.121.61:21000/c%3a/
The scheme is ftp
The user info is mp3:mp3
The host is 138.247.121.61
The port is 21000
The path is /c%3a/
The ref is null
The query string is null
Lab: write a java program to split different component of url from given url: (https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2)
Example: 
    public static void main(String[] args) throws MalformedURLException {
URL url1 = new URL("https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2");
        System.out.println(url1.toString());
        System.out.println();
        System.out.println(
            "Different components of the URL1-");
       System.out.println("Protocol:- " + url1.getProtocol());
        System.out.println("Hostname:- " + url1.getHost()); System.out.println("Default port:- "+ url1.getDefaultPort());
        // Retrieving the query part of URL
        System.out.println("Query:- " + url1.getQuery());
        // Retrieving the path of URL
        System.out.println("Path:- " + url1.getPath());
        // Retrieving the file name
        System.out.println("File:- " + url1.getFile());
        // Retrieving the reference
        System.out.println("Reference:- " + url1.getRef());
        }
```

***Output:***

### Different components of the URL1-

### Protocol:- https

### Hostname:- www.example.com

### Default port:- 443

### Query:- key1=value1&key2=value2

### Path:- /path/to/resource

### File:- /path/to/resource?key1=value1&key2=value2

### Reference:- section2

### Java URLConnection Class:

The **Java URLConnection** class represents a communication link between the **URL** and **the application**. It can be used to read and write data to the specified resource referred by the URL.

### What is the URL?

URL is an abbreviation for Uniform Resource Locator. An URL is a form of string that helps to find a resource on the World Wide Web (WWW).
URL has two components:
The protocol required to access the resource.
The location of the resource.

### Features of URLConnection class

**URLConnection** is an abstract class. The two subclasses **HttpURLConnection** and **JarURLConnection** makes the connetion between the client Java program and URL resource on the internet.
With the help of **URLConnection** class, a user can read and write to and from any resource referenced by an URL object.
Once a connection is established and the Java program has an **URLConnection** object, we can use it to read or write or get further information like content length, etc.

### Displaying Source Code of a Webpage by URLConnecton Class

The URLConnection class provides many methods. We can display all the data of a webpage by using the getInputStream() method. It returns all the data of the specified URL in the stream that can be read and displayed.

### Write a program to display source code of a webpage by URLConnection class

Example:
```java
import java.net.*;
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
```

```java
        try{
            URL url=new URL("http://www.samriddhicollege.com/jbsccsit-college-in-bhaktapur-nepal");
            URLConnection urlcon=url.openConnection();
            InputStream stream=urlcon.getInputStream();
            int i;
            while((i=stream.read())!=-1){
            System.out.print((char)i);
            }
            }catch(Exception e){System.out.println(e);}
```

```java
    }
}
```

**Java Mail API**
The **JavaMail** is an API that is used to compose, write and read electronic messages (emails).
The JavaMail API provides protocol-independent and plateform-independent framework for sending and receiving mails.
The **javax.mail** and **javax.mail.activation** packages contains the core classes of JavaMail API.
The JavaMail facility can be applied to many events. It can be used at the time of registering the user (sending notification such as thanks for your interest to my site), forgot password (sending password to the users email id), sending notifications for important updates etc. So there can be various usage of java mail api.

### Protocols used in JavaMail API

### SMTP

SMTP is an acronym for Simple Mail Transfer Protocol. It provides a **mechanism to deliver the email. **We can use Apache James server, Postcast server, cmail server etc. as an SMTP server. 

### POP

POP is an acronym for Post Office Protocol, also known as POP3. It provides a **mechanism to receive the email.** It provides support for single mail box for each user. We can use Apache James server, cmail server etc. as an POP server.

### IMAP

IMAP is an acronym for Internet Message Access Protocol. IMAP is an **advanced protocol for receiving messages.** It provides support for multiple mail box for each user

### MIME

### JavaMail Architecture

The java application uses JavaMail API to compose, send and receive emails. The JavaMail API uses SPI (Service Provider Interfaces) (google,Hotmail) that provides the intermediatory services to the java application to deal with the different protocols. Let's understand it with the figure given below:

![Figure](images/Ch05_011.png)

### Sending Email in Java:

There are various ways to send email using JavaMail API. For this purpose, you must have SMTP server that is responsible to send mails.
You can use one of the following techniques to get the SMTP server:
Install and use any SMTP server such as Postcast server, Apache James server, cmail server etc. (or)
Use the SMTP server provided by the host provider e.g. my SMTP server is mail.samriddhi.com.np (or)
Use the SMTP Server provided by other companies e.g. gmail etc.
Setting Less Secure Appp In Gmail

![Figure](images/Ch05_012.png)

Go to Security

![Figure](images/Ch05_013.png)

### Enable Two Step Verification


![Figure](images/Ch05_014.png)


![Figure](images/Ch05_015.png)

### Steps to send email using JavaMail API

**Get the session object** that stores all the information of host like host name, username, password etc.

### compose the message

### send the message

### mzdf orxd klmn dimr

Example:

### Sending Email in Java through Gmail Server

We can send email by using the SMTP server of gmail. It is good if you are don't have any SMTP server and reliable. Here we will learn how to send email through gmail server by SSL (Secured Socket Layer). SSL is basically used for security if you are sending email through gmail server.
```java
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
```

```java
public class App {
    public static void main(String[] args) throws Exception {
        //Get properties object
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
```

```java
        //get Session
            Session session = Session.getDefaultInstance(prop,
            new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
            return new PasswordAuthentication("Kamal.nialp@gmail.com","password");
            }
           });
```

```java
        try
        {
        //compose message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("Kamal.nialp@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("suneel.em@gmail.com"));
        message.setSubject("Hello Samriddhi");
        message.setText("Welcome to Samriddhi COllege");
        //send message
        Transport.send(message);
        System.out.println("message sent successfully");
        } catch (MessagingException e) {throw new RuntimeException(e);}
```

```java
    }
```

```java
}
1.Write client and server programs in which a server program accepts a radius of a circle from the client program. Compute area in client side.
```

**Client Side**
*SamriddhiClient.java*
```java
import java.io.*;
import java.net.*;
public class SamriddhiClient {
    public static void main(String args[]) throws IOException
    {
       Socket s = new Socket("localhost",4999);
       String str;
       System.out.println("Enter Radius  :");
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       str = br.readLine();
       PrintStream ps=new PrintStream(s.getOutputStream());
       ps.println(str);
       BufferedReader fs=new BufferedReader(new InputStreamReader(s.getInputStream()));
       String result = fs.readLine();
       System.out.println("Area of the circle is : "+ result);
       br.close();
       fs.close();
       ps.close();
       s.close();
     }
}
```

**ServerSide**

***SamriddhiServer.java***
```java
import java.io.*;
import java.net.*;
class SamriddhiServer
{
   public static void main(String args[]) throws IOException
   {
         ServerSocket ss=new ServerSocket(4999);
         System.out.println("Waiting for Client Request");
         Socket s=ss.accept();
         String str;
         BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
         str=br.readLine();
         System.out.println("Received radius");
         double r=Double.valueOf(str);
         double area=3.14*r*r;
         PrintStream ps=new PrintStream(s.getOutputStream());
         ps.println(String.valueOf(area));
         br.close();
         ps.close();
         s.close();
         ss.close();
```

```java
    }
```

```java
}
```


---

**Table 1:**

| Full form | It stands for Transmission Control Protocol (TCP). | It stands for User Datagram Protocol. |
| --- | --- | --- |
| Type of connection | It is a connection-oriented protocol, which means that the connection needs to be established before the data is transmitted over the network. | It is a connectionless protocol, which means that it sends the data without checking whether the system is ready to receive or not. |
| Reliable | TCP is a reliable protocol as it provides assurance for the delivery of data packets. | UDP is an unreliable protocol as it does not take the guarantee for the delivery of packets. |
| Speed | TCP is slower than UDP as it performs error checking, flow control, and provides assurance for the delivery of | UDP is faster than TCP as it does not guarantee the delivery of data packets. |
| Header size | The size of TCP is 20-60 bytes. | The size of the UDP is 8 bytes. |
| Acknowledgment | TCP uses the three-way-handshake concept. In this concept, if the sender receives the ACK, then the sender will send the data. TCP also has the ability to resend the lost data. | UDP does not wait for any acknowledgment; it just sends the data. |
| Flow control mechanism | It follows the flow control mechanism in which too many packets cannot be sent to the receiver at the same time. | This protocol follows no such mechanism. |
| Applications | This protocol is mainly used where a secure and reliable communication process is required, like military services, web browsing, and e-mail. | This protocol is used where fast communication is required and does not care about the reliability like VoIP, game streaming, video and music streaming, etc. |


**Table 2:**

| S.N. | IP address | Port Number |
| --- | --- | --- |
| 01. | Internet Protocol address (IP address) used to identify a host in network. | Port number is used to identify an processes/services on your system |
| 02. | IPv4 is of 32 bits (4 bytes) size and for IPv6 is 128 bits (16 bytes). | The Port number is 16 bits numbers. |
| 03. | IP address is provided by admin of system or network administrator. | Port number for application is provided by kernel of Operating System. |
| 04. | ipconfig command can be used to find IP address . | netstat  command can be used to find Network Statistics Including Available TCP Ports. |
| 05. | IP address identify a host/computer on a computer network. | Port numbers are logical interfaces used by communication protocols. |
| 06. | 192.168.0.2, 172.16.0.2 are some of IP address examples. | 80 for HTTP, 123 for NTP, 67 and 68 for DHCP traffic, 22 for SSH etc. |


**Table 3:**

| Class | Use |
| --- | --- |
| CookieManager | CookieManager provides a concrete implementation of CookieHandler, which separates the storage of cookies from the policy surrounding accepting and rejecting cookies. |
| DatagramPacket | This class represents a datagram packet. |
| DatagramSocket | This class represents a socket for sending and receiving datagram packets. |
| Inet4Address | This class represents an Internet Protocol version 4 (IPv4) address. |
| Inet6Address | This class represents an Internet Protocol version 6 (IPv6) address. |
| InetAddress | This class represents an Internet Protocol (IP) address. |
| NetPermission | This class is for various network permissions. |
| PasswordAuthentication | The class PasswordAuthentication is a data holder that is used by Authenticator. |
| ResponseCache | Represents implementations of URLConnection caches. |
| ServerSocket | This class implements server sockets. |
| Socket | This class implements client sockets (also called just "sockets"). |
| URI | Represents a Uniform Resource Identifier(URI) reference. |
| URL | Class URL represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web. |
| URLConnection | The abstract class URLConnection is the superclass of all classes that represent a communications link between the application and a URL. |


**Table 4:**

| Method | Description |
| --- | --- |
| public String getProtocol() | it returns the protocol of the URL. |
| public String getHost() | it returns the host name of the URL. |
| public String getPort() | it returns the Port Number of the URL. |
| public String getFile() | it returns the file name of the URL. |
| public String getAuthority() | it returns the authority of the URL. |
| public String toString() | it returns the string representation of the URL. |
| public String getQuery() | it returns the query string of the URL. |
| public String getDefaultPort() | it returns the default port of the URL. |
| public URLConnection openConnection() | it returns the instance of URLConnection i.e. associated with this URL. |
| public boolean equals(Object obj) | it compares the URL with the given object. |
| public Object getContent() | it returns the content of the URL. |
| public String getRef() | it returns the anchor or reference of the URL. |
| public URI toURI() | it returns a URI of the URL. |


**Table 5:**

| There are some protocols that are used in JavaMail API.
SMTP
POP
IMAP
MIME
NNTP and others |
| --- |


**Table 6:**

| Multiple Internet Mail Extension (MIME) tells the browser what is being sent e.g. attachment, format 
of the messages etc. It is not known as mail transfer protocol but it is used by your mail program.
NNTP and Others
There are many protocols that are provided by third-party providers. Some of them are Network News
 Transfer Protocol (NNTP), Secure Multipurpose Internet Mail Extensions (S/MIME) etc. |
| --- |


**Table 7:**

| For better understanding of this example, learn the steps of sending email using JavaMail API first. |
| --- |
| For sending the email using JavaMail API, you need to load the two jar files:
mail.jar
activation.jar |


---

## Socket Programming Lab

*Source: `SocketProgrammingLab.docx`*

> 📷 *This document contains images/diagrams — see the original .docx for visual content*

### InetAddress Class: (Imp)

It is part of **java.net** package used representation IP address, both IPv4 and IPv6.
It can resolve **hostname** to **IP address** and vice versa.

### TCP (Transmission Control Protocol)

(TCP) is a communications standard that enables application programs and computing devices to **exchange messages over a network**.
It is designed to **send ** across the internet and ensure the **successful delivery of data and messages** over networks.
**Ensuring** it gets delivered to the **destination** application or device that **IP has defined.**
**IP** **(Internet Protocol**) **defines** how to **address** and **route** each packet to make sure it reaches the **right destination**. 
Each gateway computer on the network  **to determine where to forward the message.**
**Creating InetAddress Object
**There are no public constructors in the **InetAddress** class. Instead, **InetAddress** has **Static Factory Methods** that connect to a **DNS** (Domain Name Server) server to resolve a **hostname **(IP address to Name). The most common is **InetAddress.getByName()**. For example, this is how you look up www.google.com: 
**Import java.net.*;**
```java
InetAddress obj=InetAddress.getByName("www.samriddhi.com.np");
      System.out.println(obj);//www.samriddhi.com.np/181.214.31.79
```

** Output:**


### Steps to Create new InetAddress Object

Create a java file named: **InetAddressExample.java**
```java
Add header import java.net.*;
Declare object of InetAddress with calling getByName(“www.samriddhi.com.np”) static method.
InetAddress address = InetAddress.getByName("www.samriddhi.com.np ");
Print the result using
System.out.println(address);
You can also do a reverse lookup by IP address. For example, if you want the hostname for the address 181.214.31.79, pass the dotted quad address to InetAddress.getByName()
import java.net.*;
public class App {
    public static void main(String[] args) throws UnknownHostException {
      InetAddress obj=InetAddress.getByName("www.samriddhi.com.np");
      System.out.println(obj);//www.samriddhi.com.np/181.214.31.79
```

```java
    }
Output:
www.samriddhi.com.np/181.214.31.79
```

**Commonly used methods of InetAddress class:( important)**

### Factory Method:

**getByName(String host):** creates an InetAddress object based on the provided hostname.
** getByAddress(byte[] addr):** returns an InetAddress object from a byte array of the raw IP address. 
** getAllByName(String host):** returns an array of InetAddress objects from the specified hostname, as a hostname can be associated with several IP addresses.
**getLocalHost():** returns the address of the localhost.

### Example: InetAddress.getByAddress(byte[] addr)

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
    byte[] ip = new byte[]{127, 0, 0, 1};
    InetAddress address = InetAddress.getByAddress(ip);  //Factory Method
    System.out.println(address.getHostAddress());//Getter Method
    }
}
```

**Example: InetAddress.getByName(String host)**
```java
import java.net.*;
public class App {
    public static void main(String[] args) throws UnknownHostException {
      InetAddressobj=InetAddress.getByName("www.samriddhi.com.np");//FactoryMetho
      System.out.println(obj);//www.samriddhi.com.np/181.214.31.79
```

```java
    }
Example: InetAddress.getLocalHost()
import java.net.*;
public class App {
    public static void main(String[] args) throws UnknownHostException {
      InetAddress address = InetAddress.getLocalHost();
      System.out.println(address.getHostAddress());
System.out.println(address.getHostName());
    }
}
```

**Example: InetAddress.getAllByName(String host)**
```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
        InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
        for (InetAddress address : addresses)
        {
        System.out.println(address);
        }
    }
}
Output:
www.google.com/142.250.192.164
www.google.com/2404:6800:4002:816:0:0:0:2004
```

**Getter Method:**
The **InetAddress** class contains **four getter** methods that return the **hostname** as a string and the **IP address** as both a **string** and a **byte array**: 
 **getHostAddress():** it returns the IP address in string format.
**getHostName():** it returns the host name of the IP address.
**getCanonicalHostName():**return fully qualified domain name for this IP. 
**getAddress()** :returns a multiple the dotted quad format of the IP address.
```java
public String getHostName();//returns a String the name of the host with the IP address.
public String getCanonicalHostName()//return fully qualified domain name for this IP. 
public byte[] getAddress() // returns a multiple the dotted quad format of the IP address.
public String getHostAddress()// return plain format ipaddress.
```

```java
Lab 1. Find the address and hostname of the local machine.
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
```

**Output:**
192.168.1.78
LAPTOP-4ASDH0QE
2.Write a java program to find canonicalHostName, HostName, IpAddress of www.iost.com.np
```java
import java.net.*;
public class App {
    public static void main(String[] args) throws UnknownHostException {
      InetAddress address = InetAddress.getByName("www.google.com.np");
      System.out.println(address.getCanonicalHostName());
      System.out.println(address.getHostAddress());
      System.out.println(address.getHostName());
      byte[] arr =address.getAddress();
      for(byte b : arr)
      {
      System.out.println(b);
      }
    }
}
Output:
maa05s20-in-f3.1e100.net
142.250.182.67
www.google.com.np
-114
-6
-74
67
```

```java
Q. Write a program to retrieve Hostname, IP Address and Mac Address of Local Machine.
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String ipAddress = localHost.getHostAddress();
        NetworkInterface network = NetworkInterface.getByInetAddress(localHost);
        byte[] mac = network.getHardwareAddress();
        // Print the details
        System.out.println("Hostname: " + hostName);
        System.out.println("IP Address: " + ipAddress);
        System.out.print("MacAddress: ");
        if (mac != null) {
            for (int i = 0; i < mac.length; i++) {
                System.out.printf("%02X", mac[i]);
            }
        }
    }
}
```

**SOCKET:**

A socket is a mechanism for allowing communication between processes, be it programs running on the same machine or different computers connected on a network. 
The socket provides bidirectional FIFO Communication facility over the network. 
Each socket has a specific address. This address is composed of an **IP address** and a **port number**. 
Socket are generally employed in **client server applications**.
The server creates a socket, attaches it to a **network port addresses** then waits for the client to contact it. 
The client creates a **socket** and then attempts to connect to the **server socket**. When the connection is established, transfer of data takes place.
A socket is a connection between two hosts. It can perform seven basic operations:
• Connect to a remote machine
• Send data
• Receive data
• Close a connection
• Bind to a port Listen for incoming data
• Accept connections from remote machines on the bound port

![Figure](images/Ch05_016.jpeg)

Types of Sockets : There are two types of Sockets: the datagram socket and the stream socket.
**Datagram Socket :** A datagram socket uses the **User Datagram Protocol (UDP)** for sending messages. **UDP** is a much simpler protocol as it does not provide any of the delivery guarantees that TCP does. 
**Stream Socket** A stream socket uses the **Transmission Control Protocol (TCP)** for sending messages.  network socket which provides a **connection-oriented, sequenced, and unique flow of data without record.** It is similar to phone. A connection is established between the phones (two ends) and a conversation (transfer of data) takes place.

**Write a java program to write data to server using socket.**

### MyClient.java

```java
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException {
          Socket client = new Socket("localhost", 1234);
           PrintWriter out = new PrintWriter(client.getOutputStream(), true);
           out.println("Hello from client");
           client.close();
    }
}
```

**MyServer.java**
```java
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket server = serverSocket.accept();
        System.out.println("Client Connected");
               BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));//read data so Inputstream
        String clientMessage = in.readLine();
        System.out.println("Client says: " + clientMessage);
        server.close();
        serverSocket.close();
```

```java
    }
}
Write a java program to read data from server using socket.
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException{
        Socket client = new Socket("localhost", 1234);
       BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String serverMessage = in.readLine();
        System.out.println("Server says: " + serverMessage);
        in.close();
        client.close();
    }
}
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket server = serverSocket.accept();
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        out.println("Hello from server");
        out.close();
        server.close();
        serverSocket.close();
    }
}
```

**Write a program to perform basic two way operation between client and server**

### MyClient.java

```java
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException {
         Socket clientSocket = new Socket("localhost", 1234);
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int a=5;
        int b=6;
        out.println(a + " " + b);
        String serverResponse = in.readLine();
        System.out.println("Sum from server: " + serverResponse);
        clientSocket.close();
    }
}
```

**MyServer.java**
```java
import java.io.*;
import java.net.*;
```

```java
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to Client");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       // Read the numbers from the client
       String inputLine = in.readLine();
       System.out.println("Received from client: " + inputLine);
       String[] numbers = inputLine.split(" ");
       int a = Integer.parseInt(numbers[0]);
       int b = Integer.parseInt(numbers[1]);
       int sum = a + b;
        System.out.println("Calculated sum: " + sum);
        out.println(sum);
        clientSocket.close();
        serverSocket.close();
    }
```

```java
}
```

**URL(Uniform Resource Locator)**
It is string of characters refers to just the address.
It is the most used way to locate resources on the web.

![Figure](images/Ch05_012.png)

The **URL** Class is the simplest way for a java program to **locate** and **retrieve** information form the network.
It consists of multiple parts including protocols, IP address, path and port to locate the information and the mechanism for retrieving it.
URL uses protocol such as **http://** and **ftp://** to identify the resource
The syntax of a URL is: 

### protocol://userInfo@host:port/path?query#fragment


![Figure](images/Ch05_017.jpeg)

Absolute URL: With absolute URL, you put the **exact address on the page** that you’re linking too. For example, a tag with an absolute URL would look like 
*<a **href** = https://yourwebsite.com/yourpage.html>*
Relative URL: A relative URL does not have a full address. Instead, it tells the browser to assume that the **page is on the same website**. So, to get to yourpage.html, your tag would look like 
*<a **href** = "yourpage.html">*

### Component of URL


![Figure](images/Ch05_018.jpeg)

The **Scheme**, which is the **protocol** that you’re using to interact.
The **Authority**, which is **the target you’re accessing**. This breaks down into **userinfo**, **host**, and **port**.
The **Path**, which is **the resource** you’re requesting on the host.
The **Query**, which are the **parameters** being used within the web application.
The **Fragment**, which is the target to jump to **within a given page**.

### The URL Class:

The java.net.URL class is an abstraction of a Uniform Resource Locator such as http:// www.samriddhicollege.edu.np/ or .

### Creating New URLs

Unlike the **InetAddress** objects, you can construct instances of **java.net.URL**. The constructors differ in the information they require:
```java
public URL(String url) throws MalformedURLException
(Creates an instance of a URL from the String representation.)
Example:
URL url1 = new URL("https://samriddhicollege.edu.np/bca-college-in-kathmandu-valley/");
```

```java
public URL(String protocol, String hostname, String file)
throws MalformedURLException
(Creates an instance of a URL from the given protocol name, host name, and file name.)
Exammple:
URL urlexample=new URL("Https", "samriddhicollege.edu.np", "/bca-college-in-kathmandu-valley/");
```

```java
public URL(String protocol, String host, int port, String file)
throws MalformedURLException
(Creates an instance of a URL from the given protocol, host, port number, and file.)
Example:
URL urlexample=new URL("Https", "samriddhicollege.edu.np",443, "/bca-college-in-kathmandu-valley/");
```

```java
public URL(URL base, String relative) throws MalformedURLException
(Creates an instance of a URL by parsing the given spec within a specified context.)
URL u1=new URL("https://www.samriddhicollge.edu.np");
  	URL u2=new URL(u1, "bca-college-in-kathmandu-valley");
```

```java
All these constructors throw a MalformedURLException if you try to create a URL for an unsupported protocol or if the URL is syntactically incorrect.
Lab: write a java program to spit different component of url from given url: (https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2)
Example:
Import java.net.*;
    public static void main(String[] args) throws MalformedURLException {
URL url1 = new URL("https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2");
        System.out.println(url1.toString());
        System.out.println();
        System.out.println(
            "Different components of the URL1-");
       System.out.println("Protocol:- " + url1.getProtocol());
        System.out.println("Hostname:- " + url1.getHost()); System.out.println("Default port:- "+ url1.getDefaultPort());
        // Retrieving the query part of URL
        System.out.println("Query:- " + url1.getQuery());
        // Retrieving the path of URL
        System.out.println("Path:- " + url1.getPath());
        // Retrieving the file name
        System.out.println("File:- " + url1.getFile());
        // Retrieving the reference
        System.out.println("Reference:- " + url1.getRef());
        }
```

***Output:***

### Different components of the URL1-

### Protocol:- https

### Hostname:- www.example.com

### Default port:- 443

### Query:- key1=value1&key2=value2

### Path:- /path/to/resource

### File:- /path/to/resource?key1=value1&key2=value2

### Reference:- section2

### Retrieving Data from a URL:

The URL class has several methods that retrieve data from a URL

```java
public InputStream openStream() throws IOException
public URLConnection openConnection() throws IOException
public URLConnection openConnection(Proxy proxy) throws IOException
public Object getContent() throws IOException
public Object getContent(Class[] classes) throws IOException
```

**openStream():**
Method in Java is used to retrieve data from a URL. 
It is a method of the **URL** class in the **java.net** package and returns an **InputStream** that can be used to read data from the url.
It does not include any of the **HTTP headers** or any other **protocol-related information**.

**Write a java program to read content of website name example.com.**

### OpenStream Example:

```java
import java.io.*;
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception  {
        try {
            URL u = new URL("https://www.example.com");
            InputStream in = u.openStream();
            int c;
            while ((c = in.read()) != -1)
{
System.out.write(c);
}
in.close();
           }
catch (IOException ex) {
            System.err.println(ex);
           }
    }
}
	BufferedReader in = new BufferedReader(
        new InputStreamReader(u.openStream()));
```

```java
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
```

**openConnection():**
The **URLConnection** gives you **access to everything sent by the server**: in addition to the document itself in its raw form (e.g., HTML, plain text, binary image data).
Method used to create **URLConnection** object **access to everything from document raw** form (e.g., HTML, plain text, binary image data).
It belongs to **URL** class in **java.net** package
**URLConnection** lets you access the **HTTP headers** as well as the **raw HTML**

### OpenConnection Example:

```java
import java.io.*;
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception  {
        StringBuilder content = new StringBuilder();
          try
          {
            URL u = new URL("https://www.example.com
");
            URLConnection uc = u.openConnection();
            InputStream in = uc.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
              content.append(line + "\n");
            }
            bufferedReader.close();
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }
          System.out.println(content);
    }
}
```

**getContent():**
Method of **URLConnection** class used for retrieving the content of url in object form.
Fetch data without **InputStream**

### GetContentExample:

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception  {
        URL url1=new URL("https://samriddhicollege.edu.np/contact-us/");
        System.out.println(" Given Url is : "+url1);
        System.out.println(" The content of given url is: "+url1.getContent());
    }
```

```java
}
Output:
Given Url is : https://www.ncell.com.np/en/about/career
 The content of given url is: sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@ca263c2
```

```java
Write a program to download HTML page.
import java.io.*;
import java.net.*;
public class App {
       public static void main(String[] args) throws Exception {
        String page = "index.html";
        try {
            URL url = new URL("https://example.com");
            URLConnection connection = url.openConnection(); // Open connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(page));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("Page downloaded Successfully " + page);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

**URL Connection: **

### Comparision:

**URL**: Mainly deals with parsing and handling the URL string.
**URLConnection**: Deals with the communication with the URL resource, allowing you to **send requests** and **receive responses**.
The **URLConnection** class contains many **methods** that let you communicate with the URL over the network.
**URLConnection** is an **HTTP-centric** class, many of its methods are useful when working with HTTP URLs. 
This **URLConnection** class helps read and write the data to the specific/specified resource, which is actually referred to by an URL.
**URLConnection** can send data back to a web server with POST, PUT, and other HTTP
request methods

### Opening URLConnection:

A program that uses the **URLConnection** class directly follows this basic sequence of
steps:
Construct a URL object.
Invoke the URL object’s **openConnection()** method to retrieve a
**URLConnection** object for that URL.
Configure the **URLConnection**.
Read the header fields.
Get an input stream and read data.
Get an output stream and write data.
Close the connection.
```java
The single constructor for the URLConnection class is protected:
protected URLConnection(URL url)
try {
            URL u = new URL("http://www.google.com/");
            URLConnection uc = u.openConnection();
            // read from the URL...
            } catch (MalformedURLException ex) {
            System.err.println(ex);
            } catch (IOException ex) {
            System.err.println(ex);
            }
```

```java
public abstract void connect() throws IOException
```

```java
When a URLConnection is first constructed, it is unconnected; that is, the local and
remote host cannot send and receive data. There is no socket connecting the two hosts.
The connect() method establishes a connection—normally using TCP sockets.
```

```java
Write a Java program to retrieving Specific Header Fields from URL using URLConnection Class.
import java.net.*;
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
```

```java
          URL u = new URL("https://samriddhicollege.edu.np/contact-us/");
          URLConnection uc = u.openConnection();
            System.out.println("Content-type: " + uc.getContentType());
            System.out.println("Content-encoding: " + uc.getContentEncoding());
            System.out.println("Date: " + new Date(uc.getDate()));
            System.out.println("Last modified: " + new Date(uc.getLastModified()));
            System.out.println("Expiration date: "+ new Date(uc.getExpiration()));
            System.out.println("Content-length: " + uc.getContentLength());
```

```java
    }
}
```

**UDP (User Datagram Packet) Protocol:**
**Connection-less Protocol** faster than TCP(connection oriented protocol)
Using User Datagram Protocol, Applications can send data/message to the other hosts without communications or channel or path.
Even if the destination host is not available, application can send data
There is **no guarantee** that the data is received in the other side
Good for video streaming.

### Java’s Implementation of UDP

To implement UDP in Java, you can use the **DatagramSocket** and **DatagramPacket** classes.

### DatagramSocket

**DatagramSocket** is used to **send** and **receive** UDP packets.
It can be created with or without a specific port number.
**send(packet)** sends a packet to a specified address.
**receive(packet)** waits for a packet to receive.

### DatagramPacket

**DatagramPacket** represents a **packet of data** to be sent or received.
It contains the **data**, **the length of the data**, **and the address/port** of the destination.
**DatagramPacket(byte[] buf, int length)** creates a packet to receive data.
**DatagramPacket(byte[] buf, int length, InetAddress address, int port)** creates a packet to send data.

### Simple UDP Client:

Import Required Classes: You need **DatagramSocket**, **DatagramPacket**, and **InetAddress**.
Create DatagramSocket: This is UDP socket used to send data.
Prepare the Message: Convert the message **string** to **bytes**.
Create DatagramPacket: This packet contains the **message, destination address, and port.**
Send the Packet: Use the **send** method of **DatagramSocket**.
Close the Socket: Always **close** the socket to free up resources.

### Simple Program:

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
      // Create a DatagramSocket
      DatagramSocket clientSocket = new DatagramSocket();
      // Prepare the message to be sent
      String message = "Hello, UDP Server!";
      byte[] sbuffer = message.getBytes();
      // Create a DatagramPacket with the server's address and port
      InetAddress serverAddress = InetAddress.getByName("localhost");
      DatagramPacket sendPacket = new DatagramPacket(sbuffer, sbuffer.length, serverAddress, 5000);
      // Send the packet
      clientSocket.send(sendPacket);
      // Close the socket
      clientSocket.close();
    }
}
```

```java
UDPServer.java
import java.net.*;
public class UDPServer {
     public static void main(String[] args) {
        try {
            // Create a DatagramSocket bound to a specific port
            DatagramSocket serverSocket = new DatagramSocket(5000);
            // Prepare a buffer to hold incoming data
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            // Wait for and receive a packet (blocking call)
            System.out.println("Server is waiting for a packet...");
            serverSocket.receive(receivePacket);
            // Process the received data
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + receivedMessage);
            // Close the socket
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
Write a UDP client and server socket program in which server identifies the number sent by client either even or odd and replies the client accordingly
```


![Figure](images/Ch05_019.png)


![Figure](images/Ch05_020.png)


---

**Table 1:**

| Method | Description |
| --- | --- |
| InetAddress.getByName(String host) | Resolves a hostname to an IP address. |
| InetAddress.getByAddress(byte[] addr) | Creates an instance from a raw IP address. |
| InetAddress.getLocalHost() | Gets the local machine's IP address. |
| InetAddress.getAllByName(String host) | Retrieves all IP addresses for a hostname. |


---

## Socket Programming (Additional)

*Source: `SocketNew.docx`*

> 📷 *This document contains images/diagrams — see the original .docx for visual content*

Socket Programming:
A socket is a mechanism for allowing communication between processes, be it programs running on the same machine or different computers connected on a network. 
The socket provides bidirectional FIFO Communication facility over the network. 
Each socket has a specific address. This address is composed of an **IP address** and a **port number**. 
Socket are generally employed in **client server applications**.
The server creates a socket, attaches it to a **network port addresses** then waits for the client to contact it. 
The client creates a **socket** and then attempts to connect to the **server socket**. When the connection is established, transfer of data takes place.
A socket is a connection between two hosts. It can perform seven basic operations:
• Connect to a remote machine
• Send data
• Receive data
• Close a connection
• Bind to a port Listen for incoming data
• Accept connections from remote machines on the bound port

![Figure](images/Ch05_012.png)

Types of Sockets : There are two types of Sockets: the datagram socket and the stream socket.
**Datagram Socket :** A datagram socket uses the **User Datagram Protocol (UDP)** for sending messages. **UDP** is a much simpler protocol as it does not provide any of the delivery guarantees that TCP does. 
**Stream Socket** A stream socket uses the **Transmission Control Protocol (TCP)** for sending messages.  network socket which provides a **connection-oriented, sequenced, and unique flow of data without record.** It is similar to phone. A connection is established between the phones (two ends) and a conversation (transfer of data) takes place.

### Reading from Servers with Sockets

Basic step to read data from servers with sockets
Open a socket.
Open an input stream and output stream to the socket.
Read from and write to the stream according to the server's protocol.
Close the streams.
Close the socket.

### Reading from Server

```java
import java.io.*;
import java.net.*;
public class App {
    public static void main(String[] args) throws IOException {
       Socket socket = new Socket("time.nist.gov", 13);//1.connect to remote machine
      socket.setSoTimeout(15000);
      InputStream in = socket.getInputStream();//2. open stream
      StringBuilder time = new StringBuilder();
      InputStreamReader reader = new InputStreamReader(in, "ASCII");//3. read data
      int c;
      while ((c = reader.read()) != -1)
        {
        time.append((char) c);
        }
      reader.close();//4. close the stream
      socket.close();//5. Close the socket
      System.out.println(time);
```

```java
    }
```

```java
}
```

```java
Output:
60058 23-04-24 05:04:08 50 0 0 131.2 UTC(NIST) *
```

**Another Example:**
**Lab27: Write a Java program to read data from server using socket.**

### Reading from Server

Create MyClient.java class
```java
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException {
        // Create a socket to connect to the server
        Socket clientSocket = new Socket("localhost", 1234);
        // Create input stream to read data from the server
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//read data so InputStream
        // Read data from the server
        String serverResponse = in.readLine();
        System.out.println("Server says: " + serverResponse);
        // Close the connection
        clientSocket.close();
    }
```

```java
}
Create MyServer.java
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        // Wait for a client to connect
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to Client");
        // Create output stream to send data to the client
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //send data so output Stream
        // Send the current date and time to the client
        out.println("Hello from server");
        // Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}
```

```java
    }
```

```java
    }
}
```

```java
Output:
Connected to localhost on port 1234
Server says: Hello from server
```

**Writing to Server with Socket**
**Lab28: Write a java program to write data to server using socket.**

### MyClient.java

```java
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException {
           // Create a socket to connect to the server
           Socket client = new Socket("localhost", 1234);
           // Create output stream to send data to the server
           PrintWriter out = new PrintWriter(client.getOutputStream(), true);//send data so output stream
           // Send data to the server
           out.println("Hello from client");
           // Close the connection
           client.close();
    }
}
```

**MyServer.java**
```java
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");
        // Wait for a client to connect
        Socket server = serverSocket.accept();
        // Create input stream to read data from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));//read data so Inputstream
        // Read and print the message from the client
        String clientMessage = in.readLine();
        System.out.println("Client says: " + clientMessage);
        // Close the connection
        server.close();
        serverSocket.close();
```

```java
    }
}
33.Lab: Write a java program to perform basic two-way operation between client and server using TCP.
34.Lab: Write a simple chat application using TCP Socket.
```

**MyClient.java**
```java
import java.io.*;
import java.net.*;
public class MyClient {
    public static void main(String[] args) throws IOException {
         Socket clientSocket = new Socket("localhost", 1234);
          // Set up input and output streams
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        int a=5;
        int b=6;
        out.println(a + " " + b);
        String serverResponse = in.readLine();
        System.out.println("Sum from server: " + serverResponse);
        clientSocket.close();
    }
}
```

**MyServer.java**
```java
import java.io.*;
import java.net.*;
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to Client");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       // Read the numbers from the client
       String inputLine = in.readLine();
       System.out.println("Received from client: " + inputLine);
       String[] numbers = inputLine.split(" ");
       int a = Integer.parseInt(numbers[0]);
       int b = Integer.parseInt(numbers[1]);
       int sum = a + b;
        System.out.println("Calculated sum: " + sum);
        out.println(sum);
        clientSocket.close();
        serverSocket.close();
    }
```

```java
}
```

**UDP (User Datagram Packet) Protocol:**
**Connection-less Protocol** faster than TCP(connection oriented protocol)
Using User Datagram Protocol, Applications can send data/message to the other hosts without communications or channel or path.
Even if the destination host is not available, application can send data
There is **no guarantee** that the data is received in the other side
Good for video streaming.

### Java’s Implementation of UDP

To implement UDP in Java, you can use the **DatagramSocket** and **DatagramPacket** classes.

### DatagramSocket

**DatagramSocket** is used to **send** and **receive** UDP packets.
It can be created with or without a specific port number.
**send(packet)** sends a packet to a specified address.
**receive(packet)** waits for a packet to receive.

### DatagramPacket

**DatagramPacket** represents a **packet of data** to be sent or received.
It contains the **data**, **the length of the data**, **and the address/port** of the destination.
**DatagramPacket(byte[] buf, int length)** creates a packet to receive data.
**DatagramPacket(byte[] buf, int length, InetAddress address, int port)** creates a packet to send data.

### UDP Client and Server

### UDP Client:

The UDP client sends data to a UDP server.
Unlike TCP, UDP does not establish a connection before sending data.
The client creates a **DatagramSocket** to handle sending and receiving data packets.
The client prepares the data, wraps it in a **DatagramPacket**, and sends it to the server's address and port.
The client can use any available port for sending data, and the system assigns this port automatically.**
**

### Simple UDP Client:

Import Required Classes: You need **DatagramSocket**, **DatagramPacket**, and **InetAddress**.
Create DatagramSocket: This is UDP socket used to send data.
Prepare the Message: Convert the message **string** to **bytes**.
Create DatagramPacket: This packet contains the **message, destination address, and port.**
Send the Packet: Use the **send** method of **DatagramSocket**.
Close the Socket: Always **close** the socket to free up resources.

### Simple Program:

```java
import java.net.*;
public class App {
    public static void main(String[] args) throws Exception {
      // Create a DatagramSocket
      DatagramSocket clientSocket = new DatagramSocket();
      // Prepare the message to be sent
      String message = "Hello, UDP Server!";
      byte[] sbuffer = message.getBytes();
      // Create a DatagramPacket with the server's address and port
      InetAddress serverAddress = InetAddress.getByName("localhost");
      DatagramPacket sendPacket = new DatagramPacket(sbuffer, sbuffer.length, serverAddress, 5000);
      // Send the packet
      clientSocket.send(sendPacket);
      // Close the socket
      clientSocket.close();
    }
}
```

**Step to create UDP Client Socket**
Creates a **DatagramSocket**.

Converts the message to **bytes**.

Creates a **DatagramPacket** with the message, **server address**, and **server port**.

Send the packet using the **send** method.

Wait for a response from the server if needed
Closes the socket to free resources.

### UDP Server:

The UDP server receives data from UDP clients.
The server needs to listen on a specific port, so clients know where to send the data.
The server creates a **DatagramSocket** bound to the specific port to receive incoming packets.
The server waits for incoming packets, processes the received data, and optionally sends a response back to the client.
The server uses a **blocking call** to wait for data, meaning it will pause and wait until a packet arrives.

UDPServer.java
```java
import java.net.*;
public class UDPServer {
     public static void main(String[] args) {
        try {
            // Create a DatagramSocket bound to a specific port
            DatagramSocket serverSocket = new DatagramSocket(5000);
            // Prepare a buffer to hold incoming data
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            // Wait for and receive a packet (blocking call)
            System.out.println("Server is waiting for a packet...");
            serverSocket.receive(receivePacket);
            // Process the received data
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + receivedMessage);
            // Close the socket
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
39Lab: write a simple UDP java program to send data from client to server.
40Lab: Write a UDP client and server socket program in which server identifies the number sent by client either even or odd and replies the client accordingly.(2024)
41Lab:Write a UDP client-server socket program where the client sends a number to the server. The server checks whether the number is prime or not.
42Lab:Write a UDP client-server program where the client requests the current time, and the server responds with the system's current time.
```


![Figure](images/Ch05_019.png)


![Figure](images/Ch05_020.png)

**URL(Uniform Resource Locator)**
It is string of characters refers to just the address.
It is the most used way to locate resources on the web.

![Figure](images/Ch05_017.jpeg)

The **URL** Class is the simplest way for a java program to **locate** and **retrieve** information form the network.
It consists of multiple parts including protocols, IP address, path and port to locate the information and the mechanism for retrieving it.
URL uses protocol such as **http://** and **ftp://** to identify the resource
The syntax of a URL is: 

### protocol://userInfo@host:port/path?query#fragment


![Figure](images/Ch05_018.jpeg)

**URL-** Accessing resources 
URN- Identifying resources

### URN (Uniform Resource Name)

A URN identifies a resource by name, not by where it’s located.
A URN is like a person’s name — it identifies who they are, not where they live.

### Component of URL


![Figure](images/Ch05_018.jpeg)

The **Scheme**, which is the **protocol** that you’re using to interact.
The **Authority**, which is **the target you’re accessing**. This breaks down into **userinfo**, **host**, and **port**.
The **Path**, which is **the resource** you’re requesting on the host.
The **Query**, which are the **parameters** being used within the web application.
The **Fragment**, which is the target to jump to **within a given page**.

```java
Lab: write a java program to spit different component of url from given url: (https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2)
Example:
Import java.net.*;
    public static void main(String[] args) throws MalformedURLException {
URL url1 = new URL("https://www.example.com:8080/path/to/resource?key1=value1&key2=value2#section2");
        System.out.println(url1.toString());
        System.out.println();
        System.out.println(
            "Different components of the URL1-");
       System.out.println("Protocol:- " + url1.getProtocol());
        System.out.println("Hostname:- " + url1.getHost()); System.out.println("Default port:- "+ url1.getDefaultPort());
        // Retrieving the query part of URL
        System.out.println("Query:- " + url1.getQuery());
        // Retrieving the path of URL
        System.out.println("Path:- " + url1.getPath());
        // Retrieving the file name
        System.out.println("File:- " + url1.getFile());
        // Retrieving the reference
        System.out.println("Reference:- " + url1.getRef());
        }
```

***Output:***

### Different components of the URL1-

### Protocol:- https

### Hostname:- www.example.com

### Default port:- 443

### Query:- key1=value1&key2=value2

### Path:- /path/to/resource

### File:- /path/to/resource?key1=value1&key2=value2

### Reference:- section2

### InetAddress Class: (Imp)

It is part of **java.net** package used representation IP address, both IPv4 and IPv6.
It can resolve **hostname** to **IP address** and vice versa.

**Creating InetAddress Object
**There are no public constructors in the **InetAddress** class. Instead, **InetAddress** has **Static Factory Methods** that connect to a **DNS** (Domain Name Server) server to resolve a **hostname **(IP address to Name). The most common is **InetAddress.getByName()**. For example, this is how you look up www.google.com: 
**Import java.net.*;**
```java
InetAddress obj=InetAddress.getByName("www.samriddhi.com.np");
System.out.println(obj);//www.samriddhi.com.np/181.214.31.79
```


---
