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
public class Circulo extends Figura {
    public double radio;
    public Circulo(){
        this.radio = 0.0;
    }
    public Circulo(double radio){
        this.radio = radio;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nRadio: " + this.getRadio();
    }
    
    public double getRadio(){
        return this.radio;
    }
    
    public void setRadio(double radio){
        this.radio = radio;
    }
    
    @Override
    public double getArea(){
        return Math.pow(this.radio,2) * Math.PI;
    }
    
    @Override
    public double getPerimetro(){
        return 2.0 * Math.PI * this.radio;
    }
}
