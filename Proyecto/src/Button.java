
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JPanel {

    private JLabel titulo = new JLabel();
    
    private JLabel imagenBoton = new JLabel();
    
    private JPanel contenedor = new JPanel();

    private JPanel contenido = new JPanel();

    public Button() {
        setBackground(new Color(80, 80, 80));
        setSize(255,200);
        titulo.setBounds(0, 150, getWidth(),50);
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

    public void setContenido(JPanel contenido, JPanel contenedor) {
        this.contenido = contenido;
        this.contenedor = contenedor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(),getHeight(),50,50);
        super.paintComponent(g);
    }



    private void accionMouse() {
        
        MouseListener m = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contenedor.setVisible(false);
                contenido.setVisible(true);
                App.lateralBar.getComponent(1).setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setSize(getWidth() + 3, getHeight() + 3);
                titulo.setBounds(0, (int) (getHeight()*0.75), getWidth(),getHeight()/3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setSize(getWidth() - 3, getHeight() - 3);
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
        Icon icon = new ImageIcon(
                imagen.getImage().getScaledInstance(imagenBoton.getWidth(), imagenBoton.getHeight(),Image.SCALE_DEFAULT));
        imagenBoton.setIcon(icon);
    }

}
