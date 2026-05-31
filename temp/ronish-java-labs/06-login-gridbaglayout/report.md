# Lab 6: Login GridBagLayout

## Objective
Create a Swing login form using GridBagLayout with proper spacing using GridBagConstraints.

## Source Code
```java
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login GridBagLayout");
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        f.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        f.add(new JTextField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        f.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        f.add(new JPasswordField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        f.add(new JButton("Login"), gbc);

        f.setSize(350, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
```

## Output
Login form with precise component positioning using GridBagLayout and 5px insets.

## Conclusion
Learned to use GridBagLayout and GridBagConstraints for flexible component placement.
