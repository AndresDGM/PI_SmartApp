package AppMainSrc;//Menu de Fisica

import PhysicsSrc.ConceptosFisisca;
import PhysicsSrc.Game.GameSeccion;
import PhysicsSrc.Mru.Carretera;

import javax.swing.*;
import java.awt.*;

public class PhysicsMenu extends JPanel {

    private JLabel titulo = new JLabel("Fisica");

    public Carretera carretera = new Carretera();

    private Button boton = new Button();
    
    private Button botont = new Button();

    private Button botonGs = new Button();
    
    public ConceptosFisisca conceptos = new ConceptosFisisca();

    public GameSeccion seccionJuego = new GameSeccion();
    
    public PhysicsMenu(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        boton.setLocation(552, 300);
        boton.setTitulo("Movimiento");
        botonGs.setLocation(552, 300);
        botonGs.setTitulo("Seccion Juego");
        boton.setContenido(carretera, this);
        botonGs.setContenido(seccionJuego,this);
        titulo.setBounds(410, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(botonGs);
        add(boton);
        add(titulo);
        setVisible(false);
    }
}