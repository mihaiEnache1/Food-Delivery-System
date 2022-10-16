package presentationLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EmployeeGUI extends JFrame implements Observer{
    private final JTextArea textArea;

    public EmployeeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 694, 481);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane jScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(35, 32, 400, 400);
        contentPane.add(jScrollPane);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(String text) {
        String newText = this.textArea.getText() + text + "\n";
        this.textArea.setText(newText);
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(this, "New order has been placed");
    }
}
