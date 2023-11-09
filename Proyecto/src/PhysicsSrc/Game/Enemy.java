package PhysicsSrc.Game;
//fase de prueba

import javax.imageio.ImageIO;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy extends Entity{

    private int couldown = 0;

    public Enemy(Vector2f vector, Collider hitBox, Game game) {
        super(vector, hitBox, game);
        selfSpeed = 1f;
        setSalud(10);
        setDamage(4);
        setDefense(3);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        animated();
        if(inRange()){
            aniAttack();
            g2d.drawImage(attackSheet[horizontalDirection][spriteScene], 0, 0, wSprite, hSprite, null);
        } else g2d.drawImage(spriteSheet[mode][spriteScene], 0, 0, wSprite, hSprite, null);
        //showCollider(g);
    }

    public void showCollider(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect((int) (hitBox.getVector().x - vector.x), (int) (hitBox.getVector().y - vector.y), (int) hitBox.getW(), (int) hitBox.getH());
    }

    @Override
    public void chargeVisuals(){
        setSpriteSize(100, 100);
        BufferedImage[] sprite = new BufferedImage[4];
        BufferedImage[] attack = new BufferedImage[2];
        for (int i = 0; i < 4; i++) {
            try {
                sprite[i] = ImageIO.read(
                        getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteDog-000" + (i+1) +".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            attack[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteDogHit-0001.png"));
            attack[1] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteDogHit-0002.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setAttackSheet(attack);
        setSpriteSheet(sprite);
    }

    public boolean inRange(){
        Vector2f v = new Vector2f(game.getJugador().vector.x, game.getJugador().vector.y);
        Vector2f v2 = new Vector2f(vector.x, vector.y);
        v.sub(v2);
        return v.lengthSquared() < 8100;
    }

    public void move(){
        Vector2f v = new Vector2f(game.getJugador().vector.x + 50, game.getJugador().vector.y + 50);
        Vector2f v2 = new Vector2f(vector.x + 50, vector.y + 50);
        v.sub(v2);
        if(v.lengthSquared() < 90_000 && !inRange()) {
            v.normalize();
            if(v.x > 0){
                setMode(Entity.LEFT_MODE);
                setHorizontalDirection(Entity.LEFT);
            } else if(v.x < 0) {
                setMode(Entity.RIGHT_MODE);
                setHorizontalDirection(Entity.RIGHT);
            }
            v.scale((float) game.getDeltaTime() * game.getSpeed());
            move(v);
        }else {
            setMode(getHorizontalDirection() == Entity.RIGHT ? Entity.REPOSE_RIGHT : Entity.REPOSE_LEFT);
        }
    }

    @Override
    protected void attack() {
        if (inRange()){
            attacking = true;
            couldown++;
            if(couldown == 120){
                game.getJugador().receiveDamage(damage);
                couldown = 0;
            }
        }else{
            couldown = 0;
            attacking = false;
        }
    }

    @Override
    public void aniAttack() {
        if(couldown <= 21) spriteScene = couldown/7;
        else spriteScene = 0;
    }
}
