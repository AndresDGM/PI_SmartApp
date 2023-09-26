package PhysicsSrc;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.vecmath.Vector2f;

public abstract class Entity extends JPanel{
    protected Vector2f vector;

    protected BufferedImage sprite;

    protected int wSprite = 0;

    protected int hSprite = 0;

    protected float spriteScene = 0;

    protected Collider hitBox;

    public Entity() {
    }

    public Entity(Vector2f vector, Collider hitBox) {
        this.vector = vector;
        this.hitBox = hitBox;
        setLocation((int) vector.x, (int) vector.y);
        setLayout(null);
        setOpaque(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage subSprite = sprite.getSubimage((int)spriteScene*32,0,32,32);
        g2d.drawImage(subSprite, 0, 0, wSprite, hSprite, null);
        if(spriteScene < 9){
            spriteScene+=1;
        }else{
            spriteScene = 0;
        }
        super.paint(g);
    }

    protected void move(Vector2f v){
        vector.add(v);
        setLocation((int) vector.x, (int) vector.y);
        repaint();
    }
    
    protected abstract void attack();

    public Vector2f getVector() {
        return vector;
    }

    public void setVector(Vector2f vector) {
        this.vector = vector;
    }

    public Collider getHitBox() {
        return hitBox;
    }

    public void setHitBox(Collider hitBox) {
        this.hitBox = hitBox;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getwSprite() {
        return wSprite;
    }

    public int gethSprite() {
        return hSprite;
    }

    public void setSpriteSize(int wSprite, int hSprite){
        this.wSprite = wSprite;
        this.hSprite = hSprite;
        setSize(wSprite,hSprite);
    }

    public float getSpriteScene() {
        return spriteScene;
    }

    public void setSpriteScene(int spriteScene) {
        this.spriteScene = spriteScene;
    }
}
