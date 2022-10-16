package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstReportView extends JFrame {
    public JPanel contentPane;
    private final JTextField startHour;
    private final JTextField endHour;
    private final JButton reportButton;
    private final JButton backButton;

    public FirstReportView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 454, 344);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField starttxt = new JTextField();
        starttxt.setHorizontalAlignment(SwingConstants.RIGHT);
        starttxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        starttxt.setText("Start hour:");
        starttxt.setBounds(39, 62, 142, 36);
        contentPane.add(starttxt);
        starttxt.setColumns(10);

        JTextField endtxt = new JTextField();
        endtxt.setText("End hour:");
        endtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        endtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        endtxt.setColumns(10);
        endtxt.setBounds(39, 108, 142, 36);
        contentPane.add(endtxt);

        startHour = new JTextField();
        startHour.setBounds(210, 62, 167, 36);
        contentPane.add(startHour);
        startHour.setColumns(10);

        endHour = new JTextField();
        endHour.setColumns(10);
        endHour.setBounds(210, 108, 167, 36);
        contentPane.add(endHour);

        reportButton = new JButton("Generate report");
        reportButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        reportButton.setBounds(115, 185, 182, 51);
        contentPane.add(reportButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 85, 21);
        contentPane.add(backButton);
    }

    public JButton getReportButton() {
        return reportButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void reportButtonListener(ActionListener actionListener) {
        reportButton.addActionListener(actionListener);
    }

    public int getStartHour() {
        return Integer.parseInt(startHour.getText());
    }

    public int getEndHour() {
        return Integer.parseInt(endHour.getText());
    }
}
