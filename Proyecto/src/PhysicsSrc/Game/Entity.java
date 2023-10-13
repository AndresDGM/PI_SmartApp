package PhysicsSrc.Game;
//clase padre de las entidades (Jugador, enemigos, estructuras...)
//fase de prueba

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.vecmath.Vector2f;

public abstract class Entity extends JPanel{
    protected Vector2f vector;

    protected BufferedImage[] spriteSheet;

    protected int wSprite = 0;

    protected int hSprite = 0;

    protected int spriteScene = 0;

    protected int animationSpeed = 6;

    protected int animationCont = 0;

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
        render(g);
        super.paint(g);
    }

    protected void move(Vector2f v){
        vector.add(v);
        hitBox.getVector().add(v);
        setLocation((int) vector.x, (int) vector.y);
    }

    public abstract void render(Graphics g);
    
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

    public BufferedImage[] getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(BufferedImage sprite) {
        int cantScenes = sprite.getWidth()/32;
        System.out.println(cantScenes);
        spriteSheet = new BufferedImage[cantScenes];
        for (int i = 0; i < cantScenes; i++) {
            spriteSheet[i] = sprite.getSubimage(i*32, 0, 32, 32);
        }
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

    public int getSpriteScene() {
        return spriteScene;
    }

    public void setSpriteScene(int spriteScene) {
        this.spriteScene = spriteScene;
    }

    public void animated(){
        animationCont++;
        if (animationCont == animationSpeed){
            if(spriteScene < spriteSheet.length-1) spriteScene++;
            else spriteScene = 0;
            animationCont = 0;
        }
    }
}
