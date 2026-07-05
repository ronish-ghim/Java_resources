# Module 04 — Event Handling

## Sub-programs

### 1. HelloWorld Event
**Path:** `01_HelloWorldEvent/src/App.java`

```java
import java.awt.Button;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    TextField tf;
    Button btn;

    App() {
        Frame f = new Frame("AWT Example");
        tf = new TextField();
        tf.setBounds(50, 50, 150, 20);
        btn = new Button("Click Me");
        btn.setBounds(50, 100, 60, 30);

        // Registering action listener to the button
        btn.addActionListener(this);
        f.add(btn);
        f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tf.setText("Hello World");
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 2. Calculator ComboBox
**Path:** `02_CalculatorComboBox/src/App.java`

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame frame;
    JTextField n1, n2, res;
    JComboBox<String> cb;
    JButton btn;

    App() {
        frame = new JFrame("Calculator");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        frame.add(new JLabel("Number 1:"));
        n1 = new JTextField();
        frame.add(n1);

        frame.add(new JLabel("Number 2:"));
        n2 = new JTextField();
        frame.add(n2);

        frame.add(new JLabel("Operation:"));
        String[] operations = { "Add", "Subtract", "Multiply", "Divide" };
        cb = new JComboBox<>(operations);
        frame.add(cb);

        frame.add(new JLabel("Result:"));
        res = new JTextField();
        res.setEditable(false);
        frame.add(res);

        btn = new JButton("Calculate");
        btn.addActionListener(this);
        frame.add(btn);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(n1.getText());
        double num2 = Double.parseDouble(n2.getText());
        String operation = (String) cb.getSelectedItem();
        double result = 0;

        if (operation.equals("Add")) {
            result = num1 + num2;
        } else if (operation.equals("Subtract")) {
            result = num1 - num2;
        } else if (operation.equals("Multiply")) {
            result = num1 * num2;
        } else if (operation.equals("Divide")) {
            result = num1 / num2;
        }

        res.setText(String.valueOf(result));
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 3. Mouse Events
**Path:** `03_MouseEvents/src/App.java`

```java
import java.awt.event.*;
import javax.swing.*;

public class App implements MouseListener {
    JLabel label;

    App() {
        JFrame frame = new JFrame("My App");
        frame.setSize(400, 400);

        label = new JLabel("Hello, World!");
        label.addMouseListener(this);
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked!");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released!");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered!");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited!");
    }
}
```

### 4. Mouse Motion Events
**Path:** `04_MouseMotionEvents/src/App.java`

```java
import java.awt.*;
import java.awt.event.*;

public class App implements MouseMotionListener {
    Frame f;

    App() {
        f = new Frame("My Frame");
        f.setSize(400, 400);
        f.setVisible(true);
        f.addMouseMotionListener(this);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = f.getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(e.getX(), e.getY(), 20, 20);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Graphics g = f.getGraphics();
        // g.setColor(Color.GREEN);
        // g.fillOval(e.getX(), e.getY(), 20, 20);

    }
}
```

### 5. Key Press Event
**Path:** `05_KeyPressEvent/src/App.java`

```java
import java.awt.event.*;

import javax.swing.*;

public class App implements KeyListener {
    JTextField n1, n2;
    JLabel result;

    App() {
        JFrame f = new JFrame("KeyListener Example");
        JLabel l1 = new JLabel("Number 1:");
        l1.setBounds(50, 20, 100, 20);
        n1 = new JTextField();
        n1.setBounds(50, 50, 150, 20);
        JLabel l2 = new JLabel("Number 2:");
        l2.setBounds(50, 80, 100, 20);
        n2 = new JTextField();
        n2.setBounds(50, 100, 150, 20);
        result = new JLabel();
        result.setBounds(50, 150, 200, 20);
        n2.addKeyListener(this);
        f.add(l1);
        f.add(l2);
        f.add(n1);
        f.add(n2);
        f.add(result);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int num1 = Integer.parseInt(n1.getText());
        int num2 = Integer.parseInt(n2.getText());
        int sum = num1 + num2;
        result.setText("Sum: " + sum);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int num1 = Integer.parseInt(n1.getText());
        int num2 = Integer.parseInt(n2.getText());
        int diff = num1 - num2;
        result.setText("Difference: " + diff);
    }
}
```

### 6. Calculator (Border Layout)
**Path:** `New folder/02_Calculator/src/App.java`

```java
//write a program that divides the frame into fice regions by using border layout and then add panels in the east, north and center regions.
// Finally add some descriptive label in the north panel, buttons with icon in the east panel and sample form in the center panel.
//  You can further subdivide the center panel into more panels, if necessary. Prepare a program with three text boxes. First Number, second Number and Result and four buttons add, subtract, multiply and divide. 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App implements ActionListener {
    JButton addButton, subtractButton, multiplyButton, divideButton;
    JTextField firstNumberField, secondNumberField, resultField;

    App() {
        JFrame frame = new JFrame("Calculator");

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        // North Panel
        JPanel northPanel = new JPanel();
        contentPane.add(northPanel, BorderLayout.NORTH);
        JLabel titleLabel = new JLabel("Calculator");
        northPanel.add(titleLabel);

        JPanel eastPanel = new JPanel();
        contentPane.add(eastPanel, BorderLayout.EAST);
        eastPanel.setLayout(new GridLayout(4, 1, 5, 5));

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        eastPanel.add(addButton);
        eastPanel.add(subtractButton);
        eastPanel.add(multiplyButton);
        eastPanel.add(divideButton);

        // center panel
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);
        centerPanel.add(firstNumberLabel);
        centerPanel.add(firstNumberField);
        centerPanel.add(secondNumberLabel);
        centerPanel.add(secondNumberField);
        centerPanel.add(resultLabel);
        centerPanel.add(resultField);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n1, n2;
        float result;
        n1 = Integer.parseInt(firstNumberField.getText());
        n2 = Integer.parseInt(secondNumberField.getText());

        if (e.getSource() == addButton) {
            result = n1 + n2;
        } else if (e.getSource() == subtractButton) {
            result = n1 - n2;
        } else if (e.getSource() == multiplyButton) {
            result = n1 * n2;
        } else {
            result = n1 / n2;
        }

        // checking if result is float or int
        if (result == (int) result) {
            resultField.setText(String.valueOf((int) result));
        } else {
            resultField.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```
