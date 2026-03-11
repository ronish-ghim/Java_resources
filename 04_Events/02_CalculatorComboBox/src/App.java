import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame frame;
    JTextField n1, n2, res;
    JComboBox<String> cb;
    JButton btn;

    App() {
        frame = new JFrame("Calculator");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        frame.add(new JLabel("Number 1:"));
        n1 = new JTextField();
        frame.add(n1);

        frame.add(new JLabel("Number 2:"));
        n2 = new JTextField();
        frame.add(n2);

        frame.add(new JLabel("Operation:"));
        String[] operations = { "Add", "Subtract", "Multiply", "Divide" };
        cb = new JComboBox<>(operations);
        frame.add(cb);

        frame.add(new JLabel("Result:"));
        res = new JTextField();
        res.setEditable(false);
        frame.add(res);

        btn = new JButton("Calculate");
        btn.addActionListener(this);
        frame.add(btn);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(n1.getText());
        double num2 = Double.parseDouble(n2.getText());
        String operation = (String) cb.getSelectedItem();
        double result = 0;

        if (operation.equals("Add")) {
            result = num1 + num2;
        } else if (operation.equals("Subtract")) {
            result = num1 - num2;
        } else if (operation.equals("Multiply")) {
            result = num1 * num2;
        } else if (operation.equals("Divide")) {
            result = num1 / num2;
        }

        res.setText(String.valueOf(result));
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
