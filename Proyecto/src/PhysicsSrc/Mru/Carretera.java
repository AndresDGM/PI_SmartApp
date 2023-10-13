package PhysicsSrc.Mru;

import AppMainSrc.BasicButton;

import javax.swing.*;
import java.awt.*;

public class Carretera extends JPanel {

    public JLabel carretera = new JLabel();

    public JLabel carro = new JLabel();

    public JLabel vectorHor = new JLabel();

    public JLabel vectorVer = new JLabel();

    private BasicButton boton;

    private boolean band = true;

    private boolean proceso = false;

    public Carretera(){
        setBounds(50, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(152,220,720,360);
        carretera.setBounds(0,0,720,360);
        ImageIcon cImagen = new ImageIcon("src/Imagenes/carretera.jpg");
        carretera.setIcon(cImagen);
        ImageIcon im = new ImageIcon("src/Imagenes/carro2.png");
        Icon carroIm = new ImageIcon(im.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        carro.setIcon(carroIm);
        carro.setBounds(0,240,120,120);
        ImageIcon im2 = new ImageIcon("src/Imagenes/Vectorder.png");
        Icon Vectorim = new ImageIcon(im2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        vectorHor.setIcon(Vectorim);
        vectorHor.setBounds(117,285,50,50);
        ImageIcon im3 = new ImageIcon("src/Imagenes/VectorDown.png");
        Icon Vectorim2 = new ImageIcon(im3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        vectorVer.setIcon(Vectorim2);
        vectorVer.setBounds(35,317,30,30);

        boton = new BasicButton() {
            @Override
            public void clickEvent() {
                botonFun();
            }
        };
        boton.setText("Comenzar");
        boton.setLocation(457, 30);
        panel.add(vectorVer);
        panel.add(vectorHor);
        panel.add(carro);
        panel.add(carretera);
        add(panel);
        add(boton);
        setLayout(null);
        setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void botonFun(){
        Thread run = new Thread(new Runnable(){
            @Override
            public void run() {
                if(band && !proceso){
                    proceso = true;
                    ImageIcon im2 = new ImageIcon("src/Imagenes/Vectorder.png");
                    Icon Vectorim = new ImageIcon(im2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                    vectorHor.setIcon(Vectorim);
                    ImageIcon im = new ImageIcon("src/Imagenes/carro2.png");
                    Icon carroIm = new ImageIcon(im.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                    carro.setIcon(carroIm);
                    boton.setText("Regresar");
                    band = !band;
                    for (int i = 0; i <= 600; i++) {
                        try{
                            Thread.sleep(10);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        carro.setLocation(i, 240);
                        vectorHor.setLocation(i+117, 285);
                        vectorVer.setLocation(i+35, 317);
                    }
                    proceso = false;
                }else if(!proceso){
                    proceso = true;
                    boton.setText("Comenzar");
                    ImageIcon im2 = new ImageIcon("src/Imagenes/VectorIzq.png");
                    Icon Vectorim = new ImageIcon(im2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                    vectorHor.setIcon(Vectorim);
                    ImageIcon im = new ImageIcon("src/Imagenes/carro.png");
                    Icon carroIm = new ImageIcon(im.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
                    carro.setIcon(carroIm);
                    band = !band;
                    for (int i = 600; i >= 0; i--) {
                        try{
                            Thread.sleep(10);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        carro.setLocation(i, 240);
                        vectorHor.setLocation(i-47, 285);
                        vectorVer.setLocation(i+35, 317);
                    }
                    proceso = false;
                }
            }
        });
        run.start();
    }
}
