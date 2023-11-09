package AlgebraPack;

import AppMainSrc.BasicButton;
import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;

public class InvCalculator extends JPanel {
    
    private RoundTextField[][] matriz; 
    private double[][] mat;  
    private RoundTextField tamInput = new RoundTextField(78,78 );
    private JLabel matrizText = new JLabel("A = ");
    private BasicButton[] botones = new BasicButton[3];
    private JLabel warning = new JLabel("Tamaño invalido");
    private JLabel warning2 = new JLabel("No existe inversa");
    private int d = 0;
    
    public InvCalculator(){
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
        warning.setBounds(412, 85,250, 50);
        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setVisible(false);
        warning2.setForeground(new Color(214, 20, 45));
        warning2.setFont(new Font("Arial", Font.PLAIN, 18));
        warning2.setBounds(437, 85,200, 50);
        warning2.setHorizontalAlignment(JLabel.CENTER);
        warning2.setVisible(false);
        matrizText.setForeground(Color.WHITE);
        matrizText.setFont(new Font("Arial", Font.PLAIN, 24));
        matrizText.setHorizontalAlignment(JLabel.CENTER);
        matrizText.setSize(200,50 );
        matrizText.setVisible(false);
        tamInput.setLocation(307, 30);
        tamInput.getRoundBorder().setBackground(new Color(0, 188, 255));
        add(tamInput);
        add(matrizText);
        add(tamText);
        add(warning);
        add(warning2);
        setVisible(false);
    }
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
    
    public void resolver(){
        
        warning.setVisible(false);
        warning2.setVisible(false);
        try {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    mat[i][j] = matriz[i][j].getNumText();
                }
            }
            double[][] matrizinv = OperaMatrices.MatrizInversa(mat);
            if (matrizinv == null) {
                warning2.setText("No existe inversa");
                warning2.setVisible(true);
                return;
            }
            //llenar la matriz
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz.length; j++) {
                    matriz[i][j].setText(Double.toString(matrizinv[i][j]));
                    matriz[i][j].getTextField().setHorizontalAlignment(JTextField.LEFT);
                }
            }
            matrizText.setText("A^-1= ");
        }catch(NumberFormatException e){
            warning.setText("Ingrese valores numericos");
            warning.setVisible(true);
        }
        
    }
    //inicia la matriz con el valor ingesado por el usuario 
    public void initMat(){
        d = (int) tamInput.getNumText();

        if(d > 0 && d <7) {
            warning.setVisible(false);
            warning2.setVisible(false);
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
            matrizText.setLocation(407 - (98*d-20)/2, 375);
            matrizText.setVisible(true);
        }else{
            if (d <= 0) warning.setText("Tamaño invalido");
            else warning.setText("Tamaño hasta 6x6");
            warning.setVisible(true);
        }
    }
    
    public void limpiar(){
            warning.setVisible(false);
            warning2.setVisible(false);        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j].setText("0");
                matriz[i][j].getTextField().setHorizontalAlignment(JTextField.CENTER);
            }
        }
        matrizText.setText("A = ");
        warning2.setVisible(false);
    }
    public void cargar(){//borra los elemtontos del contenedor y vuelve a inicializar las matrices con el nuevo valor ingresado
        
        warning.setVisible(false);
         warning2.setVisible(false);
        try{
            if(matriz != null) { //se limita a un tamaño de 6 para no tener errores de diseño
                if(tamInput.getNumText() > 0 && tamInput.getNumText() < 7) {
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            matriz[i][j].setVisible(false);
                            remove(matriz[i][j]);
                        }
                    }
                }
                matrizText.setText("A = ");
            }
            initMat();
        }catch(NumberFormatException e){
            warning.setText("Ingrese un tamaño valido");
            warning.setVisible(true);
        }
    }
}
