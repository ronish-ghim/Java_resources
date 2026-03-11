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
