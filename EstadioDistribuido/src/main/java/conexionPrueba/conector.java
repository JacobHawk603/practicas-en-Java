/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionPrueba;

import java.net.*;
import java.io.*;

/**
 *
 * @author yerry
 */
public class conector {

    ServerSocket server;
    Socket miSocket;
    int port = 1234;
    DataOutputStream salida;
    BufferedReader entrada;
    
    public void iniciar() {
        
        System.out.println("me inicio aquí?");
        try{
            server = new ServerSocket(port);
            miSocket = new Socket();
            miSocket = server.accept();
            
            entrada = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
            String message = entrada.readLine();
            System.out.println(message);
            
            salida = new DataOutputStream(miSocket.getOutputStream());
            salida.writeUTF("Buenas noches profe Chad");
            miSocket.close();
            
            System.out.println("si estoy trabajando");
        }catch(Exception e){
            System.out.println("error aqui eh");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        };
    }
    
}
