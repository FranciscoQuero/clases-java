/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

public class WriteData {
    public static void main(String[] args) throws java.io.IOException {
        java.io.File file = new java.io.File("scores.txt");
        if (file.exists()) {
            System.out.println("El fichero ya existe");
            System.exit(0);
        }
        // Crear el fichero
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        // Escribir salida formateada en el fichero
        output.print("Jacinto Campos ");
        output.println(90);
        output.print("Buenaventura Olmedo ");
        output.println(85);
        // Cerrar el fichero
        output.close();
    }
}
