package AlgebraPack;

import java.awt.Font;
import javax.swing.JLabel;

public class JlabelAlgebra extends JLabel {
    
    public JlabelAlgebra(String texto) {
        super(texto);

        // Configura el tipo de letra, estilo y tamaño
        Font fuente = new Font("Arial", Font.PLAIN, 20);
        setFont(fuente);

        // Establece el color de fuente en blanco
        setForeground(java.awt.Color.WHITE);

        // Centra el texto horizontalmente en el JLabel
        setHorizontalAlignment(JLabel.CENTER);
    }
    //definir cuando se llame la clase el lugar de cada jlabel
}

