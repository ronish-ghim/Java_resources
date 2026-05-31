# Lab 2: Add Two Numbers

## Objective
Create a Swing JFrame with two input fields, a non-editable result field, and an "Add" button using GridLayout.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField t1, t2, result;
    JButton b;

    public App() {
        f = new JFrame("Add Two Numbers");
        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        b = new JButton("Add");
        result.setEditable(false);
        b.addActionListener(this);
        f.setLayout(new GridLayout(4, 2));
        f.add(new JLabel("Number 1:")); f.add(t1);
        f.add(new JLabel("Number 2:")); f.add(t2);
        f.add(new JLabel("Result:")); f.add(result);
        f.add(new JLabel()); f.add(b);
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        result.setText(String.valueOf(a + b));
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
A 4x2 grid form. Entering two numbers and clicking "Add" displays the sum in the result field.

## Conclusion
Learned to use Swing components, GridLayout, and ActionListener for button click events.
