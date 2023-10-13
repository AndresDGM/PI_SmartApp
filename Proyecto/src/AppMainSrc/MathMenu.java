package AppMainSrc;

//menu de matematicas

import MathSource.Derivada;
import javax.swing.*;
import java.awt.*;
import MathSource.Graficadora;

public class MathMenu extends JPanel {
    
    public Graficadora graficadora = new Graficadora();
    
    public Derivada derivar = new Derivada();

    private final JLabel titulo = new JLabel("Matematicas II");
    
    private final Button bgrafica, bderivada;

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
        bderivada = new Button();
        bderivada.setContenido(derivar, this);
        bderivada.setTitulo("Derivar");
        bderivada.setLocation(571, 140);
        bgrafica = new Button();
        bgrafica.setContenido(graficadora, this);
        bgrafica.setTitulo("Graficadora");
        bgrafica.setLocation(200, 140);
        add(bgrafica);
        add(bderivada);
        add(titulo);
        setVisible(false);
    }
    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBounds(){
        titulo.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }
}
