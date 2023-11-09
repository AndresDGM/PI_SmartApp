package PhysicsSrc.Game;

import AppMainSrc.App;
import AppMainSrc.BasicButton;
import AppMainSrc.Button;

import javax.swing.*;
import java.awt.*;

public class GameSeccion extends JPanel {
    private JLabel titulo = new JLabel("Fisica");

    public Mecanicas mecanicas = new Mecanicas();

    public Guia guia = new Guia();

    private Button botonGuia = new Button();

    private Button botonMecanicas = new Button();

    private BasicButton jugar;
    
    private App app;

    public GameSeccion(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        botonGuia.setLocation(552, 300);
        botonGuia.setTitulo("Como Jugar?");
        botonMecanicas.setLocation(181, 300);
        botonMecanicas.setTitulo("Mecanicas");
        botonGuia.setContenido(guia, this);
        botonMecanicas.setContenido(mecanicas, this);
        jugar = new BasicButton(150,50, "Jugar") {
            @Override
            public void clickEvent() {
                startGame();
            }
        };
        jugar.setLocation(462, 600);
        jugar.setColor(new Color(18, 227, 46));
        jugar.getText().setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        jugar.getText().setVerticalAlignment(JLabel.CENTER);
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
