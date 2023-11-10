package HumanidadesPack;

import AppMainSrc.BasicButton;
import AppMainSrc.OptionButton;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Test_Huma extends JPanel {
    
    public Estructura e = new Estructura();
    private BasicButton responder, limpiar,sig,ant;
    private int puntaje = 0;
    private int contPreg = 0;
    private int cantidadPreguntas = 5;
    private String[] preguntas = {
         " ¿Cuál es el objetivo del ODS #4 de la ONU?",
         " ¿Qué niveles de educación abarca el ODS 4?",
         " ¿Cuál es uno de los temas tratados en los capítulos relacionados con el ODS 4?",
         " ¿Cuál es una de las metas específicas del ODS #4?",
         " ¿Por qué es importante el acceso a la educación?",
         " ¿Qué significa educación inclusiva?",
         " ¿Por qué es importante capacitar a los docentes?",
         " ¿Cuál es el impacto global de la educación de calidad?",
         " ¿Por qué se considera la tecnología una gran herramienta en la educación?",
         " ¿Por qué es crucial tener una infraestructura educativa sólida?",
         " ¿En qué consisten las becas y ayudas para estudiantes?",
         " ¿Cuál es la importancia del ODS #4?",
         " ¿Cuál es el rango de edades que abarca el ODS #4?",
         " ¿Qué papel juegan los gobiernos en la implementación del ODS 4?",
         " ¿Por qué es esencial garantizar que todos los niños tengan acceso a la educación?",
         " ¿Cuál es uno de los temas tratados en los capítulos relacionados con el ODS 4?",
         " ¿Cuál es uno de los objetivos de las becas y apoyos para estudiantes?",
         " ¿Cuál es el impacto global de una educación de calidad?",
         " ¿Por qué es importante capacitar a los docentes?",
         " ¿Cuál es el papel de la tecnología en la educación?",
         " ¿Cuál es la importancia de una infraestructura educativa sólida?",
         " ¿En qué consisten las becas y ayudas para estudiantes?",
         " ¿Qué representa el ODS #4 de la ONU?",
         " ¿Cuál es el alcance de la educación inclusiva?",
         " ¿Por qué es esencial capacitar a los docentes en la actualidad?",
         " ¿Cuál es la importancia de expandir la educación de calidad a nivel global?",
         " ¿Por qué se considera la tecnología una herramienta valiosa en la educación?",
         " ¿Cuál es el impacto de una infraestructura educativa sólida en los estudiantes?",
         " ¿Cuál es uno de los beneficios de las becas y apoyos para estudiantes?",
         " ¿Cuál es la principal conclusión del ODS #4?"
       
    };

    private String[][] opcRespuestas = {
         {"A) Garantizar la igualdad de género", "B) Promover el acceso a la salud", "C) Garantizar una educación inclusiva y de calidad"},
         {"A) Solo la educación primaria", "B) Solo la educación secundaria", "C) Desde la educación preescolar hasta la formación técnica y profesional"},
         {"A) Agricultura sostenible", "B) Acceso a la educación", "C) Tecnología espacial"},
         {"A) Reducir la desigualdad de ingresos", "B) Fomentar la educación de calidad desde temprana edad", "C) Aumentar la producción de energía eléctrica"},
         {"A) Para garantizar que todos tengan habilidades de lectura, escritura y matemáticas", "B) Para aumentar la producción agrícola", "C) Para desarrollar infraestructura vial"},
         {"A) Ofrecer educación solo a personas discapacitadas", "B) Garantizar que todos los alumnos tengan acceso a la educación sin importar su condición", "C) Limitar el acceso a la educación solo a ciertos grupos sociales"},
         {"A) Para reducir la calidad de la educación", "B) Para mantener las mismas metodologías de enseñanza antiguas", "C) Para asegurar que los docentes enseñen de manera excelente y de calidad"},
         {"A) Reducir la igualdad de género", "B) Aumentar la producción de petróleo", "C) Contribuir al desarrollo y el bienestar de las personas en todo el mundo"},
          {"A) Porque optimiza el tiempo y proporciona acceso a recursos educativos", "B) Porque no es accesible para la mayoría de los estudiantes", "C) Porque no requiere acceso a Internet"},
          {"A) Para fomentar la discriminación en el sistema educativo", "B) Para garantizar la igualdad de acceso a una educación de calidad", "C) Para limitar la adaptabilidad a las necesidades educativas cambiantes"},
          {"A) En proporcionarles materiales de lujo", "B) En limitar el acceso a la educación", "C) En ayudar a los estudiantes que no tienen recursos económicos a financiar su educación"},
          {"A) Promover la igualdad de ingresos", "B) Garantizar una educación inclusiva, equitativa y de calidad para todos", "C) Reducir la inversión en infraestructura educativa"},
          {"A) Solo niños en edad preescolar", "B) Niños y niñas de 6 a 10 años", "C) Desde la educación preescolar hasta la formación técnica y profesional"},
          {"A) Un papel importante", "B) Ningún papel", "C)  Un papel secundario"},
          {"A) Para limitar el acceso a la educación según la religión", "B) Para promover la igualdad de género", "C) Porque es un derecho fundamental y es crucial para el desarrollo futuro"},
          {"A) Acceso a la educación", "B) Desarrollo de la tecnología espacial", "C) Promoción de la agricultura sostenible"},
          {"A) Reducir la inversión en educación", "B) Limitar el acceso a la educación", "C) Ayudar a estudiantes sin recursos financieros a financiar su educación"},
          {"A) Aumentar la producción de petróleo", "B) Contribuir al desarrollo y el bienestar de las personas en todo el mundo", "C) Fomentar la igualdad de ingresos"},
          {"A) Para mantener las metodologías de enseñanza antiguas", "B) Para garantizar que los docentes enseñen de manera excelente y de calidad", "C) Para reducir la calidad de la educación"},
          {"A) Reemplazar completamente la educación tradicional", "B) Mantener la educación tradicional sin cambios", "C) Optimizar el tiempo y proporcionar acceso a recursos educativos"},
          {"A) Garantizar entornos de aprendizaje seguros y bien equipados", "B) Reducir la adaptabilidad a las necesidades educativas cambiantes", "C) Limitar la igualdad de acceso a una educación de calidad"},
          {"A) En promover la discriminación en la educación", "B) En reducir la calidad de la educación", "C) En ayudar a los estudiantes que no tienen recursos económicos a financiar su educación"},
          {"A) Un enfoque en la conservación de la biodiversidad ", "B) Una estrategia para reducir la producción de alimentos", "C) Un compromiso con la educación inclusiva, equitativa y de calidad"},
          {"A) Limitar la educación solo a personas discapacitadas ", "B) Garantizar que todos los alumnos tengan acceso a la educación sin importar su condición", "C) Limitar la educación solo a un grupo religioso "},
          {"A) Para mantener las mismas metodologías de enseñanza antiguas ", "B) ) Para reducir la calidad de la educación", "C) Para garantizar que los docentes enseñen de manera excelente y de calidad "},
          {"A) Reducir el impacto positivo en la sociedad", "B) Fomentar la discriminación en la educación", "C)  Contribuir al desarrollo y el bienestar de más personas en todo el mundo"},
          {"A) Porque optimiza el tiempo y proporciona acceso a recursos educativos", "B) Porque reemplaza por completo la educación tradicional", "C) Porque no requiere acceso a Internet"},
          {"A) Limitar la igualdad de acceso a una educación de calidad", "B) Garantizar entornos de aprendizaje seguros y bien equipados", "C) Reducir la adaptabilidad a las necesidades educativas cambiantes"},
          {"A) Limitar el acceso a la educación", "B) Reducir la calidad de la educación", "C) Ayudar a estudiantes sin recursos financieros a financiar su educación"},
          {"A) Garantizar una educación inclusiva y equitativa de calidad para todos los niños, niñas y adolescentes del mundo", "B) Promover la igualdad de ingresos", "C) Garantizar una educación de calidad solo para algunos grupos"},};
       

    private String[] correctas = {"C", "C", "B", "B", "A", "B", "C", "C", "A", "B", "C", "B", "C", "A", "C", "A", "C", "B", "B", "C", "A", "C", "C", "B", "C", "C", "A", "B", "C", "A"};
    
    private int[][] quest = new int[2][5];

    private JLabel labelPregunta,labelrespuesta,adv;
    private OptionButton[] opciones;
    private Random random = new Random();
    private Registro registro;

    public Test_Huma(Registro registro) {

        setSize(1074, 800);
        setBackground(new Color(46, 46, 46));
        setLayout(null);
        this.registro = registro;

        labelPregunta = new JLabel();
        labelPregunta.setBounds(266, 100, 550, 100);
        labelPregunta.setHorizontalAlignment(JLabel.CENTER);
        labelPregunta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        labelPregunta.setForeground(Color.WHITE);
        
        add(labelPregunta);
        
        labelrespuesta = new JLabel();
        labelrespuesta.setBounds(30, 30, 850, 30);
        labelrespuesta.setHorizontalAlignment(JLabel.CENTER);
        labelrespuesta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        labelrespuesta.setForeground(Color.WHITE);
        add(labelrespuesta);
        labelrespuesta.setVisible(false);
        
        adv = new JLabel("seleccione una pregunta");
        adv.setBounds(250, 550, 550, 100);
        adv.setForeground(Color.RED);
        adv.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 20));
        adv.setHorizontalAlignment(JLabel.CENTER);
        adv.setVerticalAlignment(JLabel.CENTER);
        add(adv);
        adv.setVisible(false);

        opciones = new OptionButton[3];
        
        


        for (int i = 0; i < 3; i++) {
            opciones[i] = new OptionButton(opciones);
            opciones[i].setLocation(200, 250 + i*75 );
            opciones[i].setForeground(Color.BLACK);
            

            add(opciones[i]);
        }
        
        

        responder = new BasicButton() {
            @Override
            public void clickEvent() {
                comprovar();
            }
        };
        responder.setText("reponder");
        responder.setBounds(550, 650, 160, 54);
        responder.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        responder.getText().setVerticalAlignment(JLabel.CENTER);
        responder.getText().setHorizontalAlignment(JLabel.CENTER);
        responder.getText().setSize(160, 54);
        responder.setLayout(null);
        responder.setColor(new Color(0, 188, 255));
        responder.setForeground(Color.WHITE);
        add(responder);

        limpiar = new BasicButton() {
            @Override
            public void clickEvent() {
                limpiarRespuestas();
            }
        };
        limpiar.setText("Limpiar");
        limpiar.setBounds(350, 650, 160, 54);
        limpiar.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        limpiar.getText().setVerticalAlignment(JLabel.CENTER);
        limpiar.getText().setHorizontalAlignment(JLabel.CENTER);
        limpiar.getText().setSize(160, 54);
        limpiar.setLayout(null);
        limpiar.setColor(new Color(0, 188, 255));
        limpiar.setForeground(Color.WHITE);
        add(limpiar);
        
        sig = new BasicButton() {
            @Override
            public void clickEvent() {
                sig();
            }
        };
        sig.setText("Siguiente");
        sig.setBounds(750, 650, 160, 54);
        sig.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        sig.getText().setVerticalAlignment(JLabel.CENTER);
        sig.getText().setHorizontalAlignment(JLabel.CENTER);
        sig.getText().setSize(160, 54);
        sig.setLayout(null);
        sig.setColor(new Color(0, 188, 255));
        sig.setForeground(Color.WHITE);
        add(sig);
        
        ant = new BasicButton() {
            @Override
            public void clickEvent() {
                ant();
            }
        };
        ant.setText("Anterior");
        ant.setBounds(150, 650, 160, 54);
        ant.getText().setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        ant.getText().setVerticalAlignment(JLabel.CENTER);
        ant.getText().setHorizontalAlignment(JLabel.CENTER);
        ant.getText().setSize(160, 54);
        ant.setLayout(null);
        ant.setColor(new Color(0, 188, 255));
        ant.setForeground(Color.WHITE);
        add(ant);
        
        Ramdons();
      
        mostrarPregunta();
    }
    
    public void Ramdons(){
        for (int i = 0; i < quest[0].length; i++) {
            quest[0][i] = random.nextInt(preguntas.length);
            quest[1][i] = -1;
        }
    }
    
    private void mostrarPregunta() {
        labelPregunta.setText("<html><p align=center>"+preguntas[quest[0][contPreg]]+"</p></html>");
        labelPregunta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
        for (int i = 0; i < opciones.length; i++) {
            opciones[i].setText(opcRespuestas[quest[0][contPreg]][i]);
            opciones[i].setClicked(false);
        }
    }

    private void comprovar() {
        int respuestaSeleccionada = -1;

        if (!responder.isClicked()) {

                for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].isClicked()) {
                    respuestaSeleccionada = i;  
                    quest[1][contPreg] = i;
                    break;
                }
            }

            if (respuestaSeleccionada != -1)  {
                int preguntaActual = quest[0][contPreg];
                String respuestaSeleccionadaTexto = opciones[respuestaSeleccionada].getText();
                
                if (respuestaSeleccionadaTexto.substring(0, 1).equals(correctas[preguntaActual])) {
                    puntaje++; // Incrementa el puntaje en caso de respuesta correcta
                }
                
                limpiarRespuestas();
                contPreg++;
                if (contPreg < cantidadPreguntas) {
                    mostrarPregunta();
                } else {
                    responder.setClicked(true);
                    labelrespuesta.setText("Puntaje final: " + puntaje + " de " + cantidadPreguntas);
                    labelrespuesta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
                    labelrespuesta.setLocation(250, 550);
                    labelrespuesta.setVisible(true);
                    responder.setText("volver");
                }
                
            }else adv.setVisible(true);
            
        } else evento_volver();
    }

    private void limpiarRespuestas() {
        for (OptionButton o : opciones) {
            o.setClicked(false);
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void sig(){
        if(contPreg < 4){
            contPreg++;
            mostrarPregunta();
            limpiarRespuestas();
        }
    }
    
    public void ant(){
        if(contPreg > 0 && !responder.isClicked()){
            contPreg--;
            mostrarPregunta();
            if(quest[1][contPreg] != -1){
                if (opciones[quest[1][contPreg]].getText().substring(0, 1).equals(correctas[quest[0][contPreg]]))
                    puntaje--;
                opciones[quest[1][contPreg]].setClicked(true);
                quest[1][contPreg] = -1;
                System.out.println(puntaje);
            }
        }
    }
    
    public void evento_volver(){
        registro.remove(this);
        responder.setClicked(true);
        responder.setText("responder");
        registro.setPuntaje(puntaje);
        registro.ocultar(true);
    }  
}
