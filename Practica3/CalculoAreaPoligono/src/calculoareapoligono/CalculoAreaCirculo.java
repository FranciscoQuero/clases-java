
package calculoareapoligono;

import java.util.Scanner;

/**
 *Clase CalculoAreaCirculo, pide un círculo y calcula su área
 * @author Francisco J. Quero
 */
public class CalculoAreaCirculo {
    
    public static void main(String[] args) {
        Circulo circ = new Circulo();
        Scanner conin = new Scanner(System.in);
        Poligono polig;
        int n;
        
        System.out.print("Introduzca un circulo: ");
        circ.leer(conin);
        System.out.print("Introduzca el numero de lados del poligono: ");
        n = conin.nextInt();
        
        polig = new Poligono(circ, n);
        
        System.out.println("El area aproximada es: " + polig.area() );
        System.out.println("El area exacta es: " + circ.getArea() );

    }
}
