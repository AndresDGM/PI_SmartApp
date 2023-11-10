/*
 Esta clase se encarga de recibir las funciones ingresadas por el usuario con sus intervalos, procesarlas 
y crear la gráfica.
 */
package MathSource;

import java.awt.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;
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
public final class EvaluarFunciones {

    String funcion1, funcion2, derivada1, derivada2;
    double interf1_1, interf1_2;
    JEP j1;
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries puntos_f1, puntos_f2;
    JFreeChart grafico;
    public String tipoRecta = "";
    String maximo_minimof1 = "", maximo_minimof2 = "", mensaje = "", raicesf1 = "", raicesf2 = "";
    ArrayList<double[]> puntosDeCorte = new ArrayList<>();
    DecimalFormat formatoDecimal = new DecimalFormat("#.##");

    public EvaluarFunciones() {
    }

    public EvaluarFunciones(String valores[]) {
        funcion1 = valores[0];
        funcion2 = valores[3];
        interf1_1 = Double.parseDouble(valores[1]);
        interf1_2 = Double.parseDouble(valores[2]);
        CrearPuntos(funcion1, interf1_1, interf1_2, puntos_f1, "Funcion 1");
        CrearPuntos(funcion2, interf1_1, interf1_2, puntos_f2, "Funcion 2");
        graficar();
        tipo_funcion();
        DeterminarMaximos();
        DeterminarRaices();
    }

    public void SetFuncion1(String valoresf1[]) {
        this.funcion1 = valoresf1[0];
        this.interf1_1 = Double.parseDouble(valoresf1[1]);
        this.interf1_2 = Double.parseDouble(valoresf1[2]);
        CrearPuntos(funcion1, interf1_1, interf1_2, puntos_f1, "Funcion 1");
        graficar();
    }

    public void SetFuncion2(String f2, String inicio, String fin) {
        funcion2 = f2;
        interf1_1 = Double.parseDouble(inicio);
        interf1_2 = Double.parseDouble(fin);
        CrearPuntos(funcion2, interf1_1, interf1_2, puntos_f2, "Funcion 2");
        graficar();
    }

    private void CrearPuntos(String funcion, double inicio, double fin, XYSeries serie, String nombreSerie) {
        j1 = new JEP();
        j1.addStandardFunctions(); //agrega las funciones trigonométricas
        j1.addStandardConstants(); //agrega constantes (pi, e...)
        j1.setImplicitMul(true);
        j1.addVariable("x", inicio); //Inicializa la variable x en un valor (inicio de las dos funciones) 
        j1.parseExpression(funcion); //analiza el string y lo transforma en estructura de arbol para su evaluacion
        if (j1.hasError()) {
            JOptionPane.showMessageDialog(null, j1.getErrorInfo()); // Imprime el error
        } else {
            serie = new XYSeries(nombreSerie); //se crea una serie para la función
            for (double x = inicio; x <= fin; x += 0.01) {
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

    private void tipo_funcion() {
        calcularDerivadas();
        double m1 = pendientes(derivada1);
        double m2 = pendientes(derivada2);
        if ((m1 == m2) && (m1 != 0 || m2 != 0)) {
            tipoRecta = "Paralelas";
            if (funcion1.equals(funcion2)) {
                mensaje = "Mismos puntos";
            }
            mensaje = "No hay puntos de corte";
        } else if ((m1 * m2) == -1) {
            tipoRecta = "Perpendiculares";
            PuntosCorte();
        } else {
            tipoRecta = "Rectas que se cruzan";
            PuntosCorte();
        }
    }

    private double pendientes(String derivada) {
        double pendiente = 0;
        try {
            pendiente = Double.parseDouble(derivada);
        } catch (Exception e) {
            pendiente = 0; //no serías una función lineal, ya que al derivarla no daría un valor numérico
        }
        return pendiente;
    }

    public void calcularDerivadas() {
        CalcularDerivada cd = new CalcularDerivada(funcion1);
        derivada1 = cd.getDerivada();

        CalcularDerivada c = new CalcularDerivada(funcion2);
        derivada2 = c.getDerivada();
    }

    private void PuntosCorte() {
        XYSeries item1 = dataset.getSeries("Funcion 1");
        XYSeries item2 = dataset.getSeries("Funcion 2");

        HashMap<Double, Double> cfuncion1 = new HashMap<>();
        HashMap<Double, Double> cfuncion2 = new HashMap<>();

        for (int i = 0; i < item1.getItemCount(); i++) {
            cfuncion1.put((double) item1.getX(i), (double) item1.getY(i));
        }

        for (int i = 0; i < item2.getItemCount(); i++) {
            cfuncion2.put((double) item2.getX(i), (double) item2.getY(i));
        }

        for (double x : cfuncion1.keySet()) {
            if (cfuncion2.containsKey(x) && Math.abs(cfuncion1.get(x) - cfuncion2.get(x)) < 0.00000001) {
                double ry = Math.round(cfuncion2.get(x));
                double rx = Math.round(x);
                if (Math.abs(ry - cfuncion2.get(x)) < 0.00000001) {
                    puntosDeCorte.add(new double[]{rx, ry});
                } else {
                    puntosDeCorte.add(new double[]{x, cfuncion1.get(x)});
                }
            }
        }
    }

    public void DeterminarMaximos() {
        maximo_minimof1 = Maximos_Minimos(funcion1, derivada1);
        maximo_minimof2 = Maximos_Minimos(funcion2, derivada2);
    }
    
    public void DeterminarRaices(){
        raicesf1 = "Raices: " + Raices(funcion1);
        raicesf2 = "Raices: " + Raices(funcion2);
    }

    public String Maximos_Minimos(String funcion, String derivada) {
        String cadena = "";
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        jep.addVariable("x", 0); // Inicializa la variable x con un valor, puedes usar 0 como ejemplo

        UnivariateFunction f = (double d) -> {
            jep.addVariable("x", d); // Actualiza el valor de x para evaluar la derivada en d
            jep.parseExpression(derivada);
            return jep.getValue();
        };

        UnivariateFunction segundaDerivada = (double d) -> {
            CalcularDerivada segundaD = new CalcularDerivada(derivada);
            jep.addVariable("x", d); // Actualiza el valor de x para evaluar la derivada en d
            jep.parseExpression(segundaD.getDerivada());
            return jep.getValue();
        };

        BracketingNthOrderBrentSolver solver = new BracketingNthOrderBrentSolver();
        double tol = 1e-6;

            try {
            double puntosCriticos = solver.solve(1000, f, interf1_1, interf1_2, tol);
            jep.parseExpression(funcion);
            jep.addVariable("x", puntosCriticos);
            double y = jep.getValue();
            double signo = segundaDerivada.value(puntosCriticos);
            if (signo < 0) {
                cadena = "Máximo en x: " + formatoDecimal.format(puntosCriticos) + " y: " + formatoDecimal.format(y);
            } else if (signo > 0) {
                cadena = "Minimo en x: " + formatoDecimal.format(puntosCriticos) + " y: " + formatoDecimal.format(y);;
            }
        } catch (Exception e) {
            cadena = "Intervalos no suficientes";
        }
        return cadena;
    }
    
    public String Raices(String funcion){
        ArrayList<Double> puntos = new ArrayList<>();
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        jep.addVariable("x", 0);
        
        UnivariateFunction f = (double d) -> {
            jep.addVariable("x", d); // Actualiza el valor de x para evaluar la derivada en d
            jep.parseExpression(funcion);
            return jep.getValue();
        };
        
        BracketingNthOrderBrentSolver solver = new BracketingNthOrderBrentSolver();
        String cadena = "";
        double tol = 1e-6;
        while (true) {
        try {
            double punto = solver.solve(1000, f, interf1_1, interf1_2, tol);
            puntos.add(punto);
            interf1_1 = punto + tol; // Actualiza el límite inferior para la próxima búsqueda
        } catch (Exception e) {
            break;
        }
    }
        if(cadena.isEmpty()){
            cadena = "";
            for (Double punto : puntos) {
            cadena += "x: " + formatoDecimal.format(punto) + " ";
        }
        }
        else{
           cadena = "NaNa";
        }
        return cadena;
    }

    public String getMaximo_minimof1() {
        return maximo_minimof1;
    }

    public String getMaximo_minimof2() {
        return maximo_minimof2;
    }

    public String getDerivada1() {
        return derivada1;
    }

    public String getDerivada2() {
        return derivada2;
    }

    public String getTipoRecta() {
        return tipoRecta;
    }

    public String getRaicesf1() {
        return raicesf1;
    }

    public String getRaicesf2() {
        return raicesf2;
    }

    public String mensajesPuntosDeCorte() {
        for (double[] ds : puntosDeCorte) {
            mensaje += " x: " + formatoDecimal.format(ds[0]) + " y: " + formatoDecimal.format(ds[1]) + " \n";
        }
        return mensaje;
    }
}
