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
