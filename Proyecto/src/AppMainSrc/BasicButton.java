/*Boton con bordes redondeados para proposito general
se hizo a la clase abstracto para definir al momento de
instanciar que va a hacer el boton
 */

package AppMainSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BasicButton extends JPanel {

    private boolean clicked = false;

    private JLabel text = new JLabel("");

    private Color color = new Color(77, 77, 77);

    private int arcW = 10;//redondeo horizontal

    private int arcH = 10;//redondeo vertical

    public BasicButton(int w, int h, String texto){
        setSize(w, h);
        setBackground(color);
        text.setText(texto);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.PLAIN, 32));
        setOpaque(false);
        add(text);
        accionMouse();
        setVisible(true);
    }

    public BasicButton(){
        setBounds(457, 650, 160, 54);
        setBackground(color);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.PLAIN, 32));
        setOpaque(false);
        add(text);
        accionMouse();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(3,3,getWidth()-6,getHeight()-6, arcW, arcH);
        //Rectangle.Double
        super.paint(g);
    }

    public void accionMouse(){
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickEvent();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
              
                int r,g,b;
                if( color.getRed() < 251) r = color.getRed() + 5;
                else r = color.getRed();
                
                if( color.getGreen()< 251) g = color.getGreen()+ 5;
                else g = color.getGreen();
                
                if( color.getBlue()< 251) b = color.getBlue()+ 5;
                else b = color.getBlue();
                
                setBackground(new Color(r, g, b));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
            }
        };
        addMouseListener(m);
    }

    public abstract void clickEvent();//funcion abstracta para definirle al boton que funcion va a realizar

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public void setText(String texto){
        text.setText(texto);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public int getArcW() {
        return arcW;
    }

    public void setArcW(int arcW) {
        this.arcW = arcW;
    }

    public int getArcH() {
        return arcH;
    }

    public void setArcH(int arcH) {
        this.arcH = arcH;
    }

    public void setRound(int arcW, int arcH){
        this.arcW = arcW;
        this.arcH = arcH;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
