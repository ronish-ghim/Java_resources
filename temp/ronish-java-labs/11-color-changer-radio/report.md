# Lab 11: Color Changer Radio

## Objective
Create a JFrame with three JRadioButtons (Red, Green, Blue) using ItemListener to change the content pane background.

## Source Code
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

## Output
Three radio buttons. Selecting Red turns the background red, Green turns it green, Blue turns it blue.

## Conclusion
Learned to use JRadioButton with ButtonGroup and ItemListener for selection-based actions.
