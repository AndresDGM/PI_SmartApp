package PhysicsSrc.Game;
//codigo en construccion del juego en el que aplicaran los vectores

import AppMainSrc.BasicButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.vecmath.Vector2f;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel implements Runnable{

    private double deltaTime = 0;

    private final int fpsLimit = 60;

    private int fps = 0;

    private final float speed = 40;
    
    private static Jugador jugador;
    
    private Enemy enemigos;
    
    private Map mapa = new Map();

    private static boolean gameRun = true;

    private Keylisten teclas = new Keylisten(this);

    private BasicButton boton;

    public Game(){
        Vector2f vector = new Vector2f(200,200);
        Vector2f vector2 = new Vector2f(0,0);
        Vector2f vectorCol2 = new Vector2f(16,19);
        Vector2f vectorCol = new Vector2f(225,216);
        //Collider hitBox = new Collider(vectorCol, 42, 44, true);
        Collider hitBox = new Collider(vectorCol, 59, 68, false);
        Collider hitBox2 = new Collider(vectorCol2, 53, 69, false);
        jugador = new Jugador(vector, hitBox);
        enemigos = new Enemy(vector2, hitBox2);
        boton = new BasicButton() {
            @Override
            public void clickEvent() {
                salir();
            }
        };
        boton.setLocation(457, 10);
        setSize(1074, 800);
        setFocusable(true);
        importImgSrc();
        setLayout(null);
        add(jugador);
        add(enemigos);
        add(mapa);
        setVisible(true);
    }
    
    public void importImgSrc(){
        jugador.setSpriteSize(100,100);
        enemigos.setSpriteSize(100, 100);
        BufferedImage sprite = null;
        BufferedImage sprite2 = null;
        try {
            sprite = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCat-0001.png"));
            sprite2 = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/ProfeSprite-0001.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jugador.setSpriteSheet(sprite);
        enemigos.setSpriteSheet(sprite2);
    }
    public void gameUpdate(){
        getCollitions();
        moverJugador();
        moverEnemigos();
        render();
    }

    public void moverJugador(){
        if(teclas.arriba.presionado){
            Vector2f v = new Vector2f(0,-1);
            v.scale((float) deltaTime * speed);
            jugador.move(v);
        }
        if(teclas.abajo.presionado){
            Vector2f v = new Vector2f(0,1);
            v.scale((float) deltaTime * speed);
            jugador.move(v);
        }
        if(teclas.der.presionado){
            Vector2f v = new Vector2f(1,0);
            v.scale((float) deltaTime * speed);
            jugador.move(v);
        }
        if(teclas.izq.presionado){
            Vector2f v = new Vector2f(-1,0);
            v.scale((float) deltaTime * speed);
            jugador.move(v);
        }
    }

    public void moverEnemigos(){
        Vector2f v = new Vector2f(jugador.vector.x, jugador.vector.y);
        Vector2f v2 = new Vector2f(enemigos.vector.x, enemigos.vector.y);
        v.sub(v2);
        v.normalize();
        v.scale((float) deltaTime * speed * 0.5f);
        enemigos.move(v);
    }

    public void render(){
        jugador.repaint();
        enemigos.repaint();
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static void gameOver(){
        gameRun = false;
        JOptionPane.showMessageDialog(null, "Game over");
    }

    public void getCollitions(){
        boolean b = enemigos.hitBox.Collition(jugador.hitBox);
        if(b) {
            enemigos.attack();
        }
    }

    public synchronized void star(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nanoFps = 1000000000d/fpsLimit;

        long lastCheck = System.currentTimeMillis();

        while(gameRun){
            long now = System.nanoTime();
            if(now - lastTime >= nanoFps){
                gameUpdate();
                lastTime = now;
                fps++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                deltaTime = (double) 1/fps;
                System.out.println(fps);
                fps = 0;
            }
        }
    }

    public void salir() {
        if (gameRun){
            gameRun = false;
            setDefault();
            boton.setText("Comenzar");
        }else{
            gameRun = true;
            star();
            boton.setText("Detener");
        }
    }

    public void setDefault(){
        Vector2f vector = new Vector2f(200,200);
        Vector2f vector2 = new Vector2f(0,0);
        //Vector2f vectorCol = new Vector2f(216,210);
        Vector2f vectorCol = new Vector2f(225,216);
        //Collider hitBox = new Collider(vectorCol, 42, 44, true);
        Collider hitBox = new Collider(vectorCol, 59, 68, false);
        Collider hitBox2 = new Collider(vector2, 100, 100, false);
        jugador = new Jugador(vector, hitBox);
        enemigos = new Enemy(vector2, hitBox2);
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
