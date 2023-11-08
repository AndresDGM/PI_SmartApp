
package HumanidadesPack;

import AppMainSrc.BasicButton;
import AppMainSrc.HumanidadesMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class EnviarCorreo extends JFrame {
    
    JLabel titulo, imagen;
    //Lab5_Clinica m;
    AppMainSrc.HumanidadesMenu m;
    estructura e;
    BasicButton jbvolver,test1,test2,test3;

    public EnviarCorreo(HumanidadesMenu menu) {
        super("Envio de correo electrónico");
        m = menu;
        setSize(1000, 800);
        getContentPane().setBackground(new Color(2, 1, 61));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        titulo = new JLabel("<html><p align='center'>Clínica Universitaria UCEVA</p></html>");
        titulo.setBounds(334, 38, 238, 96);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arimo", Font.BOLD, 22));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        add(titulo);
        imagen = new JLabel(new ImageIcon("src/images/MakiDoctor.png"));
        imagen.setBounds(550, 35, 95, 95);
        add(imagen);
        CrearGUI();
        
        setVisible(true);
    }

    public EnviarCorreo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void CrearGUI() {
        jbvolver = new BasicButton(100, 50, "Volver") {
            @Override
            public void clickEvent() {
                evento_volver();
            }
        };
        jbvolver.setLocation(655, 700);
        add(jbvolver);
        
        test1 = new BasicButton(300, 100, "enviar correo un solo destinatario") {
            @Override
            public void clickEvent() {
                estructura e = new estructura();
                e.test1();
            }
            };
        test1.setLocation(334, 200);
        add(test1);
        
        test2 = new BasicButton(300, 100, "enviar correo a varios destinatarios") {
            @Override
            public void clickEvent() {
                estructura e = new estructura();
                e.test2();
            }
            };
        test2.setLocation(334, 350);
        add(test2);
            
        test3 = new BasicButton(300, 100, "enviar correo con archivos") {
            @Override
            public void clickEvent() {
                estructura e = new estructura();
                e.test3();
            }
            };
        test3.setLocation(334, 500);
        add(test3);
        }

    
    private void evento_volver() {
        setVisible(false);
        dispose();
        m.setVisible(true);
    }

    
}
