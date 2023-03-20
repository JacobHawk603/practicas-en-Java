/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estadiodistribuido;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author yerry
 */
public class conectorCliente {
    
    
    Socket cliente;
    int port = 1234;
    String ip = "127.0.0.1"; //<- esta se modifica dependiendo de que dispositivo vamos a conectar
    PrintStream salida;
    BufferedReader entrada, teclado;
    
    public void iniciar() {
        
        System.out.println("me inicio aquí?");
        try{
            cliente = new Socket(ip, port);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado = new BufferedReader(new InputStreamReader(System.in));
            
            String mensajito = teclado.readLine();
            salida = new PrintStream(cliente.getOutputStream());
            salida.println(mensajito);
            
            String msg = entrada.readLine();
            System.out.println(mensajito);
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        }catch(Exception e){
            System.out.println("error aqui eh");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        };
    }
}
