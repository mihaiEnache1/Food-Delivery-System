package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditProductView extends JFrame {
    private final JTextField newTitle;
    private final JTextField rating;
    private final JTextField calories;
    private final JTextField protein;
    private final JTextField fat;
    private final JTextField sodium;
    private final JTextField price;
    private final JButton editButton;
    private final JButton backButton;
    private final JTable table;
    private final DefaultTableModel model;

    public EditProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 550);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField newTitletxt = new JTextField();
        newTitletxt.setHorizontalAlignment(SwingConstants.RIGHT);
        newTitletxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        newTitletxt.setText("New Title:");
        newTitletxt.setBounds(15, 93, 116, 31);
        contentPane.add(newTitletxt);
        newTitletxt.setColumns(10);

        JTextField ratingtxt = new JTextField();
        ratingtxt.setText("Rating:");
        ratingtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        ratingtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ratingtxt.setColumns(10);
        ratingtxt.setBounds(15, 134, 116, 31);
        contentPane.add(ratingtxt);

        JTextField caloriestxt = new JTextField();
        caloriestxt.setText("Calories:");
        caloriestxt.setHorizontalAlignment(SwingConstants.RIGHT);
        caloriestxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        caloriestxt.setColumns(10);
        caloriestxt.setBounds(15, 175, 116, 31);
        contentPane.add(caloriestxt);

        JTextField proteintxt = new JTextField();
        proteintxt.setText("Protein:");
        proteintxt.setHorizontalAlignment(SwingConstants.RIGHT);
        proteintxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        proteintxt.setColumns(10);
        proteintxt.setBounds(15, 216, 116, 31);
        contentPane.add(proteintxt);

        JTextField fattxt = new JTextField();
        fattxt.setText("Fat:");
        fattxt.setHorizontalAlignment(SwingConstants.RIGHT);
        fattxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fattxt.setColumns(10);
        fattxt.setBounds(15, 257, 116, 31);
        contentPane.add(fattxt);

        JTextField sodiumtxt = new JTextField();
        sodiumtxt.setText("Sodium:");
        sodiumtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        sodiumtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sodiumtxt.setColumns(10);
        sodiumtxt.setBounds(15, 298, 116, 31);
        contentPane.add(sodiumtxt);

        JTextField pricetxt = new JTextField();
        pricetxt.setText("Price:");
        pricetxt.setHorizontalAlignment(SwingConstants.RIGHT);
        pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pricetxt.setColumns(10);
        pricetxt.setBounds(15, 339, 116, 31);
        contentPane.add(pricetxt);

        newTitle = new JTextField();
        newTitle.setBounds(130, 93, 280, 31);
        contentPane.add(newTitle);
        newTitle.setColumns(10);

        rating = new JTextField();
        rating.setHorizontalAlignment(SwingConstants.CENTER);
        rating.setColumns(10);
        rating.setBounds(130, 134, 280, 31);
        contentPane.add(rating);

        calories = new JTextField();
        calories.setHorizontalAlignment(SwingConstants.CENTER);
        calories.setColumns(10);
        calories.setBounds(130, 175, 280, 31);
        contentPane.add(calories);

        protein = new JTextField();
        protein.setHorizontalAlignment(SwingConstants.CENTER);
        protein.setColumns(10);
        protein.setBounds(130, 216, 280, 31);
        contentPane.add(protein);

        fat = new JTextField();
        fat.setHorizontalAlignment(SwingConstants.CENTER);
        fat.setColumns(10);
        fat.setBounds(130, 257, 280, 31);
        contentPane.add(fat);

        sodium = new JTextField();
        sodium.setHorizontalAlignment(SwingConstants.CENTER);
        sodium.setColumns(10);
        sodium.setBounds(130, 298, 280, 31);
        contentPane.add(sodium);

        price = new JTextField();
        price.setHorizontalAlignment(SwingConstants.CENTER);
        price.setColumns(10);
        price.setBounds(130, 339, 280, 31);
        contentPane.add(price);

        editButton = new JButton("Edit Product");
        editButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        editButton.setBounds(169, 400, 148, 39);
        contentPane.add(editButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 85, 21);
        contentPane.add(backButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(450, 32, 510, 424);
        contentPane.add(panel);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void editButtonListener(ActionListener actionListener) {
        editButton.addActionListener(actionListener);
    }

    public String getNewTitle() {
        return newTitle.getText();
    }

    public float getRating() {
        return Float.parseFloat(rating.getText());
    }

    public int getCalories() {
        return Integer.parseInt(calories.getText());
    }

    public int getProtein() {
        return Integer.parseInt(protein.getText());
    }

    public int getFat() {
        return Integer.parseInt(fat.getText());
    }

    public int getSodium() {
        return Integer.parseInt(sodium.getText());
    }

    public float getPrice() {
        return Float.parseFloat(price.getText());
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getTable() {
        return table;
    }
}
