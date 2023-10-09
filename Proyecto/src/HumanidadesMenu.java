//Menu de humanidades

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class HumanidadesMenu extends JPanel {

    public JPanel[] capitulo = new JPanel[10];

    private JLabel titulo = new JLabel("Humanidades");

    public BasicButton[] capitulos = new BasicButton[10];

    public HumanidadesMenu() {

        setSize(1074, 800);
        iniciar_caps();
        caracteristicas();
        jpaneles();
        paginas();
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

    //inicializa los capitulos de los jpaneles
    public void iniciar_caps() {
        for (int i = 0; i < capitulos.length; i++) {
            capitulos[i] = new BasicButton() {
                @Override
                public void clickEvent() {

                    for (int j = 0; j < 10; j++) {
                        if (capitulos[j] == this) {
                            capitulo[j].setVisible(true);
                            capitulos[j].setVisible(false);
                        } else {
                            capitulos[j].setVisible(false);
                        }
                    }
                }
            };
            add(capitulos[i]);
        }
    }

    //asigna tamaño, coordenadas y recursos correspondientes para cada panel de cada capitulo
    public void caracteristicas() {

        capitulos[0].setText("capitulo 1");
        capitulos[0].setBounds(100, 200, 190, 200);
        capitulos[0].setForeground(Color.red);
        capitulos[0].setFont(new Font("Arial", capitulos[0].getFont().getStyle(), 24));

        capitulos[1].setText("capitulo 2");
        capitulos[1].setBounds(300, 200, 190, 200);
        capitulos[1].setForeground(Color.red);
        capitulos[1].setFont(new Font("Arial", capitulos[1].getFont().getStyle(), 24));

        capitulos[2].setText("capitulo 3");
        capitulos[2].setBounds(500, 200, 190, 200);
        capitulos[2].setForeground(Color.red);
        capitulos[2].setFont(new Font("Arial", capitulos[2].getFont().getStyle(), 24));

        capitulos[3].setText("capitulo 4");
        capitulos[3].setBounds(700, 200, 190, 200);
        capitulos[3].setForeground(Color.red);
        capitulos[3].setFont(new Font("Arial", capitulos[3].getFont().getStyle(), 24));

        capitulos[4].setText("capitulo 5");
        capitulos[4].setBounds(900, 200, 190, 200);
        capitulos[4].setForeground(Color.red);
        capitulos[4].setFont(new Font("Arial", capitulos[4].getFont().getStyle(), 24));

        capitulos[5].setText("capitulo 6");
        capitulos[5].setBounds(100, 500, 190, 200);
        capitulos[5].setForeground(Color.red);
        capitulos[5].setFont(new Font("Arial", capitulos[5].getFont().getStyle(), 24));

        capitulos[6].setText("capitulo 7");
        capitulos[6].setBounds(300, 500, 190, 200);
        capitulos[6].setForeground(Color.red);
        capitulos[6].setFont(new Font("Arial", capitulos[6].getFont().getStyle(), 24));

        capitulos[7].setText("capitulo 8");
        capitulos[7].setBounds(500, 500, 190, 200);
        capitulos[7].setForeground(Color.red);
        capitulos[7].setFont(new Font("Arial", capitulos[7].getFont().getStyle(), 24));

        capitulos[8].setText("capitulo 9");
        capitulos[8].setBounds(700, 500, 190, 200);
        capitulos[8].setForeground(Color.red);
        capitulos[8].setFont(new Font("Arial", capitulos[8].getFont().getStyle(), 24));

        capitulos[9].setText("capitulo 10");
        capitulos[9].setBounds(900, 500, 190, 200);
        capitulos[9].setForeground(Color.red);
        capitulos[9].setFont(new Font("Arial", capitulos[9].getFont().getStyle(), 24));
    }

    public void jpaneles() {

        capitulo[0] = new JPanel();
        JLabel cap1 = new JLabel("capitulo 1");
        capitulo[0].add(cap1);
        capitulo[0].setBounds(120, 150, 900, 600);
        capitulo[0].setForeground(Color.red);
        capitulo[0].setVisible(false);
        capitulo[0].setLayout(null);
        add(capitulo[0]);

        capitulo[1] = new JPanel();
        JLabel cap2 = new JLabel("capitulo 2");
        capitulo[1].add(cap2);
        capitulo[1].setBounds(300, 200, 190, 200);
        capitulo[1].setForeground(Color.red);
        capitulo[1].setVisible(false);
        capitulo[1].setLayout(null);
        add(capitulo[1]);

        capitulo[2] = new JPanel();
        JLabel cap3 = new JLabel("capitulo 3");
        capitulo[2].add(cap3);
        capitulo[2].setBounds(500, 200, 190, 200);
        capitulo[2].setForeground(Color.red);
        capitulo[2].setVisible(false);
        capitulo[2].setLayout(null);
        add(capitulo[2]);

        capitulo[3] = new JPanel();
        JLabel cap4 = new JLabel("capitulo 4");
        capitulo[3].add(cap4);
        capitulo[3].setBounds(700, 200, 190, 200);
        capitulo[3].setForeground(Color.red);
        capitulo[3].setVisible(false);
        capitulo[3].setLayout(null);
        add(capitulo[3]);

        capitulo[4] = new JPanel();
        JLabel cap5 = new JLabel("capitulo 5");
        capitulo[4].add(cap5);
        capitulo[4].setBounds(900, 200, 190, 200);
        capitulo[4].setForeground(Color.red);
        capitulo[4].setVisible(false);
        capitulo[4].setLayout(null);
        add(capitulo[4]);

        capitulo[5] = new JPanel();
        JLabel cap6 = new JLabel("capitulo 6");
        capitulo[5].add(cap6);
        capitulo[5].setBounds(100, 500, 190, 200);
        capitulo[5].setForeground(Color.red);
        capitulo[5].setVisible(false);
        capitulo[5].setLayout(null);
        add(capitulo[5]);

        capitulo[6] = new JPanel();
        JLabel cap7 = new JLabel("capitulo 7");
        capitulo[6].add(cap7);
        capitulo[6].setBounds(300, 500, 190, 200);
        capitulo[6].setForeground(Color.red);
        capitulo[6].setVisible(false);
        capitulo[6].setLayout(null);
        add(capitulo[6]);

        capitulo[7] = new JPanel();
        JLabel cap8 = new JLabel("capitulo 8");
        capitulo[7].add(cap8);
        capitulo[7].setBounds(500, 500, 190, 200);
        capitulo[7].setForeground(Color.red);
        capitulo[7].setVisible(false);
        capitulo[7].setLayout(null);
        add(capitulo[7]);

        capitulo[8] = new JPanel();
        JLabel cap9 = new JLabel("capitulo 9");
        capitulo[8].add(cap9);
        capitulo[8].setBounds(700, 500, 190, 200);
        capitulo[8].setForeground(Color.red);
        capitulo[8].setVisible(false);
        capitulo[8].setLayout(null);
        add(capitulo[8]);

        capitulo[9] = new JPanel();
        JLabel cap10 = new JLabel("capitulo 10");
        capitulo[9].add(cap10);
        capitulo[9].setBounds(900, 500, 190, 200);
        capitulo[9].setForeground(Color.red);
        capitulo[9].setVisible(false);
        capitulo[9].setLayout(null);
        add(capitulo[9]);

    }

    public void paginas() {
        JEditorPane capitulo1 = new JEditorPane();
        capitulo1.setContentType("text/html");

        URL url = getClass().getResource("imagenes/logo.png");

        capitulo1.setText(
                "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
                + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
                + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplican formato al texto y se muestra un imagen. Ejemplo en código fuente.<br><br>"
                + "<div align='center'><img src=" + url + " width=200 height=200></div><br>"
                + "{ ... } <a href = 'https://bit.ly/3uEnVup'>Código fuente</a><br>"
                + "🎬 <a href = 'https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>");

        capitulo1.setEditable(false);//mostrar solo codigo HTML

        capitulo1.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(e.getURL().toURI());
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
        );

        JScrollPane js = new JScrollPane(capitulo1);
        js.setBounds(0, 0, 900, 600);
        
        capitulo[0].add(js);
    }

    public static void main(String[] args) {
        HumanidadesMenu obj = new HumanidadesMenu();
        App app = new App();

    }
}
