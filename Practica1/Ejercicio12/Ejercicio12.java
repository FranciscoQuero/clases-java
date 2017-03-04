
import java.util.Scanner;

class Ejercicio12 {
      
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
    
    static int[][] productoMatrices(int[][] matriz1, int n, int m, int[][] matriz2,
            int m2, int p){
        int[][] producto = new int[n][p];
        int suma;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                suma = 0;
                for (int k = 0; k < m; k++) {
                    suma = suma + matriz1[i][k]*matriz2[j][k];
                }
                producto[i][j] = suma;
            }
        }
        
        return producto;
    }
    
    
    public static void main(String[] args) {
        int n, m, p;
        int[][] matriz1, matriz2, matrizResultado;
        
        Scanner conin;
        conin = new Scanner(System.in);
        System.out.println("Numero de filas que tendra su primera matriz: ");
        n = conin.nextInt();
        
        System.out.println("Numero de columnas que tendra su primera matriz y de filas que tendra la segunda: ");
        m = conin.nextInt();
        
        System.out.println("Numero de columnas que tendra su segunda matriz: ");
        p = conin.nextInt();
        
        System.out.println("Introduzca los numeros de la primera matriz: ");
        matriz1 = leerMatriz(n, m, conin);
        
        System.out.println("Introduzca los numeros de la segunda matriz: ");
        matriz2 = leerMatriz(m, p, conin);
        
        System.out.println("La primera matriz original es: ");
        imprimirMatriz(matriz1, n, m);
        System.out.println("La segunda matriz original es: ");
        imprimirMatriz(matriz2, m, p);
        
        matrizResultado = productoMatrices(matriz1, n, m, matriz2, m, p);
        
        System.out.println("El resultado del calculo del producto es: ");
        imprimirMatriz(matrizResultado, n, p);
        
    }
    
}