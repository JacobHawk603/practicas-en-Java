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
public class mediciones {
    
    float in;
    
    public mediciones(float in){
        this.in=in;
    }

    public void setIn(float in) {
        this.in = in;
    }
    
    public float insToCm(){
        
        float cm;
        
        cm=in * 2.54F;
        
        return cm;
    }
}
