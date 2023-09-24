package PhysicsSrc;

import javax.swing.*;
import javax.vecmath.Vector2f;

public class Jugador extends Entity{

    public Jugador() {
    }
    
    public Jugador(JLabel sprite, Vector2f vector, Collider hitBox){
        super(sprite, vector, hitBox);
    }

    @Override
    protected void attack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
