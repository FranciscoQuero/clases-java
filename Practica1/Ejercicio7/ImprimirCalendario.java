import java.util.Scanner;
    
public class ImprimirCalendario {
    /** metodo Main */
        public static void main(String[] args) {
            Scanner entrada = new Scanner(System.in);
            
            // Pedir al usuario que introduzca el anio
            System.out.print("Introduce el anio (e.g., 2016): ");
            int anio = entrada.nextInt();
            
            // Pedir al usuario que introduzca el mes
            System.out.print("Introduce el mes en rango 1 a 12: ");
            int mes = entrada.nextInt();
            
            // Imprimir el calendario
                imprimirMes(anio, mes);
        }
        
        /** Imprimir el calendario para el mes y anio */
        public static void imprimirMes(int anio, int mes) {
            imprimirTituloMes(anio, mes);
            imprimirCuerpoMes(anio, mes);
        }
        
        /** Imprir el titulo del mes, e.g., Febrero, 2016 */
        public static void imprimirTituloMes(int anio, int mes) {
            String nombre = obtenerNombreMes(mes);
            
            System.out.print("\t\t");
            System.out.println("   "+ nombre + " " + anio);
            System.out.println("-------------------------------------------------------");
        }
        
        /** Obtener el nombre del mes */
        public static String obtenerNombreMes(int mes) {
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            return meses[mes-1]; // Un valor ficticio
        }
        
        /** Imprimir el cuerpo del mes */
        public static void imprimirCuerpoMes(int anio, int mes) {
            int blanco;
            int i, dia;
            int numeroDias = obtenerNumeroDiasenMes(anio, mes);
            
            blanco = obtenerDiaComienzo(anio, mes);
            
            System.out.println("Lun\tMar\tMie\tJue\tVie\tSab\tDom");
            
            for (i = 1; i < blanco; i++) {
                System.out.print(" \t");
            }
            i = blanco;
            while (i < numeroDias + blanco) {
                               
                dia = i - blanco + 1;
                
                System.out.print(dia + "\t");
                
                if (i % 7 == 0)
                    System.out.println();
                
                i++;
            }
            
            
        }
            
        /** Obtener el dia de comienzo del mes en un anio */
        public static int obtenerDiaComienzo(int anio, int mes) {
            int respuesta = (obtenerNumeroTotalDias(anio, mes) + 3) % 7;
            return respuesta; 
        }
            
        /** Obtener numero total de dias desde 1 de enero de 1800 */
        public static int obtenerNumeroTotalDias(int anio, int mes) {
            int suma = 0;
            int i;
            
            
            for (i = 1800; i < anio; i++) {
                if (esAnioBisiesto(i) == true) {
                    suma = suma + 366;
                }
                else{
                    suma = suma + 365;
                }
            }
            
            for (i = 1; i < mes; i++) {
                suma = suma + obtenerNumeroDiasenMes(anio, i);
            }
            
            return suma;
        }
        /** Obtener el numero de dias en un mes */
        public static int obtenerNumeroDiasenMes(int anio, int mes) {
            int[] lista = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sumaBisiesto = 0;
            
            if (mes == 2 && esAnioBisiesto(anio) == true)
                sumaBisiesto = 1;
            
            return lista[mes-1]+sumaBisiesto;
        }
        /** Ver si un anio es bisiesto */
        public static boolean esAnioBisiesto(int anio) {
            boolean respuesta = false;
            
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0))
                respuesta = true;
            
            return respuesta; // Un valor ficticio
        }
}