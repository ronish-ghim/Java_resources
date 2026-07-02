import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        String insert = "INSERT INTO tblStudent (name, gender, address) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insert);

        ps.setString(1, "Ram");
        ps.setString(2, "Male");
        ps.setString(3, "Kathmandu");
        ps.executeUpdate();

        ps.setString(1, "Sita");
        ps.setString(2, "Female");
        ps.setString(3, "Pokhara");
        ps.executeUpdate();

        ps.setString(1, "Hari");
        ps.setString(2, "Male");
        ps.setString(3, "Lalitpur");
        ps.executeUpdate();

        ps.setString(1, "Gita");
        ps.setString(2, "Female");
        ps.setString(3, "Bharatpur");
        ps.executeUpdate();

        ps.setString(1, "Shyam");
        ps.setString(2, "Male");
        ps.setString(3, "Biratnagar");
        ps.executeUpdate();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tblstudent ORDER BY name ASC");
        System.out.println("ID\tName\t\tGender\t\tAddress");
        System.out.println("----------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                    + "\t\t" + rs.getString("gender") + "\t\t" + rs.getString("address"));
        }

        con.close();
    }
}
