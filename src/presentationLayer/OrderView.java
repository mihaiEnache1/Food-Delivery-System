package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderView extends JFrame {
    private final JButton addButton;
    private final JButton backButton;
    private final JButton orderButton;
    private final JTable table;
    private final DefaultTableModel defaultTableModel;

    public OrderView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 830, 530);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField namesTxt = new JTextField();
        namesTxt.setHorizontalAlignment(SwingConstants.RIGHT);
        namesTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        namesTxt.setText("Choose product:");
        namesTxt.setBounds(42, 88, 176, 31);
        contentPane.add(namesTxt);
        namesTxt.setColumns(10);

        orderButton = new JButton("Place order");
        orderButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        orderButton.setBounds(60, 144, 137, 37);
        contentPane.add(orderButton);

        addButton = new JButton("Add product");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addButton.setBounds(42, 209, 176, 37);
        contentPane.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 85, 21);
        contentPane.add(backButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(250, 32, 510, 424);
        contentPane.add(panel);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        defaultTableModel = new DefaultTableModel(columns, 0);

        table = new JTable(defaultTableModel);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void addButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void orderButtonListener(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }
}
