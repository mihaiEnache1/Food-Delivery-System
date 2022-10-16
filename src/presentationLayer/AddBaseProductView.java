package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddBaseProductView extends JFrame {
    private final JTextField title;
    private final JTextField rating;
    private final JTextField calories;
    private final JTextField protein;
    private final JTextField fat;
    private final JTextField sodium;
    private final JTextField price;
    private final JButton addBaseProductButton;
    private final JButton addCompositeProductButton;
    private final JButton backButton;

    public AddBaseProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 569);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextField titletxt = new JTextField();
        titletxt.setHorizontalAlignment(SwingConstants.RIGHT);
        titletxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titletxt.setText("Title:");
        titletxt.setBounds(36, 59, 96, 31);
        contentPane.add(titletxt);
        titletxt.setColumns(10);

        JTextField ratingtxt = new JTextField();
        ratingtxt.setText("Rating:");
        ratingtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        ratingtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        ratingtxt.setColumns(10);
        ratingtxt.setBounds(36, 100, 96, 31);
        contentPane.add(ratingtxt);

        JTextField caloriestxt = new JTextField();
        caloriestxt.setText("Calories:");
        caloriestxt.setHorizontalAlignment(SwingConstants.RIGHT);
        caloriestxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        caloriestxt.setColumns(10);
        caloriestxt.setBounds(36, 141, 96, 31);
        contentPane.add(caloriestxt);

        JTextField proteintxt = new JTextField();
        proteintxt.setText("Protein:");
        proteintxt.setHorizontalAlignment(SwingConstants.RIGHT);
        proteintxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        proteintxt.setColumns(10);
        proteintxt.setBounds(36, 182, 96, 31);
        contentPane.add(proteintxt);

        JTextField fattxt = new JTextField();
        fattxt.setText("Fat:");
        fattxt.setHorizontalAlignment(SwingConstants.RIGHT);
        fattxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fattxt.setColumns(10);
        fattxt.setBounds(36, 223, 96, 31);
        contentPane.add(fattxt);

        JTextField sodiumtxt = new JTextField();
        sodiumtxt.setText("Sodium:");
        sodiumtxt.setHorizontalAlignment(SwingConstants.RIGHT);
        sodiumtxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sodiumtxt.setColumns(10);
        sodiumtxt.setBounds(36, 264, 96, 31);
        contentPane.add(sodiumtxt);

        JTextField pricetxt = new JTextField();
        pricetxt.setText("Price:");
        pricetxt.setHorizontalAlignment(SwingConstants.RIGHT);
        pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pricetxt.setColumns(10);
        pricetxt.setBounds(36, 305, 96, 31);
        contentPane.add(pricetxt);

        title = new JTextField();
        title.setBounds(142, 59, 308, 31);
        contentPane.add(title);
        title.setColumns(10);

        rating = new JTextField();
        rating.setColumns(10);
        rating.setBounds(142, 100, 308, 31);
        contentPane.add(rating);

        calories = new JTextField();
        calories.setColumns(10);
        calories.setBounds(142, 141, 308, 31);
        contentPane.add(calories);

        protein = new JTextField();
        protein.setColumns(10);
        protein.setBounds(142, 182, 308, 31);
        contentPane.add(protein);

        fat = new JTextField();
        fat.setColumns(10);
        fat.setBounds(142, 223, 308, 31);
        contentPane.add(fat);

        sodium = new JTextField();
        sodium.setColumns(10);
        sodium.setBounds(142, 264, 308, 31);
        contentPane.add(sodium);

        price = new JTextField();
        price.setColumns(10);
        price.setBounds(142, 305, 308, 31);
        contentPane.add(price);

        addBaseProductButton = new JButton("Add Base Product");
        addBaseProductButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addBaseProductButton.setBounds(152, 367, 216, 47);
        contentPane.add(addBaseProductButton);

        addCompositeProductButton = new JButton("Add Composite Product");
        addCompositeProductButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addCompositeProductButton.setBounds(108, 424, 300, 47);
        contentPane.add(addCompositeProductButton);

        backButton = new JButton("Back");
        backButton.setBounds(10, 10, 96, 31);
        contentPane.add(backButton);
    }

    public JButton getAddBaseProductButton() {
        return addBaseProductButton;
    }

    public JButton getAddCompositeProductButton() {
        return addCompositeProductButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void baseProductButtonListener(ActionListener actionListener) {
        addBaseProductButton.addActionListener(actionListener);
    }

    public void compositeProductButtonListener(ActionListener actionListener) {
        addCompositeProductButton.addActionListener(actionListener);
    }

    public void backButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public String getTitle() {
        return title.getText();
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
}
