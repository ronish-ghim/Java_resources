import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            String DBNAME = "javasamriddhi";
            String sql = "Select * from tblStudent";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=false",
                    "root", "");

            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            rs.first();

            System.out.println(
                    "ID: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Gender: " + rs.getString("gender")
                            + " Address: " + rs.getString("address"));

            rs.last();
            System.out.println(
                    "ID: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Gender: " + rs.getString("gender")
                            + " Address: " + rs.getString("address"));

            rs.previous();
            System.out.println(
                    "ID: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Gender: " + rs.getString("gender")
                            + " Address: " + rs.getString("address"));
            rs.next();
            System.out.println(
                    "ID: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Gender: " + rs.getString("gender")
                            + " Address: " + rs.getString("address"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
