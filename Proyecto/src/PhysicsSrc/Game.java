package PhysicsSrc;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.vecmath.Vector2f;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel implements Runnable{

    private double deltaTime = 0;

    private final int fpsLimit = 60;
    
    private Jugador jugador;
    
    private Enemy[] enemigos;
    
    private Map mapa = new Map();

    private boolean gameRun = false;

    private Keylisten teclas = new Keylisten(this);

    public Game(){
        Vector2f vector = new Vector2f(0,0);
        Collider hitBox = new Collider(vector, 100, 100, true);
        jugador = new Jugador(vector, hitBox);
        setSize(1074, 800);
        setFocusable(true);
        importImgSrc();
        setLayout(null);
        add(jugador);
        add(mapa);
        setVisible(true);
    }
    
    public void importImgSrc(){
        jugador.setSpriteSize(100,100);
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCat-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        };
        jugador.setSprite(sprite);
    }
    public void gameLoop(){
        moverJugador();
    }

    public void moverJugador(){
        if(teclas.arriba.presionado){
            jugador.move(new Vector2f(0,-1));
        }
        if(teclas.abajo.presionado){
            jugador.move(new Vector2f(0,1));
        }
        if(teclas.der.presionado){
            jugador.move(new Vector2f(1,0));
        }
        if(teclas.izq.presionado){
            jugador.move(new Vector2f(-1,0));
        }
    }
    
    public void getCollitions(){
        
    }

    public synchronized void star(){
        gameRun = true;
        new Thread(this).start();
    }

    public synchronized void stop(){
        gameRun = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nanoFps = 1000000000d/fpsLimit;

        int ticks = 0;
        int fps = 0;

        long lastCheck = System.currentTimeMillis();
        double delta = 0;

        while(gameRun){
            long now = System.nanoTime();
            if(now - lastTime >= nanoFps){
                jugador.repaint();
                gameLoop();
                lastTime = now;
            }
        }
    }

    public static void main(String[] args) {
        JFrame ven = new JFrame();
        Game g = new Game();
        ven.setSize(1074,800);
        ven.setLayout(null);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.setVisible(true);
        g.star();
        ven.add(g);
        ven.setVisible(true);
    }
}
