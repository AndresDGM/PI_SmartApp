/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gauss.jordan;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author david
 */
public class GaussJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ven = new JFrame();
        ven.setSize(800,800);
        ven.setBackground(Color.WHITE);
        Matriz mat = new Matriz();
        ven.add(mat);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.setVisible(true);
    }
    
}
