# Lab 16: Ronish jdbc resultset nav

## Source Code

### App.java

```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM tblEmployee");

        System.out.println("--- first() ---");
        rs.first();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- last() ---");
        rs.last();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- previous() ---");
        rs.previous();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- beforeFirst() then next() ---");
        rs.beforeFirst();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        }

        con.close();
    }
}
```