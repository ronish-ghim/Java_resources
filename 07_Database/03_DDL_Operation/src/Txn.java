import java.sql.*;;

public class Txn {

    public static void main(String[] args) {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javasamriddhi",
                    "root",
                    "");

            // 1. Disable auto commit
            con.setAutoCommit(false);

            // 2. Deduct from Account A
            PreparedStatement withdraw = con.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
            withdraw.setDouble(1, 500);
            withdraw.setInt(2, 1);
            withdraw.executeUpdate();

            // 3. Add to Account B
            PreparedStatement deposit = con.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?");
            deposit.setDouble(1, 500);
            deposit.setInt(2, 2);
            deposit.executeUpdate();

            // 4. Commit transaction
            con.commit();

            System.out.println("Transfer Successful");

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // rollback if error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println("Transaction Failed");

        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}