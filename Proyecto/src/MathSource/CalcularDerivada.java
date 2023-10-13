/*
 En esta clase se recibe la función y se le calcula la derivada
 */
package MathSource;

import javax.swing.JOptionPane;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
/**
 *
 * @author moral
 */
public class CalcularDerivada {
    
    String funcion, resultado;
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;

    public CalcularDerivada() {

    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
     
    public String getDerivada(){
        return resultado;
    }
    
    public void derivar(){
        
        try {
            djep = new DJep();
            djep.addStandardConstants(); //Añadir constantes
            
            djep.addStandardFunctions(); //Añadir funciones constantes
            
            djep.setAllowUndeclared(true); //permite funciones no declarables
            
            djep.setAllowAssignment(true); //permitir asignación
            
            djep.setImplicitMul(true); // reglas de multiplicación, suma y sustracción
            
            djep.addStandardDiffRules(); //Estándares de derivación
            //agregamos al nodo la función
            nodoFuncion = djep.parse(funcion);
            
            Node diff = djep.differentiate(nodoFuncion, "x"); //diferenciamos con respecto a x
            
            nodoDerivada = djep.simplify(diff);
            
            //convertimos la derivada a String y se la asignamos a nuestra variable función
            resultado = djep.toString(nodoDerivada);
            
            //Por si ocurre una excepción
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getErrorInfo());
        }   
    }   
    
}
