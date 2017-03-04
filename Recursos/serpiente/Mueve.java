package serpiente;
import java.awt.Canvas;
import java.awt.Label;

/**
  * Esta clase implementa una hebra que hace que se muevan continuamente la serpiente
  * y los ratones. La hebra se encarga también de ir refrescando la pantalla
  * dónde se dibuja todo, y los puntos acumulados. Además controla si
  * la serpiente choca contra un muro o contra sí misma, para comenzar
  * el juego de nuevo. Cuando la serpiente come un Raton aumenta su longitud
  * en una celda.
  */
public class Mueve implements Runnable{
  private Serpiente serpiente;
  private Ratones ratones;
  private Rejilla rejilla;
  private int delay;
  private boolean continuar=true;
  private boolean suspendFlag=true;  
  private Canvas canvas=null; // donde se pinta todo
  private Label labelPuntuacion;
  private int puntuacion;
  
  /**
   * Constructor de la clase, que inicializa las referencias utilizadas por
   * la hebra a Rejilla, Serpiente y Ratones, establece el retardo en milisegundos
   * entre movimiento y movimiento de Serpiente y Ratones, y comienza a ejecutar
   * la hebra.
   */
  Mueve(Rejilla rej,Serpiente serp,Ratones rat,int retardo){
    rejilla=rej;
    serpiente=serp;
    ratones=rat;
    delay=retardo;
    Thread t=new Thread(this);
    t.start();
  }
  
  /**
   * Constructor de la clase, que inicializa las referencias utilizadas por
   * la hebra a Rejilla, Serpiente y Ratones, establece el retardo en milisegundos
   * entre movimiento y movimiento de Serpiente y Ratones, y comienza a ejecutar
   * la hebra. Además inicializa la referencia al Canvas dónde se dibuja
   * Serpiente y Ratones, y la refencia al Label dónde aparece la puntuación.
   */
  Mueve(Rejilla rej,Serpiente serp, Ratones rat,int retardo, Canvas c,Label label){
    rejilla=rej;
    canvas=c;
    labelPuntuacion=label;
    serpiente=serp;
    ratones=rat;
    delay=retardo;
    puntuacion=0;
    Thread t=new Thread(this);
    t.start();
  }

  /**
   * Código que constituye las sentencias de la hebra. En este caso, se encarga
   * de hacer que se muevan continuamente la Serpiente
   * y los Ratones. La hebra se encarga también de ir refrescando la pantalla
   * dónde se dibuja todo, y los puntos acumulados. Además controla si
   * la Serpiente choca contra un muro o contra sí misma, para comenzar
   * el juego de nuevo. Cuando la Serpiente come un Raton aumenta su longitud
   * en una celda.
   */
  public void run(){
    try{
      while(continuar){
        synchronized(this){
	  while(suspendFlag){
	    wait();
	  }
	}
	Thread.sleep(delay);
	int m=serpiente.mueveSerpiente(ratones);
	ratones.mueveRatones();
	if(canvas!=null)
	  canvas.repaint();
	
	if((m==Serpiente.CHOCA_BLOQUE)||(m==Serpiente.CHOCA_SERPIENTE)){
	  suspender();
	  inicializaJuego();
	  canvas.repaint();
	  labelPuntuacion.setText("Puntuación = "+puntuacion);	  
	  reanudar();
	  
	}
	else if(m==Serpiente.COME_RATON){
	  puntuacion++;
	  labelPuntuacion.setText("Puntuación = "+puntuacion);
	}
      }// end while(continuar)
    }
    catch(InterruptedException e){
      System.out.println("Hilo MueveSerpiente interrumpido");
    }
  }
  
  /**
    * Detiene momentaneamente la ejecución de la hebra, haciendo que la
    * Serpiente y Ratones queden parados.
    */
  synchronized public void suspender(){
    suspendFlag=true;
  }
  
  /**
    * Reanuda el movimiento de la hebra. La Serpiente y Ratones vuelven
    * a moverse.
    */
  public synchronized void reanudar(){
    suspendFlag = false;
    notify();
  }
  
  /**
    * Termina la ejecución de la hebra.
    */
  public void parar(){
    continuar=false;
  }
  
  /**
   * Nos dice si la hebra está o no parada.
   * @return true si Serpiente y Ratones están parados y false en otro caso
   */
  synchronized public boolean getParado(){
    return suspendFlag;  
  }
  
  /**
   * Obtiene la puntuación acumulada en el juego hasta el momento. Se consigue
   * un punto por cada Raton comido.
   * @return la puntuaci�n obtenida hasta el momento.
   */
  public int getPuntuacion(){
    return puntuacion;
  }
  
  /**
   * Deja VACIA todas las celdas de la Rejilla,  inicializa la Serpiente
   * de nuevo (se construye con 5 celdas) y se coloca en el
   * centro de la rejilla, con dirección a la izquierda. Además
   * genera 6 nuevos Ratones en posiciones aletorias y con
   * direcciones aleatorias. También pone la puntuación a 0.
   */
  public void inicializaJuego(){
    rejilla.initRejilla();
    serpiente.initSerpiente();
    ratones.initRatones();
    puntuacion=0;
  }
}