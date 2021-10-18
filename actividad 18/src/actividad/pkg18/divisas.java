/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg18;

/**
 *
 * @author Jacob
 */
public class divisas {
        
    float pesos;

    public divisas(float pesos) {
        this.pesos = pesos;
    }

    public void setPesos(float pesos) {
        this.pesos = pesos;
    }



    public float pesosDolares(){

        float dolares;

        dolares=pesos / 20.34F;

        return dolares;
    }
}
