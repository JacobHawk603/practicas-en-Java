/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstraccionPolimorfismo;

/**
 *
 * @author Jacob
 */
public abstract class Figura {
    int ladoBase;

    public Figura(int ladoBase) {
        this.ladoBase = ladoBase;
    }
    
    
    public abstract double Perimetro();
    public abstract double area();
    public abstract void dibujar();
    public abstract void mover();
    public abstract void borrar();
    public abstract void modificarTamano();
}

