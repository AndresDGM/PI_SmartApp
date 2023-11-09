package AppMainSrc;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RoundPanel extends JPanel {

    private int arc, w, h;

    public RoundPanel(int arc){
        this.arc = arc;
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect( 0, 0, w-1, h-1, arc, arc);
        super.paint(g);
    }

    public void setTam(int w, int h){
        this.w = w;
        this.h = h;
        setSize(w, h);
    }
}
