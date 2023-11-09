package PhysicsSrc.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class InfoBar extends JPanel {

    private BufferedImage[] resource = new BufferedImage[2];

    private Jugador jugador;

    private Game g;

    private JLabel vida, puntaje,fps,entityLife;

    private int entityLifeCont = 120;

    private Entity e;

    public InfoBar(Game g){
        setSize(1074, 50);
        setOpaque(false);
        setLayout(null);
        this.g = g;
        jugador = g.getJugador();
        vida = new JLabel("Salud");
        vida.setFont(new Font("Arial", Font.PLAIN, 18));
        vida.setBounds(20,0,100,50);
        vida.setForeground(Color.white);
        puntaje = new JLabel("Score: 0");
        puntaje.setFont(new Font("Arial", Font.PLAIN, 18));
        puntaje.setBounds( 400,0,100,50);
        puntaje.setForeground(Color.white);
        add(puntaje);
        fps = new JLabel("Fps: ");
        fps.setFont(new Font("Arial", Font.PLAIN, 18));
        fps.setBounds(500,0,100,50);
        fps.setForeground(Color.white);
        add(fps);
        entityLife = new JLabel("Entity");
        entityLife.setFont(new Font("Arial", Font.PLAIN, 18));
        entityLife.setBounds(600,0,100,50);
        entityLife.setForeground(Color.white);
        add(entityLife);
        entityLife.setVisible(false);
        chargeVisuals();
        setVisible(true);
    }

    public void chargeVisuals() {
        try {
            resource[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteHeart-0001.png"));
            resource[1] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpritePenCharge-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if(jugador.getCoulDown() == 60) g2d.drawImage(resource[1],250,15,100,20, null);

        for (int i = 0; i < jugador.getSalud(); i++){
            g2d.drawImage(resource[0],80 + i*15,15,20,20, null);
        }

        if(entityLifeCont < 120)
            for (int i = 0; i < e.getSalud(); i++){
                g2d.drawImage(resource[0],660 + i*15,15,20,20, null);
            }
        super.paint(g);
    }

    public JLabel getPuntaje() {
        return puntaje;
    }

    public JLabel getFps() {
        return fps;
    }

    public void setE(Entity e) {
        this.e = e;
        entityLife.setText(e.getClass() == Enemy.class? "Perro:" : "Cañon:");
        entityLife.setVisible(true);
        entityLifeCont = 0;
    }

    public void infoBarUpdate(){
        entityLifeCont++;
        if(entityLifeCont >= 120){
            entityLife.setVisible(false);
        }
    }
}
