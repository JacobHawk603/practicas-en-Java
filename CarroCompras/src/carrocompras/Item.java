/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrocompras;

/**
 *
 * @author Jacob
 */
public class Item {
    private Producto producto = new Producto(0, "", 0.0f);
    private int cantidad;

    public Item(Producto producto, int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
 
    public void AsignacrCarro(Carro carrito){
        
    }
    
    public void AsignarProducto(Producto p){
        producto = p;
    }
    
    public void modificarCantidad(){
        cantidad = Ventanas.cuadroCantidad();
    }
}