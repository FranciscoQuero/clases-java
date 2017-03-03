/* Programa que invierte un vector */
import java.util.Scanner;

class Ejercicio9 {
      
    static int[] leerArray(int n, Scanner conin){
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = conin.nextInt();
        }
        
        return array;
    }

    
    static int[] invierteArray(int[] array) {
        int i, aux, indice;
        int mitad = array.length/2;
        int longitud = array.length;
        int[] arrayCopia = array.clone();
        
        for (i = 0; i < mitad; i++) {
            indice = longitud - i -1;
            aux = arrayCopia[i];
            arrayCopia[i] = arrayCopia[indice];
            arrayCopia[indice] = aux;
        }
        
        return arrayCopia;
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
        
        arrayFinal = invierteArray(array);
        
        System.out.println("El vector original es: ");
        imprimirArray(array);
        
        System.out.println("El vector invertido es: ");
        imprimirArray(arrayFinal);
    }
}