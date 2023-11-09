package PhysicsSrc.Game;
//balas para los cañones Proximamente
//fase de prueba

import javax.imageio.ImageIO;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author david
 */
public class Bullet extends Entity {

    protected double theta = 0;

    protected Vector2f dir = new Vector2f(0, 0);

    private Canon canon;

    public Bullet(Vector2f vector, Collider hitBox, Game game, Canon canon) {
        super(vector, hitBox, game);
        this.canon = canon;
        selfSpeed = 6f;
        calculateDir();
        posToCenter();
    }

    public Bullet(Vector2f vector, Collider hitBox, Game game) {
        super(vector, hitBox, game);
        posToCenter();
    }

    public void posToCenter(){
        int x = dir.y < -0.5 || dir.y > 0.5?(int) vector.x - 12 : (int) vector.x;
        int y = dir.x < -0.5 || dir.x > 0.5?(int) vector.y - 12 : (int) vector.y;
        setVector(new Vector2f(x, y));
        hitBox.setVector(new Vector2f(x, y));
        setLocation(x, y);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(theta,15,15);
        g2d.drawImage(spriteSheet[0][0], 5, 4, wSprite - 11, hSprite - 7, null);
    }

    @Override
    public void chargeVisuals() {
        setSpriteSize(31, 31);
        BufferedImage[] sprites = new BufferedImage[1];
        try {
            sprites[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteBullet-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSpriteSheet(sprites);
    }

    @Override
    public void setSpriteSheet(BufferedImage[] sprite) {
        spriteSheet = new BufferedImage[1][1];
        spriteSheet[0][0] = sprite[0];
    }

    @Override
    public void aniAttack() {

    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void calculateDir(Vector2f v){
        dir = new Vector2f(v.x, v.y);
        dir.sub(vector);
        dir.normalize();
    }

    public void calculateDir(){
        dir = new Vector2f(game.getJugador().vector.x + 50, game.getJugador().vector.y + 50);
        dir.sub(vector);
        dir.normalize();
    }

    public void move() {
        Vector2f v = new Vector2f(dir.x, dir.y);
        v.scale((float) game.getDeltaTime() * game.getSpeed() * selfSpeed);
        move(v);
        inMap();
    }

    public Vector2f getDir() {
        return dir;
    }

    @Override
    protected void attack() {
        game.getJugador().receiveDamage(canon.damage);
        canon.getBullets().remove(this);
        game.remove(this);
    }

    public void inMap() {
        if (vector.x + wSprite < 0 || vector.x > game.getMapa().getWidth()
                || vector.y + hSprite < 0 || vector.y > game.getMapa().getHeight()) {
            canon.getBullets().remove(this);
            game.remove(this);
        }
    }
}
