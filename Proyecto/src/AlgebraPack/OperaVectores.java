/*clase para realizar operaciones con vectores
todavia no se vuelve estatic para usar las
operaciones sin necesidad de instanciar
 */

package AlgebraPack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanes
 */
public class OperaVectores extends JPanel{
    double vector1[], vector2[];
    int tam;
    //obtener tamaño y obtener valores se puede reutilizar para las 3 operaciones con vectores
    public void obtenerTamaño(){
        //se debe editar la forma de obtenerlo cuando se use el jframe
        String entrada=JOptionPane.showInputDialog("dijite el tamaño de los vectores");
        tam=Integer.parseInt(entrada);
        vector1= new double [tam];
        vector2= new double [tam];
    }
    public void obtenerValores(){
        //al igual que el anterior se debe cambiar a formato de jframe
        JOptionPane.showMessageDialog(null,"datos vector 1");
        for(int i=0;i<tam;i++){
            String entrada=JOptionPane.showInputDialog("dijite el valor #"+(i+1));
            vector1[i]=Double.parseDouble(entrada);
        }
        //ciclo 2do vector
        JOptionPane.showMessageDialog(null,"datos vector 2");
        for(int i=0;i<tam;i++){
            String entrada=JOptionPane.showInputDialog("dijite el valor #"+(i+1));
            vector2[i]=Double.parseDouble(entrada);
        }
    }
    public void multiplicarAndMostrar(){
        
        double resultado = 0.0f; // inicializamos una variable para almacenar el resultado

        for (int i = 0; i < tam; i++) {
            // multiplicar elementos en la misma posicion y sumar al resultado
            resultado += vector1[i] * vector2[i]; 
        }

        JOptionPane.showMessageDialog(
            null, "El resultado de la multiplicación de vectores es: " + resultado);
    }
    public void restarAndMostrar(){
        double vectorR[]= new double[tam];
        double resultado = 0.0f; // inicializamos una variable para almacenar el resultado

        for (int i = 0; i < tam; i++) {
            // restar los elementos de la misma posicion y guardarlos en el vector resultado en esa misma posicion
            vectorR[i]= vector1[i] - vector2[i]; 
        }
        JOptionPane.showMessageDialog(
            null, "El resultado de la resta de vectores es \n Vector Solucion: ");
        for(int i=0;i<tam;i++){
            System.out.println( " "+ vectorR[i]);
        }
    }
    public void sumarAndMostrar(){
        double vectorR[]= new double[tam];
       
        for (int i = 0; i < tam; i++) {
            // sumar los elementos de la misma posicion y guardarlos en el vector resultado en esa misma posicion
            vectorR[i]= vector1[i] + vector2[i]; 
        }
        System.out.println( "El resultado de la suma de vectores es \n Vector Solucion: ");
        for(int i=0;i<tam;i++){
            System.out.println( " "+ vectorR[i]);
        }
    }
}
