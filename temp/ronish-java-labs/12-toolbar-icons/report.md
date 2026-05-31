# Lab 12: Toolbar Icons

## Objective
Create a JToolBar with programmatically generated colored circle icons and tooltip text.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class App implements ActionListener {
    JFrame f;

    public App() {
        f = new JFrame("Toolbar Icons");
        f.setLayout(new BorderLayout());

        JToolBar toolbar = new JToolBar();
        JButton newBtn = new JButton(createIcon(Color.GREEN));
        newBtn.setToolTipText("New");
        JButton loginBtn = new JButton(createIcon(Color.BLUE));
        loginBtn.setToolTipText("Login");
        JButton logoutBtn = new JButton(createIcon(Color.RED));
        logoutBtn.setToolTipText("Logout");

        newBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        toolbar.add(newBtn);
        toolbar.add(loginBtn);
        toolbar.add(logoutBtn);
        f.add(toolbar, BorderLayout.NORTH);

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private ImageIcon createIcon(Color c) {
        BufferedImage img = new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(c);
        g.fillOval(0, 0, 24, 24);
        g.dispose();
        return new ImageIcon(img);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getToolTipText();
        if (cmd.equals("New")) JOptionPane.showMessageDialog(f, "New File Created");
        else if (cmd.equals("Login")) JOptionPane.showMessageDialog(f, "Login Successful");
        else if (cmd.equals("Logout")) JOptionPane.showMessageDialog(f, "Logged Out");
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
A toolbar with three colored circle buttons. Green shows "New File Created", Blue shows "Login Successful", Red shows "Logged Out".

## Conclusion
Learned to create icons programmatically using BufferedImage and use JToolBar with tooltips.
