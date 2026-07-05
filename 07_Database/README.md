# Module 07 — JDBC / Database

## Sub-programs

### 1. SQL Connection
**Path:** `01_SQL_Connection/src/App.java`
**Path:** `01_SQL_Connection/src/InsertExample.java`
**Path:** `01_SQL_Connection/src/SelectWhere.java`

```java
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
```

```java
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
```

```java
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
```

### 2. Login
**Path:** `02_Login/02_Login/src/App.java`

```java

import javax.swing.*;
import java.awt.*;

public class App {
    JFrame frame;
    JLabel userLabel, passwordLabel;
    JTextField userText;
    JPasswordField passwordText;
    JButton loginButton;

    App() {
        frame = new JFrame("Login Form");

        // setting gridlayout
        frame.setLayout(new GridLayout(3, 2));

        userLabel = new JLabel("Username:");
        userText = new JTextField();

        passwordLabel = new JLabel("Password:");
        passwordText = new JPasswordField();

        loginButton = new JButton("Login");

        // adding components to the frame
        frame.add(userLabel);
        frame.add(userText);
        frame.add(passwordLabel);
        frame.add(passwordText);
        frame.add(new JLabel()); // empty label for spacing
        frame.add(loginButton);

        frame.setSize(300, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

}
```

### 3. DDL Operation
**Path:** `03_DDL_Operation/src/App.java`
**Path:** `03_DDL_Operation/src/Txn.java`

```java
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
```

```java
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
```

### 4. Student DB
**Path:** `04_Student_DB/src/App.java`

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class App extends JFrame {

    JTextField nameField, emailField;
    JRadioButton male, female;
    ButtonGroup bg;
    JTable table;
    DefaultTableModel model;

    Connection con;

    public App() {
        setTitle("User Form");
        setSize(600, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // DB Connection
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }

        // Form
        add(new JLabel("Name:"));
        nameField = new JTextField(15);
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField(15);
        add(emailField);

        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        add(male);
        add(female);

        JButton saveBtn = new JButton("Save");
        JButton resetBtn = new JButton("Reset");

        add(saveBtn);
        add(resetBtn);

        // Table
        model = new DefaultTableModel(new String[] { "ID", "Name", "Email", "Gender" }, 0);
        table = new JTable(model);
        add(new JScrollPane(table));

        // Load data initially
        loadData();

        // Save Button Action
        saveBtn.addActionListener(e -> saveData());

        // Reset Button Action
        resetBtn.addActionListener(e -> resetForm());

        setVisible(true);
    }

    // Insert Data
    void saveData() {
        String name = nameField.getText();
        String email = emailField.getText();
        String gender = male.isSelected() ? "Male" : "Female";

        try {
            String query = "INSERT INTO users(name, email, gender) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, gender);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Saved");

            loadData(); // Refresh table
            resetForm();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Load Data
    void loadData() {
        model.setRowCount(0); // Clear table

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender")
                });
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Reset Form
    void resetForm() {
        nameField.setText("");
        emailField.setText("");
        bg.clearSelection();
    }

    public static void main(String[] args) {
        new App();
    }
}
```

### 5. Table
**Path:** `05_Table/src/App.java`
**Path:** `05_Table/src/LoginApp.java`

```java
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    JTextField txtName, txtEmail;
    JRadioButton rbMale, rbFemale;
    JButton btnSave, btnReset;
    JTable table;
    DefaultTableModel model;
    Connection con;

    public App() {
        setTitle("User Form");
        setSize(600, 500);
        setLayout(null);
        // Labels
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 30, 100, 30);
        add(lblName);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 70, 100, 30);
        add(lblEmail);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(50, 110, 100, 30);
        add(lblGender);

        // TextFields
        txtName = new JTextField();
        txtName.setBounds(150, 30, 200, 30);
        add(txtName);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 70, 200, 30);
        add(txtEmail);

        // Radio Buttons
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(150, 110, 80, 30);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(230, 110, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        // Buttons
        btnSave = new JButton("Save");
        btnSave.setBounds(150, 160, 90, 30);
        add(btnSave);

        btnReset = new JButton("Reset");
        btnReset.setBounds(260, 160, 90, 30);
        add(btnReset);

        // Table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Gender");

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 220, 480, 200);
        add(sp);
        // Load Data
        loadData();
        // Save Button Action
        btnSave.addActionListener(this);
        // Reset Button Action
        btnReset.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            saveData();
            loadData();
        } else {
            clearForm();
        }
    }

    // Save Data
    public void saveData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javasamriddhi",
                    "root",
                    "root");
            String name = txtName.getText();
            String email = txtEmail.getText();
            String gender = rbMale.isSelected() ? "Male" : "Female";
            PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO tblstudent(name,email,gender) VALUES(?,?,?)");
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, gender);
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(this, "Record Saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load Data into JTable
    public void loadData() {
        try {
            model.setRowCount(0);// clear all existing rows
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javasamriddhi",
                    "root",
                    ""); // change password
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tblstudent");
            while (rs.next()) {
                model.addRow(new Object[] {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender")
                });
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Clear Form
    public void clearForm() {
        txtName.setText("");
        txtEmail.setText("");
        rbMale.setSelected(true);
        rbFemale.setSelected(false);
        txtName.requestFocus();
    }

    public static void main(String[] args) {
        new App();
    }
}
```

```java
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
```
