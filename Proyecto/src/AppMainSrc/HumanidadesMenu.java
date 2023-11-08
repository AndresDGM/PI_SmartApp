package AppMainSrc;

//Menu de humanidades

import AppMainSrc.App;
import AppMainSrc.RoundBorder;
import AppMainSrc.BackButton;
import AppMainSrc.BasicButton;
import HumanidadesPack.CapitulosHuma;
import HumanidadesPack.CapitulosMenu;
import HumanidadesPack.Registro;
//import HumanidadesPack.EnviarCorreo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;


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
        /*titulo.setBounds(460, 54, 255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(), 24));
        add(titulo);*/
        setVisible(false);
    }
    
    
    
   
    //asigna tamaño, coordenadas y recursos correspondientes para cada panel de cada capitulo
    public void caracteristicas() {
        
        registro.setContenido(regis, this);
        registro.setTitulo("registrarse");
        registro.setLocation(552, 300);
        add(registro);
        
        capitulos.setContenido(menucaps, this);
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
