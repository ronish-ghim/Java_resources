import java.sql.*;

public class SelectWhere {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasamriddhi?useSSL=false",
                    "root", "");
            PreparedStatement pStatement = con.prepareStatement("select * from tblstudent where id=?");
            pStatement.setInt(1, 2);
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
