
package problemaviajero;

import java.util.ArrayList;

/**
 * Clase que implementa el algoritmo del vecino más cercano. A partir de la ciudad
 * inicial, calcula la ruta cuyo siguiente salto será siempre el de menor coste (distancia).
 */
public class HeuristicaVecinoMasCercano {
    
    /**
     * Método que calcula la mejor ruta mediante saltos de menos coste.
     * El método comprueba con qué ciudad es mejor comenzar la ruta.
     * @param problema objeto de la clase Problema al que se le calculará la ruta.
     * @return ruta calculada.
     */
    public Ruta obtenerMejorRuta(Problema problema){
       
       double coste = 0;
       Ruta ruta = obtenerRuta(0, problema);
       double costemin = problema.coste(ruta);
       Ruta actual;
       
       for(int k = 0; k < problema.getNumeroCiudades(); k++){
           
           actual = obtenerRuta(k, problema);
           
           coste = problema.coste(actual);
          
           if(coste <= costemin){   // en caso dos costes iguales si <= la ultima menor coste, si < primera que encuentre
               
               costemin = coste;
               ruta = actual;
           }
       }
       
       return ruta;
   }
    /**
     * Método que obtiene la ruta del vecino más cercano teniendo como punto de partida
     * la ciudad de origen proporcionada.
     * @param origen ciudad de origen.
     * @param problema problema para el que se calculará la ruta.
     * @return ruta obtenida.
     */
    private Ruta obtenerRuta(int origen, Problema problema){
        
       Ruta ruta = new Ruta(problema.getNumeroCiudades());
       double min = 0;
       boolean minimo;
       double distancia;
       int vecino = 0;
       int pos;
       
       ArrayList<Integer> numeros = new ArrayList(); 
       
       for(int i=0;i<problema.getNumeroCiudades();i++)
           numeros.add(i);
      
        for(int j=0; j < problema.getNumeroCiudades(); j++){
           
            ruta.addCiudad(origen);
            
            minimo = false;
            
            pos = 0;
            try {
                 while(numeros.get(pos)!=origen)
                pos++;
            } catch (Exception e) {
                System.out.println("asd");
            }
           
            
            
            numeros.remove(pos);
            
            for(int i = 0
                    ; i < numeros.size(); i++){
             
           
                distancia=problema.getDistancia(origen, numeros.get(i));

                if(!minimo){

                    min = distancia;
                    minimo = true;
                    vecino = numeros.get(i);
                }

                else{

                    if(min>distancia){

                        min = distancia;
                        vecino = numeros.get(i);
                    }
                }
                
                 
            }
            
            origen = vecino;
        }
       
       return ruta;
    }
}
