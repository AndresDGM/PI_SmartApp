package AppMainSrc;

import javax.swing.*;
import java.awt.*;

public class RoundBorder extends JPanel {

    //redondeo horizontal
    private int arcWidth = 50;

    //redondeo vertical
    private int arcHeight = 50;

    //ancho del borde
    private int w = 0;

    //alto del borde
    private int h = 0;

    //valor del grosor de la linea
    private int stroke = 4;

    public RoundBorder(){
        setSize(w,h);
        setBackground(new Color(0, 188, 255));
        setOpaque(false);
        setVisible(true);
    }

    public RoundBorder(int w, int h, int arcWidth, int arcHeight, int stroke){
        this.w = w;
        this.h = h;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.stroke = stroke;
        setSize(w,h);
        setBackground(new Color(0, 188, 255));
        setOpaque(false);
        setVisible(true);
    }

    //logica de pintado del borde
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.setStroke(new BasicStroke(stroke));
        g2.drawRoundRect(5, 5, w - 10, h - 10, arcWidth, arcHeight);
        super.paintComponent(g);
    }

    public int getArcWidth() {
        return arcWidth;
    }

    public void setArcWidth(int arcWidth) {
        this.arcWidth = arcWidth;
    }

    public int getArcHeight() {
        return arcHeight;
    }

    public void setArcHeight(int arcHeight) {
        this.arcHeight = arcHeight;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
        setSize(w, getHeight());
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
        setSize(getWidth(), h);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height); 
        h = height;
        w = width;
    }

    public int getStroke() {
        return stroke;
    }
    
    
    
    
    
}
