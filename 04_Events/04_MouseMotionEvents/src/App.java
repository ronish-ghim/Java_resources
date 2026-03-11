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
