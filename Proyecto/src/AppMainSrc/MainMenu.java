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
        botones[0].setBounds(255, 109, 341, 250);
        botones[0].setTitulo("Matematicas");
        botones[0].setImagenBoton("src/Imagenes/mate.png");

        botones[1].setBounds(535, 109, 341,250);
        botones[1].setTitulo("Algebra Lineal");
        botones[1].setImagenBoton("src/Imagenes/Algebra.png");

        botones[2].setBounds(255, 450, 341, 250);
        botones[2].setTitulo("Fisica");
        botones[2].setImagenBoton("src/Imagenes/Fisica.png");

        botones[3].setBounds(535, 450, 341, 250);
        botones[3].setTitulo("Humanidades");
        botones[3].setImagenBoton("src/Imagenes/cultura.png");

        border.setLocation(102, 36);
        border.setW(970);
        border.setH(700);

        tituloMenu.setBounds(460, 54,255, 46);
        tituloMenu.setHorizontalAlignment(JLabel.CENTER);
        tituloMenu.setVerticalAlignment(JLabel.CENTER);
        tituloMenu.setForeground(new Color(255,255,255));
        tituloMenu.setFont(new Font("Arial",tituloMenu.getFont().getStyle(),24));

        add(border);
        add(tituloMenu);
    }

    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBoundsMenu(){
        botones[0].setBounds((int) (getWidth()*0.142), (int) (getHeight()*0.1875),
                (int) (getWidth()*0.333), (int) (getHeight()*0.3125));
        botones[0].getTitulo().setBounds(0, (int) (botones[0].getHeight()*0.75),
                botones[0].getWidth(),botones[0].getHeight()/3);
        botones[0].actBounds();

        botones[1].setBounds((int) (getWidth()*0.523), (int) (getHeight()*0.1875),
                (int) (getWidth()*0.333), (int) (getHeight()*0.3125));
        botones[1].getTitulo().setBounds(0, (int) (botones[1].getHeight()*0.75),
                botones[1].getWidth(),botones[1].getHeight()/3);
        botones[1].actBounds();

        botones[2].setBounds((int) (getWidth()*0.142), (int) (getHeight()*0.563),
                (int) (getWidth()*0.333), (int) (getHeight()*0.3125));
        botones[2].getTitulo().setBounds(0, (int) (botones[2].getHeight()*0.75),
                botones[2].getWidth(),botones[2].getHeight()/3);
        botones[2].actBounds();

        botones[3].setBounds((int) (getWidth()*0.523), (int) (getHeight()*0.563),
                (int) (getWidth()*0.333), (int) (getHeight()*0.3125));
        botones[3].getTitulo().setBounds(0, (int) (botones[3].getHeight()*0.75),
                botones[3].getWidth(),botones[3].getHeight()/3);
        botones[3].actBounds();

        border.setLocation((int) (getWidth()*0.047), (int) (getHeight()*0.046));
        border.setW((int) (getWidth()*0.904));
        border.setH((int) (getHeight()*0.875));


        tituloMenu.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }

    //retorna el arreglo de botones
    public Button[] getBotones() {
        return botones;
    }
    
}
