

import javax.swing.*;
import java.awt.*;

public class BorderMenu extends JPanel {
    public BorderMenu(){
        setSize(950,675);
        setBackground(new Color(0, 188, 255));
        setOpaque(false);
        setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.setStroke(new BasicStroke(4));
        g2.drawRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 100, 100);
        super.paintComponent(g);
    }
}
