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
public class Profesores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        ArrayList <Profesor> Docentes=new ArrayList();
        ArrayList <Departamento> Dps=new ArrayList();
        // fase de registro de los maestros y departamentos
               
        Docentes.add(new Profesor((byte)6666,"Yaxkolin","chelas@gmail.com"));
        Docentes.add(new Profesor((byte)9999,"Axel","redes@gmail.com"));
        Docentes.add(new Profesor((byte)9999,"Luz","Lucesita@gmail.com") );
        Dps.add(new Departamento("Sistemas",(byte)5362));
        Dps.add(new Departamento("Ciencias",(byte)1111));
        
        // Asignar el departamento al que pertenece cada profesor
        
        Docentes.get(0).registrarD(Dps.get(1));
        Docentes.get(1).registrarD(Dps.get(0));
        Docentes.get(2).registrarD(Dps.get(0));
        
        //  
        
        for( Departamento D : Dps )
        { 
          System.out.println("El departamento "+D.getNombre()+" sus miembros son :");
           for (Profesor p: D.getProfes())
           {
                System.out.println(p.getNombre());
           }
        }
        
       for( Profesor P : Docentes )
        { 
          System.out.println("El Profesor " +P.getNombre()+" pertenece al Departamento de : "+ P.getDepartamento().getNombre());
           
        }  
    
    }
    
}
