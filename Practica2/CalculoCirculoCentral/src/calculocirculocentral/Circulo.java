
package calculocirculocentral;

import java.util.Scanner;

public class Circulo {
    public Punto centro = new Punto();    
    public double radio;

    public Circulo() {
        centro.x = 0;
        centro.y = 0;
        radio = 0;
    }
    
    @Override
    public String toString(){
        String cadena;
        
        cadena = String.valueOf(radio)+" "+centro.toString();
        
        return cadena;
    }
    
    public void set(double r, Punto c){
        centro.setCoordenadas(c.x, c.y);
        radio = r;
    }
    
    public void leer(Scanner conin){
        radio = conin.nextDouble();
        centro.leer(conin);
    }
    
    public double getRadio(){
        return radio;
    }
    
    /*Duda con esto!!! ¿Deberia volver el punto, las coordenadas por separado
    o imprimirlos directamente */
    public Punto getCentro(){
        return centro;
    }
    
    public double getArea(){
        double calculo;
        
        calculo = Math.PI * Math.pow(radio, 2);
        
        return calculo;
    }
    
}
