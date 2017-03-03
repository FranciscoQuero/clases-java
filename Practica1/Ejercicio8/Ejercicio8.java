import java.util.Scanner;

class Ejercicio8 {
    static int mayor(int[] array){
        int temporal = array[0];
        
        for (int i = 1; i < array.length ; i++) {
            if (array[i] > temporal)
                temporal = array[i];
        }
        
        return temporal;
    }
    
    static int[] leerArray(int n, Scanner conin){
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = conin.nextInt();
        }
        
        return array;
    }
    
    public static void main(String[] args) {
        int n;
        int[] array;
        Scanner conin;
        conin = new Scanner(System.in);
        System.out.println("Numero valores que va a introducir: ");
        n = conin.nextInt();
        
        array = leerArray(n, conin);
        
        System.out.println("El mayor es: " + mayor(array));
    }
}