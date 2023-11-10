package AppMainSrc;//menu de matematicas
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
        titulo.setBounds(409, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        bderivada = new Button();
        bderivada.setContenido(derivar, this);
        bderivada.setTitulo("Derivar");
        bderivada.setImagenBoton("src/Imagenes/calculadora.png");
        bderivada.setLocation(571, 275);
        bgrafica = new Button();
        bgrafica.setImagenBoton("src/Imagenes/grafico.png");
        bgrafica.setContenido(graficadora, this);
        bgrafica.setTitulo("Graficadora");
        bgrafica.setLocation(200, 275);
        add(bgrafica);
        add(bderivada);
        add(titulo);
        setVisible(false);
    }
}
