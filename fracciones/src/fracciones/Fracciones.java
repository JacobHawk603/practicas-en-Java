/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fracciones;

/**
 *
 * @author Jacob
 */
public class Fracciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fraccion F1= new fraccion(1,3);
        fraccion F2 = new fraccion(1,2);
        fraccion F= new fraccion(1,1);  //la inicializo con 1,1 para evitar errores matemáticos de indeterminaciones
        
        F=F1.sumar(F2);
        
        System.out.println("la fracción 1 es: "+F1.toString() +"\n"
        +"la fraccion 2 es: "+F2.toString());
        
        System.out.println(F1.toString() + " + " + F2.toString() +" = " +F.toString());
    }
    
}
