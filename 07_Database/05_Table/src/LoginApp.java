import java.sql.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class LoginApp extends JFrame implements ActionListener {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnLogin, btnReset;
    Connection con;

    public LoginApp() {

        setTitle("Login Form");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 10, 10));
        // Labels
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");

        // TextFields
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();

        // Buttons
        btnLogin = new JButton("Login");
        btnReset = new JButton("Reset");

        // Add components
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        add(btnReset);

        // Button Actions
        btnLogin.addActionListener(this);
        btnReset.addActionListener(this);

        setVisible(true);
    }

    // ActionPerformed
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnLogin) {
            validateLogin();
        } else {
            clearForm();
        }
    }

    // Validate Login
    public void validateLogin() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javasamriddhi",
                    "root",
                    "");

            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            PreparedStatement pst = con.prepareStatement(
                    "SELECT * FROM user_auth WHERE username=? AND password=?");

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Authorized");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Username and Password");
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Clear Form
    public void clearForm() {
        txtUsername.setText("");
        txtPassword.setText("");
        txtUsername.requestFocus();
    }

    public static void main(String[] args) {
        new LoginApp();
    }
}
