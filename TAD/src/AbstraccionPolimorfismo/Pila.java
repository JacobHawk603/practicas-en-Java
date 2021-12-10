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
public class Pila extends TipoDatoAbstracto {

    @Override
    public void vaciar() {
        System.out.println("Este es el método vaciar para la Pila");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pop() {
        System.out.println("Este es el método popo para la Pila, en este método extraen los elementos que entraron a la pila recientemente");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push() {
        System.out.println("Este es el metodo push para la Pila, en este metodo se insertan los elementos en la primer posicion");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear() {
        System.out.println("Este es el metodo crear para la pila, en este metodo se crea este tipo de dato abstracto");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
