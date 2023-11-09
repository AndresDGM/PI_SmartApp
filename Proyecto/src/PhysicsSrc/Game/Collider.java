package PhysicsSrc.Game;
//area de accion para que las entidades puedan interatuar 
//fase de prueba

import javax.vecmath.Vector2f;

public class Collider {

    private Vector2f vector;

    private float w;

    private float h;

    private boolean solid;

    
    public Collider(Vector2f vector, int w, int h, boolean solid){
        this.vector = vector;
        this.w = w;
        this.h = h;
        this.solid = solid;
    }
    
    public boolean Collition(Collider c){
        if (w<= 0 || h <= 0|| c.w <= 0 || c.h <= 0) {
            return false;
        }
        return (c.vector.x + c.w >= vector.x &&
                c.vector.y + c.h >= vector.y &&
                c.vector.x <= vector.x + w &&
                c.vector.y <= vector.y + h);
    }

    public boolean contains(Vector2f v){
        return (v.x >= vector.x &&
                v.y >= vector.y &&
                v.x < vector.x + w &&
                v.y < vector.y + h);
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
