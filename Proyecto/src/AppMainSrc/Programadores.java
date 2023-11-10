/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppMainSrc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class Programadores extends JPanel{
    private JLabel[] codigos = new JLabel[5], nombres = new JLabel[5],fotos = new JLabel[5];
    private String[] noms = {"Andres Guevara","Juan Santiago", "Sebastian Morales", "Nicolas Gutierrez", "Miguel Ruiz"},
            cods = {"230231022","230231009", "230231002", "2302310129","230231023"};
    private JLabel titulo  = new JLabel("Desarrolladores");
    
    public Programadores() {
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(409, 54,255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(),24));
        setLayout(null);
        datos();
        add(titulo);
        setVisible(false);
    }

    public void datos() {
        int j = 0;
        for (int i = 0; i < 5; i++, j += 180) {
            fotos[i] = new JLabel(imagen("src/imagenes/foto"+(i+1)+".jpg"));
            fotos[i].setBounds(87 + j, 250, 150, 200);
            add(fotos[i]);
            
            nombres[i] = new JLabel("Nombre: " + noms[i]);
            nombres[i].setBounds(72 + j, 500, 180, 30);
            nombres[i].setForeground(new Color(255,255,255));
            nombres[i].setHorizontalAlignment(JLabel.CENTER);
            add(nombres[i]);

            codigos[i] = new JLabel("codigo: "+ cods[i]);
            codigos[i].setBounds(87 + j, 540, 150, 30);
            codigos[i].setForeground(new Color(255,255,255));
            codigos[i].setHorizontalAlignment(JLabel.CENTER);
            add(codigos[i]);
        }
    }
    
    public Icon imagen(String source){
        ImageIcon imagen = new ImageIcon(source);
        float scale = (float)  200/imagen.getIconHeight();
        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance((int) (imagen.getIconWidth()*scale), (int) (imagen.getIconHeight()*scale), Image.SCALE_DEFAULT));
        return icon;
    }
}
