package HumanidadesPack;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import AppMainSrc.BasicButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class puntuacion extends JPanel {

    private JFreeChart chart;
    private DefaultCategoryDataset dataset;
    private Registro registro;
    BasicButton volver;
    
    

    public puntuacion(Registro registro) {

        setBounds(0, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));

        this.registro = registro;

        volver = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_volver();
                
            }
        };
        volver.setText("volver");
        volver.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        volver.getText().setVerticalAlignment(JLabel.CENTER);
        volver.getText().setHorizontalAlignment(JLabel.CENTER);
        volver.getText().setSize(160, 54);
        volver.setLocation(450, 700);
        volver.setLayout(null);
        volver.setColor(new Color(0, 188, 255));
        volver.setForeground(Color.WHITE);

        add(volver);

        dataset = new DefaultCategoryDataset();
        cargarDatosPuntajesDesdeCSV("score.csv");

        chart = ChartFactory.createBarChart(
                "Mejores Puntajes",
                "Nombre y Apellido", // Etiqueta eje X
                "Puntaje (0-5)", // Etiqueta eje Y
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel chartPanel = new ChartPanel(chart, false);
        //chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        chartPanel.setBounds(0, 0, 1074, 700);
        chartPanel.setMouseWheelEnabled(true); // Habilita el zoom con la rueda del ratón
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setVisible(true);
        setLayout(null);
        add(chartPanel);

        setVisible(true);
    }

    //private void cargarDatosPuntajesDesdeCSV(String archivoCSV) {
        

    private void cargarDatosPuntajesDesdeCSV(String archivoCSV) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            TreeMap<Float, String> puntajesMap = new TreeMap<>(Collections.reverseOrder());
            // TreeMap para ordenar por puntaje de mayor a menor

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String nombre = parts[1]; // Cambia el índice para usar el nombre y apellido correctos
                    String apellido = parts[0];
                    float puntaje = Float.parseFloat(parts[4]); // Cambia el índice para obtener el puntaje
                    puntajesMap.put(puntaje, nombre + " " + apellido);
                }
            }

            int contador = 0;
            for (Map.Entry<Float, String> entry : puntajesMap.entrySet()) {
                float puntaje = entry.getKey();
                String nombreCompleto = entry.getValue();
                dataset.addValue(puntaje, "Puntajes", nombreCompleto);

                contador++;
                if (contador >= 3) { // Solo toma los 3 mejores puntajes
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        
    
        };
    }
    
        /*try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String nombre = parts[1]; // Cambia el índice para usar el nombre y apellido correctos
                    String apellido = parts[0];
                    float puntaje = Float.parseFloat(parts[4]); // Cambia el índice para obtener el puntaje
                    dataset.addValue(puntaje, "Puntajes", nombre + " " + apellido);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }*/
    
    public void evento_volver() {
        registro.remove(this);
        registro.repaint();
        registro.ocultar(true);
        
    }

    
}
