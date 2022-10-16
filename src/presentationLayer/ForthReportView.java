package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ForthReportView extends JFrame {
    private final JTextField day;
    private final JButton backButton;
    private final JButton reportButton;

    public ForthReportView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 540, 306);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField dayTxt = new JTextField();
        dayTxt.setText("Day:");
        dayTxt.setHorizontalAlignment(SwingConstants.RIGHT);
        dayTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        dayTxt.setColumns(10);
        dayTxt.setBounds(58, 74, 179, 34);
        contentPane.add(dayTxt);

        day = new JTextField();
        day.setColumns(10);
        day.setBounds(261, 74, 211, 34);
        contentPane.add(day);

        reportButton = new JButton("Generate report");
        reportButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        reportButton.setBounds(142, 122, 211, 46);
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

    public void backListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void reportListener(ActionListener actionListener) {
        reportButton.addActionListener(actionListener);
    }

    public int getDay() {
        return Integer.parseInt(day.getText());
    }
}
