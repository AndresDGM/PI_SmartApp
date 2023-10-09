package AppMainSrc;//Menu de algebra

import AlgebraPack.DetCalculator;
import AlgebraPack.GaussJordan;

import javax.swing.*;
import java.awt.*;

public class AlgebraMenu extends JPanel {

    public GaussJordan gaussJordan = new GaussJordan();

    public DetCalculator detCalculator = new DetCalculator();

    private Button[] botones = new Button[2];

    private JLabel titulo = new JLabel("Algebra Lineal");

    public AlgebraMenu(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(410, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        initBotones();
        setVisible(false);
    }

    public void initBotones(){
        botones[0] = new Button();
        botones[0].setContenido(gaussJordan, this);
        botones[0].setLocation(180, 275);
        botones[0].setImagenBoton("src/Imagenes/SistemaE.png");
        botones[0].setTitulo("Sistema de ecuaciones");
        botones[1] = new Button();
        botones[1].setContenido(detCalculator, this);
        botones[1].setLocation(552, 275);
        botones[1].setImagenBoton("src/Imagenes/imgDet.png");
        botones[1].setTitulo("Determinate");
        add(botones[0]);
        add(botones[1]);
    }
}
