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
public class Cuadrado extends Figura {

    public Cuadrado(int ladoBase) {
        super(ladoBase);
    }

    @Override
    public double Perimetro() {
        
        return ladoBase*4;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double area() {
        
        return Math.pow(ladoBase, 2);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
