package serpiente;

import java.util.Random;

/**
 * Esta clase sirve para almacenar un ratón. Un Raton se define
 * mediante unas coordenadas x e y, y una dirección de movimiento.
 */
public class Raton{
    static final int DIRECCION_MASCARA = 0x0000FF00;
    static final int NINGUNA           = 0x00000000;
    static final int IZQUIERDA         = 0x00000100;
    static final int DERECHA           = 0x00000200;
    static final int ARRIBA            = 0x00000300;
    static final int ABAJO             = 0x00000400;
    
    private Punto xy;
    private int direccion;
    static private Random rand=new Random();
    
    /**
     * Crea espacio para un nuevo ratón creando un objeto de la clase Punto guardándolo
     * en el dato miembro xy. Las coordenadas x e y serán -1,-1 indicando que está inmóvil por ahora
     */
    Raton(){
        xy=new Punto(-1,-1);
        //rand=new Random();
        //initRaton(rej);
    }
    
    /**
     * Inicializa aleatoriamente coordenadas x e y del ratón en
     * una posición vacía de la rejilla. Coloca el ratón en la rejilla.
     * Además inicializa aleatoriamente la dirección del ratón.
     * @param rej la Rejilla donde se colocará el ratón
     */
    public void initRaton(Rejilla rej){
        int d;
        
        // Generamos coordenadas x,y en una posicion vacia de rejilla
        do{
            xy.x=rand.nextInt(rej.getAnchura());
            xy.y=rand.nextInt(rej.getAltura());
        }while(rej.getTipoCelda(xy.x,xy.y)!=Rejilla.VACIA);
        
        // Ponemos el raton en la rejilla
        rej.assignTipoCelda(xy.x,xy.y,Rejilla.RATON);
        
        // Inicializamos la direccion
        direccion=NINGUNA;
        d=rand.nextInt(4);
        if(d==0){
            direccion=IZQUIERDA;
        } else if(d==1){
            direccion=DERECHA;
        } else if(d==2){
            direccion=ARRIBA;
        } else{
            direccion=ABAJO;
        }
    }
    
    /**
     * Obtiene la posición x del ratón
     * @return la posición x del ratón
     */
    public int getX(){
        return xy.x;
    }
    
    /**
     * Obtiene la posición y del ratón
     * @return la posición y del ratón
     */
    public int getY(){
        return xy.y;
    }
    
    /**
     * Obtiene la dirección del ratón
     * @return la dirección del ratón
     */
    public int getDireccion(){
        return direccion;
    }
    
    
    /**
     * Mueve aleatoriamente (con probabilidad 1/4) este ratón a una
     * nueva posición contigua. También selecciona aleatoriamente una nueva dirección.
     * Esto lo hará siempre y cuando la nueva posición no esté ocupada en la rejilla y
     * la nueva dirección no sea en sentido contrario al anterior.
     * @param rej la Rejilla donde se mueve el ratón
     */
    public void mueveRaton(Rejilla rej){
        int d,dir,i,j;
        // Movemos con probabilidad 1/4
        if(rand.nextInt(4)>1)
            return;
        
        // Si el raton esta muerto no movemos
        if(xy.x==-1 || xy.y==-1)
            return;
        
        // Generamos aleatoriamente nueva direccion
        d = rand.nextInt(4);
        if(d==0){
            dir=IZQUIERDA;
        } else if(d==1){
            dir=DERECHA;
        } else if(d==2){
            dir=ARRIBA;
        } else{
            dir=ABAJO;
        }
        // No permitimos inversion de direccion
        if((dir == DERECHA   && direccion == IZQUIERDA) ||
                (dir == IZQUIERDA && direccion == DERECHA)   ||
                (dir == ABAJO     && direccion == ARRIBA)    ||
                (dir == ARRIBA    && direccion == ABAJO)){
            return;
        }
        i=xy.x;
        j=xy.y;
        switch(dir){
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
                return;
        }
        
        // Si la nueva casilla no esta vacia no movemos
        if(rej.getTipoCelda(i,j)!=Rejilla.VACIA){
            return;
        }
        
        rej.assignTipoCelda(xy.x,xy.y,Rejilla.VACIA);
        rej.assignTipoCelda(i,j,Rejilla.RATON);
        direccion=dir;
        xy.x=i;
        xy.y=j;
    }
}