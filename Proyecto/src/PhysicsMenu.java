//Menu de Fisica

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PhysicsMenu extends JPanel {

    private JLabel titulo = new JLabel("Fisica");

    public PhysicsMenu(){
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

    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBounds(){
        titulo.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }
}