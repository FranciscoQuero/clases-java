package serpiente;


import java.util.Vector;

/**
 * Esta clase representa la Serpiente. Una Serpiente está formada
 * por un número variable de celdas adyacentes, que se guardan en 
 * un Vector. El número de celdas puede aumentar si se desea.
 * La Serpiente también necesita de una dirección de movimiento (direccion) y
 * un puntero (cabezaPtr) a la posición en el Vector de celdas dónde
 * está la cabeza.
 */
   

public class Serpiente{
  static final int DIRECCION_MASCARA = 0x0000FF00;
  static final int NINGUNA           = 0x00000000;
  static final int IZQUIERDA         = 0x00000100;
  static final int DERECHA           = 0x00000200;
  static final int ARRIBA            = 0x00000300;
  static final int ABAJO             = 0x00000400;

  static final int HABIA_NADA      = 0; // Posibles situaciones al mover cabeza
  static final int CHOCA_BLOQUE    = 1;
  static final int CHOCA_SERPIENTE = 2;
  static final int COME_RATON      = 3;
  
  private Vector celdas;
  private Rejilla rejilla;
  private int cabezaPtr;
  private int direccion;

  /**
   * Crea una nueva Serpiente con 5 celdas, colocada en el centro de la Rejilla
   * y con dirección IZQUIERDA. Además hace que el dato miembro rejilla apunte
   * al objeto rej pasado como parámetro
   * @param rej La Rejilla del juego
   */
  Serpiente(Rejilla rej){
    rejilla=rej;
    initSerpiente();
  }

  /**
   * Establece una nueva dirección (IZQUIERDA, DERECHA, ARRIBA o ABAJO) 
   * para la Serpiente.
   * @param dir La nueva dirección de movimiento 
   */
  public void setDireccion(int dir){
    direccion=dir;
  }
  
  /**
   * Hace que la Serpiente vuelva a tener 5 celdas, esté colocada en el centro 
   * de la Rejilla y tenga dirección IZQUIERDA.
   */
  public void initSerpiente(){
    int i,j,k;
    Punto punto;

    i=rejilla.getAnchura()/2;
    j=rejilla.getAltura()/2;
    
    // Construimos el Vector de Puntos de la serpiente
    celdas=new Vector();
    for(k=0;k<5;k++){
      punto=new Punto(i+k-2,j);
      celdas.addElement(punto);
    }
    cabezaPtr=0;

    // Ponemos la serpiente en la rejilla
    for(k=0;k<5;k++){
      rejilla.assignTipoCelda(i+k-2,j,Rejilla.SERPIENTE);
    }
    
    // Ponemos como direccion el valor IZQUIERDA
    direccion=IZQUIERDA;
  }
  
  /**
   * Mueve la Serpiente un paso en su direccion de movimiento. Además 
   * comprueba si la cabeza de la Serpiente choca contra un muro o ella
   * misma (devolviendo entonces CHOCA_BLOQUE o CHOCA_SERPIENTE) o contra
   * un ratón (devolviendo CHOCA_RATON).
   * Cuando choca contra un Raton, aumenta su longitud en una celda, y
   * recoloca el Raton en una nueva posición aleatoria.
   * @param ratones el array de Ratones, necesario cuando serpiente
   * como un raton, para recolocarlo en otra posicion
   * @return HABIA_NADA si no choca con nada. CHOCA_BLOQUE si choca contra
   * un muro, CHOCA_SERPIENTE si choca contra sí misma, y CHOCA_RATON
   * si choca contra un Raton.
   */
  public int mueveSerpiente(Ratones ratones){
    int c,d,i,j;
    Punto pt;
    
    // Calculamos posicion nueva cabeza
    pt=(Punto)celdas.elementAt(cabezaPtr);
    i=pt.x;
    j=pt.y;
    switch(direccion){
    case IZQUIERDA:
      i--;
      break;
    case DERECHA:
      i++;
      break;
    case ARRIBA:
      j--;
      break;
    case ABAJO:
      j++;
      break;
    default:
      break;
    }
        
    // Comprobamos si nueva cabeza chocará con algo
    c=rejilla.getTipoCelda(i,j);
    if(c == Rejilla.BLOQUE){
      System.out.println("Te has chocado contra muro ");
      return CHOCA_BLOQUE;
    }
    else if(c== Rejilla.SERPIENTE){
      System.out.println("Te has chocado contra muro ");
      return CHOCA_SERPIENTE;
    }
    else if(c == rejilla.RATON){ // La serpiente crece de tamaño
      System.out.println("Te has comido un raton");
      // Insertar nuevo punto para cabeza
      pt=new Punto(i,j);
      celdas.insertElementAt(pt,cabezaPtr);
      rejilla.assignTipoCelda(i,j,Rejilla.SERPIENTE);
      int n=ratones.getNumeroRaton(i,j);
      if(n!=-1){
        ratones.initRaton(n);
      }
      return COME_RATON;
    }
    else{ // Si no choca con nada
      int colaPtr;
      // En la rejilla ponemos en la nueva celda de cabeza un trozo de SERPIENTE 
      cabezaPtr--;
      rejilla.assignTipoCelda(i,j,Rejilla.SERPIENTE);
      if(cabezaPtr < 0 )
        cabezaPtr=celdas.size()-1;
      
      // En la rejilla dejamos vacia la posicion de la antigua cola (nueva cabeza)
      pt=(Punto)celdas.elementAt(cabezaPtr);
      rejilla.assignTipoCelda(pt.x,pt.y,Rejilla.VACIA);
      // Colocamos en lista de celdas de serpiente las coordenadas de nueva cabeza
      ((Punto)celdas.elementAt(cabezaPtr)).x=i;
      ((Punto)celdas.elementAt(cabezaPtr)).y=j;
      return HABIA_NADA;
    }
  }  
}
