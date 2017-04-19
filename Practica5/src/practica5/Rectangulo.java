/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

/**
 *
 * @author Francis
 */
public class Rectangulo extends Figura {
    public double ancho;
    public double alto;
    
    public Rectangulo(){
        ancho = 0;
        alto = 0;
    }
    public Rectangulo(double ancho, double alto){
        this.ancho = ancho;
        this.alto = alto;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nAncho: " + this.getAncho() + "\nAlto: " + this.getAlto();
    }
    
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    public double getAncho(){
        return this.ancho;
    }
    
    public void setAlto(double ancho){
        this.alto = ancho;
    }
    public double getAlto(){
        return this.alto;
    }
    
    @Override
    public double getArea(){
        return this.ancho * this.alto;
    }
    
    @Override
    public double getPerimetro(){
        return 2*this.ancho + 2*this.alto;
    }
}
