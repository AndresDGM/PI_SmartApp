
package HumanidadesPack;


import AppMainSrc.BasicButton;
import AppMainSrc.Button;
import AppMainSrc.RoundTextField;
import java.awt.Color;
import java.awt.Font;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import AppMainSrc.RoundComboBox;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Registro extends JPanel {
    
    JLabel jApe,jNom,jCorre,titulo;
    
    RoundTextField jtApe,jtNom,jtCorre;
    
    RoundComboBox genero;
    
    BasicButton guardar,limpiar,test,tabla_score,enviar;
    
    private int puntaje;
    
    public estructura e = new estructura();
    

    
    
    //public Test_Huma c = new Test_Huma(this);
    
    //public puntuacion p = new puntuacion(this);
    
    public Registro(){
        
        
        setSize(1074, 800);
        setLocation(50, 0);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        crearGUI();
        setVisible(false);
        
        
        
        
       
    }

        public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    
         }
    
    public void crearGUI(){
        
        titulo = new JLabel("Registro de Usuarios");
        titulo.setBounds(400, 100, 300, 30);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
        titulo.setVisible(true);
        add(titulo);
        
        jApe = new JLabel("Apellidos:");
        jApe.setBounds(290, 300, 120, 30);
        jApe.setForeground(Color.WHITE);
        add(jApe);
        jtApe = new RoundTextField(200, 40);
        jtApe.setLocation(360, 300);
        jtApe.setText("");
        jtApe.getTextField().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        add(jtApe);
        
        
        jNom = new JLabel("Nombres:");
        jNom.setBounds(290, 400,120,30);
        jNom.setForeground(Color.WHITE);
        add(jNom);
        jtNom = new RoundTextField(200, 40);
        jtNom.setLocation(360, 400);
        jtNom.setText("");
        jtNom.getTextField().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        add(jtNom);
        
        jCorre = new JLabel("Correo:");
        jCorre.setBounds(290, 500,120,30);
        jCorre.setForeground(Color.WHITE);
        add(jCorre);
        jtCorre = new RoundTextField(200, 40);
        jtCorre.setLocation(360, 500);
        jtCorre.setText("");
        jtCorre.getTextField().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        add(jtCorre);
        
        
        genero = new RoundComboBox();
        
        genero.addItem("Mujer");
        genero.addItem("Hombre");
        genero.addItem("Otros");
        genero.setSize(200, 40);
        genero.setColor(new Color(46,46,46));
        genero.getBorde().setBackground(Color.white);
        genero.setLocation(590, 300);
        add(genero);
        
        guardar = new BasicButton() {
            @Override
            public void clickEvent() {
                 evento_guardar();
                 
                 
            }
        };
        guardar.setText("Guardar");
        guardar.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        guardar.getText().setVerticalAlignment(JLabel.CENTER);
        guardar.getText().setHorizontalAlignment(JLabel.CENTER);
        guardar.getText().setSize(160, 54);
        guardar.setLocation(460, 600);
        guardar.setLayout(null);
        guardar.setColor(new Color(0, 188, 255));
        guardar.setForeground(Color.WHITE);
        
        add(guardar);
        
        
        test = new BasicButton() {
            @Override
            public void clickEvent() {
               Test_Huma test = new Test_Huma(Registro.this);
               Registro.this.add(test);
               Registro.this.ocultar(false);

                  
            }
        };
        test.setText("Cuestionario");
        test.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        test.getText().setVerticalAlignment(JLabel.CENTER);
        test.getText().setHorizontalAlignment(JLabel.CENTER);
        test.getText().setSize(160, 54);
        test.setLocation(260, 600);
        test.setLayout(null);
        test.setColor(new Color(0, 188, 255));
        test.setForeground(Color.WHITE);
        

        add(test);
        
        enviar = new BasicButton() {
            @Override
            public void clickEvent() {
                e.test3();
            }
        };
        
        enviar.setText("enviar inf");
        enviar.setBounds(60, 600, 160, 54);
        enviar.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        enviar.getText().setVerticalAlignment(JLabel.CENTER);
        enviar.getText().setHorizontalAlignment(JLabel.CENTER);
        enviar.getText().setSize(160, 54);
        enviar.setLayout(null);
        enviar.setColor(new Color(0, 188, 255));
        enviar.setForeground(Color.WHITE);
        add(enviar);
        
        
        limpiar = new BasicButton() {
            @Override
            public void clickEvent() {
                evento_limpiar();
            }
        };
        limpiar.setText("Limpiar");
        limpiar.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        limpiar.getText().setVerticalAlignment(JLabel.CENTER);
        limpiar.getText().setHorizontalAlignment(JLabel.CENTER);
        limpiar.getText().setSize(160, 54);
        limpiar.setLocation(660, 600);
        limpiar.setLayout(null);
        limpiar.setColor(new Color(0, 188, 255));
        limpiar.setForeground(Color.WHITE);
        
        add(limpiar);
        
        tabla_score = new BasicButton() {
            @Override
            public void clickEvent() {
                puntuacion score = new puntuacion (Registro.this); 
                Registro.this.add(score);
                score.setVisible(true);
                ocultar(false);
            }
        };
        tabla_score.setText("Score");
        tabla_score.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        tabla_score.getText().setVerticalAlignment(JLabel.CENTER);
        tabla_score.getText().setHorizontalAlignment(JLabel.CENTER);
        tabla_score.getText().setSize(160, 54);
        tabla_score.setLocation(860, 600);
        tabla_score.setLayout(null);
        tabla_score.setColor(new Color(0, 188, 255));
        tabla_score.setForeground(Color.WHITE);
        
        add(tabla_score);
    }

    private void evento_limpiar() {
       jtApe.setText("");
       jtNom.setText("");
       jtCorre.setText("");
       genero.setItemSelected(0);
       jtApe.requestFocus();
    }

    public void evento_guardar() {
        FileWriter fw = null;
        boolean error = false;
        
        try {
            fw = new FileWriter("score.csv", true);
        } catch (Exception e) {
            error = true;
            JOptionPane.showMessageDialog(null,
                    "Error al crear/abrir el archivo");
            
        }
        if (!error) {
            
            String ape_tmp = jtApe.getText();
            String nom_tmp = jtNom.getText();
            String coe_tmp = jtCorre.getText();
            String plan_tmp = (String) genero.getSelectedItem();
            
            
            
            
            try {
                fw.write(ape_tmp+";"+nom_tmp+";"+coe_tmp+";"+plan_tmp+";"+ puntaje + "\r\n");
                    
             
            
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,
                    "Error al guardar en el archivo");
            }
            try {
                fw.close();
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null,
                    "Error al cerrar  el archivo");
            }
        }
    }
    
    public void ocultar(boolean flag){
        jtApe.setVisible(flag);
        jtNom.setVisible(flag);
        jtCorre.setVisible(flag);
        guardar.setVisible(flag);
        limpiar.setVisible(flag);
        test.setVisible(flag);
        tabla_score.setVisible(flag);
        jApe.setVisible(flag);
        jNom.setVisible(flag);
        jCorre.setVisible(flag);
        genero.setVisible(flag);
        titulo.setVisible(flag);
        enviar.setVisible(flag);
        AppMainSrc.App.lateralBar.getComponent(1).setVisible(flag);  
        repaint();
    }
     private void guardarEnArchivoCSV(String archivoCSV, String datos) {
        try (FileWriter fw = new FileWriter(archivoCSV, true)) {
            fw.write(datos + "\n");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo");
        }
    }
     
    
    }

    