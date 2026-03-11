//write a program that divides the frame into fice regions by using border layout and then add panels in the east, north and center regions.
// Finally add some descriptive label in the north panel, buttons with icon in the east panel and sample form in the center panel.
//  You can further subdivide the center panel into more panels, if necessary. Prepare a program with three text boxes. First Number, second Number and Result and four buttons add, subtract, multiply and divide. 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App implements ActionListener {
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JTextField firstNumberField, secondNumberField, resultField;

    App() {
        JFrame frame = new JFrame("Calculator");

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        // North Panel
        JPanel northPanel = new JPanel();
        contentPane.add(northPanel, BorderLayout.NORTH);
        JLabel titleLabel = new JLabel("Calculator");
        northPanel.add(titleLabel);

        JPanel eastPanel = new JPanel();
        contentPane.add(eastPanel, BorderLayout.EAST);
        eastPanel.setLayout(new GridLayout(4, 1, 5, 5));

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        eastPanel.add(addButton);
        eastPanel.add(subtractButton);
        eastPanel.add(multiplyButton);
        eastPanel.add(divideButton);

        // center panel
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        centerPanel.add(firstNumberLabel);
        centerPanel.add(firstNumberField);
        centerPanel.add(secondNumberLabel);
        centerPanel.add(secondNumberField);
        centerPanel.add(resultLabel);
        centerPanel.add(resultField);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n1, n2;
        float result;
        n1 = Integer.parseInt(firstNumberField.getText());
        n2 = Integer.parseInt(secondNumberField.getText());

        if (e.getSource() == addButton) {
            result = n1 + n2;
        } else if (e.getSource() == subtractButton) {
            result = n1 - n2;
        } else if (e.getSource() == multiplyButton) {
            result = n1 * n2;
        } else {
            result = n1 / n2;
        }

        // checking if result is float or int
        if (result == (int) result) {
            resultField.setText(String.valueOf((int) result));
        } else {
            resultField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
