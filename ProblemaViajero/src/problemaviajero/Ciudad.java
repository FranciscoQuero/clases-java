
package problemaviajero;

/**
 * Clase que implementa una Ciudad, representando sus coordenadas x e y, 
 * además de su nombre.
 */
public class Ciudad {
    
    private double x,y; // Coordenadas cartesianas.
    private String nombre; // NOmbre de la ciudad.

    /**
     * Constructor de una ciudad que establece sus coordenadas y su nombre.
     * @param x coordenada X de la ciudad.
     * @param y coordenada Y de la ciudad.
     * @param nombre el nombre de la ciudad.
     */
    public Ciudad(double x, double y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    /**
     * Método que devuelve la coordenada X actual de la ciudad.
     * @return coordenada X de la ciudad.
     */
    public double getX() {
        return x;
    }
    /**
     * Método que devuelve la coordenada Y actual de la ciudad.
     * @return coordenada Y de la ciudad.
     */
    public double getY() {
        return y;
    }
    /**
     * Método que devuelve el nombre actual de la ciudad.
     * @return nombre de la ciudad.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
    * Metodo que calcula la distancia euclidea entre el objeto de la clase Ciudad
    * que realiza la llamada y otro objeto de la clase Ciudad pasado por parametro.
    * @param ciudad objeto de la clase Ciudad.
    * @return la distancia euclidea entre dos ciudades (double).
    */
    public double calcularDistanciaEuclidea(Ciudad ciudad){
         
        return Math.sqrt(Math.pow(this.x-ciudad.getX(),2.0)+Math.pow(this.y-ciudad.getY(),2.0));
    } 
}
