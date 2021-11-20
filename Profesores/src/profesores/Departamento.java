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
public class Departamento {
   
    private String Nombre;
    private byte ID;
    
    private ArrayList <Profesor> Miembros;
    // gets y sets
    
    public String getNombre(){return Nombre;}
    public byte getID(){return ID;}
    public ArrayList <Profesor> getProfes(){return Miembros;}
    //constructor
    
    public Departamento (String N, byte id){
        Nombre=N;
        ID=id;
        Miembros=new ArrayList ();
        
    }
    
    public void registrarProf(Profesor P ){
           Miembros.add(P);
    }
    
}
