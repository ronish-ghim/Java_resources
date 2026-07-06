# Lab 07: Ronish calculator borderlayout

## Source Code

### App.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    public App() {
        f = new JFrame("Calculator BorderLayout");
        f.setLayout(new BorderLayout());

        JLabel title = new JLabel("Calculator", SwingConstants.CENTER);
        f.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 2));
        center.add(new JLabel("Number 1:")); t1 = new JTextField(); center.add(t1);
        center.add(new JLabel("Number 2:")); t2 = new JTextField(); center.add(t2);
        center.add(new JLabel("Result:")); result = new JTextField(); center.add(result);
        result.setEditable(false);
        f.add(center, BorderLayout.CENTER);

        JPanel east = new JPanel(new GridLayout(4, 1));
        add = new JButton("Add"); sub = new JButton("Sub");
        mul = new JButton("Mul"); div = new JButton("Div");
        add.addActionListener(this); sub.addActionListener(this);
        mul.addActionListener(this); div.addActionListener(this);
        east.add(add); east.add(sub); east.add(mul); east.add(div);
        f.add(east, BorderLayout.EAST);

        f.setSize(400, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double r = 0;
        if (e.getSource() == add) r = a + b;
        else if (e.getSource() == sub) r = a - b;
        else if (e.getSource() == mul) r = a * b;
        else if (e.getSource() == div) r = a / b;
        result.setText(String.valueOf(r));
    }

    public static void main(String[] args) {
        new App();
    }
}
```