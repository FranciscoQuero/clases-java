package serpiente; 

import java.awt.*;
import java.awt.event.*;
/**
 * Clase que representa la ventana (AWT) que incluye los demás elementos
 * del programa (Canvas, botones ...)
 */
public class MiFrame extends Frame{

  Canvas canvas;
  Label puntuacion;
  public MiFrame(Canvas c) {
    canvas = c;
    Button boton = new Button("Salir");
    boton.setName("Salir");
    puntuacion=new Label("Puntuaci�n = 0");
    setSize(300,300);
    setLayout(new BorderLayout());
    add("North",puntuacion);
    add("Center",canvas);
    add("South",boton);
    setVisible(true);
    canvas.setVisible(true);
    boton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        if(event.toString().indexOf("on Salir") != -1) {
          System.exit(0);
	}
      }
    }			    
    );
  }
  
  /**
   * Devuelve el valor de puntuacion, o sea, los puntos obtenidos hasta
   * el momento.
   * @return valor de puntuacion, o sea, los puntos obtenidos hasta
   * el momento.
   */
  public Label getLabelPuntos(){
    return puntuacion;
  }
  
}

