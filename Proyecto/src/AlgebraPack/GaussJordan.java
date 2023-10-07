package AlgebraPack;

import AppMainSrc.RoundBorder;
import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;

public class GaussJordan extends JPanel {

    private AlgOptionButton[] optionButtons = new AlgOptionButton[4];

    private JLabel[] tituloVar = new JLabel[6];

    private RoundTextField[][] matriz = new RoundTextField[5][5];

    private RoundTextField[] vector = new RoundTextField[5];

    private RoundBorder border;

    private Line l;

    private ButtonGauss bGuass;

    private JLabel warning = new JLabel("Sistema sin solucion o con infinitas soluciones");

    public GaussJordan(){
        l = new Line(15, 298);
        setSize(1074, 800);
        setLayout(null);
        setLocation(50,0);
        setBackground(new Color(46,46,46));
        border = new RoundBorder(720, 450, 50, 50, 5);
        l.setLocation(656, 250);
        border.setLocation(177, 173);
        warning.setBounds(237,145,600, 30);
        warning.setForeground(new Color(214, 20, 45));
        warning.setFont(new Font("Arial", Font.PLAIN, 20));
        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setVisible(false);
        add(warning);
        add(l);
        initOptionButton();
        initTextFields();
        bGuass = new ButtonGauss(this);
        add(bGuass);
        add(border);
        setVisible(false);
    }

    public void initOptionButton(){
        int x = 136;
        for(int i = 0; i < optionButtons.length; i++){
            optionButtons[i] = new AlgOptionButton(i+2, this);
            optionButtons[i].setLocation(x,50);
            add(optionButtons[i]);
            x += 228;
        }
        optionButtons[0].setActive(true);
    }

    public void initTextFields(){
        int x, y;

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                matriz[i][j] = new RoundTextField(118, 118);
                matriz[i][j].setVisible(false);
                add(matriz[i][j]);
            }
            vector[i] = new RoundTextField(118, 118);
            vector[i].setVisible(false);
            add(vector[i]);
        }

        for (int i = 0; i < 6; i++){
            tituloVar[i] = new JLabel("X" + (i+1));
            tituloVar[i].setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,32));
            tituloVar[i].setForeground(new Color(0, 188, 255));
            tituloVar[i].setVisible(false);
            add(tituloVar[i]);
        }
        tituloVar[5].setText("b");

        x = 280;
        for (int i = 0; i < 2; i++){
            tituloVar[i].setBounds(x, 200,39, 33);
            tituloVar[i].setVisible(true);
            x += 238;
        }
        tituloVar[5].setBounds(x, 200,39, 33);
        tituloVar[5].setVisible(true);

        y = 250;
        for (int i = 0; i < 2; i++){
            x = 240;
            for (int j = 0; j < 2; j++){
                matriz[i][j].setLocation(x, y);
                matriz[i][j].setVisible(true);
                x += 238;
            }
            vector[i].setLocation(x, y);
            vector[i].setVisible(true);
            y += 180;
        }
    }

    public class Line extends JPanel{

        private int h;
        public Line(int w, int h){
            this.h = h;
            setSize(w, h);
            setOpaque(false);
            setVisible(true);
        }
        @Override
        public void paint(Graphics g){
            int stroke = 4;
            float[] fases = {25f, 25f};
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10f, fases, 0f));
            g2.setColor(new Color(0, 188, 255));
            g2.drawLine(3, 5, 3, h-5);
        }

        public void setH(int h) {
            this.h = h;
            setSize(getWidth(), h);
        }
    }

    public AlgOptionButton[] getOptionButtons() {
        return optionButtons;
    }

    public void setOptionButtons(AlgOptionButton[] optionButtons) {
        this.optionButtons = optionButtons;
    }

    public JLabel[] getTituloVar() {
        return tituloVar;
    }

    public void setTituloVar(JLabel[] tituloVar) {
        this.tituloVar = tituloVar;
    }

    public RoundTextField[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(RoundTextField[][] matriz) {
        this.matriz = matriz;
    }

    public RoundTextField[] getVector() {
        return vector;
    }

    public void setVector(RoundTextField[] vector) {
        this.vector = vector;
    }

    public RoundBorder getBorde() {
        return border;
    }

    public void setBorde(RoundBorder border) {
        this.border = border;
    }

    public ButtonGauss getbGuass() {
        return bGuass;
    }

    public void setbGuass(ButtonGauss bGuass) {
        this.bGuass = bGuass;
    }

    public Line getL() {
        return l;
    }

    public void setL(Line l) {
        this.l = l;
    }

    public JLabel getWarning() {
        return warning;
    }

    public void setWarning(JLabel warning) {
        this.warning = warning;
    }
}
