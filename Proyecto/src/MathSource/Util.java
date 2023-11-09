/*
 Con métodos estáticos 
 */
package MathSource;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Util{
    
    //método para mostrar por un determinado tiempo el mensaje de advertencia o error
    public static void advertencia(JLabel aviso, int time, String mensaje){
        aviso.setText(mensaje);
        aviso.setVisible(true);
        Timer tiempo = new Timer(time, (e) -> {
            aviso.setVisible(false);
            aviso.setText("");
        });
        tiempo.setRepeats(false);
        tiempo.restart();
    }
}
