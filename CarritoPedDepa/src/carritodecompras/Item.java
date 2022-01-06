/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritodecompras;

/**
 *
 * @author AleBe
 */
public class Item {
    private Producto P;
    private int cantidad;
    private Carrito Carro;

    public Item(Item I){
          P=I.P;
          cantidad=I.cantidad;
          Carro=null;
    }
    public Item(Producto Pro, int c) {
        P=Pro;
        cantidad=c;
        Carro=null;
    }
    public void AsignarCarro (Carrito C){
        Carro=C;
    }
    public Carrito getCarro(  )
    {
        return Carro;
    }        
    public Producto get_prod(){
        return P;
    }
    
    public int get_can(){
        return cantidad;
    }
    
    public void set_can(int cant){
        cantidad=cant;
    }

    @Override
    public String toString() {
        return P+" , "+"Cantidad: "+ cantidad;    
    }
    
}
