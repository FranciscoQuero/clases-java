package serpiente;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

/**
 * Representa el panel donde se dibujan la serpiente, ratones
 * y rejilla. Se encarga también de recibir los eventos de teclado para
 * cambiar la dirección de movimiento de la serpiente.
 */
public class MiCanvas extends Canvas 
           implements KeyListener, MouseListener {
  private Rejilla rejilla;
  private Serpiente serpiente;
  private Image imageBuffer=null;
  private Mueve mueve;
  
  MiCanvas(Rejilla rej,Serpiente serp) {
    addMouseListener(this);
    addKeyListener(this);
    rejilla=rej;
    serpiente=serp;
    //imageBuffer = createImage(500,500);
  }
  
  /**
   * Pone un valor al campo mueve (referencia a un 
   * objeto de la clase Mueve) de este objeto
   * @param m una referencia a un objeto de la clase Mueve (hebra encargada
   * de mover serpiente y ratones)
   */
  public void setMueve(Mueve m){
    mueve=m;
  }
  
  
  /**
   * Repinta el contenido del panel. Será llamado cada vez que el panel necesita repintarse
   * @param g una referencia de la clase Graphics
   */ 
  synchronized public void paint(Graphics g){
    Graphics screengc=g;    
    if(imageBuffer!=null){
      g=imageBuffer.getGraphics();
      g.setColor(Color.white);
      g.fillRect(0,0,getWidth(),getHeight());
      g.setColor(Color.black);
      dibujaRejilla(g);
      screengc.drawImage(imageBuffer,0,0,null);
    }
  }
  
  public void update(Graphics g){
    if(imageBuffer==null){
      imageBuffer=createImage(getWidth(),getHeight());
    }
      
    paint(g);
  }
  
  /**
   * Método usado por el método paint(Graphics) para dibujar el contenido
   * del panel (Bloques, serpiente y ratones)
   * @param g una referencia de la clase Graphics
   */
  private void dibujaRejilla(Graphics g){
    int i,j;
    for(i=0;i<rejilla.getAnchura();i++){
      for(j=0;j<rejilla.getAltura();j++){
         if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE){
            g.setColor(Color.black);
            g.drawRect(i*5,j*5,5,5);
         }
         else if(rejilla.getTipoCelda(i,j) == Rejilla.SERPIENTE){
            g.setColor(Color.red);
            g.drawRect(i*5,j*5,5,5);
         }
         else if(rejilla.getTipoCelda(i,j) == Rejilla.RATON){
            g.setColor(Color.blue);
            g.drawRect(i*5,j*5,5,5);
         }
      }
    }
  }
  
  public boolean isFocusTraversable(){
    return true;
  }
  
  public void mouseClicked(MouseEvent e){
  }
  
  public void mouseEntered(MouseEvent e){
    requestFocus();
  }
  
  public void mouseExited(MouseEvent e){
  }
  
  public void mousePressed(MouseEvent e){
  }
  
  public void mouseReleased(MouseEvent e){
  }
				   
  
  public void keyTyped(KeyEvent evt){ 
  }
  
  /**
   * M�todo llamado autom�ticamente cuando se produce un evento de 
   * pulsaci�n de tecla en el panel. Se controlana las teclas de cursor
   * para cambiar direcci�n de la serpiente, y la tecla espaciadora para
   * detener el movimiento de la serpiente
   * @param evt una refencia a objeto de la clase KeyEvent
   */
  public void keyPressed(KeyEvent evt){
    if(evt.getKeyCode()==KeyEvent.VK_UP){
      serpiente.setDireccion(serpiente.ARRIBA);
    }
    else if(evt.getKeyCode()==KeyEvent.VK_DOWN){
      serpiente.setDireccion(serpiente.ABAJO);
    }
    else if(evt.getKeyCode()==KeyEvent.VK_LEFT){
      serpiente.setDireccion(serpiente.IZQUIERDA);
    }
    else if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
      serpiente.setDireccion(serpiente.DERECHA);     
    }      
    else if(evt.getKeyCode()==KeyEvent.VK_SPACE){
      if(!mueve.getParado())
	mueve.suspender();
      else
	mueve.reanudar();
    }
  }
  
  public void keyReleased(KeyEvent evt){
   // System.out.println("KeyReleased getKeyCode="+evt.getKeyCode());
   // System.out.println("KeyReleased getKeyChar="+evt.getKeyChar());   
   // System.out.println("KeyReleased getModifiers="+evt.getModifiers());    
  }
}
