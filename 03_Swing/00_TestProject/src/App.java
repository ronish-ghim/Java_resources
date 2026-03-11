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
