# Lab 03: Ronish calculator radio

## Source Code

### App.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField t1, t2, result;
    JRadioButton add, sub, mul, div;
    JButton calc;

    public App() {
        f = new JFrame("Calculator Radio");
        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        add = new JRadioButton("Add");
        sub = new JRadioButton("Sub");
        mul = new JRadioButton("Mul");
        div = new JRadioButton("Div");
        calc = new JButton("Calculate");

        ButtonGroup bg = new ButtonGroup();
        bg.add(add); bg.add(sub); bg.add(mul); bg.add(div);

        calc.addActionListener(this);
        result.setEditable(false);

        f.setLayout(new GridLayout(6, 2));
        f.add(new JLabel("Number 1:")); f.add(t1);
        f.add(new JLabel("Number 2:")); f.add(t2);
        f.add(add); f.add(sub);
        f.add(mul); f.add(div);
        f.add(new JLabel("Result:")); f.add(result);
        f.add(new JLabel()); f.add(calc);

        f.setSize(350, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double res = 0;
        if (add.isSelected()) res = a + b;
        else if (sub.isSelected()) res = a - b;
        else if (mul.isSelected()) res = a * b;
        else if (div.isSelected()) res = a / b;
        result.setText(String.valueOf(res));
    }

    public static void main(String[] args) {
        new App();
    }
}
```