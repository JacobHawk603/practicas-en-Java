/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import Bitacora.GestorBitacora;
import static client.Fila1.bitacora;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.Frame;
import javax.swing.ImageIcon;

/**
 *
 * @author Jacob
 */
public class Fila2 extends Thread{
   
   int i, j, cont;

    //variables para la conexion socket
    private int port = 1234;            //<- se puede cambiar dependiendo la situacion
    private String ip = "192.168.1.74";    //<- se cambia si es local o remoto
    private Socket socket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    
    static Logger bitacora = GestorBitacora.getBitacora("client.Fila1", "Bitacora_Fila2.txt", Level.FINE);

    private void conectar(){
        try{
            socket = new Socket(ip, port);
            
            //flujos de entrada
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //flujos de salida
            salida = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("conexión exitosa");
            bitacora.fine("Fila 2 conectada exitosamente al servidor");
            
        }catch(Exception e){
            System.out.println("no se pudo establecer conección con el servidor");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            bitacora.severe("error al conectarse al servidor: " + e.getMessage());
            
            System.exit(1);
        }
    }
    
    public void run(){
         try{
             //System.out.println(entrada.read());
             int contador = 0;
             
             bitacora.fine("cliente escuchando y mandando informacion al servidor");
             while(entrada.read() < 200){
                 
                while(i==0){
                    //System.out.println(Frame.fila1[19].getIcon().toString());



                   for (i = 0; i < 20; i++) {


                       Thread.sleep(100 * 4);

                        //Frame.fila1[i].setIcon(new ImageIcon("src/imagenes/little stickman.jpg")); 
                        salida.write(1);
                        
                        System.out.println("El vendedor Despachó al cliente "+i);

                    }
                   
                    Thread.sleep(100);
                    //Frame.x += 5;
                    salida.write(0);

                    //Frame.usuarios.setText("x "+Frame.x);

                    //for (int j = 0; j < 20; j++) {
                         //Frame.fila1[j].setIcon(new ImageIcon("")); 
                    //}
                    Thread.sleep(100 * 5);
                    salida.write(0);
                    if(entrada.read() < 180){
                        i=0;
                        cont+=20;
                    }else{
                        
                    }
                    System.out.println("Esto es el contador de la fila 2: "+cont);
                    
                    contador = entrada.read();
                    System.out.println("contador: "+contador);
                }  
                
                
             }
             
             bitacora.fine("Proceso terminado con exito");
        }catch(Exception e){
             System.out.println("Ha ocurrido algo en la fila 1");
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
             
             bitacora.severe("error en el subproceso: " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        
        Fila2 fila = new Fila2();
        System.out.println("estableciendo conección...");
        
        fila.conectar();
        
        fila.run();
    }
}
