/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gauss.jordan;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author david
 */
public class botonSolucion extends JPanel{
    
    private JLabel mensaje = new JLabel("Resolver");
    
    public botonSolucion(){
        add(mensaje);
        accionMouse();
    }
    
    public void accionMouse(){
        MouseListener m;
        m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Matriz.obtenerValores();
                double[][] mat = Matriz.getMatriz();
                int n = Matriz.n;
                double[] vec = Matriz.vectorSol;
                
                for (int i = 0; i < n; i++){
                    
                    cambiarFilas(i, n, mat, vec);
                    /*if (mat[i][i] == 0){
                        for (int j = i+1; j < n; j++){
                            if(mat[j][i] != 0){
                                double Aux = 0;
                                for(int k = 0; k < n; k++){
                                    Aux = mat[i][k];
                                    mat[i][k] = mat[j][k];
                                    mat[j][k] = Aux;
                                }
                                Aux = vec[i];
                                vec[i] = vec[j];
                                vec[j] = Aux;
                                break;
                            }
                        }
                    }*/
                    
                    ComvertirEnUno(i, n, mat, vec);
                    /*double aux = mat[i][i];
                    if(aux != 1){
                        for(int j = 0; j < n; j++){
                             mat[i][j] /= aux;
                        }
                        vec[i] /= aux;
                    }*/
                    
                    ComvertirEnCeros(i, n, mat, vec);
                    /*double aux;
                    for (int j = i+1; j < n; j++){
                        int k;
                        aux = -mat[j][i];
                        for(k = 0; k < n; k++){
                            mat[j][k] += aux*mat[i][k];
                        }
                        vec[j] += aux*vec[i];
                    }
                    
                    for (int j = i-1; j >= 0; j--){
                        int k;
                        aux = -mat[j][i];
                        for(k = 0; k < n; k++){
                            mat[j][k] += aux*mat[i][k];
                        }
                        vec[j] += aux*vec[i];
                    }*/
                }
                
                for (int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(mat[i][j] + " ");
                    }
                    System.out.print(vec[i] + " ");
                    System.out.println();
                } 
                System.out.println();
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
    
    //se encarga de que el componente evaluado de la diagonal pricipal sea diferente de 0. 
    public void cambiarFilas(int a, int n, double[][]mat, double[] vec){
        if (mat[a][a] == 0){
            for (int i = a+1; i < n; i++){
                if(mat[i][a] != 0){
                    double Aux = 0;
                    for(int j = 0; j < n; j++){
                        Aux = mat[a][j];
                        mat[a][j] = mat[i][j];
                        mat[i][j] = Aux;
                    }
                    Aux = vec[a];
                    vec[a] = vec[i];
                    vec[i] = Aux;
                    break;
                }
            }
        }
    }
    
    //se encarga de volver unos los elementos de la diagonal principal
    public void ComvertirEnUno(int a, int n, double[][]mat, double[] vec){
        double aux = mat[a][a];
        if(aux != 1){
            for(int i = 0; i < n; i++){
                 mat[a][i] /= aux;
            }
            vec[a] /= aux;
        }
    }
    
    //se encarga de volver cero los elementos arriba y abajo de componente evaluado
    public void ComvertirEnCeros(int a, int n, double[][]mat, double[] vec){
        double aux;
        for (int i = a+1; i < n; i++){
            int j;
            aux = -mat[i][a];
            for(j = 0; j < n; j++){
                mat[i][j] += aux*mat[a][j];
            }
            vec[i] += aux*vec[a];
        }

        for (int i = a-1; i >= 0; i--){
            int j;
            aux = -mat[i][a];
            for(j = 0; j < n; j++){
                mat[i][j] += aux*mat[a][j];
            }
            vec[i] += aux*vec[a];
        }
    }
}
