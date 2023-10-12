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
        animated();
        g2d.drawImage(spriteSheet[spriteScene], 0, 0, wSprite, hSprite, null);
        showCollider(g);
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

    public void showCollider(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect((int) (hitBox.getVector().x - vector.x), (int) (hitBox.getVector().y - vector.y), (int) hitBox.getW(), (int) hitBox.getH());
    }

    @Override
    protected void attack() {
    }
    
}