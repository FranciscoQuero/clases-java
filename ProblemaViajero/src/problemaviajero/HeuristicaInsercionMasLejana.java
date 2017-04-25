package problemaviajero;

/**
 * Clase de Inserción de la ciudad más lejana. Consiste en partir de una ruta
 * arbitraria a la que se le van añadiendo, al final de la misma, las ciudades más 
 * lejanas a las ciudades que ya pertenecen a la ruta. Es una clase hija de
 * RutaTriangulo, lo que permite utilizar sus datos miembro y métodos.
 */
public class HeuristicaInsercionMasLejana extends RutaTriangulo{
    
    /**
     * Constructor de la clase que establece el problema.
     * @param problema Objeto de la clase Problema.
     */
    public HeuristicaInsercionMasLejana(Problema problema) {
        super(problema);
    }
    
    /**
     * Método que obtiene la mejor ruta implementando el algoritmo de inserción
     * de la ciudad más lejana.
     * @return Ruta óptima contruida.
     */
    public Ruta obtenerMejorRuta(){
        Ruta mejorRuta=getRuta();
        double infinito=Double.NEGATIVE_INFINITY;
        double distanciaMax = 0;
        double incrementoMin=0,incremento=0;
        int ciudadMax= -1, posicionMision=0;
        double distanciaMin = 0,distancia = 0;
       
        while(mejorRuta.getnCiudades()<getProblema().getNumeroCiudades()){
            distanciaMax=infinito;
            ciudadMax= -1;
            for(int i=0;i<getCiudadesSV().size();i++){
                distanciaMin = Double.POSITIVE_INFINITY;
                for(int j=0;j<mejorRuta.getnCiudades();j++){
                    distancia=getProblema().getDistancia(getCiudadesSV().get(i), mejorRuta.getCiudades(j));
                    if (distancia < distanciaMin){
                        distanciaMin=distancia;
                    }
                }
                if(distancia > distanciaMax){
                    distanciaMax = distanciaMin;
                    ciudadMax = i;
                }
            }
            posicionMision = -1;
            incrementoMin = Double.POSITIVE_INFINITY;
            
            for(int k = 0; k < mejorRuta.getnCiudades();k++){
                incremento=getProblema().getDistancia(getCiudadesSV().get(ciudadMax), mejorRuta.getCiudades(k))+
                            getProblema().getDistancia(mejorRuta.getCiudades(mejorRuta.getnCiudades()-k-1),getCiudadesSV().get(ciudadMax))-
                            getProblema().getDistancia(mejorRuta.getCiudades(mejorRuta.getnCiudades()-k-1), mejorRuta.getCiudades(k));
                    if (incremento < incrementoMin){
                        incrementoMin=incremento;
                        posicionMision=k;
                    }
                
            }
            mejorRuta.insertarCiudad(posicionMision,getCiudadesSV().get(ciudadMax));
            eliminarCiudadVisitada(ciudadMax);
        }
        
        return mejorRuta;
    }
    
}
