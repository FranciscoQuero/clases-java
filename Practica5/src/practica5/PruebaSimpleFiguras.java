/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Francis
 */
public class PruebaSimpleFiguras {
    public static void main(String[] args){
        Scanner conin = new Scanner(System.in);
        Circulo circulo;
        Rectangulo rectangulo;
        
        System.out.print("Escribe por favor el ancho y alto del rectangulo: ");
        double ancho = conin.nextDouble();
        double alto = conin.nextDouble();
        System.out.print("Escribe por favor el radio del circulo: ");
        double radio = conin.nextDouble();
        
        circulo = new Circulo(radio);
        rectangulo = new Rectangulo(ancho, alto);
        
        Rectangulo rectanguloDelimitadorCirculo = rectanguloDelimitador(circulo);
        Rectangulo rectanguloDelimitadorRectangulo = rectanguloDelimitador(rectangulo);
        
        PruebaSimpleFiguras.imprime(rectanguloDelimitadorCirculo);
        PruebaSimpleFiguras.imprime(rectanguloDelimitadorRectangulo);
        
        System.out.println(circulo.compareTo(rectangulo));
    }
    
    static void imprime(Figura figura){
        String texto = "";
        texto = texto + figura.getClass().getName().substring(figura.getClass().getName().indexOf(".")+1) + "\n";
        long tiempo = Date.from(Instant.now()).getTime() - figura.fechaCreacion.getTime();
        texto = texto + "Tiempo desde su creacion: " + tiempo + " milisegundos.\n";
        texto = texto + "Area: " + figura.getArea() + "\nPerimetro: " + figura.getPerimetro();
        
        System.out.println(texto);
    }
    
    static Rectangulo rectanguloDelimitador(Figura figura){
        if (figura instanceof Circulo){
            double radio = 2*((Circulo) figura).getRadio();
            return new Rectangulo(radio, radio);
        } else if (figura instanceof Rectangulo){
            return (Rectangulo)figura;
        } else {
            return null;
        }
    }
}