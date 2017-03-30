
package calculoareapoligono;

import java.util.Scanner;

/**
 *
 * @author Francisco J Quero
 */
public class CalculoAreaPoligono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroPuntosIntroducidos;
        Poligono nuevoPoligono = new Poligono();
        Punto p = new Punto();
        
        Scanner conin;
        conin = new Scanner(System.in);
        
        System.out.println("Introduzca el numero de puntos: ");
        numeroPuntosIntroducidos = conin.nextInt();
        
        for (int i = 0; i < numeroPuntosIntroducidos; i++){
            System.out.print("Introduzca las coordenadas de un punto: ");
            p.leer(conin);
            nuevoPoligono.addPunto(p);
        }
        
        System.out.println( "El perimetro es: " + nuevoPoligono.perimetro() );
        
        System.out.println( "El area es: " + nuevoPoligono.area() );
    }
    
}
