package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogInView extends JFrame {
    private final JTextField username;
    private final JPasswordField password;
    private final JButton registerButton;
    private final JButton logButton;
    private final JComboBox<String> comboBox;

    public LogInView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 445);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField usernametxt = new JTextField();
        usernametxt.setHorizontalAlignment(SwingConstants.RIGHT);
        usernametxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernametxt.setText("Username:");
        usernametxt.setBounds(23, 140, 146, 31);
        contentPane.add(usernametxt);
        usernametxt.setColumns(10);

        JTextField passwordtxt = new JTextField();
        passwordtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordtxt.setText("Password:");
        passwordtxt.setColumns(10);
        passwordtxt.setBounds(23, 181, 146, 31);
        contentPane.add(passwordtxt);

        username = new JTextField();
        username.setBounds(192, 140, 204, 29);
        contentPane.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setColumns(10);
        password.setBounds(192, 181, 204, 31);
        contentPane.add(password);

        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        registerButton.setBounds(86, 233, 170, 40);
        contentPane.add(registerButton);

        logButton = new JButton("Log in");
        logButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logButton.setBounds(86, 294, 170, 40);
        contentPane.add(logButton);

        String[] types = {"Administrator", "Employee", "Client"};

        comboBox = new JComboBox<>(types);
        comboBox.setBounds(453, 168, 179, 29);
        contentPane.add(comboBox);
    }

    public JButton getLogButton() {
        return logButton;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void logButtonListener(ActionListener actionListener) {
        logButton.addActionListener(actionListener);
    }

    public void registerButtonListener(ActionListener actionListener) {
        registerButton.addActionListener(actionListener);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public void refresh() {
        this.username.setText(null);
        this.password.setText(null);
    }
}
