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
        URL cap4 = getClass().getResource("imagenes/ods4-4.png");
        URL cap5 = getClass().getResource("imagenes/ods4-5.png");
        URL cap6 = getClass().getResource("imagenes/ods4-6.png");
        URL cap7_1 = getClass().getResource("imagenes/ods4-7-1.png");
        URL cap7_2 = getClass().getResource("imagenes/ods4-7-2.png");
        URL cap8 = getClass().getResource("imagenes/ods4-8.png");
        URL cap9 = getClass().getResource("imagenes/ods4-9.png");
        URL cap10 = getClass().getResource("imagenes/ods4-10.png");
        
        texts = new String[]{
    //capitulo 1
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    +"<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>INTRODUCCION AL ODS #4</b></font></div><br>"
    +"<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Definición</strong><br><br>"
    +"<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>El ODS 4 es el cuarto Objetivo de Desarrollo Sostenible de la ONU, que tiene como objetivo garantizar una "
    +" educación inclusiva, equitativa y de calidad para todos. Esto incluye desde la educación preescolar hasta "
    +" la formación técnica y profesional, y abarca tanto la educación formal como la no formal. El ODS 4 tiene "
    +" metas específicas para lograr este objetivo, y los gobiernos tienen un papel importante en su implementación.</h2></div><p>"
    +"<div align='center: left;'><img src=" + cap1 + " width=675 height=400></div><br>"
    +"<h1><font face='Lucida Bright' size='6' color='#38B8FA'>En estos capítulos vamos a tratar temas como:</h1>"
    +"<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"   
    +"-Metas del ODS 4<br>" 
    +"-Acceso a la educación<br>" 
    +"-Educación inclusiva<br>" 
    +"-Formación de docentes<br>" 
    +"-Tecnología y educación<br>" 
    +"-Impacto global<br>" 
    +"-infraestructura educativa<br>" 
    +"-becas y apoyos para estudiantes<br>" 
    +"-Conclusión y llamado a la acción para apoyar el ODS 4.</h2></div><p>"
    + " <a href = 'https://www.youtube.com/watch?v=PhU0LAyR2KM'>Video de retroalimentacion</a><br>" 
    + " <a href='https://www.un.org/sustainabledevelopment/es/education/'>pagina web #1</a><br>"
    + " <a href='https://sdgs.un.org/es/goals/goal4?lang=es'>pagina web #2</a><br>"
    + " 🌐<a href='https://www.ei-ie.org/es'>pagina web #3</a><br>"
    + "</body></html>",
    
    //Capitulo 2
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>METAS ESPECIFICAS DEL ODS #4</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Las principales metas son:</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>-Aseguraron que todos los niños completen debidamente la educación primaria y secundaria.<br>" 
    +"-Fomentar la educación de calidad desde temprana edad.<br>" 
    +"-Accesibilidad a la educación de calidad para llegar a más niños.<br>" 
    +"-Prepararlos para el futuro sean excelente profesionales en lo que hacen.<br>" 
    +"-Igualdad de condiciones sin importar el género.<br>" 
    +"-Garantizar que todos tengan habilidades básicas de lectura, escritura y matemáticas.<br>" 
    +"-Llegar a todas las personas del mundo para que más gente pueda ayudar con los objetivos.<br>"
    +"-Ayudar con becas de estudio para aquellos niños que no cuentan con recursos financieros.<br>" 
    +"-Capacitar a los docentes para que el aprendizaje sea excelente y de calidad.</h2></div><br><br> "
    +"<div align='center: left;'><img src=" + cap2 + " width=675 height=300></div><br>"
    + "<a href = 'https://www.youtube.com/watch?v=WWrrcJpC5r0'>Video de retroalimentacion</a><br>" 
    + "<a href='https://agenda2030lac.org/es/ods/4-educacion-de-calidad'>pagina web 1</a><br>"
    + "<a href='http://los17ods.org/los-17-objetivos-para-2030/educacion/'>pagina web 2</a><br>"
    + "<a href='https://www.ilo.org/global/topics/dw4sd/theme-by-sdg-targets/WCMS_621373/lang--es/index.htm'>pagina web 3</a><br>"                   
    + "</body></html>"  ,      
       
    //capitulo 3            
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>ACCESO A LA EDUCACION</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Definicion</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>El acceso a la educacion es algo que "
    + " todo humano debe de tener, debe ser un derecho fundamental para poder"
    + " en el futuro tener muchas personas capacitadas para hacer cualquier tipo de trabajo y sobre todo ser unas personas de bien.<br>"
    + " Pero hoy en dia hay un gran problema respecto a esto, ya que muchos niños al rededor del mundo no cuentan con la posibilidad"
    + " de asistir a un centro educativo ya que no cabe dentro de sus posiblilidades, unos son porque no tienen el dinero para comprar"
    + " los materiales que se requieran para la educacion de calidad, tambien pueden que vivan en una zona que no les quede ningun colegio"
    + " cerca o los que tienen cerca son de pago y no tienen economia para pagarlo.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap3 + " width=675 height=300></div><br>"
    + "<h1><font face='Lucida Bright' size='6' color='#38B8FA'>Formas para mejorar el acceso a la educacion.</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Garantizar los recursos basicos y materiales para el aprendizaje para que todos los niños se les haga mas facil el aprender.<br>"
    + "-Mejorar la calidad de educacion, es necesaria la inversión en programas adaptados a los contextos culturales y educativos."
    + " igualdad en los procesos de aprendizaje.<br>"
    + "-Fomentar la educacion desde temprana edad para que no haya abandono escolar,los estados deben promover "
    + " facilidades para que los hogares más pobres puedan hacer frente a los costes de escolarización.<br>"
    + "-También es fundamental aplicar programas de salud o nutrición, invertir en el cumplimiento de las necesidades básicas"
    + " y en carreteras para tambien tener facil acceso a los centros educcativos</h2></div><br>"
    + "<a href = 'https://www.youtube.com/watch?v=1rPk7IJtmSs'>Video de retroalimentacion</a><br>" 
    + "<a href='https://plan-international.es/girls-get-equal/acceso-educacion'>pagina web 1</a><br>"
    + "<a href='https://es.wikipedia.org/wiki/Acceso_universal_a_la_educaci%C3%B3n'>pagina web 2</a><br>"
    + "<a href='https://www.elespectador.com/educacion/en-colombia-3-de-cada-10-personas-en-edad-escolar-no-estan-estudiando-por-que-noticias-hoy/'>pagina web 3</a><br>"
    + "</body></html>",
    
    //capitulo 4                              
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>EDUCACION INCLUSIVA</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Definicion</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>Para garantizar una educación de calidad es importante que todo los niños, niñas y adolescentes "
    + " participen en las actividades de aprendizaje, y hablando de esto hay que garantizar que todos los niños "
    + " tengan acceso garantizado a la educación, ya que esto es un derecho fundamental que debemos de tener todos los humanos,"
    + " la educación hace un papel fundamental en las personas que vamos a hacer el día de mañana.<br>" 
    + " Pero hablando de esto no solo es que se vaya  a tener preferencia a las personas con discapacidad,"
    + " sino a todos alumnos a enseñar en general sin importar la raza, condición social, estrato ,genero, religión etc.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap4 + " width=675 height=400></div><br>"
    + " <a href = 'https://www.youtube.com/watch?v=gT_3Jxrdbgs'>Video de retroalimentacion</a><br>"
    + "<a href='https://www.educo.org/Blog/Que-es-educacion-inclusiva-y-por-que-es-importante'>pagina web 1</a><br>"
    + "<a href='https://www.unesco.org/es/education/inclusion'>pagina web 2</a><br>"
    + "<a href='https://www.educacionyfp.gob.es/mc/sgctie/educacion-inclusiva.html'>pagina web 3</a><br>" 
    + "</body></html>",
    
    //capitulo 5
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>CAPACITACION DE DOCENTES</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Los profesores tambien estudian</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Esta parte es fundamental para poder lograr una educacion de calidad excelente, ya que estos docentes son los que van a enseñar"
    + " a nuestros estudiantes para que salgan capacitados y cumpliendo con todos los requerimientos, estos docentes tienen que estar"
    + " capacitados para poder tener la capacidad de enseñar a cualquier niño y hacerlo de una manera excelente y de calidad<br>"
    + " Pero lastimosamente a dia de hoy todavia hay profesores que no son tan buenas o se quedan mucho en lo antiguo, y eso aveces puede"
    + " funcionar pero ya estamos en una epoca que han evolucionado muchas cosas y que deberian cambiar la metodologia de sus clases y de la forma en que enseñan.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap5 + " width=675 height=400></div><br>"
    + "<h1><font face='Lucida Bright' size='6' color='#38B8FA'>Formas de mejorar como docente</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Uno de los aspectos que puede mejorar un docente es la comunicacion con el estudiante ya que esta es importante"
    + " ya que si hay buena comunicacion el estudiante va a resibir la informacion de buena manera y entendiendo.<br>"
    + "-Un buen docente tiene que hacer tambien autoevaluacion para mirar y fijarse si esta haciendo las cosas bien"
    + " y corregir en caso de que crea que esta fallando algo, ya que aunque sean profesores tambien tienen errores<br>"
    + "-Al momento de planificar las clases hay que ser comprensivos y tener en cuenta que hay alumnos"
    + " que no van a entender a la misma velocidad que otros o que se toman mas tiempo al momento de entender un tema.<br>"
    + "-Siempre como docente se debe estar actualizado con lo ultimo, buscando y apoyandose de nuevas herramientas"
    + " que van sacando con el paso del tiempo y que cada vez hay mas tecnologia.</h2></div><br>"           
    + "<a href = 'https://www.youtube.com/watch?v=pCNs2va3D18'>Video de retroalimentacion</a><br>"
    + "<a href='https://mineducacion.gov.co/portal/adelante-maestros/Formacion/Formacion-Docente-para-la-Calidad-Educativa/'>pagina web 1</a><br>"
    + "<a href='https://educacion.nexos.com.mx/importancia-de-la-formacion-docente-en-la-actualidad/'>pagina web 2</a><br>"
    + "<a href='https://www.uaeh.edu.mx/scige/boletin/huejutla/n9/e2.html'>pagina web 3</a><br>" 
    + "</body></html>",
    
    //capitulo 6
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>IMPACTO GLOBAL</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Educacion en todo el mundo</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Para que la educacion de calidad evolucione se tiene que expandir a todo el mundo, entre a mas personas"
    + " llegue la educacion de calidad siempre va a ser maejor, porque asi se puede ayudar a muchas personas"
    + " y el impacto global va a ser mucho mayor, y si se tiene un impacto positivo la gente va a hablar cada vez mas bien sobre "
    + " la importancia de la educacion de calidad.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap6 + " width=675 height=400></div><br>"
    + "<h1><font face='Lucida Bright' size='6' color='#38B8FA'>La eduacion a nivel global puede mejorar cosas como:</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Desarrollo económico: Si un pais es rico en gente con educacion es mas probable que ayuden al pais "
    + " con el desarrollo economico ya que los salarios serian mas alto.<br> "
    + "-Reducción de la pobreza: La educacion si es bien usada es una gran herramienta para salir de la pobreza,"
    + " ya que las personas estudiadas van a tener mas oportunidades laborales y el acceso a los recursos y asi mejorar su calidad de vida.<br>"
    + "-Salud y bienestar: Las personas educadas es mas facil que tomen desiciones sabias sobre salud y tambien tienen"
    + " tienen acceso a mejores servicios de atención médica y están más capacitados para llevar un estilo de vida saludable.<br>"
    + "-Reduccion en la desiguladad social: Aunque suene feo esto es verdad, ya que las personas se burlan de las personas que no han tenido oportunidad de tener una buena educacion,"
    + " pero si mejoramos el aspecto de la educacion, ya estas personas seran mas respetadas y tambien ascender en la escala social.</h2></div><p>" 
    + " <a href = 'https://www.youtube.com/watch?v=XrvCoUmsBuk'>Video de retroalimentacion</a><br>"
    + "<a href='https://biu.us/ventajas-desventajas-globalizacion-educacion/#:~:text=Ventajas%20de%20la%20globalizaci%C3%B3n%20en,un%20pa%C3%ADs%20distinto%20del%20suyo.'>pagina web 1</a><br>"
    + "<a href='https://blogs.worldbank.org/es/opendata/la-educacion-una-prioridad-de-desarrollo-a-nivel-mundial-regional-y-nacional'>pagina web 2</a><br>"
    + "<a href='https://www.un.org/es/impacto-acad%C3%A9mico/educaci%C3%B3n-para-todos'>pagina web 3</a><br>" 
    + "</body></html>",
    
    // Capitulo 7
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>TECNOLOGIA Y EDUCACIO</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>La tecnologia es una gran herramienta</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "La tecnología en la educación es una excelente herramienta debido a que nos  da muchas ventajas y accesibilidad para acceder "
    + " a recursos educativos, con esto también optimizamos el tiempo ya que no es como antes que los estudiantes tenían que ir a bibliotecas y "
    + " quedaban lejísimos, ahora solo es tener un dispositivo que pueda acceder al internet, pero también hay que aclarar que es importante que "
    + "la tecnología se utilice de manera equilibrada, de modo que complemente la educación tradicional y no la reemplace por completo, y mantenga un"
    + " enfoque en la interacción humana y las necesidades individuales de los estudiantes.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap7_1 + " width=675 height=400></div><br>"
    + "<h1><font face='Lucida Bright' size='6' color='#38B8FA'>Ventajas de la tecnologia</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Acceso a recursos educativos en línea.<br>"
    + "-Personalización del aprendizaje.<br>"
    + "-Interactividad y participación<br>"
    + "-Flexibilidad<br>"
    + "-Preparación para el mundo digital<br>"
    + "-Eficiencia y ahorro de tiempo</h2></div><p>" 
    + "<div align='center: left;'><img src=" + cap7_2 + " width=675 height=400></div><br>"            
    + " <a href = 'https://www.youtube.com/watch?v=8Czk6FtNxjk'>Video de retroalimentacion</a><br>"
    + "<a href='https://rockcontent.com/es/blog/tecnologia-en-la-educacion/'>pagina web 1</a><br>"
    + "<a href='https://www.intel.la/content/www/xl/es/education/technology-in-education-for-learning-and-teaching.html'>pagina web 2</a><br>"
    + "<a href='https://www.bbva.ch/noticia/importancia-de-la-tecnologia-en-la-educacion/'>pagina web 3</a><br>"
    + "</body></html>",
    
    // Capitulo 8
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>IMFRAESTRUCTURA EDUCATIVA</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Educacion en todo el mundo</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Una infraestructura educativa sólida es crucial para el éxito del sistema educativo y el desarrollo de los estudiantes. "
    + " Garantiza la igualdad de acceso a una educación de calidad, entornos de aprendizaje seguros y bien equipados, tecnología y recursos, "
    + " inclusión y motiva e involucra a los estudiantes. Además, apoya la enseñanza eficaz, la adaptabilidad a las necesidades educativas cambiantes,"
    + " mejora la reputación de la institución y, en última instancia, sienta las bases para un futuro mejor.</h2></div><p>"
    + "<div display: flex align='center: left;'><img src=" + cap8 + " width=675 height=400></div>"
    + "<h1><font face='Lucida Bright' size='5' color='#38B8FA'>Ventajas de una buena infraestructura</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Mejora la calidad de la educación.<br> "
    + "-Igualdad de oportunidades.<br>"
    + "-Innovación y adaptabilidad, con nuevas infraestructuras se pueden usar nuevas metodologias mas innovadoras.<br>"
    + "-Preparación a futuro, ya que al ser una buenas estructuras con cosas modernas prepara los alumnos para el futuro.<br>"
    + "-Fomenta la especialización, ya que con nuevos materiales de trabajo puede conducir a un mayor expertise y avances en diversos campos.<br>"
    + "-Evaluación y seguimiento ya que esto facilita la evaluación del progreso de los estudiantes, lo que ayuda a identificar áreas de mejora"
    + " y a tomar decisiones basadas en sus rendimientos para saber que se debe trabajar para mejorar los aspectos a corregir.</h2></div><p>" 
    + " <a href = 'https://www.youtube.com/watch?v=PmaDHIWB-FA'>Video de retroalimentacion</a><br>"
    + "<a href='https://www.caf.com/es/actualidad/noticias/2016/10/la-importancia-de-tener-una-buena-infraestructura-escolar/'>pagina web 1</a><br>"
    + "<a href='https://edutechnia.com/es/blog-articulo/257/Infraestructura-escolar-importante-para-la-calidad-de-la-educacin'>pagina web 2</a><br>"
    + "<a href='https://repositorio.cuc.edu.co/handle/11323/2913'>pagina web 3</a><br>" 
    + "</body></html>",
    
    // Capitulo 9
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>BECAS Y APOYO PARA LOS ESTUDIANTES</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Ayudas a lo estudiantes</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Las becas es algo muy bueno y una ayuda muy grande para los estudiantes que no tienen disponiblidad económica , "
    + "ya que la mayoría da las universidadesq ue son de alta calidad llegan a ser costosas , pero con las ayuda del estado es excelente, "
    + "por ejemplo el caso de la uceva con las ayudas de generación e o la matrícula cero.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap9 + " width=675 height=400></div><br>"
    + "<h1><font face='Lucida Bright' size='6' color='#38B8FA'>La eduacion a nivel global puede mejorar cosas como:</h1>"     
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "-Acceso a la educación<br>"
    + "-Reducción de la deuda estudiantil<br>"
    + "-Fomento del mérito y del talento<br>"
    + "-Diversidad y equidad<br>"
    + "-Desarrollo de habilidades y talentos<br>"
    + "-Redes y oportunidades<br>"
    + "-Contribución a la sociedad</h2></div><p>"
    + " <a href = 'https://www.youtube.com/watch?v=hm5TieMcBpM'>Video de retroalimentacion</a><br>"
    + "<a href='https://definicion.de/beca/'>pagina web 1</a><br>"
    + "<a href='https://www.educaweb.com/contenidos/educativos/becas-ayudas-premios/son-becas-becas-hay/'>pagina web 2</a><br>"
    + "<a href='https://www.indeed.com/orientacion-profesional/desarrollo-profesional/que-es-beca'>pagina web 3</a><br>" 
    + "</body></html>",
    
    //Capitulo 10
    "<html><body style='background-color: #2E2E2E; color: white;'>"
    + "<div align='center'><font face='Lucida Bright' size='6' color='#38B8FA'><b>CONCLUSIONES</b></font></div><br>"
    + "<strong><font face='Lucida Bright' size='6' color='#38B8FA'>Resumen de lo aprendido</strong><br><br>"
    + "<div align='justify'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Para concluir este tema, sobre la importancia de este ODS #4, lo principal es buscar la educación inclusiva, "
    + " equitativa y de calidad para todos los niños, niñas y adolescentes de todo el mundo, la educación tendría que ser "
    + " un derecho básico para todos sin importar género, religión, raza, estrato etc.</h2></div><p>"
    + "<div align='center: left;'><img src=" + cap10 + " width=675 height=400></div><br>"
    + "<div align='left'><h2><font color='White' face='Lucida Bright' size='5'>"
    + "Tambien hablar de que esto debemos de aplicar a nuestra universidad, para poder mejorar en nuestra educacion,"
    + " todas las universidades son buenas, pero siempre se puede mejorar y lograr una educacion casi perfecta.<br>"
    + "Las universidades tienen que lograr que todos los alumnos tenga fácil acceso a la universidad, ya que muchas personas no "
    + " tienen la posibilidad de pagar las matrículas que muchas veces son caras, y si llegamos a más personas más rápido vamos a "
    + " obtener el logro que tenemos, pero esto solo se logra si trabajamos todos juntos.</h2></div><p>"            
    + " <a href = 'https://www.youtube.com/watch?v=Axrfh2cae7E'>Video de retroalimentacion</a><br>"
    + "<a href='https://www.un.org/es/impacto-acad%C3%A9mico/educaci%C3%B3n-superior#:~:text=El%20ODS%204%20incluye%20el,y%20terciaria%2C%20incluyendo%20universidad%E2%80%9D.'>pagina web 1</a><br>"
    + "<a href='https://www.redalyc.org/journal/7041/704173394009/html/'>pagina web 2</a><br>"
    + "<a href='https://hazrevista.org/rsc/2019/09/como-pueden-las-universidades-contribuir-con-los-ods/'>pagina web 3</a><br>" 
    + "</body></html>"};
    }
    
    
}
