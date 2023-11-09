package PhysicsSrc.Game;

import javax.imageio.ImageIO;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Proyectil extends Bullet{

    Jugador jugador;

    public Proyectil(Vector2f vector, Collider hitBox, Game game, Canon canon) {
        super(vector, hitBox, game, canon);
    }

    public Proyectil(Vector2f vector, Collider hitBox, Game game) {
        super(vector, hitBox, game);
        jugador = game.getJugador();
        selfSpeed = 4f;
    }

    @Override
    public void chargeVisuals() {
        setSpriteSize(31, 31);
        BufferedImage[] sprites = new BufferedImage[1];
        try {
            sprites[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpritePen-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSpriteSheet(sprites);
    }

    public void inRange(){
        Vector2f v = new Vector2f(jugador.vector.x + 50,jugador.vector.y + 50);
        v.sub(vector);
        if(v.lengthSquared() > 40_000){
            jugador.getProyectiles().remove(this);
            game.remove(this);
        };
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(theta,15,15);
        g2d.drawImage(spriteSheet[0][0], 12, 4, wSprite - 24, hSprite - 7, null);
    }

    @Override
    public void move() {
        super.move();
        inRange();
    }

    @Override
    public void inMap() {
        if (vector.x + wSprite < 0 || vector.x > game.getMapa().getWidth()
                || vector.y + hSprite < 0 || vector.y > game.getMapa().getHeight()) {
            jugador.getProyectiles().remove(this);
            game.remove(this);
        }
    }

    protected void attack(Entity e) {
        e.receiveDamage(jugador.damage);
        jugador.getProyectiles().remove(this);
        game.remove(this);
    }
}
