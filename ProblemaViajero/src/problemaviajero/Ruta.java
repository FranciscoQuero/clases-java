
package problemaviajero;

/**
 * Clase Ruta que establece el orden de ciudades por el que el viajero debe pasar.
 */
public class Ruta {
    
    private int ciudades[]; // Lista del índice de ciudades en orden.
    private int nCiudades; // Número de ciudades totales.
    
    /**
     * Constructor que crea una nueva ruta con un número proporcionado de ciudades.
     * @param tam número de ciudades que tendrá la ruta.
     */
    public Ruta(int tam){
        ciudades = new int[tam];
        nCiudades = 0;
    }
    
    /**
     * Método que incorpora una ciudad a la ruta.
     * @param pos posición en la que la ciudad será incorporada.
     * @param ciudad índice de la ciudad incorporada.
     */
    public void setCiudades(int pos, int ciudad){
        
        ciudades[pos] = ciudad;
    }
    /**
     * Método que devuelve la ciudad correspondiente a la posición introducida.
     * @param pos posición de la ciudad dentro de la ruta.
     * @return índice de la ciudad en el problema original.
     */
    public int getCiudades(int pos) {
        return ciudades[pos%nCiudades];
    }
    /**
     * Método que devuelve el número de ciudades que contiene la ruta.
     * @return número de ciudades.
     */
    public int getnCiudades() {
        return nCiudades;
    }
    /**
     * Método que añade una ciudad a la ruta.
     * @param pos índice de la ciudad.
     */
    public void addCiudad(int pos){
        
        ciudades[nCiudades] = pos;
        nCiudades++;
    }
    
    /**
     * Método sobrecargado que puede devolver todas las ciudades de una sola vez.
     * @return todas las ciudades de la ruta.
     */
    public int[] getCiudades(){
        
        return ciudades;
    }
    /**
     * Método que inserta en la ruta una ciudad en una posición concreta, desplazando las siguientes.
     * @param pos posición en la que se introduce la ciudad.
     * @param valor índice de la ciudad.
     */
    public void insertarCiudad(int pos,int valor){
        int aux;
        nCiudades++;
        
         aux=ciudades[pos];
         ciudades[pos]=valor;
         int aux1;
        for(int i=pos+1;i<nCiudades;i++){
            aux1=ciudades[i];
            ciudades[i]=aux;
            aux=aux1;
           
            
        }
    }   
    /**
     * Convierte una ruta en formato String para que sea legible.
     * @return ruta convertida a String.
     */
    @Override
    public String toString(){
        String cadena="{";
        for(int i=0;i<nCiudades;i++){
            if(i!=nCiudades-1)
                cadena=cadena+ciudades[i]+",";
            else
                cadena=cadena+ciudades[i];
            
        }
        return cadena;
    }
}
