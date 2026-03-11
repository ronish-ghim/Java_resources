import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {

        // Connect to the database

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasamriddhi?useSSL=false",
                    "root",
                    "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

            }
            conn.close();
        } catch (Exception e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

    }

}
