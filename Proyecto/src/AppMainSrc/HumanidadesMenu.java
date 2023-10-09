package AppMainSrc;//Menu de humanidades

import javax.swing.*;
import java.awt.*;

public class HumanidadesMenu extends JPanel {

    private JLabel titulo = new JLabel("Humanidades");
        
    public HumanidadesMenu(){
        setSize(1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(460, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        setVisible(false);
    }
}

