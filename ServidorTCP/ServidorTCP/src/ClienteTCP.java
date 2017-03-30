/*
 * ClienteTCP.java
 *
 * Created on March 16, 2006, 3:09 PM
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */


import java.io.*;
import java.net.*;

/**
 *
 * @author jjramos
 */
public class ClienteTCP {

    static final int anfitrionNoEncontrado=1;
    static final int imposibleEstablecerConexion=2;
    
    
    static final int errorEnCierre=1;
    
    static PrintWriter out = null;
    static BufferedReader in = null;
    
    // Declaramos el socket:
    static Socket socket;
            
    /** Creates a new instance of ClienteOraculoTCP */
    public ClienteTCP() {
    }
    
    static int inicializarRed(String servidor,int puerto){
        int error=0;
        
        
        // Creamos el socket y establecemos la conexio'n TCP con el servidor:
        try {            
            socket = new Socket(servidor, puerto);
            
            // Abrimos los flujos de envi'o/recepcio'n:
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
        } catch (UnknownHostException e) {
                return anfitrionNoEncontrado;               
        } catch (IOException e) {
                return imposibleEstablecerConexion;
        };
        
        return error;
    }
     
    
    static int finalizarRed(){
        int error=0;
    
        // Cerramos los flujos y el socket:
        try{
            in.close();
            out.close();
            socket.close();         
        } catch(IOException e){
            
            error=errorEnCierre;
        }
        
        return error;
    }
    
     static int enviarSolicitud(String nombre){
        int error=0;
        
        // El mensaje lo introducimos en el vector de octetos:
        byte[] octetosMensaje;
        String mensaje;
    
        mensaje="ORACULO,1.1,PREDICE,"+nombre;
    
        // Enviamos nuestro mensaje, "por el socket"
        out.println(mensaje);
    
        return error;
    }
     
    static String recibirRespuesta() {
        String [] palabras;
        String consejo;
        String mensaje;
        char[] caracteresMensaje=new char[1024];
        int i=0;
        
        // Como sabesmo que so'lo va a venir un mensaje, solicitamos caracteres hasta '\n':
        
        try{
            mensaje=in.readLine();
        } catch (IOException e){
            return null;
        }
        
        palabras=mensaje.split(",");
        
        mensaje=palabras[2];
        
        return mensaje;
    }
    
   
    public static void main(String args[]) {
     String sugerencia;
        String servidor;
        String pregunta;
        int puerto;
        
        
        
        if(args.length<3){
            System.err.println("Sintaxis: ClienteTCP servidor puerto pregunta");
            System.exit(-1);
        }
        
        puerto=Integer.valueOf(args[1]);
        servidor=args[0];
        pregunta=args[2];
         
        if(inicializarRed(servidor, puerto)!=0){
            System.err.println("Error al abrir el socket.");
        } else {
            
            enviarSolicitud(pregunta);
            sugerencia=recibirRespuesta();
            if(sugerencia!=null){
                System.out.println("A la cuestio'n de \""+pregunta+"\", " +
                        "el Ora'culo responde: \""+sugerencia+"\"");
                
            }
                        
            finalizarRed();
        }
    }   
}
