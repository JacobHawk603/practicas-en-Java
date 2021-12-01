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
public class Cliente {
    private Carro carro;
    private String nickName;
    private String correo;

    public Cliente(String nickName, String correo) {
        this.nickName = nickName;
        this.correo = correo;
    }
    
    public void asignarCarro(Carro c){
        carro = c;
        c.asignarCliente(this);
    }

    public Carro getCarro() {
        return carro;
    }
    
        public String getNickName() {
        return nickName;
    }
    
    public static String showClients(ArrayList<Cliente> clientes){
        String cadena="";
        int contador=1;
        
        if(clientes.isEmpty()){
            cadena="este cliente no tiene cuentas asociadas";
        }else{
            for(Cliente i: clientes){
                cadena+="\n"+contador+"."+i.getNickName()+" - "+i.getCarro().getName();
                contador++;
            }
            cadena+="\n4. Salir";
        }        
        return cadena;
    }
}
