

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LateralButton extends JPanel {

    private JPanel lateralBar;

    private boolean band = false;

    public LateralButton(){
        setBounds(0,0,50,50);
        setBackground(new Color(84,84,84));
        setOpaque(true);
        setLayout(null);
        add(new Lines());
        accionMouse();
        setVisible(true);
    }

    private static class Lines extends JPanel{
        private Lines(){
            setBounds(0,0,50,50);
            setOpaque(false);
            setVisible(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0));
            g2.drawLine(7,17,43,17);
            g2.drawLine(7,27,43,27);
            g2.drawLine(7,37,43,37);
            super.paintComponent(g);
        }
    }

    public JPanel getLateralBar() {
        return lateralBar;
    }

    public void setLateralBar(JPanel lateralBar) {
        this.lateralBar = lateralBar;
    }


    private void accionMouse() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!band){
                    lateralBar.setSize(140,lateralBar.getHeight());
                    setSize(140,getHeight());
                }else {
                    lateralBar.setSize(50,lateralBar.getHeight());
                    setSize(50,getHeight());
                }
                band=!band;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(100, 100, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(84,84,84));
            }
        };
        this.addMouseListener(m);
    }
}
