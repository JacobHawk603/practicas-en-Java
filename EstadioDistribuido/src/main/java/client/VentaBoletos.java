/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import server.Frame;
import javax.swing.ImageIcon;

/**
 *
 * @author Jacob
 */
public class VentaBoletos extends Thread{
    
    int cont;
    
    private int port = 1234;            //<- se puede cambiar dependiendo la situacion
    private String ip = "192.168.1.74";    //<- se cambia si es local o remoto
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
                Thread.sleep(1000);
//                    Frame.pensamiento1.setText("Comprador: un boleto plis");
                    salida.write(1);
                Thread.sleep(1000);
//                    Frame.pensamiento1.setText("");
//                    Frame.pensamiento2.setText("Vendedor: Claro, aquí tiene");
                    salida.write(2);
                Thread.sleep(1000);
//                    Frame.pensamiento2.setText("");
//                    Frame.pensamiento1.setText("Comprador: Muchas Gracias");
                    salida.write(3);
                Thread.sleep(1000);
//                    Frame.pensamiento1.setText("");
//                    Frame.pensamiento2.setText("Vendedor: De nada");
                    salida.write(4);
                
                    cont++;
                    System.out.println("Estas son las veces que el vendedor ha despachado: "+cont);
            }
        }catch(Exception e){
            System.out.println("El vendedor se enojó 0w0");
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args){
        
        VentaBoletos venta = new VentaBoletos();
        System.out.println("estableciendo conección...");
        
        venta.conectar();
        
        venta.run();
    }
}
