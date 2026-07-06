# Lab 08a: Ronish button color

## Source Code

### App.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JButton red, blue, green;

    public App() {
        f = new JFrame("Button Color");
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
        if (e.getSource() == red) red.setBackground(Color.RED);
        else if (e.getSource() == blue) blue.setBackground(Color.BLUE);
        else if (e.getSource() == green) green.setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        new App();
    }
}
```