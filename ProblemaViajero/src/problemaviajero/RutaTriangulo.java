package problemaviajero;

import java.util.ArrayList;

/**
 * Clase RutaTriangulo, implementada para hacer los calculos necesarios para
 * hallar al triangulo formado por la ciudad mas al norte, la situada mas al 
 * este y la que se halla mas al oeste. Contiene 3 datos miembro privados.
 */
public class RutaTriangulo {
    private ArrayList<Integer> ciudadesSV; // ArrayList de ciudades que se recorrerán
    private Problema problema; // Problema temporal
    private Ruta ruta; // Ruta que incorporará el triángulo
    
    /**
     * Constructor que toma los parámetros del problema insertado y calcula en la 
     * ruta aquella formada por las ciudades que están más al norte, este y oeste respectivamente.
     * @param problema objeto de la clase Problema para el que se quiere calcular el triángulo.
     */
    public RutaTriangulo(Problema problema){
        this.problema=problema;
        ciudadesSV=new ArrayList();
        for(int i=0;i<problema.getNumeroCiudades();i++)
            ciudadesSV.add(i);
        
        ruta=new Ruta(problema.getNumeroCiudades());
        ciudadNorte();
       
        ciudadEste();
      
        ciudadOeste();
      
    }
    
    /**
     * Método que utiliza los datos miembro privados para calcular la ciudad más al norte
     */
    private void ciudadNorte(){
        boolean inicial=false;
        double y;
        double minNorte=0;
        int posN=0;
        for(int i=0;i<ciudadesSV.size();i++){
            if(inicial){
                y=problema.getCiudad(ciudadesSV.get(i)).getY();
             
                if(y>minNorte){
                    posN=i;
                    minNorte=y;
                }
               
            }else{
                inicial=true;
                minNorte=problema.getCiudad(ciudadesSV.get(i)).getY();
                posN=i;
                
            }
        }
        ruta.addCiudad(posN);
        eliminarCiudadVisitada(posN);
    } 
    /**
     * Método que utiliza los datos miembro privados para calcular la ciudad más al oeste
     */
      private void ciudadOeste(){
        boolean inicial=false;
        double x;
         double minOeste=0;
         int posO=0;
         for(int i=0;i<ciudadesSV.size();i++){
            if(inicial){
                x=problema.getCiudad(ciudadesSV.get(i)).getX();
             
                if(x<minOeste){
                    posO=i;
                    minOeste=x;
                }
               
            }else{
                inicial=true;
                minOeste=problema.getCiudad(ciudadesSV.get(i)).getX();
                posO=i;
                
            }
        }
        ruta.addCiudad(posO);
        eliminarCiudadVisitada(posO);
        
    } 
    /**
     * Método que utiliza los datos miembro privados para calcular la ciudad más al este
     */
        private void ciudadEste(){
        boolean inicial=false;
        double x;
         double minEste=0;
         int posE=0;
         for(int i=0;i<ciudadesSV.size();i++){
            if(inicial){
                x=problema.getCiudad(ciudadesSV.get(i)).getX();
             
                if(x>minEste){
                    posE=i;
                    minEste=x;
                }
               
            }else{
                inicial=true;
                minEste=problema.getCiudad(ciudadesSV.get(i)).getX();
                posE=i;
                
            }
        }
        ruta.addCiudad(posE);
        eliminarCiudadVisitada(posE);
        
    } 
    /**
     * Método que elimina una ciudad de la lista de ciudades. Se utiliza para
     * eliminar de la lista las ciudades ya visitadas.
     * @param ciudad índice del objeto de la clase Ciudad que se va a eliminar
     */
    public void eliminarCiudadVisitada(int ciudad){
        
        ciudadesSV.remove(ciudad);
    }
    /**
     * Método que devuelve la lista actual de ciudades.
     * @return 
     */
    public ArrayList<Integer> getCiudadesSV() {
        return ciudadesSV;
    }
    /**
     * Método utilizado para cambiar la lista de ciudades actual por otra proporcionada.
     * @param ciudadesSV nueva lista de ciudades.
     */
    public void setCiudadesSV(ArrayList<Integer> ciudadesSV) {
        this.ciudadesSV = ciudadesSV;
    }
    /**
     * Método que devuelve el actual problema.
     * @return objeto de la clase Problema actual.
     */
    public Problema getProblema() {
        return problema;
    }
    /**
     * Método que cambia el problema actual por otro proporcionado.
     * @param problema nuevo problema.
     */
    public void setProblema(Problema problema) {
        this.problema = problema;
    }
    /**
     * Método que devuelve la actual ruta calculada.
     * @return ruta actual calculada.
     */
    public Ruta getRuta() {
        return ruta;
    }
    /**
     * Método que cambia la ruta actual por otra proporcionada.
     * @param ruta nueva ruta.
     */
    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
}
