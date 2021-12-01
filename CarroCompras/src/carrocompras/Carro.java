/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrocompras;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Carro {
    private int id;
    private String name;
    private ArrayList <Item> Articulos = new ArrayList();
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Carro(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getArticulos() {
        return Articulos;
    }
    
    public void agregar(Producto p, int cantidad){
        if(p.getCantidad() >= cantidad){
            Item i = new Item(p, cantidad);
            i.AsignacrCarro(this);
            Articulos.add(i);
            i.AsignarProducto(p);
        }
    }
    
    public void asignarCliente(Cliente cli){
        cliente = cli;
    }
    
    public String showProducts(){
        String cadena="";
        
        if(Articulos.isEmpty()){
            cadena="El carrito está vacío \n\n 1. agregar producto\n"
                    + "6. Log out";
        }else{
            for(Item i: Articulos){
                cadena+="\n"+i.getProducto().getNombre()+" - "+i.getCantidad()+" - $"+(i.getProducto().getPrecio()*i.getCantidad());
            }
            cadena+="\n\n1. agregar producto\n"
                    + "2.Vaciar el carrito\n"
                    + "3. cambiar la cantidad de unidades a comprar\n"
                    + "4. quitar un producto del carrito\n"
                    + "5. check out\n"
                    + "6. Log out";
        }        
        return cadena;
    }
    
    public String showProducts(int algo){
        String cadena="";
        int contador=1;
        
        if(Articulos.isEmpty()){
            cadena="El carrito está vacío \n\n 1. agregar producto";
        }else{
            for(Item i: Articulos){
                cadena+="\n"+contador+"."+i.getProducto().getNombre()+" - "+i.getCantidad()+" - $"+(i.getProducto().getPrecio()*i.getCantidad());
                contador++;
            }
        }        
        return cadena;
    }
    
    public void clear(){
        Articulos.clear();
    }
    
    public void retirarDelCarro(int elemento){
        Articulos.remove(elemento);
    }
    
}
