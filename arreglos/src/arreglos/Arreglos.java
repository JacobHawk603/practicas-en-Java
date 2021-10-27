/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;

/**
 *
 * @author Jacob
 */
public class Arreglos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombres[][] = {{"Elizabeth", "Valery", "Sarah"}, {"Sarahí", "Miriam"}};
        
        //For tradicional
        
        /*for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }*/
        
        //for each anidadoc
        for(String[] arreglo: nombres){
            for(String cadena: arreglo){
                System.out.println(cadena);
            }   
        }
        
        //Iterador
        
        
    }
    
}
