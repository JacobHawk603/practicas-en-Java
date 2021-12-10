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
public class Circulo extends Figura {

    public Circulo(int ladoBase) {
        super(ladoBase);
    }

    @Override
    public double Perimetro() {        
        
        return Math.PI*(2*ladoBase);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double area() {
        
        return Math.PI*Math.pow(ladoBase, 2);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
