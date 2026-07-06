# Lab 04: Ronish sum diff adapter

## Source Code

### App.java

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