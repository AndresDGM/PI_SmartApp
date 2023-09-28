package PhysicsSrc;

import javax.vecmath.Vector2f;

public class Collider {
    
    private Vector2f vector;

    private int w = 0;
    
    private int h = 0;
    
    private boolean solid = false;

    
    public Collider(Vector2f vector, int w, int h, boolean solid){
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
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
