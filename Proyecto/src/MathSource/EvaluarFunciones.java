/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public EvaluarFunciones() {
    }
    
    public EvaluarFunciones(String valores[]) {
        funcion1 = valores[0];
        funcion2 = valores[1];
        interf1_1 = Double.parseDouble(valores[2]);
        interf1_2 = Double.parseDouble(valores[3]);
        interf2_1 = Double.parseDouble(valores[4]); 
        interf2_2 = Double.parseDouble(valores[5]);
        evaluarfuncion1();
        evaluarfuncion2();
        graficar();
    }
    
    private void evaluarfuncion1() {
        j1 = new JEP();
        j1.addStandardFunctions();
        j1.addStandardConstants();
        j1.addVariable("x", interf1_1); //Inicializa la variable x en un valor 
        j1.parseExpression(funcion1); //analiza el string y lo transforma en estructura de arbol para su evaluacion
        
        if(j1.hasError()){
            JOptionPane.showMessageDialog(null,j1.getErrorInfo()); // Imprime el error
        }
        puntos_f1 = new XYSeries("Funcion 1"); //se crea una serie para la función1
        for (double x = interf1_1;  x <= interf1_2; x+=0.01){
            j1.addVariable("x", x); //se agregan los puntos en que se desea evaluar la funcion
            double y = j1.getValue();
            puntos_f1.add(x, y);
        }
        dataset.addSeries(puntos_f1);
    }
    
    private void evaluarfuncion2() {
        j1 = new JEP();
        j1.addStandardFunctions();
        j1.addStandardConstants();
        j1.addVariable("x", interf2_1); //Inicializa la variable x en un valor 
        j1.parseExpression(funcion2); //analiza el string y lo transforma en estructura de arbol para su evaluacion
        
        if(j1.hasError()){
            JOptionPane.showMessageDialog(null,j1.getErrorInfo()); // Imprime el error
        }
        puntos_f2 = new XYSeries("Funcion 2"); //se crea una serie para la función1
        for (double x = interf2_1;  x <= interf2_2; x+=0.01){
            j1.addVariable("x", x); //se agregan los puntos en que se desea evaluar la funcion
            double y = j1.getValue();
            puntos_f2.add(x, y);
        }
        dataset.addSeries(puntos_f2);
    }

    private void graficar() {
        grafico = ChartFactory.createXYLineChart("Gráfica", 
              "Eje x", 
              "Eje y", dataset, 
              PlotOrientation.VERTICAL, 
              true, 
              true, 
              false);
        grafico.setBackgroundPaint(new Color(46,46,46));
    }
    
}
