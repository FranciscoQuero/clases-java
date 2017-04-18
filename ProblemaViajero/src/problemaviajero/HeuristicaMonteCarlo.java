
package problemaviajero;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que implementa el algoritmo de Monte Carlo, generando permutaciones mediante
 * números aleatorios.
 */
public class HeuristicaMonteCarlo {
    /**
     * Método que calcula una determinada cantidad de permutaciones y se queda 
     * con la mejor de todas ellas como la ruta óptima.
     * @param problema objeto de la clase Problema para el cual se calcula la ruta.
     * @return ruta calculada.
     */
    public static Ruta monteCarlo (Problema problema){
        
        ArrayList <Integer> rutaEnteros = new ArrayList();
        int ciudadesTotales = problema.getNumeroCiudades();
        boolean primeraVez = true;
        double coste = 0, costeActual;
        Ruta ruta, rutaMenorCoste = null;
        
        for(int i = 0; i < ciudadesTotales; i++)
            rutaEnteros.add(i);
        
        for(int k = 0; k < 100000; k++){
            
            Collections.shuffle(rutaEnteros);
            ruta = new Ruta(problema.getNumeroCiudades());
            
            for(int j = 0; j < ciudadesTotales; j++)
                ruta.addCiudad(rutaEnteros.get(j));
            
            costeActual = problema.coste(ruta);
            
            if(primeraVez){
                
                coste = costeActual;
                primeraVez = false;
                rutaMenorCoste = ruta;
            }
            else if(costeActual < coste){
            
                coste = costeActual;
                rutaMenorCoste = ruta;
            }
        }
        
        return rutaMenorCoste;
    }
}
