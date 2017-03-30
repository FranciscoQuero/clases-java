
package calculoareapoligono;

import java.util.Scanner;

/**
 * Clase Circulo compuesta de un objeto de la clase Punto llamado centro
 * y una variable tipo double llamada radio. Contiene los mÃ©todos necesarios para
 * realizar cÃ¡lculos con sus componentes asÃ­ como para inicializar, leer
 * y establecer los distintos componentes a los valores deseados.
 * 
 * @author Francisco JesÃºs Quero de la Rosa
 */
public class Circulo {
    private Punto centro;   
    private double radio;
    
    /**
     * Instancia el centro al punto origen (0, 0) y el radio a 0.
     */
    public Circulo() {
        centro =  new Punto(); 
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
     * que se introducen en el mÃ©todo.
     * @param r Nuevo valor que tendrÃ¡ el radio del cÃ­rculo, tipo double.
     * @param c Objeto de la clase Punto que establece el nuevo centro del
     * cÃ­rculo.
     */
    public void set(double r, Punto c){
        centro.setCoordenadas(c.getX(), c.getY());
        radio = r;
    }
    /**
     * Pide al usuario que introduzca en la linea de comandos el radio del circulo,
     * asÃ­ como las coordenadas del centro.
     * @param conin objeto de la clase Scanner que utilizarÃ¡ para leer los
     * parÃ¡metros.
     */
    public void leer(Scanner conin){
        radio = conin.nextDouble();
        centro.leer(conin);
    }
    /**
     * MÃ©todo que sirve para devolver el radio en formato double.
     * @return devuelve el radio del cÃ­rculo en tipo double.
     */
    public double getRadio(){
        return radio;
    }
    
    /**
     * MÃ©todo que recopila los parÃ¡metros del punto centro y los establece en un
     * nuevo punto, el cual es devuelto.
     * @return devuelve un objeto de la clase Punto idÃ©ntico al centro
     */
    public Punto getCentro(){
        Punto nuevoPunto = new Punto();
        nuevoPunto.setCoordenadas(centro.getX(), centro.getY());
        
        return nuevoPunto;
    }
    /**
     * Calcula el Ã¡rea del objeto de la clase Circulo a partir de su radio
     * @return devuelve un valor tipo double con el Ã¡rea calculada.
     */
    public double getArea(){
        double calculo;
        
        calculo = Math.PI * Math.pow(radio, 2);
        
        return calculo;
    }
    
}
