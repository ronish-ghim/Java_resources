# Lab 5: Login GridLayout

## Objective
Create a Swing login form with username and password fields using GridLayout (no event handling).

## Source Code
```java
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
```

## Output
A 3x2 grid with Username label and field, Password label and field, and a Login button.

## Conclusion
Learned to create a login form layout using GridLayout in Swing.
