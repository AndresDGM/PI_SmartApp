package PhysicsSrc.Game;

import javax.imageio.ImageIO;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Canon extends Entity{

    private int couldown = 0;

    private int limiteCouldown = 210;

    private final ArrayList<Bullet> bullets = new ArrayList<>();

    public Canon(Vector2f vector, Collider hitBox, Game game) {
        super(vector, hitBox, game);
        setDamage(6);
        setDefense(4);
        setSalud(15);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spriteSheet[0][0], 0, 0, wSprite, hSprite, null);
        if(inRange()) g2d.rotate(getAngle(), 50, 50);
        g2d.drawImage(spriteSheet[1][0], 34, 19, 31, 37, null);
    }

    @Override
    public void chargeVisuals() {
        setSpriteSize(100,100);
        BufferedImage[] sprites = new BufferedImage[2];
        try {
            sprites[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCanon-0001.png"));
            sprites[1] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCanonMouth-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setSpriteSheet(sprites);
    }

    @Override
    public void setSpriteSheet(BufferedImage[] sprite) {
        spriteSheet = new BufferedImage[2][1];
        spriteSheet[0][0] = sprite[0];
        spriteSheet[1][0] = sprite[1];
    }

    @Override
    public void aniAttack() {

    }

    public double getAngle(){
        Vector2f v = new Vector2f(vector.x + 50, vector.y + 50);
        Vector2f v2 = new Vector2f(game.getJugador().vector.x + 50, game.getJugador().vector.y + 50);
        v.sub(v2);
        v2 = new Vector2f(1, 0);
        if(v.y > 0) return v.angle(v2) - Math.PI / 2d;
        else return  -v.angle(v2) - Math.PI / 2d;
    }

    public boolean inRange(){
        Vector2f v = new Vector2f(game.getJugador().vector.x, game.getJugador().vector.y);
        Vector2f v2 = new Vector2f(vector.x, vector.y);
        v.sub(v2);
        return v.lengthSquared() < 122_500;
    }

    @Override
    protected void attack() {
        if (inRange()){
            couldown++;
            if(couldown == limiteCouldown){
                Shoot();
                if(limiteCouldown > 30){
                    limiteCouldown -= 30;
                }
                couldown = 0;
            }
        }else{
            couldown = 0;
            limiteCouldown = 210;
        }
    }

    public Vector2f getVectorBullet(){
        Vector2f v = new Vector2f(vector.x + 50, vector.y + 50);
        Vector2f v2 = new Vector2f(game.getJugador().vector.x + 50, game.getJugador().vector.y + 50);
        Vector2f v3 = new Vector2f(vector.x + 50, vector.y + 50);
        v3.sub(v2);
        v3.normalize();
        int scale = v3.y < -0.5f || v3.x > 0.5f ? 30 : 50;
        v3.scale(scale);
        v.sub(v3);
        return v;
    }

    private void Shoot() {
        Collider hitbox = new Collider(getVectorBullet(), 16, 16, true);
        bullets.add(new Bullet(getVectorBullet(), hitbox, game, this));
        bullets.get(bullets.size()-1).setTheta(getAngle());
        game.add(bullets.get(bullets.size()-1), 0);
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
