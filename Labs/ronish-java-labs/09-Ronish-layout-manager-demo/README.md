# Lab 09: Ronish layout manager demo

## Source Code

### App.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField username;
    JPasswordField password;
    JCheckBox remember;

    public App() {
        f = new JFrame("Layout Manager Demo");
        f.setLayout(new BorderLayout());

        JPanel north = new JPanel(new FlowLayout());
        north.add(new JLabel("Name: Ronish"));
        north.add(new JLabel("Roll No: 1"));
        north.add(new JLabel("Class: CSIT"));
        f.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 2));
        center.add(new JLabel("Username:"));
        username = new JTextField();
        center.add(username);
        center.add(new JLabel("Password:"));
        password = new JPasswordField();
        center.add(password);
        remember = new JCheckBox("Remember Me");
        JButton login = new JButton("Login");
        login.addActionListener(this);
        center.add(remember); center.add(login);
        f.add(center, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout());
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        reset.addActionListener(this);
        exit.addActionListener(this);
        south.add(reset); south.add(exit);
        f.add(south, BorderLayout.SOUTH);

        f.setSize(400, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Login")) {
            JOptionPane.showMessageDialog(f, "Username: " + username.getText());
        } else if (cmd.equals("Reset")) {
            username.setText("");
            password.setText("");
            remember.setSelected(false);
        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
```