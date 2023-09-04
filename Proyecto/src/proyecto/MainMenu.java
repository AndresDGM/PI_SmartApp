package proyecto;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    private Button[] botones = new Button[5];
    private BorderMenu border = new BorderMenu();
    private JLabel tituloMenu = new JLabel("Menu principal");
    public MainMenu() {
        setSize(1074, 800);
        iniciarBotones();
        iniciarComponentes();
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        setVisible(true);
    }

    public void iniciarBotones(){
        for (int i = 0; i < botones.length; i++){
            botones[i] = new Button();
            add(botones[i]);
        }
    }

    public void iniciarComponentes(){
        botones[0].setBounds(153, 109, 255, 200);
        botones[1].setBounds(460, 108, 255,200);
        botones[2].setBounds(765, 108, 255, 200);
        botones[3].setBounds(255, 450, 255, 200);
        botones[4].setBounds(664, 450, 255, 200);

        border.setBounds(102, 36, 970, 700);

        tituloMenu.setBounds(460, 54,255, 46);
        tituloMenu.setHorizontalAlignment(JLabel.CENTER);
        tituloMenu.setVerticalAlignment(JLabel.CENTER);
        tituloMenu.setForeground(new Color(255,255,255));
        tituloMenu.setFont(new Font("Arial",tituloMenu.getFont().getStyle(),24));

        add(border);
        add(tituloMenu);
    }

    public void actBoundsMenu(){
        botones[0].setBounds((int) (getWidth()*0.095), (int) (getHeight()*0.136),
                (int) (getWidth()*0.238), (int) (getHeight()*0.25));
        botones[0].setTitulo("Matematicas");
        botones[0].getTitulo().setBounds(0, (int) (botones[0].getHeight()*0.75),
                botones[0].getWidth(),botones[0].getHeight()/3);

        botones[1].setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.136),
                (int) (getWidth()*0.238), (int) (getHeight()*0.25));
        botones[1].setTitulo("Algebra Lineal");
        botones[1].getTitulo().setBounds(0, (int) (botones[1].getHeight()*0.75),
                botones[1].getWidth(),botones[1].getHeight()/3);

        botones[2].setBounds((int) (getWidth()*0.667), (int) (getHeight()*0.136),
                (int) (getWidth()*0.238), (int) (getHeight()*0.25));
        botones[2].setTitulo("Fisica");
        botones[2].getTitulo().setBounds(0, (int) (botones[2].getHeight()*0.75),
                botones[2].getWidth(),botones[2].getHeight()/3);

        botones[3].setBounds((int) (getWidth()*0.19), (int) (getHeight()*0.563),
                (int) (getWidth()*0.238), (int) (getHeight()*0.25));
        botones[3].setTitulo("Humanidades");
        botones[3].getTitulo().setBounds(0, (int) (botones[3].getHeight()*0.75),
                botones[3].getWidth(),botones[3].getHeight()/3);

        botones[4].setBounds((int) (getWidth()*0.571), (int) (getHeight()*0.563),
                (int) (getWidth()*0.238), (int) (getHeight()*0.25));
        botones[4].setTitulo("Constitucion");
        botones[4].getTitulo().setBounds(0, (int) (botones[4].getHeight()*0.75),
                botones[4].getWidth(),botones[4].getHeight()/3);

        border.setBounds((int) (getWidth()*0.047), (int) (getHeight()*0.046),
                (int) (getWidth()*0.904), (int) (getHeight()*0.875));


        tituloMenu.setBounds((int) (getWidth()*0.38), (int) (getHeight()*0.067),
                (int) (getWidth()*0.238), (int) (getHeight()*0.063));
    }

    public Button[] getBotones() {
        return botones;
    }
    
}
