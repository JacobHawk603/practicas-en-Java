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
public class temperaturas {
        
    float f;

    public temperaturas(float f) {
        this.f = f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public float FarenheithToCelsius(){

        float c;

        c = (f-32.0F) / 1.8F;

        return c;
    }

    
}
