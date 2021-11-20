/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociacion;

/**
 *
 * @author Jacob
 */
public class User_Interfase {
    public void Interfase(Cuenta cuenta1){
                // TODO code application logic here
        int index=0;
        //Cuenta cuenta1 = new Cuenta(1, "Kelly", "unaDireccion");
        
        //Cuenta cuenta1;
        
        //cuenta1 = RegistroDeCuentas.CrearCuenta();
        
        //if(cuenta1.getNombre()==null || cuenta1.getDireccion()==null)
            //System.exit(0);
        
        while(index!=7){
            index = Ventanas.cuadroIndex();

            switch(index){
                case 1:
                    cuenta1.verSaldo();
                break;

                case 2:
                    cuenta1.depositar();
                break;

                case 3:
                    cuenta1.retirar();
                break;
                
                case 4:
                    Ventanas.cuadroDetallesCuenta(cuenta1.getNomCuenta(), cuenta1.getDireccion(), cuenta1.getId_cuenta());
                break;
                
                case 5:
                    String nuevoNombre;
                    
                    //nuevoNombre = RegistroDeCuentas.modificarNombre(cuenta1.getNombre());
                    //cuenta1.setNombre(nuevoNombre);
                    
                break;
                
                case 6:
                    String nuevaDireccion;
                    
                    nuevaDireccion = RegistroDeCuentas.modificarDireccion(cuenta1.getDireccion());
                    cuenta1.setDireccion(nuevaDireccion);
                break;

                default: System.exit(0);
            }
        }
    }
}
