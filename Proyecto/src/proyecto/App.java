
package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class App extends JFrame {

    public static MainMenu menu = new MainMenu();
    public MathMenu menuMatematicas = new MathMenu();
    public PhysicsMenu menuFisica = new PhysicsMenu();
    public AlgebraMenu menuAlgebra = new AlgebraMenu();
    public HumanidadesMenu menuHumanidades = new HumanidadesMenu();
    public ConstitucionMenu menuConstitucion = new ConstitucionMenu();
    public static JPanel lateralBar = new JPanel();
    public App(){
        setSize(1124, 800);

        lateralBar.setBounds(0,0, 50,getHeight());
        lateralBar.setBackground(new Color(84, 84, 84));
        lateralBar.setLayout(null);
        LateralButton lB = new LateralButton();
        BackButton bB = new BackButton();
        lB.setLateralBar(lateralBar);
        bB.setLateralBar(lateralBar);
        lateralBar.add(lB);
        lateralBar.add(bB);

        menu.setBounds(0,0,getWidth()-lateralBar.getWidth(),getHeight());
        setContenidos();

        setLocale(null);
        getContentPane().setBackground(new Color(46, 46, 46));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        add(lateralBar);
        add(menu);
        add(menuMatematicas);
        add(menuAlgebra);
        add(menuFisica);
        add(menuHumanidades);
        add(menuConstitucion);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                actBounds();
                super.componentResized(e);
            }
        });
        setVisible(true);
    }

    public void actBounds(){
        menu.setBounds(50, 0, getWidth()-50, getHeight());
        menu.actBoundsMenu();
        lateralBar.setBounds(0,0, lateralBar.getWidth(),getHeight());
    }

    public void setContenidos() {
        Button[] b = menu.getBotones();
        b[0].setContenido(menuMatematicas);
        b[1].setContenido(menuAlgebra);
        b[2].setContenido(menuFisica);
        b[3].setContenido(menuHumanidades);
        b[4].setContenido(menuConstitucion);
    }
}