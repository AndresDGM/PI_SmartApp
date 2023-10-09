//contenido de la calculadora de sistemas de ecuaciones

package AlgebraPack;

import AppMainSrc.BasicButton;
import AppMainSrc.RoundBorder;
import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;

public class GaussJordan extends JPanel {

    private AlgOptionButton[] optionButtons = new AlgOptionButton[4];// botones para elegir el tamaño del sistema

    private JLabel[] tituloVar = new JLabel[6];//titulos de las variables

    private RoundTextField[][] matriz = new RoundTextField[5][5];

    private RoundTextField[] vector = new RoundTextField[5];

    private double[][] mat;

    private double[] vec;

    private int[] coordsTemp = new int[3];

    private RoundBorder border;

    private Line l;

    private BasicButton bGuass;

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
        bGuass = new BasicButton(160, 54, "Resolver") {
            @Override
            public void clickEvent() {
                clickFun();
            }
        };
        bGuass.setLocation(457, 650);
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

    public void initTextFields(){//inicializa los textFields y los titulos de las variables
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
            tituloVar[i].setHorizontalAlignment(JLabel.CENTER);
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

    public void clickFun(){//funcion del boton resolver
        warning.setVisible(false);
        if (!bGuass.isClicked()) {// si el boton no se ha presionado resuleve el sistema y muestra el resultodo
            obtenerValores();
            if (OperaMatrices.det(mat) != 0) {
                OperaMatrices.SolveSystem(mat, vec, vec.length);
                changeActive(false);
                coordsTemp = new int[]{tituloVar[0].getX(), tituloVar[0].getY(),
                        tituloVar[1].getX() - tituloVar[0].getX()};

                for (int i = 0; i < vec.length; i++) {
                    tituloVar[i].setBounds(border.getX() + 10,
                            vector[i].getY() + vector[i].getHeight() / 2 - 12,
                            border.getW() - 20, 33);
                    tituloVar[i].setText(tituloVar[i].getText() + " = " + vec[i]);
                }
                bGuass.setClicked(true);
                bGuass.setText("Regresar");
            } else
               warning.setVisible(true);
        }else{//volver a mostrar los textFields y reacomodar los titulos de variables
            changeActive(true);
            int x = coordsTemp[0];
            for (int i = 0; i < vec.length; i++) {
                tituloVar[i].setBounds(x,coordsTemp[1], 39, 33);
                tituloVar[i].setText("X" + (i+1));

                x += coordsTemp[2];
            }
            bGuass.setClicked(false);
            bGuass.setText("Resolver");
        }
    }

    public void obtenerValores() {//se extren los datos para guardarlos en la matriz y vector solucion
        int n = 0;

        for (AlgOptionButton c: optionButtons) {
            if (c.isActive()) {
                n = c.getValor();
            }
        }

        mat = new double[n][n];
        vec = new double[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matriz[i][j].getNumText();
            }
            vec[i] =vector[i].getNumText();
        }
    }

    public void changeActive(boolean active){// desactiva o activa los componentes la seccion de sistema de ecuaciones

        for (int i = 0; i < 4; i++) {
            optionButtons[i].setFocusable(active);
        }

        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec.length; j++) {
                matriz[i][j].setVisible(active);
                matriz[i][j].getTextField().setText("0");
            }
            vector[i].setVisible(active);
            vector[i].getTextField().setText("0");
        }
        tituloVar[5].setVisible(active);
        l.setVisible(active);
    }

    public class Line extends JPanel{//linea que separa la matriz y el vector solucion en la Gui

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

    public JLabel[] getTituloVar() {
        return tituloVar;
    }

    public RoundTextField[][] getMatriz() {
        return matriz;
    }

    public RoundTextField[] getVector() {
        return vector;
    }

    public RoundBorder getBorde() {
        return border;
    }

    public Line getL() {
        return l;
    }

    public JLabel getWarning() {
        return warning;
    }

    public BasicButton getbGuass() {
        return bGuass;
    }
}
