package serpiente;

/**
 * Esta clase sirve para almacenar un conjunto de objetos
 * de la clase Raton. El número de Ratones es el definido
 * por la constante NUMERO_RATONES. Los Ratones los consideraremos
 * numerados desde 0 hasta NUMERO_RATONES-1.
 */

public class Ratones{
  public static final int NUMERO_RATONES=6;
  private Raton[] ratones;
  
  /**
   * Referencia a la Rejilla donde se mueven los ratones
   */
  private Rejilla rejilla;

  /**
   * Reserva espacio para cada uno de los Ratones y llama
   * a initRatones() para inicializar aleatoriamente 
   * para cada ratón las coordenadas x,y dónde aparecerá en la rejilla, y
   * su dirección de movimiento. Además hace que el dato miembro rejilla
   * apunte al parámetro rej.
   */
  Ratones(Rejilla rej){
    int i;
    ratones=new Raton[NUMERO_RATONES];
    rejilla=rej;
    for(i=0;i<NUMERO_RATONES;i++){
      ratones[i]=new Raton();
    }
    initRatones();
  }

  /**
   * Inicializa aleatoriamente para cada ratón las coordenadas x,y
   * dónde aparecerá en la rejilla, y su dirección de movimiento
   */
  public void initRatones(){
    int i;
    for(i=0;i<NUMERO_RATONES;i++){
      ratones[i].initRaton(rejilla);
    }
  }
  
  /**
   * Mueve aleatoriamente cada uno de los ratones a una casilla
   * contigua.
   */  
  public void mueveRatones(){
    for(int i=0;i<NUMERO_RATONES;i++){
      ratones[i].mueveRaton(rejilla);
    }
  }
  
  /**
   * Obtiene el número de Raton que hay en las coordenadas x e y
   * de la rejilla. El primer Raton es 0 y el último 
   * es NUMERO_RATONES-1.
   * @return el número de Raton que hay en las coordenadas x e y
   * de la rejilla, o bien -1 si no hay ningún Raton en tal
   * posici�n.
   */
   public int getNumeroRaton(int x,int y){
    int i;
    for(i=0;i<NUMERO_RATONES;i++){
      if((ratones[i].getX()==x) && (ratones[i].getY()==y)){
	return i;
      }
    }
    return -1;
  }
  
  /**
   * En el ratón número n, inicializa aleatoriamente  las
   * coordenadas x,y dónde aparecerá en la rejilla, y su
   * dirección de movimiento.
   */
   public void initRaton(int n){
    ratones[n].initRaton(rejilla);
  }

}