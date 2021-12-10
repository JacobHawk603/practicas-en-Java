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
public class Triangulo extends Figura {
    int LadoAltura;

    public Triangulo(int ladoBase, int LadoAltura) {
        super(ladoBase);
        this.LadoAltura=LadoAltura;
    }
    
    @Override
    public double Perimetro() {
        
        return ladoBase + LadoAltura + Math.sqrt(Math.pow(ladoBase, 2) + Math.pow(LadoAltura, 2));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double area() {
        
        return (ladoBase * LadoAltura)/2;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dibujar() {
        
        System.out.println("Este es el metodo dibujar del Triangulo");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mover() {
        
        System.out.println("Este es el metodo mover del Triangulo");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar() {
        
        System.out.println("Este es el metodo borrar para el Triangulo");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarTamano() {
        
        System.out.println("Este es el metodo modificar Tamano para el Triangulo");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
