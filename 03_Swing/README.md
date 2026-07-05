# Module 03 — AWT / Swing

## Sub-programs

### 1. Controls Demo
**Path:** `00_TestProject/src/App.java`

```java
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Controls Demo");
        f.setSize(400, 300);
        f.setLayout(null);

        JLabel name = new JLabel("Name:");
        name.setBounds(50, 50, 80, 30);
        JTextField tf = new JTextField();
        tf.setBounds(120, 50, 150, 30);

        JCheckBox cb = new JCheckBox("Accept Terms");
        cb.setBounds(120, 100, 150, 30);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        male.setBounds(120, 150, 100, 30);
        female.setBounds(220, 150, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        f.add(name);
        f.add(tf);
        f.add(cb);
        f.add(male);
        f.add(female);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```

### 2. AWT Frame
**Path:** `01_AWT_Frame/src/App.java`

```java
import java.awt.*;

// public class App {
//     App() {
//         Frame fm = new Frame("Title");
//         Label lb = new Label("Welcome to java graphics.");
//         fm.add(lb);
//         fm.setLayout(new FlowLayout());
//         fm.setSize(300, 300);
//         fm.setVisible(true);

//     }

//     public static void main(String[] args) throws Exception {
//         new App();
//     }
// }

public class App extends Frame {
    App() {
        Button btn = new Button("Hello world");
        add(btn);
        btn.setBounds(130, 100, 100, 40);
        setSize(400, 500);
        setTitle("StudyTonight");
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 3. FlowLayout
**Path:** `02_FlowLayout/src/App.java`

```java
import javax.swing.*;
import java.awt.*;

public class App {
    JFrame f;

    App() {
        f = new JFrame();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("10");
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);

        f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        f.setSize(new Dimension(500, 500));
        f.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 4. BorderLayout
**Path:** `03_BorderLayout/src/App.java`

```java
import javax.swing.*;
import java.awt.*;

public class App {

    JFrame f;

    App() {
        f = new JFrame();
        JButton b1 = new JButton("NORTH");
        JButton b2 = new JButton("SOUTH");
        JButton b3 = new JButton("EAST");
        JButton b4 = new JButton("WEST");
        JButton b5 = new JButton("CENTER");

        b1.addActionListener(e -> JOptionPane.showInputDialog(f, "What is your name?"));

        f.add(b1, BorderLayout.NORTH);
        f.add(b2, BorderLayout.SOUTH);
        f.add(b3, BorderLayout.EAST);
        f.add(b4, BorderLayout.WEST);
        f.add(b5, BorderLayout.CENTER);
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new App();
    }
}
```

### 5. GridLayout
**Path:** `04_GridLayout/src/App.java`

```java
import javax.swing.*;
import java.awt.*;

public class App {
    JFrame f;

    App() {
        f = new JFrame();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("10");
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);

        f.setLayout(new GridLayout());
        f.setSize(new Dimension(500, 500));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 6. Calculator
**Path:** `05_Calculator/src/App.java`

```java
//write a program that divides the frame into fice regions by using border layout and then add panels in the east, north and center regions.
// Finally add some descriptive label in the north panel, buttons with icon in the east panel and sample form in the center panel.
//  You can further subdivide the center panel into more panels, if necessary. Prepare a program with three text boxes. First Number, second Number and Result and four buttons add, subtract, multiply and divide. 

import java.awt.*;
import javax.swing.*;

public class App {
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

        JButton addButton = new JButton("Add");
        // addButton.setBackground(Color.RED);
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        eastPanel.add(addButton);
        eastPanel.add(subtractButton);
        eastPanel.add(multiplyButton);
        eastPanel.add(divideButton);

        // center panel
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel firstNumberLabel = new JLabel("First Number:");
        JTextField firstNumberField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        JTextField secondNumberField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);
        centerPanel.add(firstNumberLabel);
        centerPanel.add(firstNumberField);
        centerPanel.add(secondNumberLabel);
        centerPanel.add(secondNumberField);
        centerPanel.add(resultLabel);
        centerPanel.add(resultField);

        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 7. Registration Form
**Path:** `06_RegistrationForm/src/App.java`

```java
import javax.swing.*;
import java.awt.*;

public class App {
    App() {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        // Container contentPane = frame.getContentPane();
        // contentPane.setLayout(new GridLayout(9, 2));
        JLabel titleLabel = new JLabel("Student Registration Form", JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Full Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("FullName"), gbc);

        gbc.gridx = 1;
        formPanel.add(new JTextField(15), gbc);
        // Row 2: Gender
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Gender"), gbc);

        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        formPanel.add(genderPanel, gbc);

        // Row 3: Country
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Country"), gbc);

        gbc.gridx = 1;
        formPanel.add(new JTextField(15), gbc);

        // Row 4: Reg Date
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Reg Date"), gbc);

        gbc.gridx = 1;
        formPanel.add(new JTextField(15), gbc);

        // Row 5: Photo
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.NORTH;
        formPanel.add(new JLabel("Photo"), gbc);

        gbc.gridx = 1;
        JPanel photoPanel = new JPanel(new BorderLayout());
        JLabel photoBox = new JLabel("No Image", JLabel.CENTER);
        photoBox.setPreferredSize(new Dimension(150, 100));
        photoBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton browseBtn = new JButton("Browse");

        photoPanel.add(photoBox, BorderLayout.CENTER);
        photoPanel.add(browseBtn, BorderLayout.SOUTH);

        formPanel.add(photoPanel, gbc);

        // Row 6: IsActive
        gbc.gridy++;
        gbc.gridx = 0;
        formPanel.add(new JLabel("Is Active"), gbc);
        gbc.gridx = 1;
        formPanel.add(new JCheckBox(), gbc);

        // save button
        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton("Save"));
        frame.add(btnPanel, BorderLayout.SOUTH);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
```

### 8. GridBagLayout
**Path:** `07_GridBagLayout/src/App.java`

```java
import java.awt.*;
import javax.swing.*;

public class App extends JFrame {
    App() {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(grid);
        setTitle("GridBag Layout Example");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new Button("Button One"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(new Button("Button two"), gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new Button("Button Three"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(new Button("Button Four"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        add(new Button("Button Five"), gbc);
        setSize(300, 300);
        setPreferredSize(getSize());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new App();
    }

}
```

### 9. Mouse Event Sum Difference
**Path:** `Labs/01_MouseEventSumDifference/src/App.java`

```java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Write a GUI program using components to find sum and difference of two numbers.
// Use two text fields for giving input and a label for output. 
// The program should display sum if user presses mouse and difference if user release mouse.
public class App implements MouseListener {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel resultLabel;

    public App() {
        JFrame frame = new JFrame();

        frame.setTitle("Sum and Difference Calculator");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultLabel = new JLabel("Result will be shown here");

        frame.add(textField1);
        frame.add(textField2);
        frame.add(resultLabel);

        frame.addMouseListener(this);
        frame.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int sum = num1 + num2;
            resultLabel.setText("Sum: " + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid integers");
        }
    }

    public void mouseReleased(MouseEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int difference = num1 - num2;
            resultLabel.setText("Difference: " + difference);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid integers");
        }
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
