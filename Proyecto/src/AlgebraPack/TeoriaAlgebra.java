/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgebraPack;
    
import AppMainSrc.BasicButton;
import AppMainSrc.RoundBorder;
import AppMainSrc.RoundTextField;

import javax.swing.*;
import java.awt.*;



public class TeoriaAlgebra  extends JPanel{
    //variables
    private RoundBorder border;
    
    public TeoriaAlgebra(){
        setSize(1074, 800);
        setLayout(null);
        setLocation(50,0);
        setBackground(new Color(46,46,46));
        border = new RoundBorder(720, 450, 50, 50, 5);
        border.setLocation(177, 173);
    }
}
