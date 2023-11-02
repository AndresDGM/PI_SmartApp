/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgebraPack;

import AppMainSrc.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SubMenuAlgExam  extends JPanel{
    public ExamenAlgebra examenAlgebra = new ExamenAlgebra();
    
    public TeoriaAlgebra teoriaAlgebra = new TeoriaAlgebra();
    
    private JLabel titulo = new JLabel("Conceptos y Examen");
    
    private Button[] botones = new Button[2];
    
    public SubMenuAlgExam(){
        setBounds(50, 0,1074,800);
        setBackground(new Color(46,46,46));
        setLayout(null);
        titulo.setBounds(410, 54, 255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        initBotones();
        setVisible(false);
    }
    public void initBotones(){
        botones[0]= new AppMainSrc.Button();
        botones[0].setContenido(teoriaAlgebra, this);
        botones[0].setLocation(552, 300);
        botones[0].setImagenBoton("src/Imagenes/algebrateoria.png");
        botones[0].setTitulo("Definiciones");
        botones[1]= new AppMainSrc.Button();
        botones[1].setContenido(examenAlgebra, this);
        botones[1].setLocation(181,300);
        botones[1].setImagenBoton("src/Imagenes/examenalgebra.png");
        botones[1].setTitulo("Examen Diagnostico");
        add(botones[0]);
        add(botones[1]);
    }
}
