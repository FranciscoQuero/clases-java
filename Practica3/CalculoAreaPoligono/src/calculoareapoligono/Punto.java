package calculoareapoligono;

import java.util.Scanner;

public class Punto {
    private double x;
    private double y;
    /**
     * Instancia a 0 las variables x e y, las coordenadas de los puntos.
     */
    public Punto() {
        x = 0;
        y = 0;
    }
    /**
     * Devuelve un valor tipo double que corresponde a la coordenada X del punto.
     * @return devuelve la coordenada x del punto.
     */
    public double getX(){
        return x;
    }
    /**
     * Devuelve un valor tipo double que corresponde a la coordenada Y del punto.
     * @return devuelve la coordenada y del punto.
     */
    public double getY(){
        return y;
    }
    
    /**
     * Establece las coordenadas del punto a las nuevas introducidas.
     * @param nuevoX nueva coordenada X del punto.
     * @param nuevoY nueva coordenada Y del punto.
     */
    public void setCoordenadas(double nuevoX, double nuevoY){
        this.x = nuevoX;
        this.y = nuevoY;        
    }
    /**
     * Establece las coordenadas del punto al valor leído a través de
     * un punto escrito por el usuario coordenada a coordenada.
     * @param conin objeto de la clase Scanner necesario para leer.
     */
    public void leer(Scanner conin){
        x = conin.nextDouble();
        y = conin.nextDouble();
    }
    
    /**
     * Convierte las coordenadas del punto en un String formateado.
     * @return Devuelve un String compuesto de coordenada X, un espacio
     * y la coordenada Y.
     */
    @Override
    public String toString(){
        String cadena;
        
        cadena = String.valueOf(x)+" "+String.valueOf(y);
        
        return cadena;
    }
    /**
     * Calcula la distancia euclídea entre un punto proporcionado y el mismo 
     * punto desde el que se llama al método.
     * @param punto Un objeto de la clase Punto con el que se calculará la 
     * distancia.
     * @return Devuelve un resultado tipo double que consiste en la distancia
     * entre ambos puntos.
     */
    public double calcularDistanciaEuclidea(Punto punto){
        double resultado;
        
        resultado = Math.sqrt( Math.pow( ( this.x-punto.getX() ),2) + Math.pow( ( this.y-punto.getY() ),2) );
        
        return resultado;
    }
    /**
     * Calcula el punto medio entre un punto proporcionado y el mismo 
     * punto desde el que se llama al método.
     * @param punto Un objeto de la clase Punto con el que se calculará el
     * punto medio.
     * @return Devuelve un resultado de la clase Punto consistente en el punto
     * medio calculado.
     */
    public Punto calcularPuntoMedio(Punto punto){
        Punto resultado = new Punto();
        
        resultado.x = (punto.x-x)/2;
        resultado.y = (punto.y-y)/2;
        
        return resultado;
    }
 }
