package PhysicsSrc.Game;

import javax.vecmath.Vector2f;
import java.awt.*;

public class Enemy extends Entity{

    public Enemy(Vector2f vector, Collider hitBox) {
        super(vector, hitBox);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setBackground(Color.BLUE);
    }

    @Override
    protected void attack() {
            Game.getJugador().perderSalud();
    }
}
