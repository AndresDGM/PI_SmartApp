package MathSource;

import AppMainSrc.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;

public class Graficadora extends JPanel {

    JLabel titulo, funcion1, funcion2, enunciado, warning, tipo_recta, puntosCorte, derivada1, derivada2, Max_min1, Max_min2;
    RoundTextField[] cajas = new RoundTextField[4];
    JLabel[] informacion = new JLabel[6];
    String[] info = new String[4];
    BasicButton borrar, graficar1, graficar2;
    EvaluarFunciones ev;
    JPanel ventana_grafico;
    ChartPanel chartPanel;
    int cont = 0;
    Boolean check = false;

    public Graficadora() {
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        titulo = new JLabel("Grafica funciones");
        titulo.setBounds(450, 54, 255, 46);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Arial", titulo.getFont().getStyle(), 24));
        add(titulo);
        crearCajas();
        componente();
        crearGUI();
        setVisible(false);
    }

    private void crearGUI() {
        RoundBorder bordePrincipal = new RoundBorder(450, 500, 30, 30, 3);
        bordePrincipal.setLocation((int) (getWidth() * 0.047), (int) (getHeight() * 0.060));
        bordePrincipal.setW((int) (getWidth() * 0.904));
        bordePrincipal.setH((int) (getHeight() * 0.750));
        add(bordePrincipal);

        RoundBorder borde = new RoundBorder(450, 450, 30, 30, 3);
        borde.setLocation(470, 170);
        add(borde);
        ventana_grafico = new JPanel();
        ventana_grafico.setBackground(new Color(46, 46, 46));
        ventana_grafico.setBounds(470, 180, 450, 450);
        ventana_grafico.setOpaque(false);
        add(ventana_grafico);

        enunciado = new JLabel("Ingresa dos funciones (lineal o cuadrática) que desees graficar con el intérvalo correspondiente.");
        enunciado.setBounds((1074 - 900) / 2, 100, 900, 80);
        enunciado.setHorizontalAlignment(JLabel.RIGHT);
        enunciado.setVerticalAlignment(JLabel.CENTER);
        enunciado.setForeground(new Color(255, 255, 255));
        enunciado.setFont(new Font("Anton", enunciado.getFont().getStyle(), 18));
        add(enunciado);

        warning = new JLabel("");
        warning.setBounds(35, 350, 500, 80);
        warning.setForeground(new Color(255, 87, 87));
        warning.setFont(new Font("Anton", warning.getFont().getStyle(), 17));
        warning.setHorizontalAlignment(JLabel.CENTER);
        warning.setVisible(false);
        add(warning);

        funcion1 = new JLabel("Función 1: ");
        funcion1.setBounds(55, 230, 150, 30);
        funcion1.setHorizontalAlignment(JLabel.RIGHT);
        funcion1.setVerticalAlignment(JLabel.CENTER);
        funcion1.setForeground(new Color(255, 255, 255));
        funcion1.setFont(new Font("Anton", funcion1.getFont().getStyle(), 20));
        add(funcion1);

        funcion2 = new JLabel("Función 2: ");
        funcion2.setBounds(55, 280, 150, 30);
        funcion2.setHorizontalAlignment(JLabel.RIGHT);
        funcion2.setVerticalAlignment(JLabel.CENTER);
        funcion2.setForeground(new Color(255, 255, 255));
        funcion2.setFont(new Font("Anton", funcion2.getFont().getStyle(), 20));
        add(funcion2);

        JLabel botones = new JLabel();
        botones.setBounds(99, 330, 365, 40);
        botones.setLayout(new GridLayout(1, 3));
        add(botones);

        //boton graficar funcion 1
        graficar1 = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_graficarFuncion1();
            }
        };
        graficar1.setText("Grafica f1");
        graficar1.setBounds(95, 340, 72, 40);
        graficar1.setColor(new Color(56, 184, 250));
        graficar1.getText().setForeground(new Color(46, 46, 46));
        graficar1.getText().setFont(new Font("Anton", graficar1.getFont().getStyle(), 17));
        botones.add(graficar1);

        //boton borrar
        borrar = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_borrar();
            }
        };
        borrar.setText("Borrar");
        borrar.setBounds(230, 340, 72, 40);
        borrar.setColor(new Color(255, 87, 87));
        borrar.getText().setForeground(new Color(255, 255, 255));
        borrar.getText().setFont(new Font("Anton", borrar.getFont().getStyle(), 17));
        botones.add(borrar);

        graficar2 = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_graficarFuncion2();
            }
        };
        graficar2.setText("Graficar f2");
        graficar2.setBounds(99, 340, 72, 40);
        graficar2.setColor(new Color(56, 184, 250));
        graficar2.getText().setForeground(new Color(46, 46, 46));
        graficar2.getText().setFont(new Font("Anton", graficar2.getFont().getStyle(), 17));
        botones.add(graficar2);

        tipo_recta = new JLabel("Tipo de recta");
        tipo_recta.setBounds(50, 410, 150, 30);
        tipo_recta.setHorizontalAlignment(JLabel.RIGHT);
        tipo_recta.setVerticalAlignment(JLabel.CENTER);
        tipo_recta.setForeground(new Color(255, 255, 255));
        tipo_recta.setFont(new Font("Anton", funcion1.getFont().getStyle(), 15));
        tipo_recta.setVisible(true);
        add(tipo_recta);

        puntosCorte = new JLabel("Puntos de corte");
        puntosCorte.setBounds(70, 445, 150, 30);
        puntosCorte.setHorizontalAlignment(JLabel.RIGHT);
        puntosCorte.setVerticalAlignment(JLabel.CENTER);
        puntosCorte.setForeground(new Color(255, 255, 255));
        puntosCorte.setFont(new Font("Anton", funcion1.getFont().getStyle(), 15));
        puntosCorte.setVisible(true);
        add(puntosCorte);

        derivada1 = new JLabel("Derivada funcion 1");
        derivada1.setBounds(90, 480, 150, 30);
        derivada1.setHorizontalAlignment(JLabel.RIGHT);
        derivada1.setVerticalAlignment(JLabel.CENTER);
        derivada1.setForeground(new Color(255, 255, 255));
        derivada1.setFont(new Font("Anton", funcion1.getFont().getStyle(), 15));
        derivada1.setVisible(true);
        add(derivada1);

        derivada2 = new JLabel("Derivada funcion 2");
        derivada2.setBounds(90, 520, 150, 30);
        derivada2.setHorizontalAlignment(JLabel.RIGHT);
        derivada2.setVerticalAlignment(JLabel.CENTER);
        derivada2.setForeground(new Color(255, 255, 255));
        derivada2.setFont(new Font("Anton", funcion1.getFont().getStyle(), 15));
        derivada2.setVisible(true);
        add(derivada2);

        Max_min1 = new JLabel("Maximo - Minimo:");
        Max_min1.setBounds(75, 560, 150, 30);
        Max_min1.setHorizontalAlignment(JLabel.RIGHT);
        Max_min1.setVerticalAlignment(JLabel.CENTER);
        Max_min1.setForeground(new Color(255, 255, 255));
        Max_min1.setFont(new Font("Anton", Max_min1.getFont().getStyle(), 15));
        Max_min1.setVisible(true);
        add(Max_min1);

        Max_min2 = new JLabel("Maximo - Minimo:");
        Max_min2.setBounds(75, 600, 150, 30);
        Max_min2.setHorizontalAlignment(JLabel.RIGHT);
        Max_min2.setVerticalAlignment(JLabel.CENTER);
        Max_min2.setForeground(new Color(255, 255, 255));
        Max_min2.setFont(new Font("Anton", Max_min2.getFont().getStyle(), 15));
        Max_min2.setVisible(true);
        add(Max_min2);
    }

    private void crearCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new RoundTextField(50, 50);
            cajas[i].setText("");
            cajas[i].getTextField().setFont(new Font("Anton", Font.PLAIN, 20));
            cajas[i].getRoundBorder().setBackground(new Color(0, 188, 255));
            add(cajas[i]);
        }
    }

    private void componente() {
        cajas[0].setLocation(210, 220);
        cajas[0].setTam(150, 50);
        cajas[0].setBackground(new Color(166, 166, 166));

        cajas[3].setLocation(210, 270);
        cajas[3].setTam(150, 50);
        cajas[3].setBackground(new Color(166, 166, 166));

        //Intervalos de las funciones
        cajas[1].setLocation(360, 250);
        cajas[1].setBackground(new Color(166, 166, 166));

        cajas[2].setLocation(410, 250);
        cajas[2].setBackground(new Color(166, 166, 166));
    }

    private void evento_graficarFuncion1() {
        if (comprobarText(0, 2)) {
            if (cont == 0) {
                ev = new EvaluarFunciones();
                ev.SetFuncion1(info);
                eliminarGrafica();
                chartPanel = new ChartPanel(ev.grafico);
                chartPanel.setPreferredSize(new Dimension(420, 420));
                ventana_grafico.add(chartPanel);
                ventana_grafico.revalidate();
                ventana_grafico.repaint();
                cont = 1;
            } else {
                ev = new EvaluarFunciones(info);
                eliminarGrafica();
                chartPanel = new ChartPanel(ev.grafico);
                chartPanel.setPreferredSize(new Dimension(420, 420));
                ventana_grafico.add(chartPanel);
                ventana_grafico.revalidate();
                ventana_grafico.repaint();
                if (!check) {
                    Informacion();
                } else {
                    eliminarCalculos();
                    Informacion();
                }
            }
        } else {
            Util.advertencia(warning, 2000, "Llene todos los campos para la funcion 1");
        }
    }

    private void evento_graficarFuncion2() {
        if (comprobarText(1, 3)) {
            if (cont == 0) {
                ev = new EvaluarFunciones();
                ev.SetFuncion2(info[3], info[1], info[2]);
                eliminarGrafica();
                chartPanel = new ChartPanel(ev.grafico);
                chartPanel.setPreferredSize(new Dimension(420, 420));
                ventana_grafico.add(chartPanel);
                ventana_grafico.revalidate();
                ventana_grafico.repaint();
                cont = 1;
            } else {
                ev = new EvaluarFunciones(info);
                eliminarGrafica();
                chartPanel = new ChartPanel(ev.grafico);
                chartPanel.setPreferredSize(new Dimension(420, 420));
                ventana_grafico.add(chartPanel);
                ventana_grafico.revalidate();
                ventana_grafico.repaint();
                if (!check) {
                    Informacion();
                } else {
                    eliminarCalculos();
                    Informacion();
                }
            }
        } else {
            Util.advertencia(warning, 2000, "Llene todos los campos para la funcion 2");
        }
    }

    public void Informacion() {
        for (int i = 0; i < informacion.length; i++) {
            informacion[i] = new JLabel();
            add(informacion[i]);
        }

        informacion[0].setBounds(160, 410, 300, 30);
        informacion[0].setHorizontalAlignment(JLabel.CENTER);
        informacion[0].setVerticalAlignment(JLabel.CENTER);
        informacion[0].setText(ev.getTipoRecta());
        informacion[0].setForeground(new Color(255, 255, 255));
        informacion[0].setFont(new Font("Anton", informacion[0].getFont().getStyle(), 15));
        add(informacion[0]);

        informacion[1].setBounds(150, 445, 250, 30);
        informacion[1].setHorizontalAlignment(JLabel.RIGHT);
        informacion[1].setVerticalAlignment(JLabel.CENTER);
        informacion[1].setText(ev.mensajesPuntosDeCorte());
        informacion[1].setForeground(new Color(255, 255, 255));
        informacion[1].setFont(new Font("Anton", informacion[1].getFont().getStyle(), 15));
        add(informacion[1]);

        informacion[2].setBounds(150, 480, 250, 30);
        informacion[2].setHorizontalAlignment(JLabel.RIGHT);
        informacion[2].setVerticalAlignment(JLabel.CENTER);
        informacion[2].setText(ev.getDerivada1());
        informacion[2].setForeground(new Color(255, 255, 255));
        informacion[2].setFont(new Font("Anton", informacion[2].getFont().getStyle(), 15));
        add(informacion[2]);

        informacion[3].setBounds(150, 520, 250, 30);
        informacion[3].setHorizontalAlignment(JLabel.RIGHT);
        informacion[3].setText(ev.getDerivada2());
        informacion[3].setVerticalAlignment(JLabel.CENTER);
        informacion[3].setForeground(new Color(255, 255, 255));
        informacion[3].setFont(new Font("Anton", informacion[3].getFont().getStyle(), 15));
        add(informacion[3]);

        informacion[4].setBounds(155, 560, 250, 30);
        informacion[4].setHorizontalAlignment(JLabel.RIGHT);
        informacion[4].setText(ev.getMaximo_minimof1());
        informacion[4].setVerticalAlignment(JLabel.CENTER);
        informacion[4].setForeground(new Color(255, 255, 255));
        informacion[4].setFont(new Font("Anton", informacion[4].getFont().getStyle(), 15));
        add(informacion[4]);

        informacion[5].setBounds(155, 600, 250, 30);
        informacion[5].setHorizontalAlignment(JLabel.RIGHT);
        informacion[5].setText(ev.getMaximo_minimof2());
        informacion[5].setVerticalAlignment(JLabel.CENTER);
        informacion[5].setForeground(new Color(255, 255, 255));
        informacion[5].setFont(new Font("Anton", informacion[5].getFont().getStyle(), 15));
        add(informacion[5]);

        check = true;
    }

    private void evento_borrar() {
        eliminarInfo();
        eliminarCalculos();
        eliminarGrafica();
        Util.advertencia(warning, 2000, "Gráfica y elementos borrados"); //2 segundos
        cont = 0;
    }

    private void eliminarInfo() {
        for (RoundTextField caja : cajas) {
            caja.setText("");
        }
    }

    private void eliminarCalculos() {
        if (check) {
            for (JLabel Jlabel : informacion) {
                Jlabel.setText("");
                repaint();
                check = true;
            }
        }
    }

    private void eliminarGrafica() {
        if (chartPanel != null) {
            ventana_grafico.remove(chartPanel);
            ventana_grafico.revalidate();
            ventana_grafico.repaint();
            // Configura la referencia a null para liberar recursos
            chartPanel = null;
        }
    }

    private boolean comprobarText(int inicio, int fin) {
        int ini = inicio;
        int fi = fin;
        Boolean validarText = true;
        for (int i = ini; i <= fi; i++) {
            if (cajas[i].getText().isEmpty()) {
                validarText = false;
                break;
            }
            info[i] = cajas[i].getText();
        }
        return validarText;
    }
}
