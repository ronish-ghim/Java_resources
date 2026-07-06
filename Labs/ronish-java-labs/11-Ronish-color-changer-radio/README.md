# Lab 11: Ronish color changer radio

## Source Code

### App.java

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ItemListener {
    JFrame f;
    JRadioButton red, green, blue;

    public App() {
        f = new JFrame("Color Changer Radio");
        f.setLayout(new FlowLayout());
        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        blue = new JRadioButton("Blue");
        ButtonGroup bg = new ButtonGroup();
        bg.add(red); bg.add(green); bg.add(blue);
        red.addItemListener(this);
        green.addItemListener(this);
        blue.addItemListener(this);
        f.add(red); f.add(green); f.add(blue);
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        if (red.isSelected()) f.getContentPane().setBackground(Color.RED);
        else if (green.isSelected()) f.getContentPane().setBackground(Color.GREEN);
        else if (blue.isSelected()) f.getContentPane().setBackground(Color.BLUE);
    }

    public static void main(String[] args) {
        new App();
    }
}
```