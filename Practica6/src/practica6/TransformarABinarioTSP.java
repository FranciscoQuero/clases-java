/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Francisco J. Quero
 */
public class TransformarABinarioTSP {
    public static void main(String args[]) throws Exception{
        
        int numeroLineas = 0;
        String inputName;
        String outputName;
        if (args.length != 0) {
            inputName = args[0];
            outputName = args[1];
        } else { // Declaramos un nombre por defecto en caso de que no se especifique
            inputName = "small10.tsp";
            outputName = "default_output.data";
        }
        
        try {
            
            // Leemos primero el fichero original
            java.io.File file = new java.io.File(inputName);
            Scanner input = new Scanner(file);

            // Creamos el fichero en el que se va a escribir
            DataOutputStream output = new DataOutputStream(new FileOutputStream(outputName));
            
            // Leer datos del fichero y escribirlos
            input.next();
            
            numeroLineas = input.nextInt();
            
            for (int i = 0; i < numeroLineas; i++) {
                output.writeInt(input.nextInt());
                
                output.writeDouble(input.nextDouble());
                
                output.writeDouble(input.nextDouble());
            }
            
            input.close();
            output.close();
            
        }
        catch (EOFException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();

        }
        
        try (DataInputStream ficheroBinario = new DataInputStream(new FileInputStream(outputName))) {
            for (int i = 0; i < numeroLineas; i++)
                System.out.println(ficheroBinario.readInt() + " " + ficheroBinario.readDouble() + " " + ficheroBinario.readDouble());
        }
    }
}
