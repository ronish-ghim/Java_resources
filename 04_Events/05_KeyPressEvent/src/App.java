import java.awt.event.*;

import javax.swing.*;

public class App implements KeyListener {
    JTextField n1, n2;
    JLabel result;

    App() {
        JFrame f = new JFrame("KeyListener Example");
        JLabel l1 = new JLabel("Number 1:");
        l1.setBounds(50, 20, 100, 20);
        n1 = new JTextField();
        n1.setBounds(50, 50, 150, 20);
        JLabel l2 = new JLabel("Number 2:");
        l2.setBounds(50, 80, 100, 20);
        n2 = new JTextField();
        n2.setBounds(50, 100, 150, 20);
        result = new JLabel();
        result.setBounds(50, 150, 200, 20);
        n2.addKeyListener(this);
        f.add(l1);
        f.add(l2);
        f.add(n1);
        f.add(n2);
        f.add(result);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int num1 = Integer.parseInt(n1.getText());
        int num2 = Integer.parseInt(n2.getText());
        int sum = num1 + num2;
        result.setText("Sum: " + sum);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int num1 = Integer.parseInt(n1.getText());
        int num2 = Integer.parseInt(n2.getText());
        int diff = num1 - num2;
        result.setText("Difference: " + diff);
    }
}
