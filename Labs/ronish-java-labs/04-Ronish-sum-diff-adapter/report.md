# Lab 4: Sum Diff Adapter

## Objective
Same as Lab 1 but using an anonymous MouseAdapter class instead of implementing MouseListener.

## Source Code
```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Sum Diff Adapter");
        f.setLayout(new GridLayout(3, 2));
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField result = new JTextField();
        result.setEditable(false);

        f.add(new JLabel("Number 1:")); f.add(t1);
        f.add(new JLabel("Number 2:")); f.add(t2);
        f.add(new JLabel("Result:")); f.add(result);

        f.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                result.setText(String.valueOf(a + b));
            }
            public void mouseReleased(MouseEvent e) {
                int a = Integer.parseInt(t1.getText());
                int b = Integer.parseInt(t2.getText());
                result.setText(String.valueOf(a - b));
            }
        });

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
```

## Output
A 3x2 grid layout. Mouse press shows sum, mouse release shows difference.

## Conclusion
Learned to use MouseAdapter with anonymous class for cleaner event handling code.
