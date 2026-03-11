
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Write a GUI program using components to find sum and difference of two numbers.
// Use two text fields for giving input and a label for output. 
// The program should display sum if user presses mouse and difference if user release mouse.
public class App implements MouseListener {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel resultLabel;

    public App() {
        JFrame frame = new JFrame();

        frame.setTitle("Sum and Difference Calculator");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultLabel = new JLabel("Result will be shown here");

        frame.add(textField1);
        frame.add(textField2);
        frame.add(resultLabel);

        frame.addMouseListener(this);
        frame.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int sum = num1 + num2;
            resultLabel.setText("Sum: " + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid integers");
        }
    }

    public void mouseReleased(MouseEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int difference = num1 - num2;
            resultLabel.setText("Difference: " + difference);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid integers");
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        new App();

    }

    
}
