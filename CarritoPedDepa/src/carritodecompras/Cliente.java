/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritodecompras;
import java.util.ArrayList;
/**
 *
 * @author AleBe
 */
public class Cliente {
    private byte ID;
    private String nombre;
    private float saldo;
    private Carrito carroAsignado;
    private ArrayList <Pedido> pedidos; 
    
    public Cliente(byte ID, String nombre, float saldo){
        this.ID = ID;
        this.nombre = nombre;
        this.saldo = saldo;
        pedidos=new ArrayList();
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public void agregarPedido ( Pedido p ){
         pedidos.add(p);
    }
    
    public void asignarCarrito(Carrito c){
        carroAsignado= c;
        c.asignarCliente(this);
    }
    
    public String get_nom(){
        return nombre;
    }
    
    public Carrito get_car(){
        return carroAsignado;
    }
    
}
