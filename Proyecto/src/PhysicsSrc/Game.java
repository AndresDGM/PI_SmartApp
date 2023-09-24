package PhysicsSrc;

import javax.swing.*;

import javax.vecmath.Vector2f;
import java.awt.*;

public class Game extends JPanel{
    
    private Jugador jugador;
    
    private Enemy[] enemigos;
    
    private Map mapa = new Map();
    
    public Game(){
        Vector2f vector = new Vector2f(0,0);
        Collider hitBox = new Collider(vector, 100, 100, true);
        jugador = new Jugador(new JLabel(), vector, hitBox);
        setSize(1074, 800);
        renderAll();
        setLayout(null);
        add(jugador);
        add(mapa);
        setVisible(true);
    }
    
    public void renderAll(){
        jugador.render("src/PhysicsSrc/Sprites/SpriteCat-0001.png");
    }
    
    public void gameLoop(){
        
    }
    
    public void deltaTime(){
        
    }
    
    public void getCollitions(){
        
    }
    
    public void getFps(){
        
    }

    public static void main(String[] args) {
        JFrame ven = new JFrame();
        Game g = new Game();
        ven.setSize(1074,800);
        ven.setLayout(null);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setVisible(true);
        ven.add(g);
        ven.setVisible(true);
    }
}
