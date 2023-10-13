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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


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

    public static void main(String[] args) {
        JFrame j = new JFrame("sus");
        j.setLayout(null);
        j.setSize(1000, 1000);
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        JEditorPane jep = new JEditorPane();
        File file = new File("src/AlgebraPack/HTML/pregunta_1.html");
        try {
            jep.setPage(file.toURI().toURL());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jep.setSize(900,900);
        jep.setEditable(false);
        JScrollPane jsp = new JScrollPane(jep);
        jsp.setBounds(50, 50, 900, 900);
        j.add(jsp);
        j.setVisible(true);
    }

}
