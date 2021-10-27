/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static java.lang.String.valueOf;

/**
 *
 * @author Jacob
 */
public class Cuenta {
    private int id_cuenta;
    private String nombre, direccion;
    private float saldo=1500.0F;

    public Cuenta(int id_cuenta, String nombre, String direccion) {
        this.id_cuenta = id_cuenta;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
    
    public void verSaldo(){
        Ventanas.CuadroDeTexto("El saldo de tu cuenta es: "+valueOf(saldo), 0);
    }
    
    public void depositar(){
        float cantidad;
        
        cantidad=Ventanas.cuadroDeAccion();
        
        if(cantidad>0){
            saldo+=cantidad;
            Ventanas.CuadroDeTexto("El depósito se ha realizado Exitosamente", 0);
        }
        
    }
    
        public void retirar(){
        float cantidad, intermedia=saldo;
        
        cantidad=Ventanas.cuadroDeAccion();
        
        intermedia-=cantidad;
        if(intermedia<1000.0F){
            intermedia -=30.50F;
        }
        
        if(intermedia<0){
            Ventanas.CuadroDeTexto("Saldo insuficiente", 2);
        }else if(cantidad<0){
            Ventanas.CuadroDeTexto("Retiro inválido", 2);
        }else{
            if(cantidad>0){
                Ventanas.CuadroDeTexto("El retiro se ha realizado Exitosamente", 0);
                saldo=intermedia;
            }
            
        }
    }
}
