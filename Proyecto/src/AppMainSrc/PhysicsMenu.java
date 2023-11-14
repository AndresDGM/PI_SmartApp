package AppMainSrc;//Menu de Fisica

import PhysicsSrc.Game.Game;
import PhysicsSrc.Game.Guia;
import PhysicsSrc.Game.Mecanicas;

import javax.swing.*;
import java.awt.*;

public class PhysicsMenu extends JPanel {

    private JLabel titulo = new JLabel("Fisica");

    public Mecanicas mecanicas = new Mecanicas();

    public Guia guia = new Guia();

    private Button botonGuia = new Button();

    private Button botonMecanicas = new Button();

    private BasicButton jugar;
    
    private App app;
        
    public PhysicsMenu(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        botonGuia.setLocation(552, 200);
        botonGuia.setTitulo("Como Jugar?");
        botonGuia.setImagenBoton("src/Imagenes/IconParkGameThree.png");
        botonMecanicas.setLocation(181, 200);
        botonMecanicas.setTitulo("Mecanicas");
        botonMecanicas.setImagenBoton("src/Imagenes/FaCogs.png");
        botonGuia.setContenido(guia, this);
        botonMecanicas.setContenido(mecanicas, this);
        jugar = new BasicButton(280,100, "Jugar") {
            @Override
            public void clickEvent() {
                startGame();
            }
        };
        jugar.setLocation(397, 575);
        jugar.getText().setSize(280,50);
        jugar.setColor(new Color(18, 227, 46));
        jugar.getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        jugar.getText().setVerticalAlignment(JLabel.CENTER);
        jugar.getText().setHorizontalAlignment(JLabel.CENTER);
        jugar.setLayout(null);
        jugar.getText().setLocation(0, 25);
        titulo.setBounds(410, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(jugar);
        add(botonGuia);
        add(botonMecanicas);
        add(titulo);
        setVisible(false);
    }

    public void startGame(){
        App.lateralBar.getComponent(0).setVisible(false);
        App.lateralBar.getComponent(1).setVisible(false);
        Game juego = new Game();
        juego.star();
        juego.getMenu().setGs(this);
        juego.setVisible(true);
        juego.setLocation(50, 0);
        app.add(juego);
        app.addKeyListener(juego.getTeclas());
        app.requestFocus();
        setVisible(false);
    }
    
    public Button getBotonGuia() {
        return botonGuia;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public BasicButton getJugar() {
        return jugar;
    }

    public Button getBotonMecanicas() {
        return botonMecanicas;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}