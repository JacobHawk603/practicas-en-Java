/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstraccionPolimorfismo;

/**
 *
 * @author Jacob
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cuadrado miCuadrado = new Cuadrado(5);
        Triangulo miTriangulo = new Triangulo(3,4);
        Circulo miCirculo = new Circulo(6);
        Lista miLista = new Lista();
        Cola miCola = new Cola();
        Pila miPila = new Pila();
        
        System.out.println("El perimetro del cuadrado es: "+miCuadrado.Perimetro()+"\n"
                + "El area del cuadrado es: "+miCuadrado.area()+"\n\n");
        
        System.out.println("El perimetro del circulo es: "+miCirculo.Perimetro()+"\n"
                + "El area del circulo es: "+miCirculo.area()+"\n\n");
        
        System.out.println("El perimetro del triangulo es: "+miTriangulo.Perimetro()+"\n"
                + "El area del triangulo es: "+miTriangulo.area()+"\n\n");
        
        miCola.crear();
        miCola.pop();
        miCola.push();
        miCola.vaciar();
        
        miPila.crear();
        miPila.pop();
        miPila.push();
        miPila.vaciar();
        
        miLista.crear();
        miLista.pop();
        miLista.pop(3);
        miLista.push();
        miLista.push(6);
        miLista.vaciar();
    }
    
}
