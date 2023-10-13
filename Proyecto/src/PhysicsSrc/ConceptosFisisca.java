/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhysicsSrc;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class ConceptosFisisca extends JPanel{
    
    private JLabel titulo = new JLabel("Conceptos");
    
    public ConceptosFisisca(){
        setBounds(50, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(460, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        add(titulo);
        setVisible(false);
    }
}
