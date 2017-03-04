
import java.util.Scanner;

class Ejercicio11 {
      
    static int[][] leerMatriz(int n, int m, Scanner conin){
        int[][] matriz = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matriz[i][j] = conin.nextInt();
            }
        }
        
        return matriz;
    }
    
    static void imprimirMatriz(int[][] matriz, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static int calcularTraza(int[][] matriz, int n, int m) {
        int suma = 0;
        
        for (int i = 0; i < n; i++) {
                suma = suma + matriz[i][i];
        }
        
        return suma;
    }
    
    public static void main(String[] args) {
        int n, m, traza;
        int[][] matriz;
        
        Scanner conin;
        conin = new Scanner(System.in);
        System.out.println("Numero filas y columnas que tendra su matriz: ");
        n = conin.nextInt();
        m = n;
        
        System.out.println("Introduzca los numeros: ");
        matriz = leerMatriz(n, m, conin);
        
        traza = calcularTraza(matriz, n, m);
        
        System.out.println("La matriz original es: ");
        imprimirMatriz(matriz, n, m);
        
        System.out.println("El resultado del calculo de la traza es: " + traza);
        
    }
    
}