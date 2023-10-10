package AppMainSrc;

//menu de matematicas

import javax.swing.*;
import java.awt.*;
import MathSource.Graficadora;

public class MathMenu extends JPanel {
    
    public Graficadora graficadora = new Graficadora();

    private JLabel titulo = new JLabel("Matematicas II");
    
    private Button boton = new Button();

    public MathMenu(){
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(460, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        boton.setTitulo("Graficadora");
        boton.setContenido(graficadora, this);
        boton.setLocation(367,  300);
        add(boton);
        add(titulo);
        setVisible(false);
    }

    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBounds(){
        titulo.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }
}
