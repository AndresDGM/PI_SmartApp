//Menu de humanidades

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class HumanidadesMenu extends JPanel {

    public JPanel[] capitulo = new JPanel[10];

    private JLabel titulo = new JLabel("Humanidades");

    public BasicButton[] capitulos = new BasicButton[10];
    
    public BackButton menup = new BackButton();
    
    public CapitulosHuma caps = new CapitulosHuma();
    
    private RoundBorder border = new RoundBorder();
    
    public HumanidadesMenu() {

        setSize(1074, 800);
        caracteristicas();        
        
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setBounds(460, 54, 255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(), 24));
        add(titulo);
        setVisible(false);
    }
    
    //reescala y posiciona los componentes segun el tamaño del contenedor
    public void actBounds() {
        titulo.setBounds((int) (getWidth() * 0.38), (int) (getHeight() * 0.067),
                (int) (getWidth() * 0.238), (int) (getHeight() * 0.063));
    }
   
    //asigna tamaño, coordenadas y recursos correspondientes para cada panel de cada capitulo
    public void caracteristicas() {
        
        
        capitulos[0] = new BasicButton() {
            @Override
            public void clickEvent() {
                funBoton(0);
            }
        };
        capitulos[0].setText("capitulo 1");
        capitulos[0].setBounds(100, 200, 190, 200);
        capitulos[0].setForeground(Color.red);
        capitulos[0].setFont(new Font("Arial", capitulos[0].getFont().getStyle(), 24));
        add(capitulos[0]);

        capitulos[1] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[1].setVisible(true);
                caps.getTitulo().setText("Capitulo 2");
                caps.setCapCont(1);
            }
        };
        capitulos[1].setText("capitulo 2");
        capitulos[1].setBounds(300, 200, 190, 200);
        capitulos[1].setForeground(Color.red);
        capitulos[1].setFont(new Font("Arial", capitulos[1].getFont().getStyle(), 24));
        add(capitulos[1]);

        capitulos[2] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[2].setVisible(true);
                caps.getTitulo().setText("Capitulo 3");
                caps.setCapCont(2);
            }
        };
        capitulos[2].setText("capitulo 3");
        capitulos[2].setBounds(500, 200, 190, 200);
        capitulos[2].setForeground(Color.red);
        capitulos[2].setFont(new Font("Arial", capitulos[2].getFont().getStyle(), 24));
        add(capitulos[2]);

        capitulos[3] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[3].setVisible(true);
                caps.getTitulo().setText("Capitulo 4");
                caps.setCapCont(3);
            }
        };
        capitulos[3].setText("capitulo 4");
        capitulos[3].setBounds(700, 200, 190, 200);
        capitulos[3].setForeground(Color.red);
        capitulos[3].setFont(new Font("Arial", capitulos[3].getFont().getStyle(), 24));
        add(capitulos[3]);
        
        capitulos[4] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[4].setVisible(true);
                caps.getTitulo().setText("Capitulo 5");
                caps.setCapCont(4);
            }
        };
        capitulos[4].setText("capitulo 5");
        capitulos[4].setBounds(900, 200, 190, 200);
        capitulos[4].setForeground(Color.red);
        capitulos[4].setFont(new Font("Arial", capitulos[4].getFont().getStyle(), 24));
        add(capitulos[4]);

        capitulos[5] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[5].setVisible(true);
                caps.getTitulo().setText("Capitulo 6");
                caps.setCapCont(5);
            }
        };
        capitulos[5].setText("capitulo 6");
        capitulos[5].setBounds(100, 500, 190, 200);
        capitulos[5].setForeground(Color.red);
        capitulos[5].setFont(new Font("Arial", capitulos[5].getFont().getStyle(), 24));
        add(capitulos[5]);

        capitulos[6] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[6].setVisible(true);
                caps.getTitulo().setText("Capitulo 7");
                caps.setCapCont(6);
            }
        };
        capitulos[6].setText("capitulo 7");
        capitulos[6].setBounds(300, 500, 190, 200);
        capitulos[6].setForeground(Color.red);
        capitulos[6].setFont(new Font("Arial", capitulos[6].getFont().getStyle(), 24));
        add(capitulos[6]);

        capitulos[7] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[7].setVisible(true);
                caps.getTitulo().setText("Capitulo 8");
                caps.setCapCont(7);
            }
        };
        capitulos[7].setText("capitulo 8");
        capitulos[7].setBounds(500, 500, 190, 200);
        capitulos[7].setForeground(Color.red);
        capitulos[7].setFont(new Font("Arial", capitulos[7].getFont().getStyle(), 24));
        add(capitulos[7]);

        capitulos[8] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[8].setVisible(true);
                caps.getTitulo().setText("Capitulo 9");
                caps.setCapCont(8);
            }
        };
        capitulos[8].setText("capitulo 9");
        capitulos[8].setBounds(700, 500, 190, 200);
        capitulos[8].setForeground(Color.red);
        capitulos[8].setFont(new Font("Arial", capitulos[8].getFont().getStyle(), 24));
        add(capitulos[8]);

        capitulos[9] = new BasicButton() {
            @Override
            public void clickEvent() {
                setVisible(false);
                caps.setVisible(true);
                caps.getCapitulos()[9].setVisible(true);
                caps.getTitulo().setText("Capitulo 5");
                caps.setCapCont(9);
            }
        };
        capitulos[9].setText("capitulo 10");
        capitulos[9].setBounds(900, 500, 190, 200);
        capitulos[9].setForeground(Color.red);
        capitulos[9].setFont(new Font("Arial", capitulos[9].getFont().getStyle(), 24));
        add(capitulos[9]);
    }
    
    public void funBoton(int i){
        caps.setVisible(true);
        caps.getCapitulos()[i].setVisible(true);
        caps.getTitulo().setText("Capitulo " + (i+1));
        caps.setCapCont(i);
        setVisible(false);
    }
    
    
    public static void main(String[] args) {
        HumanidadesMenu obj = new HumanidadesMenu();
        App app = new App();

    }

  
    
}
