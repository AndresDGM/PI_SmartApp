/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author suare
 */
public class CapitulosHuma extends JPanel{
    
    private String[] texts;

    private JScrollPane[] Capitulos = new JScrollPane[10];
    
    private JLabel titulo = new JLabel();
    
    private BasicButton botonSiguiente, botonAnterior;
    
    int capCont = 0;

    public CapitulosHuma() {
        setBounds(50, 0, 1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        setTexts();
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255,255,255));
        titulo.setFont(new Font("Arial",Font.PLAIN,24));
        titulo.setBounds(457, 10, 160, 50);
        InitCaps();
        botonSiguiente = new BasicButton(){
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if(capCont < 9){
                    Capitulos[capCont+1].setVisible(true);
                    capCont++;
                    titulo.setText("Capitulo " + (capCont + 1));
                }else{
                    Capitulos[0].setVisible(true);
                    capCont = 0;
                    titulo.setText("Capitulo " + (capCont + 1));
                }
            }
        };
        botonSiguiente.setLocation(850, 700);
        botonSiguiente.setText("Siguiente");
        add(botonSiguiente);
        
        botonAnterior = new BasicButton() {
            @Override
            public void clickEvent() {
                Capitulos[capCont].setVisible(false);
                if(capCont > 0){
                    Capitulos[capCont-1].setVisible(true);
                    capCont--;
                    titulo.setText("Capitulo " + (capCont + 1));
                }else{
                    Capitulos[9].setVisible(true);
                    capCont = 9;
                    titulo.setText("Capitulo " + (capCont + 1));
                }
            }
        };
        botonAnterior.setLocation(50, 700);
        botonAnterior.setText("Anterior");
        add(botonAnterior);
        add(titulo);
        setVisible(false);
    }
    
    public void InitCaps(){
        for (int i = 0; i < Capitulos.length; i++) {
            JEditorPane j = new JEditorPane();
            j.setBounds(0, 0, 700, 650);
            j.setContentType("text/html");
            j.setText(texts[i]);
            j.setBackground(new Color(46, 46, 46));
            j.setBorder(null);
            j.setEditable(false);
            j.addHyperlinkListener(new HyperlinkListener() {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        if (Desktop.isDesktopSupported()) {
                            try {
                                Desktop.getDesktop().browse(e.getURL().toURI());
                            } catch (IOException | URISyntaxException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            });

            Capitulos[i] = new JScrollPane(j);
            Capitulos[i].setBounds(187, 100, 700, 550);
            Capitulos[i].setBorder(null);
            Capitulos[i].setVisible(false);
            add(Capitulos[i]);
        };
            
    }
    

    public JScrollPane[] getCapitulos() {
        return Capitulos;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public int getCapCont() {
        return capCont;
    }

    public void setCapCont(int capCont) {
        this.capCont = capCont;
    }

    public void setTexts() {
        
        URL cap1 = getClass().getResource("imagenes/ods4-1.png");
        URL cap2 = getClass().getResource("imagenes/ods4-2.png");
        URL cap3 = getClass().getResource("imagenes/ods4-3.png");
        texts = new String[]{"<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>INTRODUCCION AL ODS #4</b></font></div><br>"
    + "<strong><font face='Arial' size='5' color='red'>Definción</strong><br><br>"
    + "El ODS 4 es el cuarto Objetivo de Desarrollo Sostenible de la ONU, que tiene como objetivo garantizar una "
    + "educación inclusiva, equitativa y de calidad para todos. Esto incluye desde la educación preescolar hasta "
    + "la formación técnica y profesional, y abarca tanto la educación formal como la no formal. El ODS 4 tiene "
    + "metas específicas para lograr este objetivo, y los gobiernos tienen un papel importante en su implementación.<br><br>"
    +"<div align='center: left;'><img src=" + cap1 + " width=400 height=300></div><br>"
    + "<h1><font face='Arial' size='5' color='red'>En estos capítulos vamos a tratar temas como:</h1>"
    + "-Metas del ODS 4<br>" +
    "-Acceso a la educación<br>" +
    "-Educación inclusiva<br>" +
    "-Formación de docentes<br>" +
    "-Tecnología y educación<br>" +
    "-Impacto global<br>" +
    "-infraestructura educativa<br>" +
    "-becas y apoyos para estudiantes<br>" +
    "-Conclusión y llamado a la acción para apoyar el ODS 4<br>"
    + "🎬 <a href = 'https://www.youtube.com/watch?v=PhU0LAyR2KM'>Video de retroalimentacion</a><br>" 
    + "🌐 <a href='https://www.un.org/sustainabledevelopment/es/education/'>pagina web #1</a><br>"
    + "🌐 <a href='https://sdgs.un.org/es/goals/goal4?lang=es'>pagina web #2</a><br>"
    + "🌐 <a href='https://www.ei-ie.org/es'>pagina web #3</a><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>METAS ESPECIFICAS DEL ODS #4</b></font></div><br>"
    + "<strong><font face='Arial' size='5' color='red'>Las principales metas son:</strong><br><br>"
    + "-Aseguraron que todos los niños completen debidamente la educación primaria y secundaria.<br>" 
    +"-Fomentar la educación de calidad desde temprana edad.<br>" 
    +"-Accesibilidad a la educación de calidad para llegar a más niños.<br>" 
    +"-Prepararlos para el futuro sean excelente profesionales en lo que hacen.<br>" 
    +"-Igualdad de condiciones sin importar el género.<br>" 
    +"-Garantizar que todos tengan habilidades básicas de lectura, escritura y matemáticas.<br>" 
    +"-Llegar a todas las personas del mundo para que más gente pueda ayudar con los objetivos.<br>"
    +"-Ayudar con becas de estudio para aquellos niños que no cuentan con recursos financieros.<br>" 
    +"-Capacitar a los docentes para que el aprendizaje sea excelente y de calidad.<br><br> "
    +"<div align='center: left;'><img src=" + cap2 + " width=650 height=300></div><br>"
    + "🎬 <a href = 'https://www.youtube.com/watch?v=WWrrcJpC5r0'>Video de retroalimentacion</a><br>" 
    + "🌐 <a href='https://agenda2030lac.org/es/ods/4-educacion-de-calidad'>pagina web 1</a><br>"
    + "🌐 <a href='http://los17ods.org/los-17-objetivos-para-2030/educacion/'>pagina web 2</a><br>"
    + "🌐 <a href='https://www.ilo.org/global/topics/dw4sd/theme-by-sdg-targets/WCMS_621373/lang--es/index.htm'>pagina web 3</a><br>"                   
    + "</body></html>"  ,      
       
    //capitulo 3            
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>ACCESO A LA EDUCACION</b></font></div><br>"
    + "<strong><font face='Arial' size='5' color='red'>definicion</strong><br><br>"
    + "El acceso a la educacion es algo que todo humano debe de tener, debe ser un derecho fundamental para poder"
    + "en el futuro tener muchas personas capacitadas para hacer cualquier tipo de trabajo y sobre todo ser unas personas"
    + "de bien.<br> "
    + "Pero hoy en dia hay un gran problema respecto a esto, ya que muchos niños al rededor del mundo no cuentan con la posibilidad"
    + "de asistir a un centro educativo ya que no cabe dentro de sus posiblilidades, unos son porque no tienen el dinero para comprar"
    + "los materiales que se requieran para la educacion de calidad, tambien pueden que vivan en una zona que no les quede ningun colegio"
    + "cerca o los que tienen cerca son de pago y no tienen economia para pagarlo.<br><br>"
    +"<div align='center: left;'><img src=" + cap3 + " width=650 height=300></div><br>"
    + "🎬 <a href = 'https://www.youtube.com/watch?v=1rPk7IJtmSs'>Video de retroalimentacion</a><br>" 
    + "🌐 <a href='https://plan-international.es/girls-get-equal/acceso-educacion'>pagina web 1</a><br>"
    + "🌐 <a href='https://es.wikipedia.org/wiki/Acceso_universal_a_la_educaci%C3%B3n'>pagina web 2</a><br>"
    + "🌐 <a href='https://www.elespectador.com/educacion/en-colombia-3-de-cada-10-personas-en-edad-escolar-no-estan-estudiando-por-que-noticias-hoy/'>pagina web 3</a><br>"
    + "</body></html>",
                                  
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",
    
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Arial' size='5' color='red'><b>Ejemplo JEditorPane</b></font></div><br>"
    + "<strong>El paquete Swing - La clase JEditorPane | GUI en Java</strong><br><br>"
    + "Definición del componente. Creación de un JEditorPane que visualiza texto en formato HTML. Se aplica formato al texto y se muestra una imagen. Ejemplo en código fuente.<br><br>"
    + "{ ... } <a href='https://bit.ly/3uEnVup'>Código fuente</a><br>"
    + "hola golda"
    + "<p>sebastian tiene una nariz monumental</p>"
    + "<h1>Taller de diagnóstico Álgebra Lineal</h1>"
    + "🎬 <a href='https://youtube.com/playlist?list=PLV3xT3LjqLpbPIkOtVRui6Faxu3y6wEer'>Lista de reproducción - GUI en Java</a><br><br>"
    + "</body></html>",};
    }
    
    
}
