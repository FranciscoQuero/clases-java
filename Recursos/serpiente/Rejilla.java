package serpiente;

/**
 * Esta clase representa una rejilla con una determinada Anchura
 * y Altura, en la que cada celda puede estar VACIA, contener
 * un trozo de SERPIENTE, un RATON, o un BLOQUE (muro)
 */
public class Rejilla{
    static final int TIPO_MASCARA = 0x00FF0000; // Tipos de celda de la rejilla
    static final int VACIA        = 0x00000000;
    static final int BLOQUE       = 0x00010000;
    static final int SERPIENTE    = 0x00020000;
    static final int RATON        = 0x00030000;
    
    private int anchura;
    private int altura;
    
    private int[][] celdas;
    
    /**
     * Crea espacio para una rejilla con anchura igual a w y altura
     * igual a h. Además inicializa la Rejilla poniendo a VACIA todas las celdas,
     * excepto la primera y última fila, y primera y última columna que se ponen
     * al valor BLOQUE (ver initRejilla())
     */
    Rejilla(int w,int h){
        anchura=w;
        altura=h;
        celdas= new int[anchura][altura];
        initRejilla();
    }
    
    /**
     * Devuelve la anchura de la rejilla.
     */
    public int getAnchura(){
        return anchura;
    }
    
    /**
     *  Devuelve la altura de la rejilla.
     */
    public int getAltura(){
        return altura;
    }
    
    /**
     * Devuelve el valor almacenado en  las coordenadas x e y de esta
     * Rejilla
     */
    private int getValor(int x,int y){
        return celdas[x][y];
    }
    
    /**
     * Establece el tipo de celda (VACIA, BLOQUE,SERPIENTE,
     * RATON) en las coordenadas x e y de esta Rejilla
     */
    public void assignTipoCelda(int x,int y,int valor){
        celdas[x][y]= valor & Rejilla.TIPO_MASCARA ;
    }
    
    /**
     * Obtiene el tipo de celda (VACIA, BLOQUE,SERPIENTE,
     * RATON) en las coordenadas x e y de esta Rejilla
     * @return el tipo de Celda en la coordenada x,y. Este tipo
     * puede ser: VACIA, BLOQUE, SERPIENTE o RATON
     */
    
    public int getTipoCelda(int x,int y){
        return (getValor(x,y) & Rejilla.TIPO_MASCARA);
    }
    
    
    /**
     * Pone VACIA como tipo de celda, en todas las celdas de esta
     * Rejilla. Pone BLOQUE como tipo de celda en la primera y última fila,
     * y en la primera y última columna.
     */
    public void initRejilla(){
        int i,j;
        
        for(i=0;i<anchura;i++){
            for(j=0;j<altura;j++){
                celdas[i][j]=VACIA;
            }
        }
        
        // Añadimos los muros exteriores
        for(i=0;i<anchura;i++){
            celdas[i][0]=BLOQUE;
            celdas[i][altura-1]=BLOQUE;
        }
        for(j=1;j<altura-1;j++){
            celdas[0][j]=BLOQUE;
            celdas[anchura-1][j]=BLOQUE;
        }
    }
}

