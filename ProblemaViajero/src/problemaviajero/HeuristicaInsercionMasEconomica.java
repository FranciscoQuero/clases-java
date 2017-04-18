
package problemaviajero;

/**
 * Clase hija de RutaTriangulo, que implementa el algoritmo de la insercion mas economica.
 */
public class HeuristicaInsercionMasEconomica extends RutaTriangulo{
    /**
     * Constructor que incorpora un problema proporcionado.
     * @param problema problema para el que se calcula la ruta.
     */
    public HeuristicaInsercionMasEconomica(Problema problema) {
        super(problema);
    }
    /**
     * Calcula la mejor ruta posible partiendo del triángulo que forman las ciudades
     * más al norte, este y oeste, insertando cada vez el que menos coste suponga.
     * @return ruta calculada.
     */
    public Ruta obtenerMejorRuta(){
        Ruta mejorRuta=getRuta();
        double infinito=Double.POSITIVE_INFINITY;
        double incrementoMin=0,incremento=0;
        int ciudadMin=0,posicionMision=0;
       
        while(mejorRuta.getnCiudades()<getProblema().getNumeroCiudades()){
            incrementoMin=infinito;
            for(int i=0;i<getCiudadesSV().size();i++){
                for(int j=0;j<mejorRuta.getnCiudades();j++){
                    incremento=getProblema().getDistancia(getCiudadesSV().get(i), mejorRuta.getCiudades(j))+
                            getProblema().getDistancia( mejorRuta.getCiudades(mejorRuta.getCiudades(mejorRuta.getnCiudades()-j-1)),getCiudadesSV().get(i))-
                            getProblema().getDistancia(mejorRuta.getCiudades(mejorRuta.getnCiudades()-j-1), mejorRuta.getCiudades(j));
                    if (incremento < incrementoMin){
                        incrementoMin=incremento;
                        ciudadMin=i;
                        posicionMision=j;
                        
                    }
                }
                
            }
          
            mejorRuta.insertarCiudad(posicionMision,getCiudadesSV().get(ciudadMin));
             
            eliminarCiudadVisitada(ciudadMin);
        }
        
        return mejorRuta;
    }
}
