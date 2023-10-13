package AppMainSrc;//boton basico encargado de mostra y ocultar secciones de la aplicacion

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JPanel {

    private JLabel titulo = new JLabel();
    
    private JLabel imagenBoton = new JLabel();

    //atributo que corresponde al objeto que contiene al boton
    private JPanel contenedor = new JPanel();

    //atributo que corresponde al contenido que muestra el boton
    private JPanel contenido = new JPanel();

    public Button() {
        setBackground(new Color(80, 80, 80));
        setSize(341,250);
        titulo.setBounds(0, 200, getWidth(),50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Arial",titulo.getFont().getStyle(),24));
        imagenBoton.setBounds(10,20,330,160);
        setLayout(null);
        setOpaque(false);
        add(titulo);
        add(imagenBoton);
        accionMouse();
        setVisible(true);
    }

    public JPanel getContenido() {
        return contenido;
    }

    // este metodo se setea el contenido y contenedor de forma directa
    public void setContenido(JPanel contenido, JPanel contenedor) {
        this.contenido = contenido;
        this.contenedor = contenedor;
    }

    //rectangulo redondeado que da la forma del boton
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(),getHeight(),50,50);
        super.paintComponent(g);
    }

    //escuchante del raton para que la clase se comporte como un boton
    private void accionMouse() {

        MouseListener m = new MouseListener() {
            /*logica al clickear el mouse, desactiva el contenedor, activa el contenido
            y activa el boton de volver a la vez que agrega el contenido visitado actual
            */
            @Override
            public void mouseClicked(MouseEvent e) {
                contenedor.setVisible(false);
                contenido.setVisible(true);
                BackButton b = (BackButton) App.lateralBar.getComponent(1);
                b.getAntContenidos().add(contenido);
                if(!b.isVisible()){
                    b.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            //expande el boton cuando el mouse pasa sobre el
            @Override
            public void mouseEntered(MouseEvent e) {
                setSize(getWidth() + 4, getHeight() + 4);
                setLocation(getX() - 2,getY() - 2);
                imagenBoton.setLocation(imagenBoton.getX() + 2, imagenBoton.getY() + 2);
                titulo.setBounds(0, (int) (getHeight()*0.75), getWidth(),getHeight()/3);
            }

            //contrae el boton cuando el mouse sale de el
            @Override
            public void mouseExited(MouseEvent e) {
                setSize(getWidth() - 4, getHeight() - 4);
                setLocation(getX() + 2,getY() + 2);
                imagenBoton.setLocation(imagenBoton.getX() - 2, imagenBoton.getY() - 2);
                titulo.setBounds(0, (int) (getHeight()*0.75), getWidth(),getHeight()/3);
            }
        };
        this.addMouseListener(m);
    }
    public JLabel getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String texto) {
        titulo.setText(texto);
    }
    
    public void setImagenBoton(String source){
        ImageIcon imagen = new ImageIcon(source);
        float scale = (float)  imagenBoton.getHeight()/imagen.getIconHeight();
        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance((int) (imagen.getIconWidth()*scale), (int) (imagen.getIconHeight()*scale), Image.SCALE_DEFAULT));
        imagenBoton.setSize((int) (imagen.getIconWidth()*scale), (int) (imagen.getIconHeight()*scale));
        imagenBoton.setLocation(getWidth()/2 - imagenBoton.getWidth()/2,10);
        imagenBoton.setIcon(icon);
    }
}
