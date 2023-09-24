package PhysicsSrc;

import java.awt.Image;
import javax.swing.*;
import javax.vecmath.Vector2f;

public abstract class Entity extends JPanel{
    
    protected JLabel sprite;
    
    protected Vector2f vector;
    
    protected Collider hitBox;

    public Entity() {
        setSize(100,100);
    }

    public Entity(JLabel sprite, Vector2f vector, Collider hitBox) {
        setSize(100,100);
        this.sprite = sprite;
        this.vector = vector;
        this.hitBox = hitBox;
        setLocation((int) vector.x, (int) vector.y);
        setLayout(null);
        setOpaque(false);
        sprite.setBounds(this.getBounds());
        add(sprite);
        setVisible(true);
    }
    
    protected void move(Vector2f v){
        vector.add(v);
    }
    
    protected abstract void attack();
    
    protected void render(String source){

        ImageIcon spriteImage = new ImageIcon(source);
        int a = getHeight()/spriteImage.getIconHeight();
        Icon icon = new ImageIcon(spriteImage.getImage().getScaledInstance
                (spriteImage.getIconWidth()*a,spriteImage.getIconHeight()*a,Image.SCALE_DEFAULT));
        sprite.setIcon(icon);
    }

    public JLabel getSprite() {
        return sprite;
    }

    public void setSprite(JLabel sprite) {
        this.sprite = sprite;
    }

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
}
