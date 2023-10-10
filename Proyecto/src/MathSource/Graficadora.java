/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathSource;

import AppMainSrc.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;


public class Graficadora extends JPanel{
    JLabel titulo, funcion1, funcion2, enunciado;
    RoundTextField[] cajas = new RoundTextField[6];
    String[] info = new String[6];
    BasicButton graficar, borrar;
    EvaluarFunciones ev;
    JPanel ventana_grafico;
    ChartPanel panel;

    public Graficadora() {
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo = new JLabel("Grafica funciones");
        titulo.setBounds(460, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        crearCajas();
        componente();
        crearGUI();
        setVisible(false);
    }
    
    private void crearGUI() {
        RoundBorder borde = new RoundBorder(450, 450, 30, 30, 3);
        borde.setLocation(470, 170);
        add(borde);
        ventana_grafico = new JPanel();
        ventana_grafico.setBackground(new Color(46,46,46));
        ventana_grafico.setBounds(470, 180, 450, 450); 
        ventana_grafico.setOpaque(false);
        add(ventana_grafico);
        
        enunciado = new JLabel("Ingresa dos funciones (lineal o cuadrática) que desees graficar con sus intervalos correspondientes.");
        enunciado.setBounds((1074-900)/2, 100, 900, 80);
        enunciado.setHorizontalAlignment(JLabel.RIGHT);
        enunciado.setVerticalAlignment(JLabel.CENTER);
        enunciado.setForeground(new Color(255,255,255));
        enunciado.setFont(new Font("Anton", enunciado.getFont().getStyle(),18));
        add(enunciado);
        
        funcion1 = new JLabel("Función 1: ");
        funcion1.setBounds(55, 220, 150, 30);
        funcion1.setHorizontalAlignment(JLabel.RIGHT);
        funcion1.setVerticalAlignment(JLabel.CENTER);
        funcion1.setForeground(new Color(255,255,255));
        funcion1.setFont(new Font("Anton", funcion1.getFont().getStyle(),20));
        add(funcion1);
        
        funcion2 = new JLabel("Función 2: ");
        funcion2.setBounds(55, 270, 150, 30);
        funcion2.setHorizontalAlignment(JLabel.RIGHT);
        funcion2.setVerticalAlignment(JLabel.CENTER);
        funcion2.setForeground(new Color(255,255,255));
        funcion2.setFont(new Font("Anton", funcion2.getFont().getStyle(),20));
        add(funcion2);
        
        graficar = new BasicButton(){
            @Override
            public void clickEvent(){
                 evento_graficar();
            }
        };
        graficar.setText("Graficar");
        graficar.setBounds(99, 320, 127, 40);
        graficar.setColor(new Color(56, 184, 250));
        graficar.getText().setForeground(new Color(46,46,46));
        graficar.getText().setFont(new Font("Anton", graficar.getFont().getStyle(),17));
        add(graficar);
        
        borrar = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_borrar();
            }
        };
        borrar.setText("Borrar");
        borrar.setBounds(230, 320, 129, 40);
        borrar.setColor(new Color(255, 87, 87));
        borrar.getText().setForeground(new Color(255,255,255));
        borrar.getText().setFont(new Font("Anton", borrar.getFont().getStyle(),17));
        add(borrar);
    }
    
    private void crearCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new RoundTextField(50, 50);
            cajas[i].setText("");
            cajas[i].getTextField().setFont(new Font("Anton", Font.PLAIN,20));
            cajas[i].getRoundBorder().setBackground(new Color(0, 188, 255));
            add(cajas[i]);
        }
    }

    private void componente() {
        cajas[0].setLocation(210,220);
        cajas[0].setTam(150, 50);
        cajas[0].setBackground(new Color(166,166,166));
        
        cajas[1].setLocation(210,270);
        cajas[1].setTam(150, 50);
        cajas[1].setBackground(new Color(166,166,166));
        
        //Intervalos de las funciones
        cajas[2].setLocation(360, 220);
        cajas[2].setBackground(new Color(166,166,166));
        
        cajas[3].setLocation(410, 220);
        cajas[3].setBackground(new Color(166,166,166));
        
        cajas[4].setLocation(360, 270);
        cajas[4].setBackground(new Color(166,166,166));
        
        cajas[5].setLocation(410, 270);
        cajas[5].setBackground(new Color(166,166,166));
    }
    
    private void evento_graficar() {
        extraerInfo();
        ev = new EvaluarFunciones(info);
        //Verifica si hay un panel
        if(ventana_grafico.getComponents() != null){
            eliminarGrafica();
        }
        panel = new ChartPanel(ev.grafico);
        panel.setPreferredSize(new Dimension(420, 420));
        ventana_grafico.add(panel);
        ventana_grafico.revalidate();
        ventana_grafico.repaint();
        
}
    private void evento_borrar(){
       eliminarInfo();
       eliminarGrafica();
    }
    private void eliminarInfo() {
        for (int i = 0; i < cajas.length; i++) {
           cajas[i].setText(" ");
        }
    }
    
    private void eliminarGrafica(){
        // Verifica si el ChartPanel no es nulo y elimínalo del JPanel
    if (panel != null) {
        ventana_grafico.remove(panel);
        ventana_grafico.revalidate();
        ventana_grafico.repaint();
        // Configura la referencia a null para liberar recursos
        panel = null;
    }
    }
    
    private void extraerInfo() {
        for (int i = 0; i < cajas.length; i++) {
            info[i] = cajas[i].getText();
        }
    }
}
