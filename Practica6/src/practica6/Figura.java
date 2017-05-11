/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica6;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Francisco J. Quero
 */
public abstract class Figura implements Comparable<Figura>, Serializable {
    public Date fechaCreacion;
    private double area;
    private double perimetro;
    
    public Figura(){
        this.fechaCreacion = new Date();
        this.area = 0.0;
        this.perimetro = 0.0;
    }
    
    @Override
    public int compareTo(Figura figura){
        double resta;
        if (this instanceof Circulo) {
            resta = ((Circulo)this).getArea() - figura.getArea();
        } else {
            resta = ((Rectangulo)this).getArea() - figura.getArea();
        }
        if (resta > 0){
            return 1;
        } else if (resta < 0){
            return -1;
        } else {
            return 0;
        }
    }
    @Override
    public String toString(){
        String linea1 = super.toString().subSequence(super.toString().indexOf(".")+1, super.toString().indexOf("@")) + " creado el " + this.fechaCreacion.toString() + ".";
        String linea2 = "Area: " +this.getArea();
        String linea3 = "Perimetro: "+ this.getPerimetro();
        
        return linea1 + "\n" + linea2 + "\n" + linea3;
    }
    
    public double getArea(){
        return this.area;
    }
    
    public double getPerimetro(){
        return this.perimetro;
    }
}
