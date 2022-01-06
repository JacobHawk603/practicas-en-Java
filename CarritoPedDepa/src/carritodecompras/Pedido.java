/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritodecompras;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author flore
 */
public class Pedido {
    
    private static int Gen=256010;
    private int ID;
    private ArrayList <Item> articulos;
    private Date fecha;
    private Cliente cliente;

    public Pedido(Carrito Carro) {
        //articulos=new ArrayList();
        ID=Gen++;
        cliente=Carro.getCliente();
        cliente.agregarPedido(this);
        articulos=Carro.getArticulos();
        fecha=new Date();
    }
    
    public int getID() {
        return ID;
    }
    public Producto getProducto(int i){
        return articulos.get(i).get_prod();
    }
            
    public ArrayList<Item> getArticulos() {
        return articulos;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
                    
        String pedido= "ID: " + ID + " , Hecho: "+fecha+"\n";
        for (int i=0;i<articulos.size();i++) 
              pedido+=articulos.get(i).get_prod() +" , Cant: "+articulos.get(i).get_can()+"\n";
        
        return pedido;
    }
    
    
}
