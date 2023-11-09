package PhysicsSrc.Game;
//clase padre de las entidades (Jugador, enemigos, estructuras...)
//fase de prueba

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.vecmath.Vector2f;

public abstract class Entity extends JPanel{
    protected Vector2f vector;

    Game game;

    protected boolean attacking = false;

    protected boolean alive = true;

    protected BufferedImage[][] spriteSheet;

    protected BufferedImage[][] attackSheet;

    protected int wSprite = 0;

    protected int hSprite = 0;

    protected int spriteScene = 0;

    protected int animationSpeed = 6;

    protected int animationCont = 0;

    protected int salud = 10;

    protected int damage = 0;

    protected int defense = 0;

    protected float selfSpeed;

    public static final int REPOSE_RIGHT = 0;

    public static final int RIGHT_MODE = 1;

    public static final int LEFT_MODE = 2;

    public static final int REPOSE_LEFT = 3;

    public static final int RIGHT = 0;

    public static final int LEFT = 1;

    protected int mode = REPOSE_RIGHT;

    protected int horizontalDirection = RIGHT;

    protected Collider hitBox;

    public Entity() {
    }

    public Entity(Vector2f vector, Collider hitBox, Game game) {
        this.vector = vector;
        this.hitBox = hitBox;
        this.game = game;
        setLocation((int) vector.x, (int) vector.y);
        chargeVisuals();
        setLayout(null);
        setOpaque(false);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        render(g);
        super.paint(g);
    }

    protected void move(Vector2f v){
        vector.add(v);
        hitBox.getVector().add(v);
        setLocation((int) vector.x, (int) vector.y);
    }

    public abstract void render(Graphics g);

    public abstract void chargeVisuals();
    
    protected abstract void attack();

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

    public BufferedImage[][] getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(BufferedImage[] sprite) {
        int cantScenes = sprite[0].getWidth()/32;
        int n = sprite.length;
        spriteSheet = new BufferedImage[n][cantScenes];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cantScenes; j++) {
                spriteSheet[i][j] = sprite[i].getSubimage(j*32, 0, 32, 32);
            }
        }
    }

    public void setAttackSheet(BufferedImage[] sprite) {
        int cantScenes = sprite[0].getWidth()/32;
        int n = sprite.length;
        attackSheet = new BufferedImage[n][cantScenes];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cantScenes; j++) {
                attackSheet[i][j] = sprite[i].getSubimage(j*32, 0, 32, 32);
            }
        }
    }

    public int getwSprite() {
        return wSprite;
    }

    public int gethSprite() {
        return hSprite;
    }

    public void setSpriteSize(int wSprite, int hSprite){
        this.wSprite = wSprite;
        this.hSprite = hSprite;
        setSize(wSprite,hSprite);
    }

    public int getSpriteScene() {
        return spriteScene;
    }

    public void setSpriteScene(int spriteScene) {
        this.spriteScene = spriteScene;
    }

    public void animated(){
        animationCont++;
        if (animationCont == animationSpeed){
            if(spriteScene < spriteSheet[0].length-1) spriteScene++;
            else spriteScene = 0;
            animationCont = 0;
        }
    }

    public abstract void aniAttack();
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getHorizontalDirection() {
        return horizontalDirection;
    }

    public void setHorizontalDirection(int horizontalDirection) {
        this.horizontalDirection = horizontalDirection;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public void receiveDamage(int damage){
        salud -= (damage - defense);
        alive = salud > 0;
        if(!alive && getClass() == Jugador.class){
            game.gameOver();
        } else if (!alive) {
            if(getClass() == Enemy.class) game.getEnemigos().remove(this);
            if(getClass() == Canon.class){
                Canon c = game.getCanons().get(game.getCanons().indexOf(this));
                for (int i = 0; i <c.getBullets().size(); i++) {
                    game.remove(c.getBullets().get(i));
                }
                game.getCanons().remove(this);
            }
            game.getJugador().setScore(game.getJugador().getScore() + (getClass() == Enemy.class ? 10: 15));
            game.getInfoBar().getPuntaje().setText("Score: " + game.getJugador().getScore());
            game.remove(this);
        }
        if(getClass() != Jugador.class) game.getInfoBar().setE(this);
        game.getInfoBar().repaint();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    /**
     *
     * @param vec
     * @param e
     * @return 0 si la entidad se puede mover, 1 si se puede
     * mover en x, 2 si se puede mover en y, 3 en caso de no poder moverse.
     */
    public int canMove(Vector2f vec, Entity e){
        if(hitBox.contains(vec)){
            if(!e.hitBox.contains(new Vector2f(vec.x,0))){
                return 1;
            }
            if(!e.hitBox.contains(new Vector2f(0,vec.y))){
                return 2;
            }
            return 3;
        }
        return 0;
    }

    public void setSelfSpeed(float selfSpeed) {
        this.selfSpeed = selfSpeed;
    }

    public float getSelfSpeed() {
        return selfSpeed;
    }
}
