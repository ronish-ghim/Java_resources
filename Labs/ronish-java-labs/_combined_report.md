# Ronish's Java Lab Report

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

---

# Lab 2: Add Two Numbers

## Objective
Create a Swing JFrame with two input fields, a non-editable result field, and an "Add" button using GridLayout.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField t1, t2, result;
    JButton b;

    public App() {
        f = new JFrame("Add Two Numbers");
        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        b = new JButton("Add");
        result.setEditable(false);
        b.addActionListener(this);
        f.setLayout(new GridLayout(4, 2));
        f.add(new JLabel("Number 1:")); f.add(t1);
        f.add(new JLabel("Number 2:")); f.add(t2);
        f.add(new JLabel("Result:")); f.add(result);
        f.add(new JLabel()); f.add(b);
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        result.setText(String.valueOf(a + b));
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
A 4x2 grid form. Entering two numbers and clicking "Add" displays the sum in the result field.

## Conclusion
Learned to use Swing components, GridLayout, and ActionListener for button click events.

---

# Lab 3: Calculator Radio

## Objective
Create a Swing calculator using JRadioButtons for selecting operations (Add, Sub, Mul, Div) with a Calculate button.

## Source Code
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

## Output
A 6x2 grid with radio buttons for operation selection. Selecting an operation and clicking Calculate displays the result.

## Conclusion
Learned to use JRadioButton with ButtonGroup and perform arithmetic operations based on selection.

---

# Lab 4: Sum Diff Adapter

## Objective
Same as Lab 1 but using an anonymous MouseAdapter class instead of implementing MouseListener.

## Source Code
```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Sum Diff Adapter");
        f.setLayout(new GridLayout(3, 2));
        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField result = new JTextField();
        result.setEditable(false);

        f.add(new JLabel("Number 1:")); f.add(t1);
        f.add(new JLabel("Number 2:")); f.add(t2);
        f.add(new JLabel("Result:")); f.add(result);

        f.addMouseListener(new MouseAdapter() {
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
        });

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
```

## Output
A 3x2 grid layout. Mouse press shows sum, mouse release shows difference.

## Conclusion
Learned to use MouseAdapter with anonymous class for cleaner event handling code.

---

# Lab 5: Login GridLayout

## Objective
Create a Swing login form with username and password fields using GridLayout (no event handling).

## Source Code
```java
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login GridLayout");
        f.setLayout(new GridLayout(3, 2));
        f.add(new JLabel("Username:"));
        f.add(new JTextField());
        f.add(new JLabel("Password:"));
        f.add(new JPasswordField());
        f.add(new JLabel());
        f.add(new JButton("Login"));
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
```

## Output
A 3x2 grid with Username label and field, Password label and field, and a Login button.

## Conclusion
Learned to create a login form layout using GridLayout in Swing.

---

# Lab 6: Login GridBagLayout

## Objective
Create a Swing login form using GridBagLayout with proper spacing using GridBagConstraints.

## Source Code
```java
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Login GridBagLayout");
        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        f.add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        f.add(new JTextField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        f.add(new JLabel("Password:"), gbc);
        gbc.gridx = 1;
        f.add(new JPasswordField(15), gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        f.add(new JButton("Login"), gbc);

        f.setSize(350, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
```

## Output
Login form with precise component positioning using GridBagLayout and 5px insets.

## Conclusion
Learned to use GridBagLayout and GridBagConstraints for flexible component placement.

---

# Lab 7: Calculator BorderLayout

## Objective
Create a calculator using BorderLayout. NORTH has title, CENTER has number inputs, EAST has operation buttons.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    public App() {
        f = new JFrame("Calculator BorderLayout");
        f.setLayout(new BorderLayout());

        JLabel title = new JLabel("Calculator", SwingConstants.CENTER);
        f.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 2));
        center.add(new JLabel("Number 1:")); t1 = new JTextField(); center.add(t1);
        center.add(new JLabel("Number 2:")); t2 = new JTextField(); center.add(t2);
        center.add(new JLabel("Result:")); result = new JTextField(); center.add(result);
        result.setEditable(false);
        f.add(center, BorderLayout.CENTER);

        JPanel east = new JPanel(new GridLayout(4, 1));
        add = new JButton("Add"); sub = new JButton("Sub");
        mul = new JButton("Mul"); div = new JButton("Div");
        add.addActionListener(this); sub.addActionListener(this);
        mul.addActionListener(this); div.addActionListener(this);
        east.add(add); east.add(sub); east.add(mul); east.add(div);
        f.add(east, BorderLayout.EAST);

        f.setSize(400, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double r = 0;
        if (e.getSource() == add) r = a + b;
        else if (e.getSource() == sub) r = a - b;
        else if (e.getSource() == mul) r = a * b;
        else if (e.getSource() == div) r = a / b;
        result.setText(String.valueOf(r));
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
BorderLayout with title at top, inputs in center, operation buttons on the right.

## Conclusion
Learned to combine BorderLayout with nested JPanels using GridLayout for complex layouts.

---

# Lab 8a: Button Color

## Objective
Create a JFrame with three buttons. Clicking a button changes that button's background color (RED/BLUE/GREEN).

## Source Code
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

## Output
Three buttons in a row. Clicking "RED" turns the red button red, and similarly for blue and green.

## Conclusion
Learned to change component background colors dynamically on button click.

---

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

---

# Lab 9: Layout Manager Demo

## Objective
Create a JFrame using BorderLayout with NORTH (labels), CENTER (login form), and SOUTH (Reset/Exit buttons).

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField username;
    JPasswordField password;
    JCheckBox remember;

    public App() {
        f = new JFrame("Layout Manager Demo");
        f.setLayout(new BorderLayout());

        JPanel north = new JPanel(new FlowLayout());
        north.add(new JLabel("Name: Ronish"));
        north.add(new JLabel("Roll No: 1"));
        north.add(new JLabel("Class: BCA"));
        f.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(3, 2));
        center.add(new JLabel("Username:"));
        username = new JTextField();
        center.add(username);
        center.add(new JLabel("Password:"));
        password = new JPasswordField();
        center.add(password);
        remember = new JCheckBox("Remember Me");
        JButton login = new JButton("Login");
        login.addActionListener(this);
        center.add(remember); center.add(login);
        f.add(center, BorderLayout.CENTER);

        JPanel south = new JPanel(new FlowLayout());
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        reset.addActionListener(this);
        exit.addActionListener(this);
        south.add(reset); south.add(exit);
        f.add(south, BorderLayout.SOUTH);

        f.setSize(400, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Login")) {
            JOptionPane.showMessageDialog(f, "Username: " + username.getText());
        } else if (cmd.equals("Reset")) {
            username.setText("");
            password.setText("");
            remember.setSelected(false);
        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
Top panel shows student info, center has login form with Remember Me checkbox, bottom has Reset and Exit buttons. Login shows a dialog, Reset clears fields, Exit closes the app.

## Conclusion
Learned to combine multiple layout managers (BorderLayout, FlowLayout, GridLayout) in a single application.

---

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

---

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

---

# Lab 12: Toolbar Icons

## Objective
Create a JToolBar with programmatically generated colored circle icons and tooltip text.

## Source Code
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class App implements ActionListener {
    JFrame f;

    public App() {
        f = new JFrame("Toolbar Icons");
        f.setLayout(new BorderLayout());

        JToolBar toolbar = new JToolBar();
        JButton newBtn = new JButton(createIcon(Color.GREEN));
        newBtn.setToolTipText("New");
        JButton loginBtn = new JButton(createIcon(Color.BLUE));
        loginBtn.setToolTipText("Login");
        JButton logoutBtn = new JButton(createIcon(Color.RED));
        logoutBtn.setToolTipText("Logout");

        newBtn.addActionListener(this);
        loginBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        toolbar.add(newBtn);
        toolbar.add(loginBtn);
        toolbar.add(logoutBtn);
        f.add(toolbar, BorderLayout.NORTH);

        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private ImageIcon createIcon(Color c) {
        BufferedImage img = new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.setColor(c);
        g.fillOval(0, 0, 24, 24);
        g.dispose();
        return new ImageIcon(img);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = ((JButton) e.getSource()).getToolTipText();
        if (cmd.equals("New")) JOptionPane.showMessageDialog(f, "New File Created");
        else if (cmd.equals("Login")) JOptionPane.showMessageDialog(f, "Login Successful");
        else if (cmd.equals("Logout")) JOptionPane.showMessageDialog(f, "Logged Out");
    }

    public static void main(String[] args) {
        new App();
    }
}
```

## Output
A toolbar with three colored circle buttons. Green shows "New File Created", Blue shows "Login Successful", Red shows "Logged Out".

## Conclusion
Learned to create icons programmatically using BufferedImage and use JToolBar with tooltips.

---

# Lab 13: JDBC Insert Students

## Objective
Insert 5 student records using PreparedStatement and display them sorted by name.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        String insert = "INSERT INTO student (id, name, gender, address) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insert);

        ps.setInt(1, 1); ps.setString(2, "Ram"); ps.setString(3, "Male");
        ps.setString(4, "Kathmandu"); ps.executeUpdate();

        ps.setInt(1, 2); ps.setString(2, "Sita"); ps.setString(3, "Female");
        ps.setString(4, "Pokhara"); ps.executeUpdate();

        ps.setInt(1, 3); ps.setString(2, "Hari"); ps.setString(3, "Male");
        ps.setString(4, "Lalitpur"); ps.executeUpdate();

        ps.setInt(1, 4); ps.setString(2, "Gita"); ps.setString(3, "Female");
        ps.setString(4, "Bharatpur"); ps.executeUpdate();

        ps.setInt(1, 5); ps.setString(2, "Shyam"); ps.setString(3, "Male");
        ps.setString(4, "Biratnagar"); ps.executeUpdate();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student ORDER BY name ASC");
        System.out.println("ID\tName\t\tGender\t\tAddress");
        System.out.println("----------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getString("gender") + "\t\t" + rs.getString("address"));
        }

        con.close();
    }
}
```

## Output
```
ID      Name            Gender          Address
----------------------------------------------
4       Gita            Female          Bharatpur
3       Hari            Male            Lalitpur
1       Ram             Male            Kathmandu
5       Shyam           Male            Biratnagar
2       Sita            Female          Pokhara
```

## Conclusion
Learned to use PreparedStatement for parameterized queries and ResultSet for displaying data.

---

# Lab 14: JDBC Update Salary

## Objective
Update salary by 15% for employees with salary less than 20000.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement();

        System.out.println("Before Update:");
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        System.out.println("ID\tName\t\tSalary");
        System.out.println("---------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getDouble("salary"));
        }

        int updated = st.executeUpdate(
            "UPDATE student SET salary = salary + (salary * 15 / 100) WHERE salary < 20000");
        System.out.println("\nRows updated: " + updated);

        System.out.println("\nAfter Update:");
        rs = st.executeQuery("SELECT * FROM student");
        System.out.println("ID\tName\t\tSalary");
        System.out.println("---------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getDouble("salary"));
        }

        con.close();
    }
}
```

## Output
Shows salary records before and after the 15% increment for employees with salary less than 20000.

## Conclusion
Learned to execute UPDATE queries and display before/after results using JDBC.

---

# Lab 15: JDBC Create Table

## Objective
Create a table tblStudent with id, name, email columns and insert a record.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS tblStudent ("
            + "id INT PRIMARY KEY, "
            + "name VARCHAR(50), "
            + "email VARCHAR(100))");
        System.out.println("Table created successfully.");

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO tblStudent (id, name, email) VALUES (?, ?, ?)");
        ps.setInt(1, 1);
        ps.setString(2, "Ronish");
        ps.setString(3, "ronish@example.com");
        ps.executeUpdate();
        System.out.println("Record inserted successfully.");

        ResultSet rs = st.executeQuery("SELECT * FROM tblStudent");
        System.out.println("\nID\tName\t\tEmail");
        System.out.println("--------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name")
                + "\t\t" + rs.getString("email"));
        }

        con.close();
    }
}
```

## Output
```
Table created successfully.
Record inserted successfully.

ID      Name            Email
--------------------------------
1       Ronish          ronish@example.com
```

## Conclusion
Learned to use CREATE TABLE IF NOT EXISTS and insert records using PreparedStatement.

---

# Lab 16: JDBC ResultSet Navigation

## Objective
Demonstrate scrollable ResultSet navigation (first, last, previous, beforeFirst, next) using TYPE_SCROLL_INSENSITIVE.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("SELECT * FROM emp");

        System.out.println("--- first() ---");
        rs.first();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- last() ---");
        rs.last();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- previous() ---");
        rs.previous();
        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

        System.out.println("\n--- beforeFirst() then next() ---");
        rs.beforeFirst();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        }

        con.close();
    }
}
```

## Output
Demonstrates navigation through emp table records using first(), last(), previous(), beforeFirst(), and next().

## Conclusion
Learned to use scrollable ResultSet with TYPE_SCROLL_INSENSITIVE for flexible cursor navigation.

---

# Lab 17: JDBC Updatable ResultSet

## Objective
Use CONCUR_UPDATABLE ResultSet to update employee name and show before/after values.

## Source Code
```java
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javasamriddhi", "root", "");

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM emp WHERE id = ?",
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Before Update:");
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));

            rs.updateString("name", "UpdatedName");
            rs.updateRow();

            System.out.println("\nAfter Update:");
            rs.beforeFirst();
            rs.next();
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        }

        con.close();
    }
}
```

## Output
```
Before Update:
ID: 1, Name: OriginalName

After Update:
ID: 1, Name: UpdatedName
```

## Conclusion
Learned to use CONCUR_UPDATABLE ResultSet to update records directly through the result set.

---

# Lab 18: Servlet Lifecycle

## Objective
Implement the Servlet interface and demonstrate init, service, and destroy lifecycle methods.

## Source Code

### LifeCycleServlet.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LifeCycleServlet implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("in init");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        System.out.println("in service");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Hello from LifeCycleServlet</h2>");
    }

    public String getServletInfo() {
        return "LifeCycleServlet";
    }

    public void destroy() {
        System.out.println("in destroy");
    }
}
```

### index.html
```html
<html>
<body>
    <form action="lifecycle">
        <input type="submit" value="Call LifeCycleServlet">
    </form>
</body>
</html>
```

### web.xml
```xml
<web-app>
    <display-name>LifeCycleServlet</display-name>
    <servlet>
        <servlet-name>LifeCycle</servlet-name>
        <servlet-class>LifeCycleServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>LifeCycle</servlet-name>
        <url-pattern>/lifecycle</url-pattern>
    </servlet-mapping>
</web-app>
```

## Output
Console shows "in init" (once), "in service" (on each request). Browser displays "Hello from LifeCycleServlet". On undeploy, console shows "in destroy".

## Conclusion
Learned the servlet lifecycle: init(), service(), and destroy() methods.

---

# Lab 19: Servlet Session

## Objective
Demonstrate HttpSession by setting an attribute in one servlet and reading it in another.

## Source Code

### MyServlet1.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet1 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession();
        session.setAttribute("college", "Samriddhi College");

        out.println("<h2>Session attribute set</h2>");
        out.println("<a href='view'>View Session</a>");
    }
}
```

### MyServlet2.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);
        if (session != null) {
            String college = (String) session.getAttribute("college");
            out.println("<h2>College: " + college + "</h2>");
        } else {
            out.println("<h2>No session found</h2>");
        }
    }
}
```

### index.html
```html
<html>
<body>
    <a href="store">Store Session Attribute</a>
</body>
</html>
```

### web.xml
```xml
<web-app>
    <servlet>
        <servlet-name>Servlet1</servlet-name>
        <servlet-class>MyServlet1</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>Servlet2</servlet-name>
        <servlet-class>MyServlet2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Servlet1</servlet-name>
        <url-pattern>/store</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>Servlet2</servlet-name>
        <url-pattern>/view</url-pattern>
    </servlet-mapping>
</web-app>
```

## Output
Clicking "store" sets session attribute and shows a link to "view". Clicking "view" displays "College: Samriddhi College".

## Conclusion
Learned to use HttpSession to share data across multiple servlets for the same user session.

---

# Lab 20: Servlet Cookies

## Objective
Demonstrate cookies by storing username/password in LoginServlet and reading them in ViewCookiesServlet.

## Source Code

### LoginServlet.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");

        Cookie c1 = new Cookie("userName", userName);
        Cookie c2 = new Cookie("userPassword", userPassword);
        res.addCookie(c1);
        res.addCookie(c2);

        out.println("<h2>Cookies set successfully</h2>");
        out.println("<a href='view'>View Cookies</a>");
    }
}
```

### ViewCookiesServlet.java
```java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewCookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }
    }
}
```

### index.html
```html
<html>
<body>
    <form action="login" method="post">
        Username: <input type="text" name="userName"><br>
        Password: <input type="password" name="userPassword"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
```

### web.xml
```xml
<web-app>
    <servlet>
        <servlet-name>Login</servlet-name>
        <servlet-class>LoginServlet</servlet-class>
    </servlet>
    <servlet>
        <servlet-name>ViewCookies</servlet-name>
        <servlet-class>ViewCookiesServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>Login</servlet-name>
        <url-pattern>/login</url-pattern>
    </servlet-mapping>
    <servlet-mapping>
        <servlet-name>ViewCookies</servlet-name>
        <url-pattern>/view</url-pattern>
    </servlet-mapping>
</web-app>
```

## Output
Login form submits to /login, sets cookies, then clicking "View Cookies" shows userName and userPassword.

## Conclusion
Learned to create and read cookies in servlets for client-side data storage.

---

# Lab 21: JSP Cookies

## Objective
Create cookies in JSP from form parameters and display them on another JSP page.

## Source Code

### index.jsp
```jsp
<html>
<body>
    <form action="welcome.jsp" method="post">
        Username: <input type="text" name="userName"><br>
        Password: <input type="password" name="userPassword"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
```

### welcome.jsp
```jsp
<html>
<body>
<%
    String userName = request.getParameter("userName");
    String userPassword = request.getParameter("userPassword");

    Cookie c1 = new Cookie("userName", userName);
    Cookie c2 = new Cookie("userPassword", userPassword);
    response.addCookie(c1);
    response.addCookie(c2);
%>
<h2>Cookies set successfully</h2>
<a href="display.jsp">View Cookies</a>
</body>
</html>
```

### display.jsp
```jsp
<html>
<body>
<h2>All Cookies:</h2>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
        }
    } else {
        out.println("<p>No cookies found</p>");
    }
%>
</body>
</html>
```

## Output
Form → welcome.jsp creates cookies → display.jsp shows "userName: value" and "userPassword: value".

## Conclusion
Learned to work with cookies in JSP using scriptlets and the request/response implicit objects.

---

# Lab 22: JSP Form Display

## Objective
Create a student form and display the submitted data in an HTML table using JSP.

## Source Code

### studentForm.jsp
```jsp
<html>
<body>
<h2>Student Form</h2>
<form action="displayStudent.jsp" method="post">
    Name: <input type="text" name="name"><br>
    Roll No: <input type="text" name="rollNo"><br>
    Class: <input type="text" name="className"><br>
    Address: <input type="text" name="address"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
```

### displayStudent.jsp
```jsp
<html>
<body>
<h2>Student Details</h2>
<table border="1">
    <tr><th>Field</th><th>Value</th></tr>
    <tr><td>Name</td><td><%= request.getParameter("name") %></td></tr>
    <tr><td>Roll No</td><td><%= request.getParameter("rollNo") %></td></tr>
    <tr><td>Class</td><td><%= request.getParameter("className") %></td></tr>
    <tr><td>Address</td><td><%= request.getParameter("address") %></td></tr>
</table>
</body>
</html>
```

## Output
Student form submits to displayStudent.jsp which shows a bordered HTML table with the submitted field values.

## Conclusion
Learned to use JSP expressions and request.getParameter to process and display form data.

---

# Lab 23: JSP Simple Interest

## Objective
Calculate simple interest using JSP. Input principal, time, and rate; display inputs and result in a table.

## Source Code

### simpleInterestForm.jsp
```jsp
<html>
<body>
<h2>Simple Interest Calculator</h2>
<form action="calculateSI.jsp" method="post">
    Principal: <input type="text" name="principal"><br>
    Time (years): <input type="text" name="time"><br>
    Rate (%): <input type="text" name="rate"><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>
```

### calculateSI.jsp
```jsp
<html>
<body>
<%
    double p = Double.parseDouble(request.getParameter("principal"));
    double t = Double.parseDouble(request.getParameter("time"));
    double r = Double.parseDouble(request.getParameter("rate"));
    double si = (p * t * r) / 100;
%>
<h2>Simple Interest Result</h2>
<table border="1">
    <tr><th>Field</th><th>Value</th></tr>
    <tr><td>Principal</td><td><%= p %></td></tr>
    <tr><td>Time (years)</td><td><%= t %></td></tr>
    <tr><td>Rate (%)</td><td><%= r %></td></tr>
    <tr><td>Simple Interest</td><td><%= si %></td></tr>
</table>
</body>
</html>
```

## Output
Form for principal, time, rate. Submitting shows a table with inputs and the calculated simple interest.

## Conclusion
Learned to perform arithmetic calculations in JSP scriptlets and display results using expressions.

---

# Lab 24: RMI Adder

## Objective
Create a remote interface Adder, implement it in a server, and call it from a client.

## Source Code

### Adder.java
```java
import java.rmi.*;

public interface Adder extends Remote {
    public int add(int x, int y) throws RemoteException;
}
```

### MyServer.java
```java
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class MyServer extends UnicastRemoteObject implements Adder {

    public MyServer() throws RemoteException {
        super();
    }

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(5000);
        reg.rebind("hiserver", new MyServer());
        System.out.println("Server is ready on port 5000...");
    }
}
```

### MyClient.java
```java
import java.rmi.*;
import java.rmi.registry.*;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 5000);
        Adder adder = (Adder) reg.lookup("hiserver");
        int result = adder.add(20, 30);
        System.out.println("Sum = " + result);
    }
}
```

### App.java
```java
public class App {
    public static void main(String[] args) {
        System.out.println("Run MyServer first, then MyClient.");
    }
}
```

## Output
```
Server is ready on port 5000...
```
Run `java MyServer` first, then `java MyClient`:
```
Sum = 50
```

## Conclusion
Learned RMI architecture: remote interface, server implementation with UnicastRemoteObject, and client lookup.

---


