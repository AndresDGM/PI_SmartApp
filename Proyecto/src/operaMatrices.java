
import java.util.Scanner;
public class OperaMatrices {
    
    static Scanner sc = new Scanner(System.in);
    double matriz1[][],matriz2[][], matrizR[][];
    int f1,f2,c1,c2;// se le asignara los valores 
    public void obtenertamaños(){
        //toda esta monda sera cambiada por el jframe hpta vida la mia 
        System.out.println("a continuacion se obtendra el tamaño de la primera matriz");
        System.out.println("ingrese el numero de filas");
        f1=sc.nextInt();
        System.out.println("ingrese el numero de columnas");
        c1=sc.nextInt();
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
    
    public static void main(String[] args) {
        OperaMatrices obj= new OperaMatrices();
        obj.obtenertamaños();
        obj.llenar();
        obj.Multiplicar(obj.comparar());
        obj.mostrar();
    }

}  

