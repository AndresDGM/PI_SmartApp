package PhysicsSrc.Game;
//conjunto de imagenes que conforman el mapa
//fase de prueba

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile extends JPanel {

    private Collider hitbox;

    public BufferedImage image = null;



    public Tile(){
        setSize(96,96);
        initImage();
        setOpaque(false);
        setVisible(true);
    }

    public void initImage(){
        try {
            image = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteDirt-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHitbox(Collider hitbox) {
        this.hitbox = hitbox;
    }

    public Collider getHitbox() {
        return hitbox;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image,0, 0, 100, 100, null);
    }
}
