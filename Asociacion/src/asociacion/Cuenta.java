/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociacion;

import static java.lang.String.valueOf;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Cuenta {
    private ArrayList <Cliente> Titulares = new ArrayList();
    private String NomCuenta;
    private int id_cuenta;
    private String direccion;
    private float saldo=1500.0F;

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cuenta(String NomCuenta, int id_cuenta, String direccion) {
        this.NomCuenta = NomCuenta;
        this.id_cuenta = id_cuenta;
        this.direccion = direccion;
    }

    public String getNomCuenta() {
        return NomCuenta;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setNomCuenta(String NomCuenta) {
        this.NomCuenta = NomCuenta;
    }

    public ArrayList<Cliente> getTitulares() {
        return Titulares;
    }
    
    void registrarTitular(Cliente c){
        Titulares.add(c);
        c.registrarCuenta(this);
   }
    
    /*@Override
    public String toString(){
        
        return NomCuenta;
    }*/
    
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
