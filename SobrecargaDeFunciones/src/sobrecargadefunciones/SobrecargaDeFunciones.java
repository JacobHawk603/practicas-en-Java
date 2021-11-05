/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sobrecargadefunciones;

import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public class SobrecargaDeFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList <String> palabras = new ArrayList();
        Lista miLista = new Lista("");
        
        palabras.add("Chelas");
        palabras.add("Tacos");
        palabras.add(1, "huaraches");
        palabras.add("sopes");
        palabras.add(2, "Pulque");
        
        for(String elemento : palabras){
            System.out.println(elemento);
        }
        
        System.out.println("\nOtra manera de hacerlo: \n");
        
        miLista.add("Chelas");
        miLista.add("Tacos");
        miLista.add(1, "huaraches");
        miLista.add("sopes");
        miLista.add(2, "pulque");
        
        miLista.mostrarLista();
    }
    
}
