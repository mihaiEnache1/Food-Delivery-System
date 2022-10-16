package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ThirdReportView extends JFrame {
    private final JTextField noTimes;
    private final JTextField amount;
    private final JButton backButton;
    private final JButton reportButton;

    public ThirdReportView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 571, 385);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField timestxt = new JTextField();
        timestxt.setHorizontalAlignment(SwingConstants.RIGHT);
        timestxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        timestxt.setText("Number of times:");
        timestxt.setBounds(32, 96, 201, 37);
        contentPane.add(timestxt);
        timestxt.setColumns(10);

        JTextField amounttxt = new JTextField();
        amounttxt.setText("Amount:");
        amounttxt.setHorizontalAlignment(SwingConstants.RIGHT);
        amounttxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amounttxt.setColumns(10);
        amounttxt.setBounds(32, 154, 201, 37);
        contentPane.add(amounttxt);

        noTimes = new JTextField();
        noTimes.setHorizontalAlignment(SwingConstants.RIGHT);
        noTimes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        noTimes.setColumns(10);
        noTimes.setBounds(257, 96, 201, 37);
        contentPane.add(noTimes);

        amount = new JTextField();
        amount.setHorizontalAlignment(SwingConstants.RIGHT);
        amount.setFont(new Font("Tahoma", Font.PLAIN, 20));
        amount.setColumns(10);
        amount.setBounds(257, 154, 201, 37);
        contentPane.add(amount);

        reportButton = new JButton("Generate report");
        reportButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        reportButton.setBounds(167, 219, 175, 37);
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

    public int getNoTimes() {
        return Integer.parseInt(noTimes.getText());
    }

    public int getAmount() {
        return Integer.parseInt(amount.getText());
    }
}
