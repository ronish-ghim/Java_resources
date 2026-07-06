# Lab 17: Ronish jdbc updatable resultset

## Source Code

### App.java

```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM tblEmployee WHERE id = ?",
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Before Update:");
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

            rs.updateString("name", "Rons");
            rs.updateRow();

            System.out.println("\nAfter Update:");
            rs.beforeFirst();
            rs.next();
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        }

        con.close();
    }
}
```