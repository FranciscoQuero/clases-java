
import java.util.Scanner;

class Ejercicio10 {
      
    static int[] leerArray(int n, Scanner conin){
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = conin.nextInt();
        }
        
        return array;
    }
    
    static int buscarElemento(int elemento, int[] array, int posicionInicial, int posicionFinal){
        int i = posicionInicial;
        
        while(i<=posicionFinal){
            if(array[i] == elemento) {
                return i;
            }
            i++;
        }

        return -1;
    }
    
    static int[] moverIzquierda(int[] array, int posicionInicial, int posicionFinal) {
        int aux = array[posicionInicial];
        int[] arrayCopia = array.clone();
        
        for (int i = posicionInicial; i < posicionFinal; i++) {
            arrayCopia[i] = arrayCopia[i+1];
        }
        arrayCopia[posicionFinal] = aux;
        
        return arrayCopia;
    }
    
    public static int[] eliminarRepetidos(int[] array) {
        int[] arrayCopia;
        int i;
        int utiles = array.length;
        
        arrayCopia = array.clone();
        
        /* Ahora detectamos los repetidos */
        i = 1;
        while(i<utiles){
            if(buscarElemento(arrayCopia[i], arrayCopia, 0, i-1) >= 0) {
                arrayCopia = moverIzquierda(arrayCopia, i, utiles-1);
                utiles--;
            }
            else {
                i++;
            }
        }
        
        /* Ahora copiamos de nuevo solamente la parte que queremos en un nuevo 
        array para devolverlo*/
        int[] arrayFinal = new int[utiles];
        
        System.arraycopy(arrayCopia, 0, arrayFinal, 0, utiles);
        
        return arrayFinal;
    }
    
    static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n;
        int[] array;
        int[] arrayFinal;
        Scanner conin;
        conin = new Scanner(System.in);
        System.out.println("Numero valores que va a introducir: ");
        n = conin.nextInt();
        System.out.println("Introduzca los numeros: ");
        array = leerArray(n, conin);
        
        arrayFinal = eliminarRepetidos(array);
        
        System.out.println("El vector original es: ");
        imprimirArray(array);
        
        System.out.println("El vector sin elementos repetidos es: ");
        imprimirArray(arrayFinal);
    }
}