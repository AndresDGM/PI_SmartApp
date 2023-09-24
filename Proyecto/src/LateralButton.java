/*
clase de boton encargado de expandir y contraer la barra lateral y
de transformar botones contenidos en ella.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LateralButton extends JPanel {

    //copia de la barra lateral para modificarla mas facilmente
    private JPanel lateralBar;

    //alterna entre expandir y comtraer la barra
    private boolean band = false;

    //esta activa mientras la barra se expande o contrae para no causar conflictos cn el hilo
    private boolean running = false;

    public LateralButton(){
        setBounds(0,0,50,50);
        setBackground(new Color(84,84,84));
        setOpaque(true);
        setLayout(null);
        add(new Lines());
        accionMouse();
        setVisible(true);
    }

    //clase que dibuja las tres barras del boton
    private static class Lines extends JPanel{
        private Lines(){
            setBounds(0,0,50,50);
            setOpaque(false);
            setVisible(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0));
            g2.drawLine(7,17,43,17);
            g2.drawLine(7,27,43,27);
            g2.drawLine(7,37,43,37);
            super.paintComponent(g);
        }
    }

    public JPanel getLateralBar() {
        return lateralBar;
    }

    public void setLateralBar(JPanel lateralBar) {
        this.lateralBar = lateralBar;
    }


    //escuchante del raton para que la clase se comporte como un boton
    private void accionMouse() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Thread run = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        if(!band && !running){
                            running = true;
                            //expande la barra 7 pixeles cada 1 ms
                            for (int i = 50; i <= 190; i+=7) {
                                try{
                                    Thread.sleep(1);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                lateralBar.setSize(i,lateralBar.getHeight());
                            }
                            running = false;
                            band=!band;//dentro del if para no causar conflictos con la alternacia
                        }else if(!running){
                            running = true;
                            //contrae la barra 7 pixeles cada 1 ms
                            for (int i = 190; i >= 50; i-=7) {
                                try{
                                    Thread.sleep(1);
                                }catch(Exception e){
                                    System.out.println(e);
                                }
                                lateralBar.setSize(i,lateralBar.getHeight());
                            }
                            running = false;
                            band=!band;//dentro del else para no causar conflictos con la alternacia
                        }
                    }
                });
                run.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(100, 100, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(84,84,84));
            }
        };
        this.addMouseListener(m);
    }
}
