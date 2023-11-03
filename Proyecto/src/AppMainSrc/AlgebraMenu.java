package AppMainSrc;//Menu de algebra

import AlgebraPack.DetCalculator;
import AlgebraPack.ExamenAlgebra;
import AlgebraPack.GaussJordan;
import AlgebraPack.SubMenuAlgExam;
import AlgebraPack.SubMenuAlgOpera;
import AlgebraPack.TeoriaAlgebra;
import javax.swing.*;
import java.awt.*;

public class AlgebraMenu extends JPanel {

    public GaussJordan gaussJordan = new GaussJordan();
    
    public SubMenuAlgExam subMenuAlgExam = new SubMenuAlgExam();

    public SubMenuAlgOpera subMenuAlgOpera = new SubMenuAlgOpera();
    
    public DetCalculator detCalculator = new DetCalculator();
    
    public ExamenAlgebra examenAlgebra = new ExamenAlgebra();
    
    public TeoriaAlgebra teoriaAlgebra = new TeoriaAlgebra();

    private Button[] botones = new Button[2];

    private JLabel titulo = new JLabel("Algebra Lineal");

    public AlgebraMenu(){
        setBounds(50, 0,1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(410, 54,255, 46);
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
        botones[0].setContenido(subMenuAlgOpera, this);
        botones[0].setLocation(552, 300);
        botones[0].setImagenBoton("src/Imagenes/algebrateoria.png");
        botones[0].setTitulo("Matrices y Vectores");
        botones[1]= new AppMainSrc.Button();
        botones[1].setContenido(subMenuAlgExam, this);
        botones[1].setLocation(181,300);
        botones[1].setImagenBoton("src/Imagenes/examenalgebra.png");
        botones[1].setTitulo("Conceptos y Examen");
        add(botones[0]);
        add(botones[1]);
    }
}
