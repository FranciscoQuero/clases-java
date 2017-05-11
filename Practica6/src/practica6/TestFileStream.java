/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;
import java.io.*;

/**
 *
 * @author Francisco J. Quero de la Rosa
 */
public class TestFileStream {
    public static void main(String args[]) throws IOException {
        
        OutputStream f0 = new FileOutputStream("temp.data");
        
        for (int i=1; i < 11; i++) {
            f0.write( i );
        }
        
        f0.close();
        
    }
}

