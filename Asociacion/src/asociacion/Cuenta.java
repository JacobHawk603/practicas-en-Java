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

    public Cuenta(String NomCuenta) {
        this.NomCuenta = NomCuenta;
    }

    public String getNomCuenta() {
        return NomCuenta;
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
}
