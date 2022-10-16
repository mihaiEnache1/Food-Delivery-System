package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorGUI extends JFrame{
    private final JButton importButton;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton showButton;
    private final JButton report1Button;
    private final JButton report2Button;
    private final JButton report3Button;
    private final JButton report4Button;
    private final JButton backButton;
    private final JButton editButton;
    private final JTable table;
    private final DefaultTableModel defaultTableModel;

    public AdministratorGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 789, 649);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        importButton = new JButton("Import products");
        importButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        importButton.setBounds(22, 41, 200, 44);
        contentPane.add(importButton);

        addButton = new JButton("Add product");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addButton.setBounds(22, 95, 200, 44);
        contentPane.add(addButton);

        deleteButton = new JButton("Delete product");
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deleteButton.setBounds(22, 149, 200, 44);
        contentPane.add(deleteButton);

        showButton = new JButton("Show products");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        showButton.setBounds(22, 257, 200, 44);
        contentPane.add(showButton);

        report1Button = new JButton("Report 1");
        report1Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        report1Button.setBounds(22, 311, 200, 44);
        contentPane.add(report1Button);

        report2Button = new JButton("Report 2");
        report2Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        report2Button.setBounds(22, 365, 200, 44);
        contentPane.add(report2Button);

        report3Button = new JButton("Report 3");
        report3Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        report3Button.setBounds(22, 419, 200, 44);
        contentPane.add(report3Button);

        report4Button = new JButton("Report 4");
        report4Button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        report4Button.setBounds(22, 473, 200, 44);
        contentPane.add(report4Button);

        backButton = new JButton("Back");
        backButton.setBounds(22, 10, 85, 21);
        contentPane.add(backButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(250, 32, 510, 424);
        contentPane.add(panel);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        defaultTableModel = new DefaultTableModel(columns, 0);

        table = new JTable(defaultTableModel);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        editButton = new JButton("Edit Product");
        editButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        editButton.setBounds(22, 203, 200, 44);
        contentPane.add(editButton);
    }

    public JButton getImportButton() {
        return importButton;
    }

    public JButton getShowButton() {
        return showButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JButton getReport1Button() {
        return report1Button;
    }

    public JButton getReport2Button() {
        return report2Button;
    }

    public JButton getReport3Button() {
        return report3Button;
    }

    public JButton getReport4Button() {
        return report4Button;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void addButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void importButtonListener(ActionListener actionListener) {
        importButton.addActionListener(actionListener);
    }

    public void showButtonListener(ActionListener actionListener) {
        showButton.addActionListener(actionListener);
    }

    public void deleteButtonListener(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void editButtonListener(ActionListener actionListener) {
        editButton.addActionListener(actionListener);
    }

    public void report1ButtonListener(ActionListener actionListener) {
        report1Button.addActionListener(actionListener);
    }

    public void report2ButtonListener(ActionListener actionListener) {
        report2Button.addActionListener(actionListener);
    }

    public void report3ButtonListener(ActionListener actionListener) {
        report3Button.addActionListener(actionListener);
    }

    public void report4ButtonListener(ActionListener actionListener) {
        report4Button.addActionListener(actionListener);
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JTable getTable() {
        return table;
    }
}
