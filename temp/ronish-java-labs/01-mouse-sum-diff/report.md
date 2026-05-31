# Lab 1: Mouse Sum Diff

## Objective
Create an AWT Frame that implements MouseListener. On mouse press, display the sum of two numbers. On mouse release, display the difference.

## Source Code
```java
import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements MouseListener {
    TextField t1, t2, result;
    Label l;

    public App() {
        setLayout(new FlowLayout());
        t1 = new TextField(10);
        t2 = new TextField(10);
        result = new TextField(15);
        l = new Label("Result");
        add(t1); add(t2); add(l); add(result);
        addMouseListener(this);
        setSize(300, 200);
        setTitle("Mouse Sum Diff");
        setVisible(true);
    }

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

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
A window with two text fields for input. Pressing the mouse shows the sum; releasing shows the difference in the result field.

## Conclusion
Learned to implement MouseListener interface and handle mouse events in AWT.
