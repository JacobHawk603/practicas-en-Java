/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrocompras;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Jacob
 */

public class Ventanas {
    public static void CuadroDeTexto(String info, int estado){
        switch (estado){
            case 0:
                JOptionPane.showMessageDialog(null, info, "informacion", JOptionPane.INFORMATION_MESSAGE);
            break;
            
            case 1:
                JOptionPane.showMessageDialog(null, info, "informacion", JOptionPane.WARNING_MESSAGE);
            break;
            
            case 2:
                JOptionPane.showMessageDialog(null, info, "informacion", JOptionPane.ERROR_MESSAGE);
            break;
            
            default: JOptionPane.showMessageDialog(null, info, "informacion", JOptionPane.INFORMATION_MESSAGE);;
        }
    }
    
    public static int cuadroDeAccion(String catalogo){
        int index=0;
        String entrada="no";
        String validos ="12345678910";
        boolean bandera=true;
        int i;
        
        try{
            while(bandera){
                entrada = JOptionPane.showInputDialog(catalogo);
                    if(validos.contains(entrada)){
                        index = Integer.parseInt(entrada);
                        if(index>0 && index <12){
                            bandera=false;
                        }else{
                            CuadroDeTexto("ingresa un valor válido", 2);
                        }
                    }else{
                        CuadroDeTexto("ingresa un valor válido", 2);
                    }
                }
            return index;
        }catch(Exception e){
            CuadroDeTexto("Operación cancelada", 0);
            return -1;
        }
    }
        
    public static int cuadroIndex(ArrayList<Cliente> clientes){
        int index;
        String entrada="4";
        String validos = "1234";
        boolean bandera = true;
        
        try{
            while(bandera){
                entrada =JOptionPane.showInputDialog(
                        "Elige al cliente cuya información desees consultar: \n\n"+
                        Cliente.showClients(clientes));
                
                if(validos.contains(entrada) && (Integer.parseInt(entrada)>0 && Integer.parseInt(entrada)<8)){
                    bandera=false;
                }else{
                    CuadroDeTexto("inserte un valor entre 1 y 4", 2);
                }
            }
            index = Integer.parseInt(entrada);
        }catch(Exception e){
            return 4;
        }
        return index;
    }
    
    
    
    public static int cuadroIndex(Carro carrito){
        int x=0;
        String entrada="4";
        String validos = "123456";
        boolean bandera = true;
        
        try{
            while(bandera){
                entrada =JOptionPane.showInputDialog(
                        "Carrito de "+carrito.getCliente().getNickName()+"\n\n"+
                        carrito.showProducts());
                
                for (int i = 0; i < entrada.length(); i++) {
                    if (validos.indexOf(entrada.charAt(i))!=-1) {
                        bandera=false;
                    }else{
                        CuadroDeTexto("Inserte caracteres válidos", 2);
                        bandera=true;
                        break;
                    }
                }
            }
            x=Integer.parseInt(entrada);
        }catch(Exception e){
            return -1;
        }
        return x;
    }
    
    public static int cuadroCantidad(){
        int cant;
        String entrada="";
        String validos = "0123456789";
        boolean bandera = true;
        
        try{
            while(bandera){
                entrada = JOptionPane.showInputDialog("¿qué cantidad del producto desea llevarse?");

                for (int i = 0; i < entrada.length(); i++) {
                    if (validos.indexOf(entrada.charAt(i))!=-1) {
                        bandera=false;
                    }else{
                        CuadroDeTexto("Inserte caracteres válidos", 2);
                        bandera=true;
                        break;
                    }
                }
            }
            cant = Integer.parseInt(entrada);
        }catch(Exception e){
            cant = -1;
        }
        return cant;
    }
    
    public static String cuadroRegistro(String dato){
        String entrada="";
        String validos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        boolean bandera = true; 
        
        try{
            while(bandera){
                entrada = JOptionPane.showInputDialog("Escribe tu "+dato);

                for (int i = 0; i < entrada.length(); i++) {
                    if (validos.indexOf(entrada.charAt(i))!=-1) {
                        bandera=false;
                    }else{
                        CuadroDeTexto("Inserte caracteres válidos", 2);
                        bandera=true;
                        break;
                    }
                }
            }
            
            return entrada;
        }catch(Exception e){
            CuadroDeTexto("Operación cancelada", 0);
            return entrada;
        }
    }
    
    public static void cuadroDetallesCuenta(String nombre, String direccion, int id){
        JOptionPane.showMessageDialog(null,
            "nombre: "+nombre+"\n"
            + "direccion: " +direccion+"\n"
            + "id: "+id,"detalles de cuenta",JOptionPane.INFORMATION_MESSAGE);
    }
}
