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
