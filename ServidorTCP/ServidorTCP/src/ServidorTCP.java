/*
 * ServidorTCP.java
 *
 * Created on March 16, 2006, 5:06 PM
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
public class ServidorTCP {
        
    static final int errorAlAbrirPuerto=1;
    static final int errorAlEscucharSocket=2;
    static final int errorAlAceptarConexion=3; 
    static final int errorCerrarConexionServicio=4;
            
    static PrintWriter out;
    static BufferedReader in;
    
    // Socket que se utilizara' para recibir peticiones de servicio
    static ServerSocket socket = null;
    // Socket que se utilizara' para realizar la transaccio'n con el cliente
    static Socket socketServicio=null;
    
    /** Creates a new instance of ServidorOraculoTCP */
    public ServidorTCP() {
    }
    
    static int inicializarRed(int puerto){
        int error=0;
        
        try {    
            // Se crea el socket que leera' del puerto indicado:
            socket = new ServerSocket(puerto);
        } catch (IOException e) {
            error=errorAlAbrirPuerto;           
        }
        
        return error;
    }
    
     static String  recibirSolicitud() {
        String pregunta=null;
        String mensaje;
        String [] palabras;
        DatagramPacket paquete;
        byte [] octetosMensaje=new byte[1024];
        

        
        try {
            socketServicio=socket.accept();
        } catch (IOException e){
            //error=errorAlAceptarConexion;
            // throw ...
            return null;
        }    
        
        // Preparamos los flujos para leer y escribir los mensajes:
        try {
            out= new PrintWriter(socketServicio.getOutputStream(), true);
            in= new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));
        } catch(IOException e){
            
            return null;
        }
        
        try {
            mensaje=in.readLine();
        } catch (IOException e){
            return null;
        }
        
        // Se procesa el mensaje recibido:
        palabras=mensaje.split(",");
        
        // Si el mensaje es de solicitud:
        if(palabras[2].compareTo("PREDICE")==0){
            pregunta=new String(palabras[3]);
        }
        
        return pregunta;
    }
     
    private static int enviarRespuesta(String sugerencia) {
       int error=0;
        
        // El mensaje 
        String mensaje;
                
        mensaje="ORACULO/1.1,ok,"+sugerencia;
    
        // Creamos el datagrama aniadiendo nuestro mensaje, y lo enviamos 
        out.println(mensaje);
    
        
        try {
            in.close();
            out.close();
            socketServicio.close();
        } catch(IOException e){
            error=errorCerrarConexionServicio;
        }
        return error;
    }
    
     public static void main(String args[]) {
        int error=0;
        
        int puerto;
        String pregunta=null;
        
        Bola8 oraculo=new Bola8();
        
        if(args.length<1){
            System.err.println("Sintaxis: ServidorTCP puerto");
            System.exit(-1);
        }
        
        puerto=Integer.valueOf(args[0]);
        
        if(inicializarRed(puerto)==0){
            String peticion=null;
            String sugerencia=null;
            boolean salir=false;
            
            
            // Mientras no haya que salir, se ejecuta el ciclo de servicio del servidor:
            do{
                peticion=recibirSolicitud();
                
                if(peticion!=null){
                    sugerencia=oraculo.obtenerPrediccion();
                
                    if(enviarRespuesta(sugerencia)!=0){
                        System.err.println("Error al cerrar el socket de servicio");
                        salir=true;
                    }
                    
                
                    
                    
                } else {
                    salir=true;
                }
                
            } while(!salir);
                
        } else {
          
            System.err.println("Error al crear el socket.");
            error=2;
        }
        
        
        
        
        System.exit(error);
    }
}
