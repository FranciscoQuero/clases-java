/*
 * Bola8.java
 *
 * Created on 12 de marzo de 2006, 12:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import java.util.*;

/***********
    * Signs point to yes.
    * Yes.
    * Reply hazy, try again.
    * Without a doubt.
    * My sources say no.
    * As I see it, yes.
    * You may rely on it.
    * Concentrate and ask again.
    * Outlook not so good.
    * It is decidedly so.
    * Better not tell you now.
    * Very doubtful.
    * Yes - definitely.
    * It is certain.
    * Cannot predict now.
    * Most likely.
    * Ask again later.
    * My reply is no.
    * Outlook good.
    * Don't count on it. 
**************/
/**
 *
 * @author jjramos
 */
public class Bola8 {
    Random aleatorio;
    
    static final String predicciones[]={"Los signos apuntan a que asi' sera'","Si'",
                "Respuesta dudosa... reformule la pregunta",
            "Sin duda","Mis fuentes dicen que no","Tal como lo veo... asi' es","Puedes confiar en ello",
            "Conce'ntrate e inte'ntalo otra vez", "No tiene visos de ello","Decidi'damente si'",
            "Mejor no te lo digo ahora","Dudosamente","Definitivamente si'",
            "Es cierto","No puedo predecirlo ahora","Probablemente","Pregunta ma's tarde",
            "Mi respuesta es \"no\"","Tiene buena pinta","No cuentes con ello"};
    
    /** Creates a new instance of Bola8 */
    public Bola8() {
        aleatorio=new Random();
    }
    
    String obtenerPrediccion(){
        return predicciones[aleatorio.nextInt(predicciones.length)];
    }
}
