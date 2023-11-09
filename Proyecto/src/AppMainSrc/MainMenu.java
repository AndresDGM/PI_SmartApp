package AppMainSrc;//menu principal

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    //arreglo con los botones de las categorias pricipales
    private Button[] botones = new Button[4];

    //borde azul del menu
    private RoundBorder border = new RoundBorder();
    
    private JLabel tituloMenu = new JLabel("Menu principal");
    
    public MainMenu() {
        setSize(1074, 800);
        setLocation(50,0);
        iniciarBotones();
        iniciarComponentes();
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        setVisible(true);
    }

    //inicializa los botones del arreglo
    public void iniciarBotones(){
        for (int i = 0; i < botones.length; i++){
            botones[i] = new Button();
            add(botones[i]);
        }
    }

    //asigna tamaño, coordenadas y recursos correspondientes para cada componente
    public void iniciarComponentes(){
        botones[0].setBounds(153, 150, 341, 250);
        botones[0].setTitulo("Matematicas");
        botones[0].setImagenBoton("src/Imagenes/mate.png");

        botones[1].setBounds(561, 150, 341,250);
        botones[1].setTitulo("Algebra Lineal");
        botones[1].setImagenBoton("src/Imagenes/algebrateoria.png");

        botones[2].setBounds(153, 450, 341, 250);
        botones[2].setTitulo("Fisica");
        botones[2].setImagenBoton("src/Imagenes/Fisica.png");

        botones[3].setBounds(561, 450, 341, 250);
        botones[3].setTitulo("Humanidades");
        botones[3].setImagenBoton("src/Imagenes/cultura.png");

        border.setLocation(50, 37);
        border.setW(970);
        border.setH(700);

        tituloMenu.setBounds(408, 54,255, 46);
        tituloMenu.setHorizontalAlignment(JLabel.CENTER);
        tituloMenu.setVerticalAlignment(JLabel.CENTER);
        tituloMenu.setForeground(new Color(255,255,255));
        tituloMenu.setFont(new Font("Arial",tituloMenu.getFont().getStyle(),24));

        add(border);
        add(tituloMenu);
    }

    //retorna el arreglo de botones
    public Button[] getBotones() {
        return botones;
    }
    
}
