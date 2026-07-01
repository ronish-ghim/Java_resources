# Lab 10: Shape Drawer

## Objective
Create a Canvas with Circle, Square, and Triangle buttons. Clicking a button draws the corresponding shape.

## Source Code
```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends Canvas implements ActionListener {
    String shape = "";

    public App() {
        JFrame f = new JFrame("Shape Drawer");
        f.setLayout(new BorderLayout());

        JPanel north = new JPanel();
        JButton circle = new JButton("Circle");
        JButton square = new JButton("Square");
        JButton triangle = new JButton("Triangle");
        circle.addActionListener(this);
        square.addActionListener(this);
        triangle.addActionListener(this);
        north.add(circle); north.add(square); north.add(triangle);
        f.add(north, BorderLayout.NORTH);

        setSize(400, 400);
        f.add(this, BorderLayout.CENTER);

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        shape = e.getActionCommand();
        repaint();
    }

    public void paint(Graphics g) {
        if (shape.equals("Circle")) {
            g.setColor(Color.RED);
            g.fillOval(100, 100, 200, 200);
        } else if (shape.equals("Square")) {
            g.setColor(Color.BLUE);
            g.fillRect(100, 100, 200, 200);
        } else if (shape.equals("Triangle")) {
            g.setColor(Color.GREEN);
            int[] x = {200, 100, 300};
            int[] y = {100, 300, 300};
            g.fillPolygon(x, y, 3);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
Three buttons at top. Clicking Circle draws a red circle, Square draws a blue square, Triangle draws a green triangle on the canvas.

## Conclusion
Learned to use Canvas, override paint(Graphics), and draw shapes using fillOval, fillRect, and fillPolygon.
