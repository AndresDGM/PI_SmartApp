package AlgebraPack;

import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonGauss extends JPanel {

    private GaussJordan gj;

    private double[][] mat;

    private double[] vec;

    public ButtonGauss(GaussJordan gj){
        setBounds(457, 650, 160, 54);
        setBackground(new Color(77, 77, 77));
        JLabel text = new JLabel("Resolver");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.PLAIN, 32));
        this.gj = gj;
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
        g2.fillRoundRect(3,3,getWidth()-6,getHeight()-6,10,10);
        super.paint(g);
    }

    public void accionMouse(){
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gj.getWarning().setVisible(false);
                OperaMatrices o = new OperaMatrices();
                obtenerValores();
                if(o.det(mat) != 0)
                    o.SolveSystem(mat, vec, vec.length, gj.getMatriz(), gj.getVector());
                else
                    gj.getWarning().setVisible(true);
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
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(77,77,77));
            }
        };
        addMouseListener(m);
    }

    public void obtenerValores() {
        int n = 0;

        for (AlgOptionButton c: gj.getOptionButtons()) {
            if (c.isActive()) {
                n = c.getValor();
            }
        }

        mat = new double[n][n];
        vec = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = gj.getMatriz()[i][j].getNumText();
            }
            vec[i] = gj.getVector()[i].getNumText();
        }
    }
}
