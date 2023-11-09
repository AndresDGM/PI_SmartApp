package PhysicsSrc.Game;
//fase de prueba

import javax.imageio.ImageIO;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador extends Entity implements MouseListener {

    private ArrayList<Proyectil> proyectiles = new ArrayList<>();

    private int coulDown = 60;

    private int aniAttackCont = 0;

    private int attackSpeed = 60;

    private int score = 0;

    private Vector2f mouseVec;

    public Jugador(Vector2f vector, Collider hitBox, Game game){
        super(vector, hitBox, game);
        selfSpeed = 1.25f;
        salud = 10;
        damage = 5;
        defense = 2;
        game.addMouseListener(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        animated();
        if(attacking){
            aniAttack();
            horizontalDirection = mouseVec.x > vector.x + 50 ? Entity.RIGHT : Entity.LEFT;
            g2d.drawImage(attackSheet[horizontalDirection][spriteScene], 0, 0, wSprite, hSprite, null);
        }
        else g2d.drawImage(spriteSheet[mode][spriteScene], 0, 0, wSprite, hSprite, null);
        //showCollider(g);
    }

    public void showCollider(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.drawRect((int) (hitBox.getVector().x - vector.x), (int) (hitBox.getVector().y - vector.y), (int) hitBox.getW(), (int) hitBox.getH());
    }

    @Override
    public void chargeVisuals(){
        setSpriteSize(100,100);
        BufferedImage[] sprite = new BufferedImage[4];
        BufferedImage[] attack = new BufferedImage[2];
        for (int i = 0; i < 4; i++) {
            try {
                sprite[i] = ImageIO.read(
                        getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCat-000" + (i+1) +".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            attack[0] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCatHit-0001.png"));
            attack[1] = ImageIO.read(
                    getClass().getClassLoader().getResource("PhysicsSrc/Sprites/SpriteCatHit-0002.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setAttackSheet(attack);
        setSpriteSheet(sprite);
    }

    public Vector2f getVectorProyectil(){
        Vector2f v = new Vector2f(vector.x + 50, vector.y + 50);
        Vector2f v2 = new Vector2f(mouseVec.x, mouseVec.y);
        Vector2f v3 = new Vector2f(vector.x + 50, vector.y + 50);
        v3.sub(v2);
        v3.normalize();
        int scale = v3.y < -0.5f || v3.x > 0.5f ? 30 : 50;
        v3.scale(scale);
        v.sub(v3);
        return v;
    }

    private void Shoot() {
        if(coulDown == attackSpeed && aniAttackCont > 56) {
            Collider hitbox = new Collider(getVectorProyectil(), 16, 16, true);
            proyectiles.add(new Proyectil(getVectorProyectil(), hitbox, game));
            proyectiles.get(proyectiles.size() - 1).setTheta(getAngle());
            proyectiles.get(proyectiles.size() - 1).calculateDir(new Vector2f(mouseVec.x, mouseVec.y));
            proyectiles.get(proyectiles.size() - 1).setDamage(damage);
            game.add(proyectiles.get(proyectiles.size() - 1), 0);
            coulDown = 0;
            aniAttackCont = 0;
            attacking = false;
        }
    }

    public double getAngle(){
        Vector2f v = new Vector2f(vector.x + 50, vector.y + 50);
        Vector2f v2 = new Vector2f(mouseVec.x, mouseVec.y);
        v.sub(v2);
        v2 = new Vector2f(1, 0);
        if(v.y > 0) return v.angle(v2) - Math.PI / 2d;
        else return  -v.angle(v2) - Math.PI / 2d;
    }

    protected void move() {
        float bonus = game.getTeclas().shift.presionado ? 2f : 1f;

        if(game.getTeclas().arriba.presionado && vector.y > 0){
            Vector2f v = new Vector2f(0,-1);
            v.scale((float) game.getDeltaTime() * game.getSpeed() * selfSpeed * bonus);
            super.move(v);
            setMode(getHorizontalDirection() == Entity.RIGHT ? Entity.RIGHT_MODE : Entity.LEFT_MODE);
        }
        if(game.getTeclas().abajo.presionado && vector.y + gethSprite() < 760){
            Vector2f v = new Vector2f(0,1);
            v.scale((float) game.getDeltaTime() * game.getSpeed() * selfSpeed * bonus);
            super.move(v);
            setMode(getHorizontalDirection() == Entity.RIGHT ? Entity.RIGHT_MODE : Entity.LEFT_MODE);
        }
        if(game.getTeclas().der.presionado && vector.x + getwSprite() < 1045){
            Vector2f v = new Vector2f(1,0);
            v.scale((float) game.getDeltaTime() * game.getSpeed() * selfSpeed * bonus);
            super.move(v);
            setMode(Entity.RIGHT_MODE);
            setHorizontalDirection(Entity.RIGHT);
        }
        if(game.getTeclas().izq.presionado && vector.x > 0){
            Vector2f v = new Vector2f(-1,0);
            v.scale((float) game.getDeltaTime() * game.getSpeed() * selfSpeed * bonus);
            super.move(v);
            setMode(Entity.LEFT_MODE);
            setHorizontalDirection(Entity.LEFT);
        }

        if(!game.getTeclas().der.presionado && !game.getTeclas().izq.presionado &&
                !game.getTeclas().arriba.presionado && !game.getTeclas().abajo.presionado)
            setMode(getHorizontalDirection() == Entity.RIGHT ? Entity.REPOSE_RIGHT : Entity.REPOSE_LEFT);
    }

    public ArrayList<Proyectil> getProyectiles() {
        return proyectiles;
    }

    @Override
    protected void attack() {
        if(coulDown < attackSpeed) coulDown++;
        if(attacking) aniAttackCont++;
        if(aniAttackCont > 56) Shoot();
    }

    @Override
    public void aniAttack() {
        if(attacking) {
            spriteScene = aniAttackCont/6;
        } else spriteScene = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(coulDown == attackSpeed) attacking = true;
        mouseVec = new Vector2f(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getCoulDown() {
        return coulDown;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
