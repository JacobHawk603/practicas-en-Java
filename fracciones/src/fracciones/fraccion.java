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
public class fraccion {
    int numerador, denominador;

    public fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }
    
    public fraccion sumar(fraccion frac2){
        fraccion resultado= new fraccion(1,1);
        
        resultado.denominador= denominador*frac2.denominador;
        resultado.numerador=(numerador*frac2.denominador)+(frac2.numerador*denominador);
        resultado.simplificar();
        
        return resultado;
    }
    
    private void simplificar(){
        int menor=1, mayor=1, mcd=1;
        
        if (denominador==1 && numerador==1) {
            return;
        }else if (denominador==numerador) {
            numerador=denominador=1;
            return;
        }else if (numerador>denominador) {
            mayor=numerador;
            menor=denominador;
        }else if (denominador>numerador) {
            mayor=denominador;
            menor=numerador;
        }
        
        if (mayor%menor==0) {
            numerador/=menor;
            denominador/=menor;
            
            return;
        }
        
        for (int i = 1; i < menor; i++) {
            if (numerador%i==0 &&denominador%i==0)
                mcd=i;
        }
            numerador/=mcd;
            denominador/=mcd;
    }
    
    @Override
    public String toString(){
        return numerador + "/" + denominador;
    }
}
