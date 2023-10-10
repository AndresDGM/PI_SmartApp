package PhysicsSrc.Game;

import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Jugador extends Entity{

    private int salud = 10;

    public Jugador(Vector2f vector, Collider hitBox){
        super(vector, hitBox);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage subSprite = sprite.getSubimage((int)spriteScene*32,0,32,32);
        g2d.drawImage(subSprite, 0, 0, wSprite, hSprite, null);
        hitBox.showCollider(g);
    }

    public void perderSalud(){
        if(salud > 0){
            salud--;
        }
        if(salud == 0){
            Game.gameOver();
        }
        System.out.println(salud);
    }

    @Override
    protected void attack() {
    }
    
}
