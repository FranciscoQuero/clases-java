
package calculocirculocentral;

import java.util.Scanner;

/**
 * Clase Circulo compuesta de un objeto de la clase Punto llamado centro
 * y una variable tipo double llamada radio. Contiene los métodos necesarios para
 * realizar cálculos con sus componentes así como para inicializar, leer
 * y establecer los distintos componentes a los valores deseados.
 * 
 * @author Francisco Jesús Quero de la Rosa
 */
public class Circulo {
    public Punto centro = new Punto();    
    public double radio;
    
    /**
     * Instancia el centro al punto origen (0, 0) y el radio a 0.
     */
    public Circulo() {
        centro.x = 0;
        centro.y = 0;
        radio = 0;
    }
     /**
     * Convierte las coordenadas del centro y el radio en un String formateado.
     * @return Devuelve un String compuesto del radio, un espacio, la coordenada 
     * X, un espacio y la coordenada Y.
     */
    @Override
    public String toString(){
        String cadena;
        
        cadena = String.valueOf(radio)+" "+centro.toString();
        
        return cadena;
    }
    /**
     * Establece el radio y las coordenadas del centro del Circulo a los valores
     * que se introducen en el método.
     * @param r Nuevo valor que tendrá el radio del círculo, tipo double.
     * @param c Objeto de la clase Punto que establece el nuevo centro del
     * círculo.
     */
    public void set(double r, Punto c){
        centro.setCoordenadas(c.x, c.y);
        radio = r;
    }
    /**
     * Pide al usuario que introduzca en la linea de comandos el radio del circulo,
     * así como las coordenadas del centro.
     * @param conin objeto de la clase Scanner que utilizará para leer los
     * parámetros.
     */
    public void leer(Scanner conin){
        radio = conin.nextDouble();
        centro.leer(conin);
    }
    /**
     * Método que sirve para devolver el radio en formato double.
     * @return devuelve el radio del círculo en tipo double.
     */
    public double getRadio(){
        return radio;
    }
    
    /**
     * Método que recopila los parámetros del punto centro y los establece en un
     * nuevo punto, el cual es devuelto.
     * @return devuelve un objeto de la clase Punto idéntico al centro
     */
    public Punto getCentro(){
        Punto nuevoPunto = new Punto();
        nuevoPunto.setCoordenadas(centro.getX(), centro.getY());
        
        return nuevoPunto;
    }
    /**
     * Calcula el área del objeto de la clase Circulo a partir de su radio
     * @return devuelve un valor tipo double con el área calculada.
     */
    public double getArea(){
        double calculo;
        
        calculo = Math.PI * Math.pow(radio, 2);
        
        return calculo;
    }
    
}
