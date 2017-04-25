/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Francisco J. Quero
 */
public class TestComparable {
    public static void main(String[] args){
        
        
        /*int nfiguras = Integer.parseInt(args[0]);
        double prob = Double.parseDouble(args[1]);
        int dimMax = Integer.parseInt(args[2]);*/
        
        Scanner conin = new Scanner(System.in);
        int nfiguras, dimMax;
        double prob;
        
        System.out.print("Introduce el numero de figuras: ");
        nfiguras = conin.nextInt();
        System.out.print("Introduce la probabilidad de circulos: ");
        prob = conin.nextDouble();
        System.out.print("Introduce la dimension maxima: ");
        dimMax = conin.nextInt();
        
        Figura[] figuras = randomArrayFiguras(nfiguras, prob, dimMax);
        
        Figura mayor = ComparableAlgoritmos.mayor(figuras);
        System.out.print(mayor);
        
        Figura[] figuras_copia1 = figuras.clone();
        
        System.out.println("Ordenando...");
        ComparableAlgoritmos.ordena(figuras_copia1);
        
        
        
        for (int i = 0; i < figuras.length; i++)
            System.out.println(figuras_copia1[i] + "\n");
    }
    
    static Figura[] randomArrayFiguras( int nfiguras, double prob, int dimMax){
        Figura[] figuras = new Figura[nfiguras];
        for (int i = 0; i < nfiguras; i++)
            figuras[i] = randomFigura(prob, dimMax);
        
        return figuras;
    }
    
    static Figura randomFigura(double prob, double dimMax){
        Random aleatorio = new Random();
        double numeroGenerado = aleatorio.nextDouble();
        if (numeroGenerado <= prob) {
            double radio = aleatorio.nextDouble()*dimMax/2;
            System.out.println(radio);
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
