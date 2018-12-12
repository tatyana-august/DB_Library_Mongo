package View.src;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{
    private JButton button1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel panel1;

    private void setupUI() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout());
        button1 = new JButton();
        button1.setText("Button");
        panel1.add(button1);
        textField1 = new JTextField();
        panel1.add(textField1);
        textArea1 = new JTextArea();
        panel1.add(textArea1);
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
}
    public static void main(String [] args){
        SwingUtilities.invokeLater( new Runnable(){
            public void run(){
                new MainForm().setupUI();
            } } );
    }
}
