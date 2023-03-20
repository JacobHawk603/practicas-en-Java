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
public class Fila2 extends Thread{
   
    int i, cont;
    
    public void run(){
        try{
            while(Frame.x < 200){
                while(i==0){
                    for ( i = 0; i < 20; i++) {

                        Thread.sleep((100 * 4)+20);

                        Frame.fila2[i].setIcon(new ImageIcon("src/imagenes/little stickman.jpg"));  

                         System.out.println("El vendedor Despachó al cliente "+(i*2));

                    }


                    Thread.sleep(100);
                    
                    Frame.x += 10;
                    Frame.usuarios.setText("x "+Frame.x);
                     for (int j = 0; j < 20; j++) {
                         Frame.fila2[j].setIcon(new ImageIcon("")); 
                     }
                     if (Frame.x < 180) {
                         i=0;
                         //cont++;
                    }
                    System.out.println("Este es el contador de la fila 2: "+cont);
                }
            }
        }catch(Exception e){
            System.out.println("Hay un error en la Fila 2");
            System.out.println(e.getMessage());
            
            
        }
}
}
