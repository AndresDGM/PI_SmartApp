package PhysicsSrc.Game;
//fase de prueba

import javax.vecmath.Vector2f;
import java.awt.*;

public class Enemy extends Entity{

    public Enemy(Vector2f vector, Collider hitBox) {
        super(vector, hitBox);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        animated();
        g2d.drawImage(spriteSheet[spriteScene], 0, 0, wSprite, hSprite, null);
        showCollider(g);
    }

    public void showCollider(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect((int) (hitBox.getVector().x - vector.x), (int) (hitBox.getVector().y - vector.y), (int) hitBox.getW(), (int) hitBox.getH());
    }

    @Override
    protected void attack() {
            Game.getJugador().perderSalud();
    }
}
