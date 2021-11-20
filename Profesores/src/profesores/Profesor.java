/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesores;

import java.util.ArrayList;

/**
 *
 * @author flore
 */
public class Profesor implements Cloneable {
    
    private byte Num_Emp;
    private String Nombre;
    private ArrayList < String > Horario;      
    private String CorreoE;
    
    //...
    private Departamento D;
    // gets y sets
    
    public String getNombre(){        
        return Nombre;
    }
    public byte getNum_Emp(){return Num_Emp;}
    public Departamento getDepartamento (){return D;}
    
    public Profesor ( byte NE, String N,String CE){
    
         Num_Emp=NE;
         Nombre=N;
         Horario=new ArrayList();
         CorreoE=CE; 
         D=null;
    }
    
      
    public void registrarD ( Departamento De   ){
    
         D=De;
         De.registrarProf(this);
    }
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
}
