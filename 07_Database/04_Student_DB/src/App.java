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