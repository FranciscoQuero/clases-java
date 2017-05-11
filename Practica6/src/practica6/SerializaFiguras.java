/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

/**
 *
 * @author Francisco J. Quero
 */
public class SerializaFiguras {
    public static void main(String args[]) throws ClassNotFoundException, IOException{
        String nombreFichero;
        
        // Le damos un nombre por defecto en caso de que no se proporcione
        if (args.length == 0) {
            nombreFichero = "default.bin";
        } else {
            nombreFichero = args[0];
        }
        
        // Abrimos el fichero de salida creando un flujo de salida
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(nombreFichero));
        
        // Generamos 100 objetos y los escribimos
        for (int i = 0; i<100; i++){
            output.writeObject(randomFigura(0.5, 20)); // 20 es un valor arbitrario para la dimension maxima
        }
        output.close();
        
        // Leemos el fichero y lo mostramos por la salida estandar
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(nombreFichero));
        
        for (int i = 0; i < 100; i++) {
            System.out.println(input.readObject().toString()+"\n");
        }
        
    }
    
    static Figura randomFigura(double prob, double dimMax){
        Random aleatorio = new Random();
        double numeroGenerado = aleatorio.nextDouble();
        if (numeroGenerado <= prob) {
            double radio = aleatorio.nextDouble()*dimMax/2;
            Circulo figura = new Circulo(radio);
            return figura;

        } else {
            double lado1 = aleatorio.nextDouble()*dimMax;
            double lado2 = aleatorio.nextDouble()*dimMax;
            Rectangulo figura = new Rectangulo(lado1, lado2);
            return figura;
        }
        
    }
}
