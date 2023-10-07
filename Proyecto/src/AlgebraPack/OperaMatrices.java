package AlgebraPack;

import AppMainSrc.RoundTextField;

import java.util.Scanner;
public class OperaMatrices {

    static Scanner sc = new Scanner(System.in);
    double matriz1[][],matriz2[][], matrizR[][];
    int f1,f2,c1,c2;// se le asignara los valores
    public void obtenertamaños(int tamF, int tamC){
        //toda esta monda sera cambiada por el jframe hpta vida la mia
        f1 = tamF;
        System.out.println("ingrese el numero de columnas");
        c1 = tamC;
        matriz1= new double[f1][c1];
        System.out.println("datos de la segunda matriz:");
        System.out.println("ingrese el numero de filas");
        f2=sc.nextInt();
        System.out.println("ingrese el numero de columna");
        c2=sc.nextInt();
        matriz2= new double[f1][c1];
    }
    public void llenar() {
        System.out.println("Llenado de la primera matriz:");
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.println("Ingrese el valor en la posicion [" + (i + 1) + "][" + (j + 1) + "]");
                matriz1[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Llenado de la segunda matriz:");
        for (int i = 0; i < f2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.println("Ingrese el valor en la posicion [" + (i + 1) + "][" + (j + 1) + "]");
                matriz2[i][j] = sc.nextDouble();
            }
        }
    }
    public void mostrar() {
        System.out.println("Matriz Resultante:");

        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println(); // Salto de linea para la siguiente fila
        }
    }

    public boolean  comparar(){
        return c1==f2;
    }
    public void Multiplicar(boolean comparar) {
        if (comparar) {
            if (c1 != f2) {
                System.out.println("Las matrices no son compatibles para multiplicar");
            } else {
                matrizR = new double[f1][c2];
                // Realiza la multiplicacion de matrices
                for (int a = 0; a < f1; a++) {
                    for (int i = 0; i < c2; i++) {
                        int suma = 0;
                        for (int j = 0; j < c1; j++) {
                            suma += matriz1[a][j] * matriz2[j][i];
                        }
                        matrizR[a][i] = suma;
                    }
                }
            }
        } else {
            System.out.println("No se realizo la multiplicacion");
        }
    }

    public double det(double[][] mat){
        double det = 0;
        int coFat = 1;
        if(mat.length == 1)
            return mat[0][0];

        if(mat.length == 2)
            return mat[0][0]*mat[1][1]-mat[0][1]*mat[1][0];

        if(mat.length > 2) {
            for(int i = 0; i < mat.length; i++){
                det += coFat * mat[0][i] * det(getMenor(mat, 0, i));
                coFat *= -1;
            }
        }
        return det;
    }

    public double[][] getMenor(double[][] mat, int i, int j){
        int tam = mat.length;
        double[][] menor = new double[tam-1][tam-1];
        double[] fila = new double[tam-1];
        int a = 0;
        for(int k = 0; k < tam; k++){
            if (k != i) {
                int l = 0;
                for (int m = 0; m < tam; m++) {
                    if(m != j){
                        fila[l] = mat[k][m];
                        l++;
                    }
                }
                for (int m = 0; m < tam-1; m++)
                    menor[a][m] = fila[m];
                a++;
            }
        }
        return menor;
    }

    public void SolveSystem(double[][] mat, double[] vec, int n, RoundTextField[][] matText, RoundTextField[] vecText){

        for (int i = 0; i < n; i++){
            cambiarFilas(i, n, mat, vec);
            convertirEnUno(i, n, mat, vec);
            buscarCeros(i, n, mat, vec);
        }

        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matText[i][j].setText(Double.toString(mat[i][j]));
            }
            vecText[i].setText(Double.toString(vec[i]));
        }
    }

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
    public void convertirEnUno(int a, int n, double[][]mat, double[] vec){
        double aux = mat[a][a];
        if(aux != 1){
            for(int i = 0; i < n; i++){
                mat[a][i] /= aux;
            }
            vec[a] /= aux;
        }
    }

    //se encarga de volver cero los elementos arriba y abajo de componente evaluado
    public void buscarCeros(int a, int n, double[][]mat, double[] vec){
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