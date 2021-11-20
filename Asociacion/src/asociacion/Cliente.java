/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociacion;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class Cliente {
    
    private ArrayList <Cuenta> Cts = new ArrayList();
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
        //this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cuenta> getCts() {
        return Cts;
    }
    
    void registrarCuenta(Cuenta Cu) {
        Cts.add(Cu);
    }
    
    public String showAccounts(){
        String cadena="";
        int contador=1;
        
        if(Cts.isEmpty()){
            cadena="este cliente no tiene cuentas asociadas";
        }else{
            for(Cuenta i: Cts){
                cadena+="\n"+contador+"."+i.getNomCuenta();
                contador++;
            }   
        }        
        return cadena;
    }
    
        public static String showClients(ArrayList<Cliente> clientes){
        String cadena="";
        int contador=1;
        
        if(clientes.isEmpty()){
            cadena="este cliente no tiene cuentas asociadas";
        }else{
            for(Cliente i: clientes){
                cadena+="\n"+contador+"."+i.getNombre();
                contador++;
            }
            cadena+="\n4. Salir";
        }        
        return cadena;
    }
}
