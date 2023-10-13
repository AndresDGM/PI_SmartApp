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
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;


public class Graficadora extends JPanel{
    JLabel titulo, funcion1, funcion2, enunciado, warning_vacio, warning_borrar; 
    RoundTextField[] cajas = new RoundTextField[6];
    String[] info = new String[6];
    BasicButton graficar, borrar;
    EvaluarFunciones ev;
    JPanel ventana_grafico;
    ChartPanel chartPanel;
    Boolean validarText = false;

    public Graficadora() {
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo = new JLabel("Grafica funciones");
        titulo.setBounds(450, 54,255, 46);
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
        RoundBorder bordePrincipal = new RoundBorder(450, 500, 30, 30, 3);
        bordePrincipal.setLocation((int) (getWidth()*0.047), (int) (getHeight()*0.060));
        bordePrincipal.setW((int) (getWidth()*0.904));
        bordePrincipal.setH((int) (getHeight()*0.750));
        add(bordePrincipal);
         
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
        
        warning_vacio = new JLabel("Llene todos los campos de texto");
        warning_vacio.setBounds(35, 350, 500, 80);
        warning_vacio.setForeground(new Color(255,87,87));
        warning_vacio.setFont(new Font("Anton", warning_vacio.getFont().getStyle(),17));
        warning_vacio.setHorizontalAlignment(JLabel.CENTER);
        warning_vacio.setVisible(false);
        add(warning_vacio);
        
        warning_borrar = new JLabel("No hay elementos para borrar");
        warning_borrar.setBounds(35, 350, 500, 80);
        warning_borrar.setForeground(new Color(255,87,87));
        warning_borrar.setFont(new Font("Anton", warning_vacio.getFont().getStyle(),17));
        warning_borrar.setHorizontalAlignment(JLabel.CENTER);
        warning_borrar.setVisible(false);
        add(warning_borrar);
        
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
    
    //método para mostrar por un determinado tiempo el mensaje de advertencia o error
    private void MostrarError(JLabel aviso, int time){
        Timer tiempo = new Timer(time, (e) -> {
            aviso.setVisible(false);
        });
        tiempo.setRepeats(false);
        tiempo.restart();
    }
    
    private void evento_graficar() {
        
        comprobarText();
        if(!validarText){
            warning_vacio.setVisible(true);
            MostrarError(warning_vacio, 2000); //2 segundos
        }else{
            ev = new EvaluarFunciones(info);
            eliminarGrafica();
            
            chartPanel = new ChartPanel(ev.grafico);
            chartPanel.setPreferredSize(new Dimension(420, 420));
            ventana_grafico.add(chartPanel);
            ventana_grafico.revalidate();
            ventana_grafico.repaint();   
        }       
}
    
    private void evento_borrar(){
       if(validarText){
           warning_borrar.setVisible(false);
           eliminarInfo();
           eliminarGrafica();
       } 
       else{
           warning_borrar.setVisible(true);
           MostrarError(warning_borrar, 2000); //2 segundos
       }
    }
    
    private void eliminarInfo() {
        for(int i = 0; i < cajas.length; i++) {
           cajas[i].setText("");
        }
    }
    
    private void eliminarGrafica(){
        if(chartPanel != null){
            ventana_grafico.remove(chartPanel);
            ventana_grafico.revalidate();
            ventana_grafico.repaint();
            // Configura la referencia a null para liberar recursos
            chartPanel = null;
        }      
    }
    
    private void comprobarText() {
        for (int i = 0; i < cajas.length; i++) {
            if(cajas[i].getText().isEmpty()){
                validarText = false;
            }else{
                info[i] = cajas[i].getText();
                validarText = true;
            }
        }
    }
}
