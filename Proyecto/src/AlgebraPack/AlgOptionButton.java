package AlgebraPack;

import AppMainSrc.RoundBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AlgOptionButton extends JPanel {
    
    private boolean active = false;

    private GaussJordan g;

    private int valor;

    private RoundBorder border;

    private JLabel text = new JLabel();

    public AlgOptionButton(int valor, GaussJordan g) {
        setSize(114,50);
        setBackground(new Color(77,77,77));
        setLayout(null);
        this.g = g;
        this.valor = valor;
        text.setSize(114, 50);
        text.setText(valor + "x" + valor);
        text.setFont(new Font("Arial Rounded MT Bold",text.getFont().getStyle(),24));
        text.setForeground(new Color(0,188,255));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setVerticalAlignment(JLabel.CENTER);
        border = new RoundBorder(114,50,10,10,3);
        border.setLocation(0, 0);
        border.setBackground(getBackground());
        accionMouse();
        add(border);
        add(text);
        setOpaque(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(3,3,getWidth()-6,getHeight()-6,10,10);
        super.paint(g);
    }
    
    public void accionMouse(){
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isFocusable()) {
                    for (AlgOptionButton c : g.getOptionButtons()) {
                        if (c.isActive()) {
                            c.setActive(false);
                            c.getBor().setBackground(getBackground());
                        }
                        setActive(true);
                        getBor().setBackground(new Color(0, 188, 255));
                        g.getWarning().setVisible(false);
                    }

                    switch (valor) {
                        case 2:
                            changeCoordsMat(240, 238, 250, 180, 118);
                            changeCoordsText(280, 200, 238);
                            g.getWarning().setLocation(237, 145);
                            g.getBorde().setW(720);
                            g.getBorde().setH(450);
                            g.getBorde().setLocation(177, 173);
                            g.getL().setBounds(656, 250, 15, 298);
                            g.getL().setH(298);
                            g.getbGuass().setLocation(457, 650);
                            break;
                        case 3:
                            changeCoordsMat(250, 160, 250, 120, 98);
                            changeCoordsText(280, 200, 160);
                            g.getWarning().setLocation(237, 145);
                            g.getBorde().setW(720);
                            g.getBorde().setH(450);
                            g.getBorde().setLocation(177, 173);
                            g.getL().setBounds(696, 250, 15, 336);
                            g.getL().setH(336);
                            g.getbGuass().setLocation(457, 650);
                            break;
                        case 4:
                            changeCoordsMat(237, 128, 218, 108, 88);
                            changeCoordsText(262, 174, 128);
                            g.getWarning().setLocation(237, 120);
                            g.getBorde().setLocation(157, 151);
                            g.getBorde().setW(760);
                            g.getBorde().setH(520);
                            g.getL().setBounds(728, 225, 15, 450);
                            g.getL().setH(410);
                            g.getbGuass().setLocation(457, 686);
                            break;
                        case 5:
                            changeCoordsMat(228, 108, 195, 100, 78);
                            changeCoordsText(248, 143, 108);
                            g.getWarning().setLocation(237, 97);
                            g.getBorde().setLocation(167, 127);
                            g.getBorde().setW(740);
                            g.getBorde().setH(566);
                            g.getL().setBounds(750, 215, 15, 472);
                            g.getL().setH(457);
                            g.getbGuass().setLocation(457, 700);
                            break;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(80,80,80));
                if(!active) border.setBackground(new Color(80,80,80));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(77,77,77));
                if(!active) border.setBackground(new Color(77,77,77));
            }
        };
        addMouseListener(m);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        border.setBackground(new Color(0,188,255));
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public RoundBorder getBor(){
        return border;
    }

    public void setBorder(RoundBorder border) {
        this.border = border;
    }

    public JLabel getText() {
        return text;
    }

    public void setText(JLabel text) {
        this.text = text;
    }

    public void changeCoordsMat(int x, int xIntcrement, int y, int yIntcrement, int s){

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                g.getMatriz()[i][j].setVisible(false);
            }
            g.getVector()[i].setVisible(false);
        }
        int y2 = y;
        for (int i = 0; i < valor; i++){
            int x2 = x;
            for (int j = 0; j < valor; j++){
                g.getMatriz()[i][j].setSize(s, s);
                g.getMatriz()[i][j].setLocation(x2, y2);
                g.getMatriz()[i][j].getRoundBorder().setW(s);
                g.getMatriz()[i][j].getRoundBorder().setH(s);
                g.getMatriz()[i][j].getTextField().setSize(s , s);
                g.getMatriz()[i][j].setVisible(true);
                x2 += xIntcrement;
            }
            g.getVector()[i].setSize(s, s);
            g.getVector()[i].setLocation(x2, y2);
            g.getVector()[i].getRoundBorder().setW(s);
            g.getVector()[i].getRoundBorder().setH(s);
            g.getVector()[i].getTextField().setSize(s , s);
            g.getVector()[i].setVisible(true);
            y2 += yIntcrement;
        }
    }

    public void changeCoordsText(int x, int y, int xIntcrement){
        for (int i = 0; i < 5; i++){
            g.getTituloVar()[i].setVisible(false);
        }

        for (int i = 0; i < valor; i++){
            g.getTituloVar()[i].setBounds(x, y,39, 33);
            g.getTituloVar()[i].setVisible(true);
            x += xIntcrement;
        }
        g.getTituloVar()[5].setBounds(x, y,39, 33);
        g.getTituloVar()[5].setVisible(true);
    }
}
