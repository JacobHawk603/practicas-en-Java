/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.Frame;
import javax.swing.ImageIcon;

/**
 *
 * @author Jacob
 */
public class AsientosUsados extends Thread{
    
    int asientos;
    
    public void run(){
        
        try{
            
            while(asientos != 200){
                
                Thread.sleep((1000 * 8)+40);
                //Frame.x += 40;
                Frame.asientos.setIcon(new ImageIcon("src/imagenes/stickman-sit.jpg"));
                //Frame.usuarios.setText("x "+Frame.x);
               
            }
            
        }catch(Exception e){
            System.out.println("Alguien se robó un asiento");
            System.out.println(e.getMessage());
        }
    }
}
