/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.AsientosUsados;
import client.Fila1;
import client.Fila2;
import client.VentaBoletos;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

import java.net.*;
import java.io.*;

/**
 *
 * @author Jacob
 */
public class Frame extends JFrame{
    
    static JLabel[] fila1, fila2;
    static JLabel man, pensamiento1, pensamiento2, asientos, usuarios;
    static int x = 0;
    //private Thread hilo1, hilo2, hilo3, hilo4;
    
    //variables para la coneccion socket
    private ServerSocket server;
    private Socket fila1_socket, fila2_socket, venta;
    DataOutputStream fila1Output, fila2Output, ventaOutput;
    BufferedReader fila1Input, fila2Input, ventaInput;
    
    public Frame(){
        super("Ejemplo de uso de Hilos en Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        
        this.setContentPane(new JLabel(new ImageIcon("src/main/java/imagenes/stadium.jpg")));

        
        
        man = new JLabel(new ImageIcon("src/main/java/imagenes/stickman.jpg"));
        man.setBounds(650, 520, 100, 146);
        add(man);
        
        pensamiento1 = new JLabel("");
        pensamiento1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        pensamiento1.setBounds(700, 450, 200, 30);
        add(pensamiento1);
        
        pensamiento2 = new JLabel("");
        pensamiento2.setBounds(700, 400, 200, 30);
        pensamiento2.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        add(pensamiento2);
        
        asientos = new JLabel();
        asientos.setBounds(650, 0, 138, 153);
        add(asientos);
        
        usuarios = new JLabel();
        usuarios.setBounds(790, 0, 138, 153);
        usuarios.setFont(new Font("Algerian", Font.PLAIN, 36));
        add(usuarios);
        usuarios.setText("x"+ x);
        
        fila1 = new JLabel[20];
        fila2 = new JLabel[20];

        for (int i = 0; i < 20; i++) {
            fila1[i] = new JLabel(new ImageIcon(""));

            fila2[i] = new JLabel(new ImageIcon(""));

            if (i<10) {
                fila1[i].setBounds(120, (i*36)+300, 25, 36);
                add(fila1[i]);

                fila2[i].setBounds(275, (i*36)+300, 25, 36);
                add(fila2[i]);

            }else{
                fila1[i].setBounds(165, ((i-10)*36)+300, 25, 36);
                add(fila1[i]);

                fila2[i].setBounds(325, ((i-10)*36)+300, 25, 36);
                add(fila2[i]);
            }
        }
//        hilo1= new Thread(new Fila1());
//        hilo1.start();
//        
//        hilo2 = new Thread(new Fila2());
//        hilo2.start();
//        
//        hilo3 = new Thread(new VentaBoletos());
//        hilo3.start();
//        
//        hilo4 = new Thread(new AsientosUsados());
//        hilo4.start();
        
    }
    
    public void Launcher(){
        Frame obj = new Frame();
        obj.setVisible(true);
        obj.setBounds(0, 0, 900, 700);
        obj.setLocationRelativeTo(null);
    }
    
    protected void montar(int port){
        int cont_fila1 = 0, cont_fila2 = 0, cont_fila3 = 0;
        
        try{
            server = new ServerSocket(port);
            
            System.out.println("esperando coneccion con los subprocesos...");
            
            //fila 1
            fila1_socket = new Socket();
            fila1_socket = server.accept();
            
            
            System.out.println("la fila 1 está conectada\n\nEsperando conexion con la fila 2...");
            
            //fila 2
            fila2_socket = new Socket();
            fila2_socket = server.accept();
            
            System.out.println("la fila 2 está conectada\n\npreparando proceso de venta...");
            
            //asientos usados
            
            //venta boletos
            venta = new Socket();
            venta = server.accept();
            
            System.out.println("El vendedor está listo\n\n");
            
            System.out.println("servidor montado y listo para la simulación");
            
            //fila 1
            fila1Input = new BufferedReader(new InputStreamReader(fila1_socket.getInputStream()));
            fila1Output = new DataOutputStream(fila1_socket.getOutputStream());
            
            //fila2
            fila2Input = new BufferedReader(new InputStreamReader(fila2_socket.getInputStream()));
            fila2Output = new DataOutputStream(fila2_socket.getOutputStream());
            
            //venta Boletos
            ventaInput = new BufferedReader(new InputStreamReader(venta.getInputStream()));
            ventaOutput = new DataOutputStream(venta.getOutputStream());
            
            while(true){
                
                fila1Output.write(x);
                fila2Output.write(x);
                ventaOutput.write(x);
                //CONTROL FILA 1
                
                if(fila1Input.read() == 1){
                    fila1[cont_fila1].setIcon(new ImageIcon("src/main/java/imagenes/little stickman.jpg"));
                    cont_fila1 ++;
                }else if(fila1Input.read() == 0){
                    cont_fila1 = 0;
                    for (int i = 0; i < 20; i++) {
                        fila1[i].setIcon(new ImageIcon(""));
                    }
                    x+=10;
                    usuarios.setText("x "+ x);   
                    
                }
                
                //CONTROL FILA 2
                
                if(fila2Input.read() == 1){
                    fila2[cont_fila2].setIcon(new ImageIcon("src/main/java/imagenes/little stickman.jpg"));
                    cont_fila2 ++;
                }else if(fila2Input.read() == 0){
                    cont_fila2 = 0;
                    for (int i = 0; i < 20; i++) {
                        fila2[i].setIcon(new ImageIcon(""));
                    }
                    x+=20;
                    usuarios.setText("x "+ x);   
                    
                }
                
                //CONTROL VENTA DE BOLETOS
                
                if(ventaInput.read() == 1){
                    pensamiento1.setText("Comprador: un boleto plis");
                }else if(ventaInput.read() == 2){
                    pensamiento1.setText("");
                    pensamiento2.setText("Vendedor: Claro, aquí tiene");
                }else if(ventaInput.read() == 3){
                    pensamiento2.setText("");
                    pensamiento1.setText("Comprador: Muchas Gracias");
                }else if(ventaInput.read() == 4){
                    pensamiento1.setText("");
                    pensamiento2.setText("Vendedor: De nada");
                }
                
                System.out.println(ventaInput.read());
            }
            
        }catch(Exception e){
            System.out.println("ha ocurrido un error en el servidor");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.exit(1);
        }
    }
}
