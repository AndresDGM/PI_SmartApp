package HumanidadesPack;

import AppMainSrc.BasicButton;
import AppMainSrc.OptionButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Test_Huma extends JPanel {

    BasicButton responder, limpiar;
    
    
    
    private int puntaje = 0;
    private int preguntasMostradas = 0;
    private int cantidadPreguntas = 5;
    private ArrayList<Integer> preguntasMostradasList = new ArrayList<>();
    private String[] preguntas = {
        " ¿Cuál es el desafío principal en la educación superior en Centroamérica y República Dominicana?",
        " ¿Qué función debe cumplir la universidad según el Objetivo 4 de los ODS?",
        " ¿Qué organismo ha consensuado el PIRESC IV para abordar desafíos en la educación superior?",
        " ¿Qué busca la educación ambiental según el capítulo 3?",
        " ¿Por qué la Educación Superior es clave para el desarrollo sostenible?",
        " ¿Qué desafío se menciona en el capítulo 5 en relación a la educación en América Latina?",
        " ¿Cuál es el objetivo del Objetivo 4 de los ODS?",
        " ¿Qué cátedra han firmado la Universidad Complutense y la Alianza de la Sanidad Privada Española?",
        " ¿Qué han tenido que adaptar muchas empresas debido a la pandemia?",
        " ¿Cuál es la importancia de abordar la brecha digital en la educación en línea?",
        " ¿Qué ha expuesto la pandemia en el ámbito educativo?",
        " ¿Qué función debe cumplir la educación en derechos humanos en la recuperación de la COVID-19?",
        " ¿Qué deben conceder las instituciones  financieras internacionales a los países según el capítulo 10?",
        " ¿Cuál es el objetivo del PIRESC IV?",
        " ¿Qué dimensiones integra el desarrollo sostenible en la actualidad?",
        " ¿Qué papel tienen las empresas en la consecución del ODS 4?",
        " ¿Cuál es la función social que debe cumplir la universidad según el Objetivo 4 de los ODS?",
        " ¿Qué organismo respalda la cátedra extraordinaria Salud sostenible y responsable?",
        " ¿Cuál es el desafío principal mencionado en el capítulo 2 en la educación debido a la pandemia de COVID-19?",
        " ¿Qué busca la educación ambiental?",
        " ¿Cuál es el objetivo del Objetivo 4 de los ODS?",
        " ¿Qué desafío se menciona en el capítulo 5 en relación a la educación en América Latina?",
        " ¿Qué han tenido que adaptar muchas empresas debido a la pandemia?",
        " ¿Qué importancia tiene abordar la brecha digital en la educación en línea?",
        " ¿Qué ha expuesto la pandemia en el ámbito educativo?",
        " ¿Qué función debe cumplir la educación en derechos humanos en la recuperación de la COVID-19?",
        " ¿Qué deben conceder las instituciones financieras internacionales a los países según el capítulo 10?",
        " ¿Cuál es el objetivo del PIRESC IV?",
        " ¿Qué papel tienen las empresas en la consecución del ODS 4?",
        " ¿Cuál es la función social que debe cumplir la universidad según el Objetivo 4 de los ODS?"
    };

    private String[][] respuestas = {
        {"A) Problemas de calidad", "B) Problemas de financiación", "C) Problemas de gestión"},
        {"A) Función económica", "B) Función social en equidad y calidad", "C) Función política"},
        {"A) UNESCO", "B) Consejo Superior Universitario Centroamericano (CSUCA)", "C) Organización de Estados Americanos (OEA"},
        {"A) Generar críticas al desarrollo sostenible", "B) Conciliar el desarrollo y el medio ambiente", "C) Promover el antropocentrismo"},
        {"A) Porque forma a profesionales del pasado", "B) Porque produce conocimiento innovador", "C) Porque no está relacionada con los ODS"},
        {"A) Falta de financiación", "B) Brecha de ingresos entre trabajadores con educación universitaria", "C) Cierre de escuelas debido a la pandemia"},
        {"A) Garantizar una educación de calidad para todos", "B) Eliminar la educación", "C) Promover la educación en línea"},
        {"A) Cátedra de Astronomía", "B) Cátedra de Salud sostenible y responsable", "C) Cátedra de Historia del Arte"},
        {"A) Su ubicación", "B) Su estructura de precios", "C) Su enfoque en la educación"},
        {"A) Mejorar la comunicación interna de las empresas", "B) Facilitar la educación en línea", "C) Promover la educación en derechos humanos"},
        {"A) La falta de interés en la educación", "B) Las disparidades educativas preexistentes", "C) La sobreabundancia de recursos educativos"},
        {"A) Proteger la financiación de la educación", "B) Promover el acceso a la educación", "C) Proteger, respetar y promover los derechos humanos"},
        {"A) Espacio fiscal suficiente", "B) Más restricciones financieras", "C) Recursos adicionales"},
        {"A) Promover la educación en línea", "B) Abordar desafíos en la educación superior", "C) Eliminar la educación superior"},
        {"A) Solo la dimensión económica", "B) Las dimensiones económica, social y ambiental", "C) Las dimensiones social y política"},
        {"A) Ningún papel", "B) Contribuir a mejorar el acceso a la educación y fomentar la innovación", "C) Limitar el acceso a la educación"},
        {"A) Plantear problemas prioritarios de su entorno", "B) Promover la exclusión en la educación", "C) Ignorar los problemas de la sociedad"},
        {"A) La ONU", "B) La CEOE", "C) El Banco Mundial"},
        {"A) Cierre masivo de escuelas", "B) Falta de profesores", "C) Exceso de recursos educativos"},
        {"A) Promover la degradación ambiental", "B) Solucionar la problemática ambiental", "C) Ignorar el medio ambiente"},
        {"A) Promover la brecha digital", "B) Garantizar una educación de calidad para todos", "C) Eliminar la educación"},
        {"A) Brecha de ingresos entre trabajadores con educación universitaria ", "B) Falta de recursos educativos", "C) Exceso de inversión en educación"},
        {"A) Su ubicación ", "B) Su enfoque en la educación ", "CSu estructura de precios "},
        {"A) Facilitar la educación en línea ", "B) Mejorar la comunicación interna de las empresas", "C) Promover la educación en derechos humanos "},
        {"A) La falta de recursos educativos", "B) Las disparidades educativas preexistentes", "C)  La sobreabundancia de profesores"},
        {"A) Proteger, respetar y promover los derechos humanos", "B) Promover la exclusión social", "C) Limitar el acceso a la educación"},
        {"A) Espacio fiscal suficiente", "B) Más restricciones financieras", "C) Recursos adicionales"},
        {"A) Promover la educación en línea", "B) Abordar desafíos en la educación superior", "C) Eliminar la educación superior"},
        {"A) Limitar el acceso a la educación", "B) Contribuir a mejorar el acceso a la educación y fomentar la innovación", "C) Ningún papel"},
        {"A) Ignorar los problemas de la sociedad", "B) Promover la exclusión en la educación", "C) Plantear problemas prioritarios de su entorno"},};

    String[] respuestasCorrectas = {"A", "B", "B", "B", "B", "B", "A", "B", "C", "A", "B", "C", "A", "B", "B", "B", "B", "A", "A", "B", "B", "C", "A", "B", "A", "B", "A", "B", "A", "C"};

    private JLabel labelPregunta,labelrespuesta,adv;
    private OptionButton[] opciones;
    private Random random = new Random();
    private ActionListener actionListener;

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
        labelrespuesta.setBounds(30, 30, 550, 30);
        labelrespuesta.setHorizontalAlignment(JLabel.CENTER);
        labelrespuesta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 14));
        labelrespuesta.setForeground(Color.WHITE);
        add(labelrespuesta);
        labelrespuesta.setVisible(false);
        
        adv = new JLabel("seleccione una pregunta");
        adv.setBounds(30, 30, 550, 30);
        adv.setForeground(Color.RED);
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
                verificarRespuesta();
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

        mostrarPregunta();
    }

    private void mostrarPregunta() {
        if (preguntasMostradas < cantidadPreguntas) {
            int preguntaAleatoria;
            do {
                preguntaAleatoria = random.nextInt(preguntas.length);
            } while (preguntasMostradasList.contains(preguntaAleatoria));

            preguntasMostradasList.add(preguntaAleatoria);

            labelPregunta.setText("<html><p align=center>"+preguntas[preguntaAleatoria]+"</p></html>");
            labelPregunta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
            for (int i = 0; i < opciones.length; i++) {
                opciones[i].setText(respuestas[preguntaAleatoria][i]);
                opciones[i].setClicked(false);
            }
        } else {
            responder.setClicked(true);
            labelrespuesta.setText("Puntaje final: " + puntaje + " de " + cantidadPreguntas);
            //labelrespuesta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
            //labelrespuesta.setLocation(270, 550);
            labelrespuesta.setVisible(true);
            responder.setText("volver");
        }
    }

    private void verificarRespuesta() {
        int respuestaSeleccionada = -1;

        if (!responder.isClicked()) {

                for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].isClicked()) {
                    respuestaSeleccionada = i;  
                    break;
                }
            }

            if (respuestaSeleccionada == -1) {
                adv.setVisible(true);
            } else {
                int preguntaActual = preguntasMostradasList.get(preguntasMostradas);
                String respuestaSeleccionadaTexto = opciones[respuestaSeleccionada].getText();
                System.out.println("Pregunta actual: " + preguntas[preguntaActual]);
                System.out.println("Respuesta seleccionada: " + respuestaSeleccionadaTexto);

                if (respuestaSeleccionadaTexto.substring(0, 1).equals(respuestasCorrectas[preguntaActual])) {
                    puntaje++; // Incrementa el puntaje en caso de respuesta correcta
                    System.out.println("Respuesta correcta. Puntaje actual: " + puntaje);
                }

                limpiarRespuestas();
                preguntasMostradas++;
                if (preguntasMostradas < cantidadPreguntas) {
                    mostrarPregunta();
                } else {
                    responder.setClicked(true);
                    labelrespuesta.setText("Puntaje final: " + puntaje + " de " + cantidadPreguntas);
                    labelrespuesta.setFont(new Font("Lucida Bright", Font.TYPE1_FONT, 25));
                    labelrespuesta.setLocation(250, 550);
                    labelrespuesta.setVisible(true);
                    responder.setText("volver");
                }
            }
        } else {
            evento_volver();
            
        }
    }

    private void limpiarRespuestas() {
        for (OptionButton o : opciones) {
            o.setClicked(false);
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void evento_volver(){
        registro.remove(this);
        responder.setClicked(true);
        responder.setText("responder");
        registro.setPuntaje(puntaje);
        registro.ocultar(true);
    }
    /*private void mostrarResultado() {
        

        // Establece el puntaje en la instancia de Registro
        if (registro != null) {
            registro.setPuntaje(puntaje);
        }

        if (registro != null) {
            registro.setVisible(true);
            setVisible(false);
        }
    }
*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Registro registro = new Registro(); // Crea una instancia de Registro
            Test_Huma cuestionario = new Test_Huma(registro); // Pasa la instancia de Registro al cuestionario
            registro.setVisible(true); // Muestra la ventana de Registro
        });
    }
}
