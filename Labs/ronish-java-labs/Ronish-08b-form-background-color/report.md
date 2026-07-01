# Lab 8b: Form Background Color

## Objective
Create a JFrame with three buttons. Clicking a button changes the content pane's background color.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JButton red, blue, green;

    public App() {
        f = new JFrame("Form Background Color");
        f.setLayout(new FlowLayout());
        red = new JButton("RED");
        blue = new JButton("BLUE");
        green = new JButton("GREEN");
        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        f.add(red); f.add(blue); f.add(green);
        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == red) f.getContentPane().setBackground(Color.RED);
        else if (e.getSource() == blue) f.getContentPane().setBackground(Color.BLUE);
        else if (e.getSource() == green) f.getContentPane().setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
Three buttons. Clicking "RED" turns the entire form background red, and similarly for blue and green.

## Conclusion
Learned to change the content pane background of a JFrame dynamically.
