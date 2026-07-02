import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS tblStudent ("
                + "id INT PRIMARY KEY, "
                + "name VARCHAR(50), "
                + "email VARCHAR(100))");
        System.out.println("Table created successfully.");

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tblStudent (name, email) VALUES ( ?, ?)");
        ps.setString(1, "Ronish");
        ps.setString(2, "ronish@example.com");
        ps.executeUpdate();
        System.out.println("Record inserted successfully.");

        ResultSet rs = st.executeQuery("SELECT * FROM tblStudent");
        System.out.println("\nID\tName\t\tEmail");
        System.out.println("--------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                    + "\t\t" + rs.getString("email"));
        }

        con.close();
    }
}
