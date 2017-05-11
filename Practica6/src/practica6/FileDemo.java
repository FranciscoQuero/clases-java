/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.File;
class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }
    public static void main(String args[]) {
        File f1 = new File("FileDemo.java");
        p("Nombre de fichero: " + f1.getName());
        p("Ruta: " + f1.getPath());
        p("Ruta absoluta: " + f1.getAbsolutePath());
        p("Padre: " + f1.getParent());
        p(f1.exists() ? "existe" : "no existe");
        p(f1.canWrite() ? "es modificable" : "no es modificable");
        p(f1.canRead() ? "puede leerse" : "no puede leerse");
        p((f1.isDirectory() ? "" : "no" + " es un directorio"));
        p(f1.isFile() ? "es un fichero normal" : "podr´ıa ser un pipe");
        p(f1.isAbsolute() ? "es una rura absoluta" : "no es una ruta absoluta");
        p("´ultima modificaci´on del fichero: " + f1.lastModified());
        p("Tama˜no del fichero: " + f1.length() + " Bytes");
    }
}
