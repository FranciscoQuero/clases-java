
import calculocirculocentral.Circulo;
import java.util.Scanner;

public class CalculoCirculoCentral {
    
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo();
        Circulo circulo2 = new Circulo();
        Circulo circuloFinal = new Circulo();
        
        Scanner conin;
        conin = new Scanner(System.in);
        
        /* Leemos el primer y segundo círculo */
        System.out.println("Introduzca el radio y las coordenadas del centro del primer circulo: ");
        circulo1.leer(conin);
        
        System.out.println("Introduzca el radio y las coordenadas del centro del segundo circulo: ");
        circulo2.leer(conin);
        
        /* Calculamos punto medio */
        // ¿Se hace asi?
        circuloFinal.centro = circulo1.centro.calcularPuntoMedio(circulo2.centro);
        
        /* Calculamos la distancia entre centros */
        circuloFinal.radio = circulo1.centro.calcularDistanciaEuclidea(circulo2.centro)/2;
        
        /* Mostramos los resultados */
        System.out.println("El radio y las coordenadas del nuevo circulo son: ");
        System.out.println(circuloFinal.toString());
    }
    
}
