/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.util.Scanner;

/**
 *
 * @author Francisco J. Quero
 */
public class ReplaceText {
    public static void main(String[] args) throws java.io.IOException {
        String ficheroOriginal = args[0];
        String nuevoFichero = args[1];
        String stringAntiguo = args[2];
        String stringNuevo = args[3];
        
        String temporal;
        
        java.io.File ficheroEntrada = new java.io.File(ficheroOriginal);
        java.io.PrintWriter ficheroSalida = new java.io.PrintWriter(nuevoFichero);
        Scanner input = new Scanner(ficheroEntrada);
        
        while (input.hasNext()) {
            temporal = input.nextLine();
            temporal = temporal.replaceAll(stringAntiguo, stringNuevo);
            ficheroSalida.println(temporal);
        }
        ficheroSalida.close();
        
    }
}
