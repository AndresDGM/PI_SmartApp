//contenido de la calculadora de determinantes

package AlgebraPack;

import AppMainSrc.BasicButton;
import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;

public class DetCalculator extends JPanel {

    private RoundTextField[][] matriz;// matriz donde se leeran los datos el tamaño sera definido por el usuario (0 a 6 tempralmente)

    private double[][] mat;//matriz donde se guardaran los datos para relizar la determinante

    private RoundTextField tamInput = new RoundTextField(78, 78);

    private JLabel resultado = new JLabel("det(A) = ");

    private JLabel matrizText = new JLabel("A = ");

    private BasicButton[] botones = new BasicButton[3];

    private JLabel warning = new JLabel("Tamaño invalido");//texto de advertencias

    private int d = 0;

    public DetCalculator(){
        setSize(1074, 800);
        setLayout(null);
        setLocation(50,0);
        setBackground(new Color(46,46,46));
        initBotones();
        JLabel tamText = new JLabel("Tamaño");
        tamText.setForeground(Color.WHITE);
        tamText.setFont(new Font("Arial", Font.PLAIN, 24));
        tamText.setBounds(147, 44,150, 50);
        tamText.setHorizontalAlignment(JLabel.CENTER);
        warning.setForeground(new Color(214, 20, 45));
        warning.setFont(new Font("Arial", Font.PLAIN, 18));
        warning.setBounds(437, 85,200, 50);
        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setVisible(false);
        resultado.setForeground(Color.WHITE);
        resultado.setFont(new Font("Arial", Font.PLAIN, 24));
        resultado.setHorizontalAlignment(JLabel.CENTER);
        resultado.setSize(200,50 );
        resultado.setVisible(false);
        matrizText.setForeground(Color.WHITE);
        matrizText.setFont(new Font("Arial", Font.PLAIN, 24));
        matrizText.setHorizontalAlignment(JLabel.CENTER);
        matrizText.setSize(200,50 );
        matrizText.setVisible(false);
        tamInput.setLocation(307, 30);
        tamInput.getRoundBorder().setBackground(new Color(0, 188, 255));
        add(tamInput);
        add(resultado);
        add(matrizText);
        add(tamText);
        add(warning);
        setVisible(false);
    }

    //instancia de botones
    public void initBotones(){
        botones[0] = new BasicButton() {
            @Override
            public void clickEvent() {
                cargar();
            }
        };
        botones[0].setText("Cargar");
        botones[0].setLocation(407, 42);
        add(botones[0]);

        botones[1] = new BasicButton() {
            @Override
            public void clickEvent() {
                if (matriz != null) resolver();
            }
        };
        botones[1].setText("Resolver");
        botones[1].setLocation(587, 42);
        add(botones[1]);

        botones[2] = new BasicButton() {
            @Override
            public void clickEvent() {
                if(matriz != null) limpiar();
            }
        };
        botones[2].setText("Limpiar");
        botones[2].setLocation(767, 42);
        add(botones[2]);
    }

    //inializa la matriz con el valor ingresado por el usuario
    public void initMat(){
        d = (int) tamInput.getNumText();

        if(d > 0 && d <7) {
            warning.setVisible(false);
            matriz = new RoundTextField[d][d];
            mat = new double[d][d];

            int x;
            int y = 400 - (98*d-20) / 2;
            for (int i = 0; i < d; i++) {

                x = 537 - (98*d-20) / 2;
                for (int j = 0; j < d; j++) {
                    matriz[i][j] = new RoundTextField(78, 78);
                    matriz[i][j].getRoundBorder().setBackground(new Color(0, 188, 255));
                    matriz[i][j].setLocation(x, y);
                    add(matriz[i][j]);
                    x += 98;
                }
                y += 98;
            }
            resultado.setLocation(437, 420 + (98*d-20) / 2);
            resultado.setVisible(true);
            matrizText.setLocation(407 - (98*d-20)/2, 375);
            matrizText.setVisible(true);
        }else{
            if (d <= 0) warning.setText("Tamaño invalido");
            else warning.setText("Tamaño hasta 6x6");
            warning.setVisible(true);
        }
    }

    public void resolver() {// toma los valores para resolver la determinante
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                mat[i][j] = matriz[i][j].getNumText();
            }
        }
        resultado.setVisible(true);
        resultado.setText("det(A) = " + OperaMatrices.det(mat));
    }

    public void limpiar(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j].setText("0");
            }
        }
        resultado.setText("det(A) = ");
    }

    public void cargar(){//borra los elemtontos del contenedor y vuelve a inicializar las matrices con el nuevo valor ingresado
        if(matriz != null) { //se limita a un tamaño de 6 para no tener errores de diseño (probablemente temporal hasta implementar ScrollBars)
            if(tamInput.getNumText() > 0 && tamInput.getNumText() < 7) {
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz.length; j++) {
                        matriz[i][j].setVisible(false);
                        remove(matriz[i][j]);
                    }
                }
            }
        }
        initMat();
    }
}