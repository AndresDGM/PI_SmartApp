
import java.util.Scanner;
public class OperaMatrices {
    static Scanner sc = new Scanner(System.in);
    double matriz1[][],matriz2[][];
    int f1,f2,c1,c2;// se le asignara los valores 
    public void obtenertamaños(){
        //toda esta monda sera cambiada por el jframe hpta vida la mia 
        System.out.println("a continuacion se obtendra el tamaño del primer vector");
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
    public void llenar(){
        
    }
    public void compAndMulti(){
        double matrizR[][]= new double[f1][c2];
        if (c1==f2) {
            
        } else {
            System.out.println("bobo hpta no son compatibles para multiplicar");
        }
    }
    
}
