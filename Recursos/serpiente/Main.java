package serpiente;

/**
 * Clase que contiene el método main(String args[] para ejecutar el programa
 * con jdk
 */

public class Main{
  public static void main(String args[]){
    Rejilla rejilla=new Rejilla(39,25);
    Serpiente serpiente=new Serpiente(rejilla);
    Ratones ratones=new Ratones(rejilla);
    MiCanvas canvas=new MiCanvas(rejilla,serpiente);
    MiFrame frame=new MiFrame(canvas);
    Mueve mueve=new Mueve(rejilla,serpiente,ratones,200,
			  canvas,frame.getLabelPuntos());
    canvas.setMueve(mueve);
    mueve.reanudar();
  }
}
