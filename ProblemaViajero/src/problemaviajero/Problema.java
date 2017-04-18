package problemaviajero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Problema que representa un problema del viajante, incorporando la lista de
 * ciudades por las que debe pasar y la matriz de distancias entre ellas.
 */
public class Problema {
    
    private ArrayList <Ciudad> ciudades; // Lista de ciudades por las que el viajero debe pasar.
    
    private double matrizDistancias[][]; // Matriz de distancias de las ciudades.
    
    /**
     * Constructor sin parámetros que crea una nueva lista de ciudades en blanco.
     */
    public Problema() {
        this.ciudades = new ArrayList();
    }    
    /**
     * Constructor que crea una lista de ciudades a partir de la lista proporcionada.
     * También crea una matriz de distancias a partir de las coordenadas.
     * @param ciudades lista de ciudades proporcionada.
     */
    public Problema(ArrayList <Ciudad> ciudades) {
        this.ciudades = ciudades;
        
        matrizDistancias = new double [ciudades.size()][ciudades.size()];
        
        for(int i = 0; i < ciudades.size(); i++){
            
            for(int j = 0; j < ciudades.size(); j++){
                
                matrizDistancias[i][j] = ciudades.get(i).calcularDistanciaEuclidea(ciudades.get(j));
            }
        }
    }
    /**
     * Método que crea una lista de ciudades a partir de los datos introducidos por
     * pantalla.
     * @param conin lector de la clase Scanner al que habrá que proporcionarle los siguientes
     * datos en el mismo orden: numero de ciudades, coordenada X de la ciudad 1, 
     * coordenada Y de la ciudad 1, coordenada X de la ciudad 2, etc.
     * @return objeto de la clase Problema con la lista de ciudades introducidas y
     * su vector de distancias creado.
     */
    static Problema leerCiudades(Scanner conin){
        
        int totalCiudades;
        String nombre;
        double x,y;
        ArrayList <Ciudad> ciudades = new ArrayList();
        
       
        //System.out.print("DIMENSION: ");
        
        totalCiudades = conin.nextInt();
        
        for(int i = 0; i< totalCiudades; i++){
            
            nombre = conin.next();
            x = conin.nextDouble();
            y = conin.nextDouble();
            ciudades.add(new Ciudad(x,y,nombre));
        }
        
       return new Problema(ciudades);
    }
    /**
     * Método que devuelve el número actual de ciudades en el problema.
     * @return número de ciudades.
     */
   public int getNumeroCiudades(){
        
        return ciudades.size();
    }
    /**
     * Método que devuelve la ciudad que se encuentra en la posición proporcionada.
     * @param pos posición en la que se encuentra la ciudad.
     * @return ciudad que se encuentra en la posición.
     */
    public Ciudad getCiudad(int pos){
        
        return ciudades.get(pos % ciudades.size()); // la ultima ciudade con la primera
    }
    
    double getDistancia(int pos1, int pos2){
        
        return matrizDistancias[pos1][pos2];
    }
    /**
     * Método que, una vez proporcionada una ruta, calcula el coste (distancia) total
     * de dicha ruta para el actual problema.
     * @param ruta objeto de la clase Ruta proporcionado.
     * @return distancia total que hay que recorrer.
     */
    public double coste(Ruta ruta){
        
        double distancia = 0;
        int total = ruta.getnCiudades();
        
        for(int i = 0; i < total; i++){
            
            distancia += ciudades.get(ruta.getCiudades(i)).calcularDistanciaEuclidea(ciudades.get(ruta.getCiudades((i + 1) % total)));
        }
        
        return distancia;
    }
}
