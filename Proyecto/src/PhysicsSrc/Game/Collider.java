package PhysicsSrc.Game;

import javax.vecmath.Vector2f;
import java.awt.*;

public class Collider extends Rectangle {

    private Vector2f vector;

    private float w;

    private float h;

    private boolean solid;

    
    public Collider(Vector2f vector, int w, int h, boolean solid){
        super((int) vector.x,(int) vector.y, w, h);
        this.vector = vector;
        this.w = w;
        this.h = h;
        this.solid = solid;
    }
    
    public boolean Collition(Collider c){
        return (vector.x < c.vector.x + c.w &&  vector.x + w > c.vector.x &&
                vector.y < c.vector.y + c.h && vector.y + h < c.vector.y);
    }

    public Vector2f getVector() {
        return vector;
    }

    public void setVector(Vector2f vector) {
        this.vector = vector;
    }

    public float getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public float getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
}
