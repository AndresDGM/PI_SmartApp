//boton para retroceder los contenidos

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BackButton extends JPanel {

    //arreglo con los contenidos en orden de con se visitan para siempre saber cual es el anterior
    //se eligio usar un ArrayList para poder redimenzionar el arreglo
    private ArrayList<JPanel> antContenidos = new ArrayList<JPanel>();
        
    public BackButton() {
        setBounds(0,50,50,50);
        setBackground(new Color(84,84,84));
        setOpaque(true);
        setLayout(null);

        //se añade el menu pricipal como contenido anterior a los demas
        antContenidos.add(App.menu);
        add(new BackButton.Lines());
        accionMouse();
        setVisible(false);
    }

    //clase que dibuja la flecha del boton
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
            g2.drawLine(7,27,21,17);
            g2.drawLine(7,27,43,27);
            g2.drawLine(7,27,21,37);
            super.paintComponent(g);
        }
    }

    //escuchante del raton para que la clase se comporte como un boton
    private void accionMouse() {
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //logica del boton
                int iC = antContenidos.size() - 1;
                antContenidos.get(iC).setVisible(false);
                antContenidos.get(iC - 1).setVisible(true);
                antContenidos.remove(iC);
                if(iC - 1 == 0){
                    setVisible(false);
                }
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

    //retorna la array para que la clase boton pueda acceder a ella y agregar los contenidos
    public ArrayList<JPanel> getAntContenidos() {
        return antContenidos;
    }
}
