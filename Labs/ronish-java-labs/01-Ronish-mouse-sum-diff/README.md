# Lab 01: Ronish mouse sum diff

## Source Code

### App.java

```java
import java.awt.*;
import java.awt.event.*;

public class App extends Frame implements MouseListener {
    TextField t1, t2, result;
    Label l1, l2, l;

    public App() {
        setLayout(new FlowLayout());
        l1 = new Label("Number 1");
        l2 = new Label("Number 2");
        t1 = new TextField(10);
        t2 = new TextField(10);
        result = new TextField(10);
        l = new Label("Result");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l);
        add(result);
        addMouseListener(this);
        setSize(300, 200);
        setTitle("Ronish 32");
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

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        new App();
    }
}
```