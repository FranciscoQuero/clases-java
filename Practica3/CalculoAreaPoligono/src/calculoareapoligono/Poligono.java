
package calculoareapoligono;

/**
 *
 * @author Francisco J Quero
 */
public class Poligono {
    private Punto ptos[]; // array con los vertices del Poligono
    private int numPuntos; // numero de vertices que tiene ahora el Poligono
    
    public Poligono() {

        ptos = new Punto[4];
        numPuntos = 0;
    }
    
    public Poligono(Circulo circ, int n){
        double a = 2*Math.PI/n;
        ptos = new Punto[n];
        numPuntos = n;
        Punto centro = circ.getCentro();
        
        for(int i = 0; i < n; i++) {
            ptos[i].setCoordenadas(centro.getX()+circ.getRadio()*Math.cos(i*a),
                    centro.getY()+circ.getRadio()*Math.cos(i*a));
        }
    }
    
    public void addPunto(Punto p) {
        if (numPuntos >= ptos.length)  {
            Punto[] nPtos = new Punto[numPuntos*2];
            
            System.arraycopy(ptos, 0, nPtos, 0, numPuntos);
            
            ptos = nPtos;
        }
        
        ptos[numPuntos] = new Punto();
        ptos[numPuntos].setCoordenadas(p.getX(), p.getY());
        numPuntos++;
    }
    
    public int numberOfPuntos() {
        return numPuntos;
    }
    
    public Punto getPunto(int n) {
        if (n > numPuntos || n <= 0)
            return null;
        else {
            return ptos[n-1];
        }
    }
    
    public String toString() {
        String cadena = "" + numPuntos;
        for (int i = 0; i < numPuntos; i++)
            cadena = cadena + '\n' + ptos[i].toString();
        
        return cadena;
    }
    
    public double perimetro() {
        double calculo = 0.0;
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        int numberOfPuntos = this.numberOfPuntos();
        
        for (int i = 0; i < numberOfPuntos; i++) {
            punto1 = this.getPunto(i+1);
            
            if (i < numberOfPuntos - 1) {
                punto2 = this.getPunto(i+2);
            }
            else {
                punto2 = this.getPunto(1);
            }
            calculo = calculo + punto1.calcularDistanciaEuclidea(punto2);
        }
        return calculo;
    }
    
    private static double areaTriangulo(Punto pto1, Punto pto2, Punto pto3) {
        double calculo;
        double T, s1, s2, s3;
        
        s1 = pto1.calcularDistanciaEuclidea(pto2);
        s2 = pto2.calcularDistanciaEuclidea(pto3);
        s3 = pto3.calcularDistanciaEuclidea(pto1);
        
        T = (s1+s2+s3)/2;
        
        calculo = Math.sqrt( T*(T-s1)*(T-s2)*(T-s3) );
        
        return calculo;
    }
    
    public double area() {
        double calculo = 0.0;
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();
        Punto punto3 = new Punto();
        
        int numberOfPuntos = this.numberOfPuntos();
        punto3 = getPuntoInterior();

        for (int i = 0; i < numberOfPuntos; i++) {
            punto1 = this.getPunto(i+1);
            
            if (i < numberOfPuntos - 1) {
                punto2 = this.getPunto(i+2);
            }
            else {
                punto2 = this.getPunto(1);
            }
                        
            calculo = calculo + Poligono.areaTriangulo(punto1, punto2, punto3);
        }
        return calculo;
    }
    
    private Punto getPuntoInterior() {
        int numero = this.numberOfPuntos()/2;
        Punto punto = this.getPunto(1);
        Punto punto2 = this.getPunto(numero);
        
        return punto.calcularPuntoMedio(punto2);
    }
        
}