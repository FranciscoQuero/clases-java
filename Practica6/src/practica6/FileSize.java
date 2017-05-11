/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Francisco J. Quero
 */
public class FileSize {
    public static void main(String args[]) throws IOException{
        // Crear objeto File
        
        FileInputStream f0 = new FileInputStream(args[0]);
        boolean eof = false;
        // Leer datos del fichero
        int contador = 0;
        int temporal;
        while (!eof) {
            temporal = f0.read();
            if (temporal == -1){
                eof = true;
            } else {
                contador++;
            }
        }
        
        System.out.println("El fichero tiene "+contador+" Bytes.");
        // Cerrar el fichero
        f0.close();
    }
}
