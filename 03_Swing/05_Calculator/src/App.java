//write a program that divides the frame into fice regions by using border layout and then add panels in the east, north and center regions.
// Finally add some descriptive label in the north panel, buttons with icon in the east panel and sample form in the center panel.
//  You can further subdivide the center panel into more panels, if necessary. Prepare a program with three text boxes. First Number, second Number and Result and four buttons add, subtract, multiply and divide. 

import java.awt.*;
import javax.swing.*;

public class App {
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

        JButton addButton = new JButton("Add");
        // addButton.setBackground(Color.RED);
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        eastPanel.add(addButton);
        eastPanel.add(subtractButton);
        eastPanel.add(multiplyButton);
        eastPanel.add(divideButton);

        // center panel
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel firstNumberLabel = new JLabel("First Number:");
        JTextField firstNumberField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        JTextField secondNumberField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        centerPanel.add(firstNumberLabel);
        centerPanel.add(firstNumberField);
        centerPanel.add(secondNumberLabel);
        centerPanel.add(secondNumberField);
        centerPanel.add(resultLabel);
        centerPanel.add(resultField);

        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
