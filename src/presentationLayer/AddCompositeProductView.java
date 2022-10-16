package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddCompositeProductView extends JFrame {
    public JPanel contentPane;
    private final JTextField compositeName;
    private final JButton addButton;
    private final JButton backButton;
    private final JTable table;
    private final DefaultTableModel model;

    public AddCompositeProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 510);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField compositetxt = new JTextField();
        compositetxt.setHorizontalAlignment(SwingConstants.RIGHT);
        compositetxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        compositetxt.setText("Composite Product Name:");
        compositetxt.setBounds(5, 57, 258, 31);
        contentPane.add(compositetxt);
        compositetxt.setColumns(10);

        compositeName = new JTextField();
        compositeName.setBounds(270, 57, 258, 31);
        contentPane.add(compositeName);
        compositeName.setColumns(10);

        addButton = new JButton("Add to Composite Product");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addButton.setBounds(120, 120, 275, 41);
        contentPane.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 85, 21);
        contentPane.add(backButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(550, 32, 510, 424);
        contentPane.add(panel);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void addButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public String getCompositeName() {
        return compositeName.getText();
    }

    public JButton getBackButton() {
        return backButton;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getTable() {
        return table;
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
