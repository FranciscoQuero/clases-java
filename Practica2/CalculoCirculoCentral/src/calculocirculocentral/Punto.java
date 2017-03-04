
package calculocirculocentral;

import java.util.Scanner;


public class Punto {
    public double x , y;
    
    public Punto() {
        x = 0;
        y = 0;
    }
    
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    
    void setCoordenadas(double nuevoX, double nuevoY){
        x = nuevoX;
        y = nuevoY;        
    }
    
    public void leer(Scanner conin){
        x = conin.nextDouble();
        y = conin.nextDouble();
    }
    
    @Override
    public String toString(){
        String cadena;
        
        cadena = String.valueOf(x)+" "+String.valueOf(y);
        
        return cadena;
    }
    
    public double calcularDistanciaEuclidea(Punto punto){
        double resultado;
        
        resultado = Math.sqrt( Math.pow((x-punto.x),2) + Math.pow((y-punto.y),2) );
        
        return resultado;
    }
    
    public Punto calcularPuntoMedio(Punto punto){
        Punto resultado = new Punto();
        
        resultado.x = (punto.x-x)/2;
        resultado.y = (punto.y-y)/2;
        
        return resultado;
    }
 }
