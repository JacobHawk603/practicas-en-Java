/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Jacob
 */
public class RegistroDeCuentas {
    
    public static Cuenta CrearCuenta(){
        String nombre="", direccion="";
        int id=0;
        
            nombre = Ventanas.cuadroRegistro("nombre");

            if(nombre==null || nombre.equals(" ")){
                Ventanas.CuadroDeTexto("Error en la creacion de la cuenta", 2);
                System.exit(0);
            }

            direccion = Ventanas.cuadroRegistro("direccion");
            id++;

            if(direccion==null || direccion.equals(" ")){
                Ventanas.CuadroDeTexto("Error en la creacion de la cuenta", 2);
                System.exit(0);
            }
            
            Ventanas.CuadroDeTexto("cuenta creada satisfactoriamente", 0);
        
        return new Cuenta(id, nombre, direccion);
    }
    
    public static String modificarNombre(String original){
        String nombre;
        String auxiliar;
        
        auxiliar = Ventanas.cuadroRegistro("nombre");
        
        if(auxiliar!=null){
            nombre = auxiliar;
            Ventanas.CuadroDeTexto("El nombre se ha modificado con éxito", 0);
        }else{
            nombre= original;
        }
        
        return nombre;
    }
    
    public static String modificarDireccion(String original){
        String direccion;
        String auxiliar;
        
        auxiliar = Ventanas.cuadroRegistro("direccion");
        
        if(auxiliar!=null){
            direccion = auxiliar;
            Ventanas.CuadroDeTexto("La dirección se ha modificado con éxito", 0);
        }else{
            direccion= original;
        }
        
        return direccion;
    }
}
