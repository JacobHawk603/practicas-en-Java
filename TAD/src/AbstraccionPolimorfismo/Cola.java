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
public class Cola extends TipoDatoAbstracto {

    @Override
    public void vaciar() {
        System.out.println("Este es el metodo vaciar para la cola");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void pop() {
        
        System.out.println("Este es el metodo pop para la cola, en este método se extraen los elemntos y es el elemento más antiguo el que sale primero");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push() {
        System.out.println("Este es el método push para la cola, en este metodo se insertan los elementos hasta la ultima posición");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear() {
        System.out.println("Este es el método crear para la cola, crea este tipo de dato abstractod");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
