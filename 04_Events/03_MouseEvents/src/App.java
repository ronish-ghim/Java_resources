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
