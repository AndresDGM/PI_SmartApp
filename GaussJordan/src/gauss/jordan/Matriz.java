/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gauss.jordan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author david
 */
public class Matriz extends JPanel {

    public static JTextField[][] matText;

    public static JTextField[] vectorText;

    public static JTextField dimension = new JTextField();

    private final botonDimencion b = new botonDimencion();

    private final botonSolucion b2 = new botonSolucion();

    public static int n;

    public static double[][] matriz;

    public static double[] vectorSol;

    public Matriz() {
        setSize(800, 800);
        setLayout(null);
        setBackground(Color.white);
        b.setSize(60, 20);
        b.setBounds(150, 150, b.getWidth(), b.getHeight());
        b2.setSize(60, 20);
        b2.setBounds(700, 150, b.getWidth(), b.getHeight());
        dimension.setBounds(200, 50, 50, 50);
        add(b);
        add(b2);
        add(dimension);
        setVisible(true);
    }

    public class botonDimencion extends JPanel {

        JLabel mensaje = new JLabel("subir");

        public botonDimencion() {
            add(mensaje);
            accionMouse();
        }

        public void accionMouse() {
            MouseListener m = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String dato;
                    dato = dimension.getText();
                    n = Integer.parseInt(dato);
                    iniciarMat();
                    setVisible(false);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            };
            addMouseListener(m);
        }
    }

    public void iniciarMat() {
        matText = new JTextField[n][n];
        vectorText = new JTextField[n];
        matriz = new double[n][n];
        vectorSol = new double[n];

        int posY = 100;
        for (int i = 0; i < n; i++) {
            int posX = 90;
            for (int j = 0; j < n; j++) {
                matText[i][j] = new JTextField();
                matText[i][j].setBounds(posX, posY, 70, 70);
                matText[i][j].setHorizontalAlignment(JTextField.CENTER);
                add(matText[i][j]);
                matText[i][j].repaint();
                dimension.setVisible(false);
                posX += 90;
            }

            vectorText[i] = new JTextField();
            vectorText[i].setBounds(posX + 10, posY, 70, 70);
            add(vectorText[i]);
            vectorText[i].repaint();
            posY += 100;
        }
    }

    public static void obtenerValores() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = Double.parseDouble(matText[i][j].getText());
            }
            vectorSol[i] = Double.parseDouble(vectorText[i].getText());
        }
    }
    
    public static double[][] getMatriz(){
        return matriz;
    }

}
