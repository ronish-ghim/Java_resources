import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;

    public App() {
        f = new JFrame("Toolbar Icons");
        f.setLayout(new BorderLayout());

        JToolBar toolbar = new JToolBar();
        ImageIcon newIcon = getIcon("assets/new.png");
        ImageIcon loginIcon = getIcon("assets/login.png");
        ImageIcon logoutIcon = getIcon("assets/logout.png");

        JButton newBtn = new JButton(newIcon);
        newBtn.setToolTipText("New");
        JButton loginBtn = new JButton(loginIcon);
        loginBtn.setToolTipText("Login");
        JButton logoutBtn = new JButton(logoutIcon);
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

    public ImageIcon getIcon(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image scaled = icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getToolTipText();
        if (cmd.equals("New"))
            JOptionPane.showMessageDialog(f, "New File Created");
        else if (cmd.equals("Login"))
            JOptionPane.showMessageDialog(f, "Login Successful");
        else if (cmd.equals("Logout"))
            JOptionPane.showMessageDialog(f, "Logged Out");
    }

    public static void main(String[] args) {
        new App();
    }
}
