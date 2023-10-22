package HumanidadesPack;

import AppMainSrc.BasicButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class CapitulosHuma extends JPanel {

    private JScrollPane[] Capitulos = new JScrollPane[10];

    private JLabel titulo = new JLabel();

    private BasicButton botonSiguiente, botonAnterior;

    int capCont = 0;

    public CapitulosHuma() {
        setBounds(50, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", Font.PLAIN, 24));
        titulo.setBounds(457, 10, 160, 50);
        InitCaps();
        botonSiguiente = new BasicButton() {
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if (capCont < 9) {
                    Capitulos[capCont + 1].setVisible(true);
                    capCont++;
                    titulo.setText("Capitulo " + (capCont + 1));
                } else {
                    Capitulos[0].setVisible(true);
                    capCont = 0;
                    titulo.setText("Capitulo " + (capCont + 1));
                }
            }
        };
        botonSiguiente.setLocation(850, 700);
        botonSiguiente.setText("Siguiente");
        add(botonSiguiente);

        botonAnterior = new BasicButton() {
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if (capCont > 0) {
                    Capitulos[capCont - 1].setVisible(true);
                    capCont--;
                    titulo.setText("Capitulo " + (capCont + 1));
                } else {
                    Capitulos[9].setVisible(true);
                    capCont = 9;
                    titulo.setText("Capitulo " + (capCont + 1));
                }
            }
        };
        botonAnterior.setLocation(50, 700);
        botonAnterior.setText("Anterior");
        add(botonAnterior);
        add(titulo);
        setVisible(false);
    }

    public void InitCaps() {
        for (int i = 0; i < Capitulos.length; i++) {

            JEditorPane jep = new JEditorPane();
            File file = new File("src/HumanidadesPack/HTMLcaps/Cap"+ (i + 1) +".html");
            try {
                jep.setPage(file.toURI().toURL());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            jep.setBounds(0, 0, 700, 650);
            jep.setBackground(new Color(46, 46, 46));
            jep.setBorder(null);
            jep.setEditable(false);
            jep.addHyperlinkListener(new HyperlinkListener() {
                @Override
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
            });
            Capitulos[i] = new JScrollPane(jep);
            Capitulos[i].setBounds(187, 100, 700, 550);
            Capitulos[i].setBorder(null);
            Capitulos[i].setVisible(false);
            add(Capitulos[i]);
        };

    }

    public JScrollPane[] getCapitulos() {
        return Capitulos;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public int getCapCont() {
        return capCont;
    }

    public void setCapCont(int capCont) {
        this.capCont = capCont;
    }
}
