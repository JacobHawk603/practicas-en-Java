/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes2;
//Orotogonal 
//Obstaculos 
//Inicialice en la nave 
//Tomar solo 1 Sample
//Regrese a la nave
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author macario
 */
public class Agente extends Thread
{ //pasa la informacion del nombre, i, j y la matiz y tablero 
    String nombre;
    int i;
    int j;
    ImageIcon icon;
    int[][] matrix;
    JLabel tablero[][];
    //ImageIcon motherIcon;
    
    JLabel casillaAnterior; 
    Random aleatorio = new Random(System.currentTimeMillis()); //clase random genera numeros leatorios "tiempo distinto"
    //constructor 
   public Agente(String nombre, ImageIcon icon, int[][] matrix, JLabel tablero[][])
    {
        this.nombre = nombre;
        this.icon = icon;
        this.matrix = matrix;
        this.tablero = tablero;
        this.i = aleatorio.nextInt(matrix.length);
        this.j = aleatorio.nextInt(matrix.length);
        tablero[i][j].setIcon(icon);        
    }
    
    public void run(){
        
        int dirRow=1;
        int dirCol=1;
        /*
         switch (true){
         case 1:
             int dirRow=0;
             int dirCol=1;

             break;
         case 2:
             int dirRow=1;
             int dirCol=0;
             break;
         }*/
        while(true){

            casillaAnterior = tablero[i][j];
               
            if(i > matrix.length-2 && dirRow == 1) dirRow=-1;
            if(i < 1 && dirRow==-1) dirRow=1;

            if(j > matrix.length-2 && dirCol ==1) dirCol=-1;
            if(j < 1 && dirCol==-1) dirCol=1;
            
            if(dirRow== 1 || dirRow==-1) dirCol=0;
             if(dirCol== -1 || dirCol==1) dirRow=0;
            
            if (i < i+dirRow && dirCol < 0) i=i+dirRow;
            if (j > j+dirRow) j=j+dirRow;
            i=i+dirRow;
            j=j+dirCol;

            actualizarPosicion();
                
            try{
               sleep(100+aleatorio.nextInt(100));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
                
        //Cuando se tienen distintos hilos de posicion  que accedes a la memoria, es necesario que se sincronicen para que no 
        //Colicionen entre ellos, y si los dos modifican al mismo tiempo entonces crea un colicion
    }
    //El metodo "synchronized" permite que se sincronice y no colicionen
    public synchronized void actualizarPosicion()
    {
        casillaAnterior.setIcon(null); // Elimina su figura de la casilla anterior
        tablero[i][j].setIcon(icon); // Pone su figura en la nueva casilla (Los iconos pueden tener la misma posicion pero no pueden hacer cambios al mismo tiempo)
        System.out.println(nombre + " in -> Row: " + i + " Col:"+ j);              
    }
    
}
