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
    
    public App(){
        super("Smart App");
        setSize(1124, 800);

        lateralBar.setBounds(0,0, 50,getHeight());
        lateralBar.setBackground(new Color(84, 84, 84));
        lateralBar.setLayout(null);
        LateralButton lB = new LateralButton();
        BackButton bB = new BackButton();
        lB.setLateralBar(lateralBar);
        lateralBar.add(lB);
        lateralBar.add(bB);

        menu.setLocation(50,0);
        setContenidos();

        ImageIcon icon = new ImageIcon("src/Imagenes/logo.png");
        menuFisica.setApp(this);
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(46, 46, 46));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
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
        setVisible(true);
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