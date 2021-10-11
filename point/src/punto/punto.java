/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto;

/**
 *
 * @author Jacob
 */
public class punto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        point p = new point();
        point p2 = new point(10, 0);
        
        System.out.println(p.toString());
        System.out.println("la distancia entre  es: "+ p.distancia(p2));
    }
    
}
