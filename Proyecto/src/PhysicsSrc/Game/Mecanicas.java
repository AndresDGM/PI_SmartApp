package PhysicsSrc.Game;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Mecanicas extends JPanel {
     private JScrollPane js;
    
    private JLabel titulo = new JLabel("Guia");
    
    public Mecanicas(){
        setBounds(50, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", Font.PLAIN, 24));
        titulo.setBounds(457, 10, 160, 50);
        add(titulo);
        JEditorPane jep = new JEditorPane();
            File file = new File("src/PhysicsSrc/Recursos/Guia.html");
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
        js = new JScrollPane(jep);
        js.setBounds(182, 100, 700, 660);
        js.setBorder(null);
        add(js);
        setVisible(false); 
    }
}
