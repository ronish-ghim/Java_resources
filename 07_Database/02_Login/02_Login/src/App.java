
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
