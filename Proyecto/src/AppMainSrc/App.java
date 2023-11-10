package AppMainSrc;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    
    public static MainMenu menu = new MainMenu();
    
    public MathMenu menuMatematicas = new MathMenu();
    
    public PhysicsMenu menuFisica = new PhysicsMenu();

    public AlgebraMenu menuAlgebra = new AlgebraMenu();
    
    public HumanidadesMenu menuHumanidades = new HumanidadesMenu();
            
    public static JPanel lateralBar = new JPanel();
    
    public Programadores programadores = new Programadores();
    
    public Constitucion constitucion = new Constitucion();
    
    public App(){
        super("Smart App");
        setSize(1124, 800);
        ImageIcon icon = new ImageIcon("src/Imagenes/logo.png");
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(46, 46, 46));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        initGui();
        setVisible(true);
    }
    
    public void initGui(){
        lateralBar.setBounds(0,0, 50,getHeight());
        lateralBar.setBackground(new Color(84, 84, 84));
        lateralBar.setLayout(null);
        BackButton bB = new BackButton();
        lateralBar.add(bB);
        menu.setLocation(50,0);
        menuFisica.setApp(this);
        setContenidos();
        BasicButton infoPro = new BasicButton(50, 50, "") {
            @Override
            public void clickEvent() {
                funBotonInfo();
            }
        };
        infoPro.setArcH(0);
        infoPro.setArcW(0);
        infoPro.setOpaque(true);
        infoPro.setLayout(null);
        infoPro.setLocation(0, 0);
        infoPro.setColor(new Color(84,84,84));
        JLabel icon = new JLabel(new ImageIcon("src/Imagenes/Info.png"));
        icon.setBounds(5, 5,40,40);
        infoPro.add(icon);
        lateralBar.add(infoPro, 0);
        BasicButton consBoton = new BasicButton(50, 50, "") {
            @Override
            public void clickEvent() {
                funBotonCons();
            }
        };
        consBoton.setArcH(0);
        consBoton.setArcW(0);
        consBoton.setOpaque(true);
        consBoton.setLayout(null);
        consBoton.setLocation(0, 50);
        consBoton.setColor(new Color(84,84,84));
        JLabel icon2 = new JLabel(new ImageIcon("src/Imagenes/OcticonLaw16.png"));
        icon2.setBounds(5, 5,40,40);
        consBoton.add(icon2);
        lateralBar.add(consBoton);
        add(lateralBar);
        add(menu);
        add(menuMatematicas);
        add(menuAlgebra);
        add(menuFisica);
        add(menuFisica.guia);
        add(menuFisica.mecanicas);
        add(menuHumanidades);
        add(menuHumanidades.menucaps.caps);
        add(menuMatematicas.graficadora);
        add(menuMatematicas.derivar);
        add(menuAlgebra.teoriaAlgebra);
        add(menuAlgebra.detCalculator);
        add(menuAlgebra.gaussJordan);
        add(menuAlgebra.invCalculator);
        add(menuHumanidades.regis);
        add(menuHumanidades.menucaps);
        add(programadores);
        add(constitucion);
    }
    
    public void funBotonInfo(){
        BackButton b = (BackButton) lateralBar.getComponent(1);
        for (JPanel j : b.getAntContenidos()) {
            if(j.isVisible()){
                j.setVisible(false);
            }
        }
        programadores.setVisible(true);
        lateralBar.getComponent(0).setVisible(false);
        lateralBar.getComponent(2).setVisible(false);
        b.getAntContenidos().add(programadores);
        b.setVisible(true);
    }
    
    public void funBotonCons(){
        BackButton b = (BackButton) lateralBar.getComponent(1);
        for (JPanel j : b.getAntContenidos()) {
            if(j.isVisible()){
                j.setVisible(false);
            }
        }
        constitucion.setVisible(true);
        lateralBar.getComponent(0).setVisible(false);
        lateralBar.getComponent(2).setVisible(false);
        b.getAntContenidos().add(constitucion);
        b.setVisible(true);
    }

    //asigna los contenidos a mostrar y ocultar por los botones respectivamente
    public void setContenidos() {
        Button[] b = menu.getBotones();
        b[0].setContenido(menuMatematicas, menu);
        b[1].setContenido(menuAlgebra, menu);
        b[2].setContenido(menuFisica, menu);
        b[3].setContenido(menuHumanidades, menu);
    }
}