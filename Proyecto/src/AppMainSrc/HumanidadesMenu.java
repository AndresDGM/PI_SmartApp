package AppMainSrc;

//Menu de humanidades

import AppMainSrc.RoundBorder;
import HumanidadesPack.CapitulosMenu;
import HumanidadesPack.Registro;
//import HumanidadesPack.EnviarCorreo;
import javax.swing.*;
import java.awt.*;



public class HumanidadesMenu extends JPanel {

    

    private JLabel titulo = new JLabel("Humanidades");
    
    private JLabel paneltitulo = new JLabel();

    private RoundBorder border = new RoundBorder();
    
    public Registro regis = new Registro();
    
    public CapitulosMenu menucaps = new CapitulosMenu();
    
    Button registro = new Button();
    
    Button capitulos = new Button();
    
    //HumanidadesPack.Registro r;
    
    
    public HumanidadesMenu() {
        caracteristicas();
        paneltitulo.setBounds(285, 20, 500, 170);  
        cargarImagen();
        add(paneltitulo);
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        setVisible(false);
    }
    
    
    
   
    //asigna tamaño, coordenadas y recursos correspondientes para cada panel de cada capitulo
    public void caracteristicas() {
        
        registro.setContenido(regis, this);
        registro.setTitulo("registrarse");
        registro.setImagenBoton("src/Imagenes/examen.png");
        registro.setLocation(552, 300);
        add(registro);
        
        capitulos.setContenido(menucaps, this);
        capitulos.setImagenBoton("src/Imagenes/ods-4.png");
        capitulos.setTitulo("menu capitulos");
        capitulos.setLocation(181, 300);       
        add(capitulos);
        
        
    }
    
    public void cargarImagen(){
        ImageIcon imagen = new ImageIcon("src/Imagenes/bannerhuma.jpg");
        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance(paneltitulo.getWidth(), paneltitulo.getHeight(),Image.SCALE_DEFAULT));
        paneltitulo.setIcon(icon);
    }

    

   
}
