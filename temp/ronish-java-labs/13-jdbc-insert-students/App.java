import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        String insert = "INSERT INTO student (id, name, gender, address) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insert);

        ps.setInt(1, 1); ps.setString(2, "Ram"); ps.setString(3, "Male");
        ps.setString(4, "Kathmandu"); ps.executeUpdate();

        ps.setInt(1, 2); ps.setString(2, "Sita"); ps.setString(3, "Female");
        ps.setString(4, "Pokhara"); ps.executeUpdate();

        ps.setInt(1, 3); ps.setString(2, "Hari"); ps.setString(3, "Male");
        ps.setString(4, "Lalitpur"); ps.executeUpdate();

        ps.setInt(1, 4); ps.setString(2, "Gita"); ps.setString(3, "Female");
        ps.setString(4, "Bharatpur"); ps.executeUpdate();

        ps.setInt(1, 5); ps.setString(2, "Shyam"); ps.setString(3, "Male");
        ps.setString(4, "Biratnagar"); ps.executeUpdate();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student ORDER BY name ASC");
        System.out.println("ID\tName\t\tGender\t\tAddress");
        System.out.println("----------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getString("gender") + "\t\t" + rs.getString("address"));
        }

        con.close();
    }
}
