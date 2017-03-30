
package calculoareapoligono;

import java.util.ArrayList;

/**
 *
 * @author Francisco J Quero
 */
public class Poligono2 {
    private ArrayList<Punto> ptos; // array con los vertices del Poligono
    private int numPuntos; // numero de vertices que tiene ahora el Poligono
    
    public Poligono2() {

        ptos = new ArrayList<>();
        numPuntos = 0;
    }
    
    public Poligono2(Circulo circ, int n){
        double a = 2*Math.PI/n;
        ptos = new ArrayList<>();
        numPuntos = n;
        Punto centro = circ.getCentro();
        int i = 0;
        
        for (Punto pto: ptos) {
            pto.setCoordenadas(centro.getX()+circ.getRadio()*Math.cos(i*a),
                    centro.getY()+circ.getRadio()*Math.cos(i*a));
            i++;
        }
    }
    
    public void addPunto(Punto p) {
        ptos.add(p);
        numPuntos++;
    }
    
    public int numberOfPuntos() {
        return numPuntos;
    }
    
    public Punto getPunto(int n) {
        if (n > numPuntos || n <= 0)
            return null;
        else {
            return ptos.get(n-1);
        }
    }
    
    public String toString() {
        String cadena = "" + numPuntos;
        for (int i = 0; i < numPuntos; i++)
            cadena = cadena + '\n' + ptos.get(i).toString();
        
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
                        
            calculo = calculo + Poligono2.areaTriangulo(punto1, punto2, punto3);
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