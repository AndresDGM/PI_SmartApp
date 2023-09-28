package PhysicsSrc;

import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador extends Entity{

    public Jugador(Vector2f vector, Collider hitBox){
        super(vector, hitBox);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage subSprite = sprite.getSubimage((int)spriteScene*32,0,32,32);
        g2d.drawImage(subSprite, 0, 0, wSprite, hSprite, null);
        if(spriteScene < 9){
            spriteScene++;
        }else{
            spriteScene = 0;
        }
    }

    @Override
    protected void attack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
