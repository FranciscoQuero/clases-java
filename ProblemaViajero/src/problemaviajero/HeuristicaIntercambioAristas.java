
package problemaviajero;

/**
 * Algoritmo que implementa el algoritmo de intercambio de aristas, el cual se
 * sirve del vecino más cercano pero detecta cruces de caminos y los resuelve.
 */
public class HeuristicaIntercambioAristas {
    
    /**
     * Método que parte de una ruta y busca cruces de caminos para resolverlos.
     * @param ruta ruta preestablecida, normalmente la del vecino más cercano.
     * @param problema problema para el que se calcula la ruta.
     * @return nueva ruta optimizada.
     */
    public static Ruta cambioAristas(Ruta ruta, Problema problema){

        int i, j, nCiudades = ruta.getnCiudades(), mini = 0, minj = 0;
        double minimoCambio, cambio=0;
        Ruta mejorRuta = ruta;
        
// esta parte es la propuesta en la practica aunque sale un peor resultado        
//        do{
//            minimoCambio = 0;
//            
//            for( i = 0; i< nCiudades-2; i++) {
//                for(j = i+2; j< nCiudades; j++) {
//                    cambio = problema.getCiudad(mejorRuta.getCiudades(i)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j)))
//                    + problema.getCiudad(mejorRuta.getCiudades(i+1)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j+1)))
//                    - problema.getCiudad(mejorRuta.getCiudades(i)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(i+1)))
//                    - problema.getCiudad(mejorRuta.getCiudades(j)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j+1)));
//                    
//                    if (minimoCambio>cambio) {
//                        
//                        minimoCambio = cambio;
//                        mini = i;
//                        minj = j;
//                    }
//                }
//                if(minimoCambio < 0)
//                mejorRuta = optIntercambio(mejorRuta, mini, minj);
//            }
//            
//        } while (minimoCambio < 0);


// esta parte es la mejorada por mi  
              minimoCambio=0; 
            for( i = 0; i< nCiudades-1 ; i++) {
              
                for(j = i+2; j< nCiudades ; j++) {
                     cambio = problema.getCiudad(mejorRuta.getCiudades(i)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j)))
                    + problema.getCiudad(mejorRuta.getCiudades(i+1)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j+1)))
                    - problema.getCiudad(mejorRuta.getCiudades(i)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(i+1)))
                    - problema.getCiudad(mejorRuta.getCiudades(j)).calcularDistanciaEuclidea(problema.getCiudad(mejorRuta.getCiudades(j+1)));

                    if (minimoCambio>cambio) {
                        
                        minimoCambio = cambio;
                        mini = i;
                        minj = j;
                    }
                    
                
                }
              if(minimoCambio < 0)
                mejorRuta = optIntercambio(mejorRuta, mini, minj);
                 
            }
           
        return mejorRuta;
    }
    
    /**
     * Intercambia las aristas proporcionadas.
     * @param ruta ruta para la que se hace el intercambio.
     * @param mini índice de la primera ciudad.
     * @param minj índice de la segunda ciudad.
     * @return ruta con las aristas intercambiadas.
     */
    private static Ruta optIntercambio(Ruta ruta, int mini, int minj){
        
        int z = (minj - mini)/2;
        int aux;
        for (int i = 1; i <= z; i++){
            
           aux = ruta.getCiudades(mini+i);
           ruta.setCiudades(mini+i, ruta.getCiudades(minj-1-i));
           ruta.setCiudades(minj-1-i, aux);
        }
            
        return ruta;
    }
    
    

}