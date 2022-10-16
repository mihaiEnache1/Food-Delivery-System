package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SecondReportView extends JFrame {
    private final JTextField value;
    private final JButton reportButton;
    private final JButton backButton;

    public SecondReportView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 524, 377);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField text = new JTextField();
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setText("Products ordered more than:");
        text.setBounds(24, 76, 321, 39);
        contentPane.add(text);
        text.setColumns(10);

        value = new JTextField();
        value.setBounds(355, 76, 96, 39);
        contentPane.add(value);
        value.setColumns(10);

        reportButton = new JButton("Generate report");
        reportButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        reportButton.setBounds(134, 152, 211, 39);
        contentPane.add(reportButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 85, 21);
        contentPane.add(backButton);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public void backListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void reportListener(ActionListener actionListener) {
        reportButton.addActionListener(actionListener);
    }

    public int getValue() {
        return Integer.parseInt(value.getText());
    }
}
