/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author Francisco J. Quero
 */
public class ComparableAlgoritmos {
    
    public static Figura mayor(Figura[] figuras){
        Figura mayor = figuras[0];
        for (int i = 1; i < figuras.length; i++){
            if (mayor.compareTo(figuras[i]) == 1)
                mayor = figuras[i];
        }
        
        return mayor;
    }
    
    public static void ordena(Figura[] array){
        Figura aux;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++){
                
                if (array[j+1].compareTo(array[j]) == -1) {
                    
                    aux = array[j+1];
                    array[j+1] = array[j];
                    array[j] = aux;
                }
            }
        }
    }
}
