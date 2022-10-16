package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private final JButton showButton;
    private final JButton searchButton;
    private final JButton orderButton;
    private final JButton backButton;
    private final DefaultTableModel defaultTableModel;
    private final JTable table;
    private final JTextField title;
    private final JTextField rating;
    private final JTextField calories;
    private final JTextField sodium;
    private final JTextField price;
    private final JTextField protein;
    private final JTextField fat;

    public ClientGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 912, 507);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        showButton = new JButton("Show Products");
        showButton.setBounds(100, 325, 162, 37);
        contentPane.add(showButton);

        searchButton = new JButton("Search Products");
        searchButton.setBounds(100, 372, 162, 37);
        contentPane.add(searchButton);

        orderButton = new JButton("Order");
        orderButton.setBounds(100, 419, 162, 37);
        contentPane.add(orderButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(380, 32, 510, 424);
        contentPane.add(panel);

        String[] columns = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

        defaultTableModel = new DefaultTableModel(columns, 0);

        table = new JTable(defaultTableModel);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JTextField titletxt = new JTextField();
        titletxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titletxt.setHorizontalAlignment(SwingConstants.RIGHT);
        titletxt.setText("Title:");
        titletxt.setBounds(27, 32, 96, 31);
        contentPane.add(titletxt);
        titletxt.setColumns(10);

        JTextField ratingtxt = new JTextField();
        ratingtxt.setText("Rating:");
        ratingtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        ratingtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ratingtxt.setColumns(10);
        ratingtxt.setBounds(27, 73, 96, 31);
        contentPane.add(ratingtxt);

        JTextField caloriestxt = new JTextField();
        caloriestxt.setText("Calories:");
        caloriestxt.setHorizontalAlignment(SwingConstants.RIGHT);
        caloriestxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        caloriestxt.setColumns(10);
        caloriestxt.setBounds(27, 114, 96, 31);
        contentPane.add(caloriestxt);

        JTextField proteintxt = new JTextField();
        proteintxt.setText("Protein:");
        proteintxt.setHorizontalAlignment(SwingConstants.RIGHT);
        proteintxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        proteintxt.setColumns(10);
        proteintxt.setBounds(27, 155, 96, 31);
        contentPane.add(proteintxt);

        JTextField fattxt = new JTextField();
        fattxt.setText("Fat:");
        fattxt.setHorizontalAlignment(SwingConstants.RIGHT);
        fattxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fattxt.setColumns(10);
        fattxt.setBounds(27, 196, 96, 31);
        contentPane.add(fattxt);

        JTextField sodiumtxt = new JTextField();
        sodiumtxt.setText("Sodium:");
        sodiumtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        sodiumtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sodiumtxt.setColumns(10);
        sodiumtxt.setBounds(27, 237, 96, 31);
        contentPane.add(sodiumtxt);

        JTextField pricetxt = new JTextField();
        pricetxt.setText("Price:");
        pricetxt.setHorizontalAlignment(SwingConstants.RIGHT);
        pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pricetxt.setColumns(10);
        pricetxt.setBounds(27, 278, 96, 31);
        contentPane.add(pricetxt);

        title = new JTextField();
        title.setBounds(133, 32, 217, 31);
        contentPane.add(title);
        title.setColumns(10);

        rating = new JTextField();
        rating.setColumns(10);
        rating.setBounds(133, 73, 217, 31);
        contentPane.add(rating);

        calories = new JTextField();
        calories.setColumns(10);
        calories.setBounds(133, 114, 217, 31);
        contentPane.add(calories);

        protein = new JTextField();
        protein.setColumns(10);
        protein.setBounds(133, 155, 217, 31);
        contentPane.add(protein);

        fat = new JTextField();
        fat.setColumns(10);
        fat.setBounds(133, 196, 217, 31);
        contentPane.add(fat);

        sodium = new JTextField();
        sodium.setColumns(10);
        sodium.setBounds(133, 237, 217, 31);
        contentPane.add(sodium);

        price = new JTextField();
        price.setColumns(10);
        price.setBounds(133, 278, 217, 31);
        contentPane.add(price);

        backButton = new JButton("Back");
        backButton.setBounds(10, 1, 85, 21);
        contentPane.add(backButton);
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JButton getShowButton() {
        return showButton;
    }

    public JButton getOrderButton() {
        return orderButton;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public int getCaloriesField() {
        return Integer.parseInt(calories.getText());
    }

    public int getFatField() {
        return Integer.parseInt(fat.getText());
    }

    public float getPriceField() {
        return Float.parseFloat(price.getText());
    }

    public int getProteinField() {
        return Integer.parseInt(protein.getText());
    }

    public float getRatingFiled() {
        return Float.parseFloat(rating.getText());
    }

    public int getSodiumField() {
        return Integer.parseInt(sodium.getText());
    }

    public String getTitleField() {
        return title.getText();
    }

    public String getCalories() {
        return calories.getText();
    }

    public String getFat() {
        return fat.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getProtein() {
        return protein.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getSodium() {
        return sodium.getText();
    }

    public void searchButtonListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void showButtonListener(ActionListener actionListener) {
        showButton.addActionListener(actionListener);
    }

    public void orderButton(ActionListener actionListener) {
        orderButton.addActionListener(actionListener);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
