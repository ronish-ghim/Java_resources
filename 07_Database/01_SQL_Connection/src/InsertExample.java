import java.sql.*;

public class InsertExample {

    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javasamriddhi?useSSL=false",
                    "root", "");
            String sql = "insert into tblStudent( name, gender, address) values (?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "Ram");
            pstmt.setString(2, "Male");
            pstmt.setString(3, "Kathmandu");
            pstmt.executeUpdate();
            con.close();
            System.out.println("Data inserted successfully.");

        } catch (Exception e) {
            // System.out.println(".");
            e.printStackTrace();
            return;
        }
    }
}
