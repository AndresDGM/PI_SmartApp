/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gauss.jordan;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author david
 */
public class botonDimencion extends JPanel{
    
    private JLabel mensaje = new JLabel("subir");
    private Matriz mat = new Matriz();
    
    public botonDimencion(){
        add(mensaje);
        accionMouse();
    }
    
    public void accionMouse(){
        MouseListener m = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String dato;
                dato = Matriz.dimension.getText();
                Matriz.n = Integer.parseInt(dato);
                mat.iniciarMat();
                setVisible(false);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        addMouseListener(m);
    }
    }
