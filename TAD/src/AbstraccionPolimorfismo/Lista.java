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
public class Lista extends TipoDatoAbstracto{

    @Override
    public void vaciar() {
        System.out.println("Este es e metodo vaciar para la lista, con el queda vacia la lista (¬w¬)");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pop() {
        System.out.println("Este tambien es el metodo pop para la lista, tambien es posible extraer el primer elemento de la lista");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void pop(int posicion){
        System.out.println("Este es el metodo pop para la lista, recordemos que la lista requiere que indiquemos la posicion del elemento que queremos extraer, por ello este metodo es aparte");
    }

    @Override
    public void push() {
        System.out.println("Este tambien es el metodo push de las listas, pues tambien podemos insertar el elemento en la ultima posicion de la lista");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void push(int posicion){
        System.out.println("Este es el metodo push para las listas, la lista requiere que indiquemos la posicion en la que se va a insertar el elemento");
    }

    @Override
    public void crear() {
        //System.out.println("Este es el metodo crear para la Lista, crea este tipo de dato abstracto");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
