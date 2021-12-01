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
public class Producto {
    private int cantidad;
    private String nombre;
    private float precio;

    public Producto(int cantidad, String nombre, float precio) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public static String showProducts(ArrayList<Producto>Articulos){
        String cadena="";
        int contador=1;
        
        if(Articulos.isEmpty()){
            cadena="El carrito está vacío \n\n "
                    + "1. agregar producto\n"
                    + "6. Log out";
        }else{
            for(Producto i: Articulos){
                cadena+="\n"+contador+"."+i.getNombre()+" - "+i.getCantidad()+" - $"+i.getPrecio();
                contador++;
            }
        }        
        return cadena;
    }
}