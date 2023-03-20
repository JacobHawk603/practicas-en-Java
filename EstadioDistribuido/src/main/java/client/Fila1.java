/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.Frame;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;

/**
 *
 * @author Jacob
 */
public class Fila1 extends Thread {
    
    int i, j, cont;

    //variables para la conexion socket
    private int port = 1234;            //<- se puede cambiar dependiendo la situacion
    private String ip = "127.0.0.1";    //<- se cambia si es local o remoto
    private Socket socket;
    private DataOutputStream salida;
    private BufferedReader entrada;

    private void conectar(){
        try{
            socket = new Socket(ip, port);
            
            //flujos de entrada
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //flujos de salida
            salida = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("conexión exitosa");
            
        }catch(Exception e){
            System.out.println("no se pudo establecer conección con el servidor");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
            System.exit(1);
        }
    }
    
    public void run(){
         try{
             while(entrada.read() < 200){
                while(i==0){
                    //System.out.println(Frame.fila1[19].getIcon().toString());



                   for (i = 0; i < 10; i++) {


                       Thread.sleep(100 * 4);

                        //Frame.fila1[i].setIcon(new ImageIcon("src/imagenes/little stickman.jpg")); 
                        salida.writeUTF("Fila1");
                        
                        System.out.println("El vendedor Despachó al cliente "+i);

                   }
                   
                       Thread.sleep(100);
                       //Frame.x += 5;
                       salida.writeInt(5);
                       
                       //Frame.usuarios.setText("x "+Frame.x);
                       
                    //for (int j = 0; j < 20; j++) {
                        //Frame.fila1[j].setIcon(new ImageIcon("")); 
                    //}
                    salida.writeUTF("Fila1Empty");
                    if(entrada.read() < 180){
                        i=0;
                        cont+=10;
                    }else{
                        
                    }
                    System.out.println("Esto es el contador de la fila 1: "+cont);
                }    
             }
        }catch(Exception e){
             System.out.println("Ha ocurrido algo en la fila 1");
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
        }
    }
    
    public static void main(String[] args){
        
        Fila1 fila = new Fila1();
        System.out.println("estableciendo conección...");
        
        fila.conectar();
        
        fila.run();
    }
}
