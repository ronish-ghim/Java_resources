import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login GridLayout");
        f.setLayout(new GridLayout(3, 2));
        f.add(new JLabel("Username:"));
        f.add(new JTextField());
        f.add(new JLabel("Password:"));
        f.add(new JPasswordField());
        f.add(new JLabel());
        f.add(new JButton("Login"));
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
