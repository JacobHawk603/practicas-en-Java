/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

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
    
    public static float cuadroDeAccion(){
        float cantidad;
        String entrada="4";
        String validos = "0123456789.";
        boolean bandera=true;
        
        try{
            while(bandera){
                entrada = JOptionPane.showInputDialog("inserte el monto");
                
                for(int i=0; i<entrada.length(); i++){
                    if(validos.indexOf(entrada.charAt(i))!=-1){
                        bandera=false;
                    }else{
                        CuadroDeTexto("Inserte un monto válido", 2);
                        break;
                    }
                }
            }
            cantidad=Float.parseFloat(entrada);
            
            return cantidad;
        }catch(Exception e){
            CuadroDeTexto("Operación cancelada", 0);
            return 0;
        }
    }
        
    public static int cuadroIndex(){
        int index;
        String entrada="7";
        String validos = "1234567";
        boolean bandera = true;
        
        try{
            while(bandera){
                entrada =JOptionPane.showInputDialog("¿qué desea hacer?\n\n"
                        + "1. ver saldo\n"
                        + "2. depositar una cantidad\n"
                        + "3. retirar una cantidad\n"
                        + "4. Detalles de la cuenta\n"
                        + "5. modificar nombre\n"
                        + "6. modificar direccion\n"
                        + "7. salir");
                
                if(validos.contains(entrada) && (Integer.parseInt(entrada)>0 && Integer.parseInt(entrada)<8)){
                    bandera=false;
                }else{
                    CuadroDeTexto("inserte un valor entre 1 y 7", 2);
                }
            }
            index = Integer.parseInt(entrada);
        }catch(Exception e){
            return 7;
        }
        return index;
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
