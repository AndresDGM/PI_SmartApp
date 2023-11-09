/*
Clase destinanda a la solución de derivadas, el usuario ingresa una función, 
 */
package MathSource;

import AppMainSrc.BasicButton;
import AppMainSrc.RoundBorder;
import AppMainSrc.RoundTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Derivada extends JPanel{
    JLabel titulo, enunciado, funcion, derivada;
    BasicButton derivar, borrar;
    RoundTextField ingresar, resultado;
    String expresion;
    JLabel advertencia = new JLabel("No has ingresado una función para derivar");

    public Derivada() {
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo = new JLabel("Calcula la derivada");
        titulo.setBounds(450, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        CrearGUI();
        setVisible(false);
    }

    private void CrearGUI() {
        RoundBorder bordePrincipal = new RoundBorder(450, 500, 30, 30, 3);
        bordePrincipal.setLocation((int) (getWidth()*0.047), (int) (getHeight()*0.060));
        bordePrincipal.setW((int) (getWidth()*0.904));
        bordePrincipal.setH((int) (getHeight()*0.750));
        add(bordePrincipal);
        
        advertencia.setBounds((1074-900)/2, 420, 900, 80);
        advertencia.setForeground(new Color(255,87,87));
        advertencia.setFont(new Font("Anton", advertencia.getFont().getStyle(),17));
        advertencia.setHorizontalAlignment(JLabel.CENTER);
        advertencia.setVisible(false);
        add(advertencia);
        
        enunciado = new JLabel("En el siguiente apartado debes ingresar una función que desees derivar");
        enunciado.setBounds((1074-900)/2, 105, 900, 80);
        enunciado.setHorizontalAlignment(JLabel.CENTER);
        enunciado.setVerticalAlignment(JLabel.CENTER);
        enunciado.setForeground(new Color(255,255,255));
        enunciado.setFont(new Font("Anton", enunciado.getFont().getStyle(),18));
        add(enunciado);
        
        funcion = new JLabel("Función:");
        funcion.setBounds(320, 250, 150, 30);
        funcion.setHorizontalAlignment(JLabel.RIGHT);
        funcion.setVerticalAlignment(JLabel.CENTER);
        funcion.setForeground(new Color(255,255,255));
        funcion.setFont(new Font("Anton", funcion.getFont().getStyle(),20));
        add(funcion);
        
        derivada = new JLabel("Derivada:");
        derivada.setBounds(325, 325, 150, 30);
        derivada.setHorizontalAlignment(JLabel.RIGHT);
        derivada.setVerticalAlignment(JLabel.CENTER);
        derivada.setForeground(new Color(255,255,255));
        derivada.setFont(new Font("Anton", derivada.getFont().getStyle(),20));
        add(derivada);
        
        ingresar = new RoundTextField(50, 50);
        ingresar.getTextField().setFont(new Font("Anton", Font.PLAIN,20));
        ingresar.getRoundBorder().setBackground(new Color(0, 188, 255));
        ingresar.setLocation(500,238);
        ingresar.setTam(170, 50);
        ingresar.setText("");
        add(ingresar);
        
        resultado = new RoundTextField(50, 50);
        resultado.getTextField().setFont(new Font("Anton", Font.PLAIN,20));
        resultado.getRoundBorder().setBackground(new Color(0, 188, 255));
        resultado.setLocation(500,315);
        resultado.setTam(170, 50);
        resultado.setEditable(false);
        resultado.setText("");
        add(resultado);
        
        derivar = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_derivar();
                resultado.setEditable(true);
            }
        };
        derivar.setText("Derivar");
        derivar.setBounds(410, 400, 115, 40);
        derivar.setColor(new Color(56, 184, 250));
        derivar.getText().setForeground(new Color(46,46,46));
        derivar.getText().setFont(new Font("Anton", derivar.getFont().getStyle(),17));
        add(derivar);
        
        borrar = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_borrar();
                resultado.setEditable(false);
            }
        };
        borrar.setText("Borrar");
        borrar.setBounds(535, 400, 115, 40);
        borrar.setColor(new Color(255, 87, 87));
        borrar.getText().setForeground(new Color(255,255,255));
        borrar.getText().setFont(new Font("Anton", derivar.getFont().getStyle(),17));
        add(borrar);  
    }
    
    private void evento_derivar() {
        if(ingresar.getText().isEmpty()){  //valida si hay información o no
            advertencia.setVisible(true);
            resultado.setText(""); // Limpiar el campo de resultado
        }else{
           expresion = ingresar.getText(); //se obtiene la información ingresada en el jtextfield
           CalcularDerivada dev = new CalcularDerivada(expresion); //se le envía a la clase Calcular derivada la expresion
           resultado.setText(dev.getDerivada());  //se obtiene escribe el resultado obtenido en el jtextfield 
           advertencia.setVisible(false);
        }  
    }
    
    private void evento_borrar(){
        ingresar.setText("");
        resultado.setText("");
    }
}