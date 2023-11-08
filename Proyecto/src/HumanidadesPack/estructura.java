
package HumanidadesPack;

import java.util.Properties;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class estructura {
    
    public void enviar(String parametros[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(parametros[3])); // correoDestinatario
            
            mm.setSubject(parametros[4]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[5],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage); // adicionar el texto  
                        
            mm.setContent(mp); // adicionar la informacion del objeto Multipart al mensaje
                                    
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],     // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
    
     public void enviar(String parametros[], String correosDestinatarios[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            
            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios
            
            mm.setSubject(parametros[3]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage); // adicionar el texto  
            
            mm.setContent(mp); // adicionar la informacion del objeto Multipart al mensaje
            
                        
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],      // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
     
     public void enviar(String parametros[], String correosDestinatarios[], String archivos[]){
        try{
            // --------------------------------------------------------------------------------
            //1) Configurar propiedades de la conexion             
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", parametros[1]); // correoRemitente
            props.setProperty("mail.smtp.auth", "true");

            // Preparar la sesion
            Session session = Session.getDefaultInstance(props);

            // Construir el mensaje
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress( parametros[1],      // correoRemitente
                                            parametros[0]));    // remitente
            
            InternetAddress toList[] = new InternetAddress[correosDestinatarios.length];
            for (int i = 0; i < correosDestinatarios.length; i++) { // recorrer el arreglo correosDestinatarios
                toList[i] = new InternetAddress(correosDestinatarios[i]);
            }
            mm.addRecipients(Message.RecipientType.TO, toList); // adicionar la lista de correosDestinatarios
            
            mm.setSubject(parametros[3]); // asunto
            
            // --------------------------------------------------------------------------------
            // 2) Crear el contenido del mensaje a enviar
            MimeBodyPart mime_mensage = new MimeBodyPart();
            mime_mensage.setContent(parametros[4],  // texto del mensage
                                    "text/html");   // tipo de codificacion del mensage
            
            //Crear un objeto de la Clase Multipart y adicionar las partes es este
            Multipart mp = new MimeMultipart();            
            mp.addBodyPart(mime_mensage); // adicionar el texto  
                        
            for (String nf : archivos) {
                MimeBodyPart attach = new MimeBodyPart();
                attach.attachFile(nf);
                mp.addBodyPart(attach); // adicionar el archivo 
            }
            
            mm.setContent(mp);// adicionar la informacion del objeto Multipart al mensaje
                        
            // --------------------------------------------------------------------------------
            // 3) Enviar el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(  parametros[1],      // correoRemitente
                        parametros[2]);     // contrasena de aplicaciones de Gmail
            t.sendMessage(mm, mm.getAllRecipients());
            t.close();
            
        }catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }     
    }
    
    /* public void test1(){ // enviar correo a un solo destinatario
         String parametros[] =  { "Nicolas Gutierrez Escudero, "
                                + "Sebastian Morales Florez"
                                + "Javier Eduardo Moran"
                                + "David Mora Duque",        // remitente
                                "gutinico023@gmail.com",     // correoRemitente
                                "jstxpbrztsxnbozj",                 // contrasena de aplicaciones de Gmail
                                "nicolas.gutierrez01@uceva.edu.co",              // correoDestinatario
                                "Prueba de correo desde Java",      // asunto
                                "Hola.<br>Este es un correo de prueba enviado desde <b><u>Java</u></b><br><br>chao" // mensaje
                                }; 
         enviar(parametros);
     }
     */
     /*
     public void test2(){ // enviar correo a varios destinatarios
         String parametros[] =  { "Nicolas Gutierrez Escudero," 
                                + " Sebastian Morales Florez" 
                                + "Javier Eduardo Moran"
                                + "David Mora Duque",      // remitente
                                "gutinico023@gmail.com",     // correoRemitente
                                "jstxpbrztsxnbozj",                 // contrasena de aplicaciones de Gmail
                                "Prueba de correo desde Java",      // asunto
                                "Hola.<br>Este es un correo de prueba enviado desde <b><u>Java</u></b><br><br>chao" // mensaje
                                }; 
         
         String correosDestinatarios[] = {  "llasso@uceva.edu.co",
                                            "adrianlassocardona@yahoo.es"};
         
         enviar(parametros, correosDestinatarios);
     }
     */
     public void test3(){ // enviar correo a varios destinatarios con archivos adjuntos
         String parametros[] =  { "Nicolas Gutierrez",      // remitente
                                "gutinico023@gmail.com",     // correoRemitente
                                "jstxpbrztsxnbozj",                 // contrasena de aplicaciones de Gmail
                                "Prueba de correo desde Java",      // asunto
                                "Hola.<br>Este es un correo de prueba enviado desde <b><u>Java</u></b><br><br>chao" // mensaje
                                }; 
         
         String correosDestinatarios[] = {  //"llasso@uceva.edu.co",
                                            //"adrianlassocardona@yahoo.es",
                                            "nicolas.gutierrez01@uceva.edu.co"
                                            };
         
         String archivos[] = {  "score.csv" 
                                };
         
         enviar(parametros, correosDestinatarios, archivos);
     }

    
}
