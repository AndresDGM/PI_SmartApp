package AlgebraPack;

import java.awt.Color;
import javax.swing.JPanel;

public class OperaMatrices extends JPanel{
    
    public OperaMatrices(){
        setSize(1074, 800);
        setSize(1074, 800);
        setLayout(null);
        setLocation(50,0);
        setBackground(new Color(46,46,46));
        setVisible(false);
    }
    public void initBotones(){
        
    }
    //funcion para multipicar matrices (futuro apartado del menu de algebra)
    public static double[][] Multiplicar(double[][] mat, double[][] mat2) {

        double[][] matrizR;
        if (mat[0].length == mat2.length) {
            matrizR = new double[mat.length][mat2[0].length];

            for (int a = 0; a < mat.length; a++) {
                for (int i = 0; i < mat2[0].length; i++) {
                    int suma = 0;
                    for (int j = 0; j < mat2.length; j++) {
                        suma += mat[a][j] * mat2[j][i];
                    }
                    matrizR[a][i] = suma;
                }
            }
        } else {
            return mat;
        }

        return matrizR;
    }

    //funcion de la determinante mediante Laplace
    public static double det(double[][] mat){
        double det = 0;
        int coFat = 1;
        int matTam = mat.length;
        if(matTam == 1)
            return mat[0][0];

        if(matTam == 2)
            return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];

        for(int i = 0; i < matTam; i++){
            det += coFat * mat[0][i] * det(getMenor(mat, 0, i));
            coFat *= -1;    
        }
        return det;
    }

    //funcion para obtener la menor de las matrices para Laplace
    public static double[][] getMenor(double[][] mat, int i, int j){
        int tam = mat.length;
        double[][] menor = new double[tam-1][tam-1];
        double[] fila = new double[tam-1];
        int a = 0;
        for(int k = 0; k < tam; k++){
            if (k != i) {
                int l = 0;
                for (int m = 0; m < tam; m++) {
                    if(m != j){
                        menor[a][l] = mat[k][m];
                        l++;
                    }
                }
                a++;
            }
        }
        return menor;
    }

    //funcion Gauss Jordan
    public static void SolveSystem(double[][] mat, double[] vec, int n){
        for (int i = 0; i < n; i++){
            cambiarFilas(i, n, mat, vec);
            convertirEnUno(i, n, mat, vec);
            buscarCeros(i, n, mat, vec);
        }
    }

    // si algun valor de la diagonal principar es seron busca un elemento distinto para hacer un cambio de fila (para Gauss Jordan)
    public static void cambiarFilas(int a, int n, double[][]mat, double[] vec){
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

    //se encarga de volver unos los elementos de la diagonal principal (para Gauss Jordan)
    public static void convertirEnUno(int a, int n, double[][]mat, double[] vec){
        double aux = mat[a][a];
        if(aux != 1){
            for(int i = 0; i < n; i++){
                mat[a][i] /= aux;
            }
            vec[a] /= aux;
        }
    }

    //se encarga de volver cero los elementos arriba y abajo de componente evaluado (para Gauss Jordan)
    public static void buscarCeros(int a, int n, double[][]mat, double[] vec){
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
    
    //se enarga de encontrar la inversa de la matriz
    public static double[][] MatrizInversa(double[][] mat) {
        int n = mat.length;
        double[][] matrizInversa = new double[n][n];

        // Calcula el determinante de la matriz original
        double determinante = det(mat);

        if (determinante == 0) {
            // La matriz no tiene inversa
            return null;
        }
        
        if(mat.length == 1){
            return new double[][]{{1/mat[0][0]}};
        }

        // Calcula la matriz adjunta
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double cofactor = det(getMenor(mat, i, j));
                matrizInversa[j][i] = cofactor / determinante * ((i + j) %2 == 0? 1 : -1);
            }
        }

        return matrizInversa;
    }

}