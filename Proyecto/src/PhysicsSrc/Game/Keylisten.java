package PhysicsSrc.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keylisten implements KeyListener {

    public Keylisten(Game g){
        g.addKeyListener(this);
    }

    public Key arriba = new Key();
    public Key abajo = new Key();
    public Key izq = new Key();
    public Key der = new Key();

    public class Key{
        public boolean presionado = false;

        public void isPressed(boolean presionado){
            this.presionado = presionado;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        isKeyPressed(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isKeyPressed(e.getKeyCode(), false);
    }

    public void isKeyPressed(int keyCode, boolean pressed){
        if (keyCode == KeyEvent.VK_A){
            izq.isPressed(pressed);
        }
        if (keyCode == KeyEvent.VK_D){
            der.isPressed(pressed);
        }
        if (keyCode == KeyEvent.VK_W){
            arriba.isPressed(pressed);
        }
        if (keyCode == KeyEvent.VK_S){
            abajo.isPressed(pressed);
        }
    }
}
