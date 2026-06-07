# Lab 17: JDBC Updatable ResultSet

## Objective
Use CONCUR_UPDATABLE ResultSet to update employee name and show before/after values.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM emp WHERE id = ?",
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Before Update:");
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

            rs.updateString("name", "UpdatedName");
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

## Output
```
Before Update:
ID: 1, Name: OriginalName

After Update:
ID: 1, Name: UpdatedName
```

## Conclusion
Learned to use CONCUR_UPDATABLE ResultSet to update records directly through the result set.
