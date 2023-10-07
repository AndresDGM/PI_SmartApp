package AppMainSrc;//Menu de algebra

import AlgebraPack.GaussJordan;

import javax.swing.*;
import java.awt.*;

public class AlgebraMenu extends JPanel {

    public GaussJordan gaussJordan = new GaussJordan();

    private Button b = new Button();

    private JLabel titulo = new JLabel("Algebra Lineal");

    public AlgebraMenu(){
        setSize(1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(460, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        b.setContenido(gaussJordan, this);
        b.setLocation(getWidth()/2 - b.getWidth()/2, getHeight()/2 - b.getHeight()/2);
        add(b);
        add(titulo);
        setVisible(false);
    }

    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBounds(){
        titulo.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }
}
