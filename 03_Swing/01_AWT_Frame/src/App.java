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