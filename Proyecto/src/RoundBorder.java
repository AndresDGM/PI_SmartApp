import javax.swing.*;
import java.awt.*;

public class RoundBorder extends JPanel {
    
    private int arcWidth = 100;
    
    private int arcHeight = 100;
    
    private int w = 0;
    
    private int h = 0;
    
    private int stroke = 4;
            
    public RoundBorder(){
        setSize(w,h);
        setBackground(new Color(0, 188, 255));
        setOpaque(false);
        setVisible(true);
    }
    
    public RoundBorder(int w, int h){
        this.w = w;
        this.h = h;
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
    
}
