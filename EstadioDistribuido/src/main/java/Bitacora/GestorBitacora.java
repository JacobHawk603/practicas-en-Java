/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Bitacora;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yerry
 */
public class GestorBitacora {
    public static Logger getBitacora(){
        return Logger.getGlobal();
    }
    
    public static Logger getBitacora(String paquete, String nombreBitacora, Level nivel){
        Logger bitacora = null;
        bitacora = Logger.getLogger(paquete);
        
        try{
            FileHandler handler = new FileHandler(nombreBitacora);
            bitacora.addHandler(handler);
        }catch(Exception e){
            bitacora = Logger.getGlobal();
            bitacora.severe("Error en la cración de la bitacora");
            
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
            return bitacora;
        }
        bitacora.setLevel(nivel);
        return bitacora;
    }
}
