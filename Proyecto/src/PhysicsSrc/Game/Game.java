package PhysicsSrc.Game;
//codigo en construccion del juego en el que aplicaran los vectores
//fase de prueba

import java.awt.Color;
import javax.swing.*;
import javax.vecmath.Vector2f;
import java.util.ArrayList;

public class Game extends JPanel implements Runnable{

    private double deltaTime = 0;

    private final int fpsLimit = 60;

    private int fps = 0;

    private final float speed = 40;

    private Thread hilo;

    private GameMenu menu;

    private Jugador jugador;
    
    private ArrayList<Enemy> enemigos = new ArrayList<>();

    private ArrayList<Canon> canons = new ArrayList<>();
    
    private final Map mapa = new Map();

    private boolean gameRun = true, gamePause = false;

    private int[][] enemyPos = {{0,0}, {400,200}, {700,570}, {500,570},{500,100}};

    private int[][] canonsPos = {{382,572}, {572,97}, {762,382}};

    private final Keylisten teclas = new Keylisten(this);

    private InfoBar infoBar;

    public Game(){
        Vector2f vector = new Vector2f(200,200);
        Vector2f vectorCol = new Vector2f(225,216);
        Collider hitBox = new Collider(vectorCol, 59, 68, false);
        hilo = new Thread(this);
        menu = new GameMenu(this);
        add(menu);
        jugador = new Jugador(vector, hitBox, this);
        infoBar = new InfoBar(this);
        setSize(1074, 800);
        setFocusable(true);
        setBackground(new Color(46,46,46));
        setLayout(null);
        add(infoBar);
        add(jugador);
        add(mapa);
        initEnemigos();
        initCanons();
        addKeyListener(teclas);
        addMouseListener(jugador);
        setVisible(true);
    }

    public void initCanons(){
        for (int i = 0; i < canonsPos.length; i++) {
            Vector2f v = new Vector2f(canonsPos[i][0],canonsPos[i][1]);
            Vector2f vc = new Vector2f(canonsPos[i][0],canonsPos[i][1]);
            Collider c = new Collider(vc,100, 100, false);
            canons.add(new Canon(v, c, this));
            add(canons.get(i), getComponentZOrder(mapa));
        }
    }

    public void removeCanons(){
        for (Canon c: canons){
            for (Bullet b: c.getBullets()) {
                remove(b);
            }
            c.getBullets().clear();
            remove(c);
        }
        canons.clear();
    }

    public void initEnemigos(){
        for (int i = 0; i < enemyPos.length; i++) {
            Vector2f v = new Vector2f(enemyPos[i][0],enemyPos[i][1]);
            Vector2f vc = new Vector2f(enemyPos[i][0] + 16, enemyPos[i][1] + 19);
            Collider c = new Collider(vc,65, 69, false);
            enemigos.add(new Enemy(v, c, this));
            add(enemigos.get(i), getComponentZOrder(mapa));
        }
    }

    public void removeEnemys(){
        for (Enemy e: enemigos) remove(e);
        enemigos.clear();
    }

    public void gameUpdate(){
        jugador.attack();
        getCollitions();
        moverJugador();
        moverEnemigos();
        moverBalas();
        infoBar.infoBarUpdate();
        checkWin();
        render();
    }

    public void moverJugador(){
        jugador.move();
    }

    public void moverEnemigos(){
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).move();
        }
    }

    public void moverBalas(){

        for (int i = 0; i < canons.size() ; i++) {
            for (int j = 0; j < canons.get(i).getBullets().size(); j++) {
                canons.get(i).getBullets().get(j).move();
            }
        }

        for (int i = 0; i < jugador.getProyectiles().size(); i++) {
            jugador.getProyectiles().get(i).move();
        }
    }

    public void render(){
        jugador.repaint();
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).repaint();
        }

        for (int i = 0; i < canons.size(); i++) {
            canons.get(i).repaint();
        }
        repaint();
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void gameOver(){
        menu.gameOverMode();
    }

    public void getCollitions(){

        for (int i = 0; i < canons.size(); i++) {
            canons.get(i).attack();
        }

        for (int i = jugador.getProyectiles().size() - 1; i >= 0; i--) {

            for (int j = 0; j < enemigos.size(); j++) {
                if(jugador.getProyectiles().size() > 0) {
                    if (jugador.getProyectiles().get(i).hitBox.Collition(enemigos.get(j).getHitBox())){
                        jugador.getProyectiles().get(i).attack(enemigos.get(j));
                        i = jugador.getProyectiles().size() - 1;
                    }
                }
            }

            for (int j = 0; j < canons.size(); j++) {
                if(jugador.getProyectiles().size() > 0){
                    if(jugador.getProyectiles().get(i).hitBox.Collition(canons.get(j).hitBox)) {
                        jugador.getProyectiles().get(i).attack(canons.get(j));
                        i = jugador.getProyectiles().size() - 1;
                    }
                }
            }
        }

        for (int i = 0; i < enemigos.size(); i++)
            enemigos.get(i).attack();

        for (int i = 0; i < canons.size(); i++) {
            for (int j = 0; j < canons.get(i).getBullets().size(); j++) {
                if(canons.get(i).getBullets().get(j).hitBox.Collition(jugador.hitBox))
                    canons.get(i).getBullets().get(j).attack();
            }
        }
    }

    public synchronized void star(){
        hilo.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nanoFps = 1000000000d/fpsLimit;

        long lastCheck = System.currentTimeMillis();

        while(gameRun){
            if(teclas.esc.presionado) menu.pauseGame();
            long now = System.nanoTime();
            if(now - lastTime >= nanoFps && !gamePause){
                gameUpdate();
                lastTime = now;
                fps++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000 && !gamePause){
                lastCheck = System.currentTimeMillis();
                deltaTime = (double) 1/fps;
                infoBar.getFps().setText("Fps: " + fps);
                fps = 0;
            }
        }
    }

    public void checkWin(){
        if(enemigos.size() == 0 && canons.size() == 0) menu.winMode();
    }

    public void setDefault(){
        removeEnemys();
        removeCanons();
        Vector2f vector = new Vector2f(200,200);
        Vector2f vectorCol = new Vector2f(225,216);
        Collider hitBox = new Collider(vectorCol, 59, 68, false);
        jugador.setVector(vector);
        jugador.setLocation((int) vector.x, (int) vector.y);
        jugador.setHitBox(hitBox);
        jugador.setSalud(10);
        jugador.setScore(0);
        initEnemigos();
        initCanons();
        render();
    }

    public Map getMapa() {
        return mapa;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(double deltaTime) {
        this.deltaTime = deltaTime;
    }

    public int getFpsLimit() {
        return fpsLimit;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public float getSpeed() {
        return speed;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Enemy> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(ArrayList<Enemy> enemigos) {
        this.enemigos = enemigos;
    }

    public ArrayList<Canon> getCanons() {
        return canons;
    }

    public void setCanon(ArrayList<Canon> canons) {
        this.canons = canons;
    }

    public boolean isGameRun() {
        return gameRun;
    }

    public void setGameRun(boolean gameRun) {
        this.gameRun = gameRun;
    }

    public Keylisten getTeclas() {
        return teclas;
    }

    public InfoBar getInfoBar() {
        return infoBar;
    }

    public void setGamePause(boolean gamePause) {
        this.gamePause = gamePause;
    }

    public boolean isGamePause() {
        return gamePause;
    }

    public GameMenu getMenu() {
        return menu;
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
        g.setGamePause(false);
        ven.setVisible(true);
    }
}
