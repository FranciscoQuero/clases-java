
package problemaviajero;


import java.util.Scanner;

/**
 * Clase principal del problema del viajero que contiene un main con lo necesario
 * para elegir y ejecutar la heuristica deseada. Depende de los parámetros/argumentos
 * introducidos, el main decide a qué clase llamar.
 */
public class TSP {

    /**
     * @param args los argumentos pasados por la linea de comandos
     */
    public static void main(String[] args) {
        
        Ruta ruta;
        String opcion;
        int inicio = 0;
        
        Scanner conin = new Scanner(System.in);
        Problema problema = Problema.leerCiudades(conin);
        
        HeuristicaVecinoMasCercano vecino = new HeuristicaVecinoMasCercano();
        
        ruta = vecino.obtenerMejorRuta(problema);
        
        if (args[0].equals("-algo")){
            
            switch(Integer.parseInt(args[1])){ // si no ponemos el parametro -algo 
                case 1:                        // se resolvera mediante la heuristica
                    break;                     // del vecino mas cercano
                case 2:
                    HeuristicaInsercionMasEconomica eco=new HeuristicaInsercionMasEconomica(problema);
                    ruta=eco.obtenerMejorRuta();
                    break;
                case 4:
                    ruta = HeuristicaIntercambioAristas.cambioAristas(ruta, problema);
                    break;
                case 5:
                    ruta = HeuristicaMonteCarlo.monteCarlo(problema);
                    break;
            }
            inicio = 2;
        }
          for(int i = inicio; i < args.length; i++){
              opcion=args[i];
              
           
              switch(opcion){
                  case "-solucion":
                      for(int j = 0; j < ruta.getnCiudades(); j++){
                          System.out.println(problema.getCiudad(ruta.getCiudades(j)).getX()+" "+problema.getCiudad(ruta.getCiudades(j)).getY());
                      }
                      System.out.println(problema.getCiudad(ruta.getCiudades(0)).getX()+" "+problema.getCiudad(ruta.getCiudades(0)).getY());
                  break;
                  case "-coste":
                      System.out.println("MEJOR SOLUCION : " +problema.coste(ruta));
                  break;
                  case "-ruta":
                          for(int j = 0; j < ruta.getnCiudades(); j++){
                          System.out.println(problema.getCiudad(ruta.getCiudades(j)).getNombre());
                      }
                      System.out.println(problema.getCiudad(ruta.getCiudades(0)).getNombre());
                  break;
              }
              
          }  
    }
    
}
