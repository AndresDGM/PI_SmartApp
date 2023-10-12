/*
 Esta clase se encarga de recibir las funciones ingresadas por el usuario con sus intervalos, procesarlas 
y crear la gráfica.
tareas pendientes: 
Modificar el color de la gráfica
 */
package MathSource;

import java.awt.Color;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.nfunk.jep.JEP;

/**
 *
 * @author moral
 */
public class EvaluarFunciones{
    String funcion1, funcion2;
    double interf1_1, interf1_2, interf2_1, interf2_2;
    JEP j1;
    XYSeriesCollection dataset = new XYSeriesCollection(); 
    XYSeries puntos_f1, puntos_f2;
    JFreeChart grafico;

    public EvaluarFunciones(String valores[]) {
        funcion1 = valores[0];
        funcion2 = valores[1];
        interf1_1 = Double.parseDouble(valores[2]);
        interf1_2 = Double.parseDouble(valores[3]);
        interf2_1 = Double.parseDouble(valores[4]); 
        interf2_2 = Double.parseDouble(valores[5]);
        evaluarFunciones(funcion1, interf1_1, interf1_2, puntos_f1, "Funcion 1");
        evaluarFunciones(funcion2, interf2_1, interf2_2, puntos_f2, "Funcion 2");
        graficar();
    }
    
    private void Evaluar2Funciones(){
        
    }
    private void evaluarFunciones(String funcion, double inicio, double fin, XYSeries serie, String nombreSerie) {
        j1 = new JEP();
        j1.addStandardFunctions(); //agrega las funciones trigonométricas
        j1.addStandardConstants(); //agrega constantes (pi, e...)
        j1.addVariable("x", inicio); //Inicializa la variable x en un valor (inicio de las dos funciones) 
        j1.parseExpression(funcion); //analiza el string y lo transforma en estructura de arbol para su evaluacion
        
        if(j1.hasError()){
            JOptionPane.showMessageDialog(null, j1.getErrorInfo()); // Imprime el error
        }
        else{
        serie = new XYSeries(nombreSerie); //se crea una serie para la función
        for (double x = inicio;  x <= fin; x+=0.01){
            j1.addVariable("x", x); //se agregan los puntos en que se desea evaluar la funcion
            double y = j1.getValue();
            serie.add(x, y);
        }
        dataset.addSeries(serie);
        }
    }

    private void graficar() {
        grafico = ChartFactory.createXYLineChart("Gráfica", 
              "Eje x", 
              "Eje y", dataset, 
              PlotOrientation.VERTICAL, 
              true, 
              true, 
              false);
    } 
}
