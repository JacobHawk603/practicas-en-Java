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
public class VentaBoletos extends Thread{
    
    int cont;
    
    public void run(){
        try{
            while(cont!=9){
                Thread.sleep(1000);
                    Frame.pensamiento1.setText("Comprador: un boleto plis");
                Thread.sleep(1000);
                    Frame.pensamiento1.setText("");
                    Frame.pensamiento2.setText("Vendedor: Claro, aquí tiene");
                Thread.sleep(1000);
                    Frame.pensamiento2.setText("");
                    Frame.pensamiento1.setText("Comprador: Muchas Gracias");
                Thread.sleep(1000);
                    Frame.pensamiento1.setText("");
                    Frame.pensamiento2.setText("Vendedor: De nada");
                
                    cont++;
                    System.out.println("Estas son las veces que el vendedor ha despachado: "+cont);
            }
        }catch(Exception e){
            System.out.println("El vendedor se enojó 0w0");
            System.out.println(e.getMessage());
        }
    }
}
