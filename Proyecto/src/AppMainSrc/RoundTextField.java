package AppMainSrc;

import javax.swing.*;
import java.awt.*;

public class RoundTextField extends JPanel {

    private RoundBorder border;

    private JTextField textField = new JTextField();
    public RoundTextField(int w, int h){
        setSize(w, h);
        setBackground(new Color(46,46,46));
        setLayout(null);
        setOpaque(false);
        textField.setBounds(3, 3,w - 6, h - 6);
        textField.setText("0");
        textField.setFont(new Font("Arial",Font.PLAIN,32));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFocusable(true);
        textField.setOpaque(false);
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        border = new RoundBorder(w, h, 20, 20, 3);
        border.setBackground(Color.WHITE);
        add(border);
        add(textField);
        setVisible(true);
    }

    public double getNumText(){
        return Double.parseDouble(textField.getText());
    }

    public void setText(String text){
        textField.setText(text);
        textField.setFocusable(false);
    }
    public RoundBorder getRoundBorder(){
        return border;
    }

    public JTextField getTextField() {
        return textField;
    }
}
