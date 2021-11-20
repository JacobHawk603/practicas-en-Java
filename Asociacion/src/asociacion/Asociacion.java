/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 */
public class Asociacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x;
        boolean bandera=true;
        
        //Creando los arrayList
        ArrayList <Cliente> clientes = new ArrayList();
        ArrayList <Cuenta> cuentas = new ArrayList();
        
        //creando a los clientes
        Cliente Lorea = new Cliente("Lorea");
        Cliente Maribel = new Cliente("Maribel");
        Cliente Mario = new Cliente("Mario");
        
        //agregando los clientes a la lista correspondiente
        clientes.add(Lorea);
        clientes.add(Maribel);
        clientes.add(Mario);
        
        //creando las cuentas
        Cuenta ahorro = new Cuenta("ahorro",1, "direccion1");
        Cuenta libreton = new Cuenta("libreton", 2, "direccion2");
        Cuenta debito_basica = new Cuenta("debito_basica", 3, "direccion3");
        
        //asignando las cuentas a la lista correspondiente
        cuentas.add(ahorro);
        cuentas.add(libreton);
        cuentas.add(debito_basica);
        
        //asisgnando cuentas a los clientes
        Lorea.registrarCuenta(ahorro);
        Mario.registrarCuenta(ahorro);
        
        Maribel.registrarCuenta(libreton);
        Lorea.registrarCuenta(libreton);
        
        Maribel.registrarCuenta(debito_basica);
 
        while(bandera){
            
            x=Ventanas.cuadroIndex(clientes);
            if(x>=0 && x<4){
                Ventanas.cuadroDeAccion("Cuentas que posee "+clientes.get(x-1).getNombre()+": \n\n"+
                        clientes.get(x-1).showAccounts()+"\n"
                );
                
            }else{
                bandera=false;
                System.exit(0);                
            }
        }

        
        /*switch(x){
            case 1:
                Ventanas.CuadroDeTexto("Cuentas que posee "+clientes.get(x-1).getNombre()+": \n\n"+
                        clientes.get(x-1).showAccounts()+"\n", 0
                );
                break;
            case 2:
                Ventanas.CuadroDeTexto("Cuentas que posee "+clientes.get(x-1).getNombre()+": \n\n"+
                        clientes.get(x-1).showAccounts()+"\n", 0
                );
                break;
            case 3:
                Ventanas.CuadroDeTexto("Cuentas que posee "+clientes.get(x-1).getNombre()+": \n\n"+
                        clientes.get(x-1).showAccounts()+"\n", 0
                );
                break;
            default: System.exit(0);
        }*/
        
        
        for(Cliente i: clientes){
            System.out.println(i.getNombre());
            for(Cuenta j: i.getCts()){
                System.out.println(j.getNomCuenta());
            }
        }
        for(Cuenta i: cuentas){
            System.out.println(i.getNomCuenta());
        }
    }
    
}
