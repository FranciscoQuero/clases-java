import java.util.Scanner;

class Ejercicio5 {
        /***************************************************
         * Comprueba si un numero es primo
         ***************************************************/
    
        public static boolean esPrimo(int numeroComprobacion) {
            boolean primo = true;
            int i;
            
            for (i = 2; i < numeroComprobacion; i++){
                if (numeroComprobacion % i == 0)
                    primo = false;
            }    
            
            return primo;
        }
        /***************************************
            Imprime primos desde 2 hasta numero
        ****************************************/
        public static void imprimePrimos(int primos) {
            int i = 2;
            int impresos = 0;
            
               
                while (impresos < primos) {
                    if (esPrimo(i) == true) {
                        System.out.print(i+" ");
                        impresos++;

                        if (impresos % 10 == 0)
                            System.out.println("");
                    }
                    i++;
                }
                        
        }
    
	public static void main(String args[]) {
                Scanner conin = new Scanner(System.in);
		int primos;
                
		System.out.println("Introduce cuantos numeros primos quieres ver: ");
                primos = conin.nextInt();
                
                Ejercicio5.imprimePrimos(primos);
	}
}