package PhysicsSrc;

import javax.swing.*;
import javax.vecmath.Vector2f;

public class Jugador extends Entity{

    public Jugador() {
    }
    
    public Jugador(Vector2f vector, Collider hitBox){
        super(vector, hitBox);
    }

    @Override
    protected void attack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
