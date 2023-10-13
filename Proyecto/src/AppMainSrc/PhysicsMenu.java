package AppMainSrc;//Menu de Fisica

import javax.swing.*;
import java.awt.*;
import PhysicsSrc.ConceptosFisisca;
import PhysicsSrc.Mru.Carretera;

public class PhysicsMenu extends JPanel {

    private JLabel titulo = new JLabel("Fisica");

    public Carretera carretera = new Carretera();

    private Button boton = new Button();
    
    private Button botont = new Button();
    
    public ConceptosFisisca conceptos = new ConceptosFisisca();
    
    public PhysicsMenu(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        boton.setLocation(552, 300);
        boton.setTitulo("Movimiento");
        botont.setLocation(181, 300);
        botont.setTitulo("Conceptos");
        boton.setContenido(carretera, this);
        botont.setContenido(conceptos, this);
        titulo.setBounds(410, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(boton);
        add(botont);
        add(titulo);
        setVisible(false);
    }
}