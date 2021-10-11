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
public class point {
  
    private float x, y;
    
    
    public point(){
           x=0.0F;
           y=0.0F;
    }

    public point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public point(point p){
        x=p.x;
        y=p.y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public double distancia(point p){
        return Math.sqrt((p.x-x)*(p.x-x) + (p.y-y)*(p.y-y));
    }
    
        @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
