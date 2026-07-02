import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement();

        System.out.println("Before Update:");
        ResultSet rs = st.executeQuery("SELECT * FROM tblEmployee");
        System.out.println("ID\tName\t\tSalary");
        System.out.println("---------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getDouble("salary"));
        }

        int updated = st.executeUpdate(
            "UPDATE tblEmployee SET salary = salary + (salary * 15 / 100) WHERE salary < 20000");
        System.out.println("\nRows updated: " + updated);

        System.out.println("\nAfter Update:");
        rs = st.executeQuery("SELECT * FROM tblEmployee");
        System.out.println("ID\tName\t\tSalary");
        System.out.println("---------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getDouble("salary"));
        }

        con.close();
    }
}
