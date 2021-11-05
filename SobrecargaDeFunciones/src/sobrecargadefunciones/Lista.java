/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sobrecargadefunciones;

/**
 *
 * @author Jacob
 */
public class Lista {
        private String lista;

    public Lista(String lista) {
        this.lista = lista;
    }

    public String getLista() {
        return lista;
    }
        
    public void add(String elemento){
        lista = lista+elemento+",";
    }
    
    public void add(int lugar, String elemento){
        String arreglo[] = new String[lista.split(",").length+1];
        String auxiliar[] = lista.split(",");

        for (int i = 0; i < auxiliar.length; i++) {

            arreglo[i]=auxiliar[i];
        }

        for (int i = (arreglo.length)-1; i >= (arreglo.length)-lugar; i--) {
            arreglo[i]=arreglo[i-1];
        }
        arreglo[lugar]=elemento;

        lista = "";

        for (int i = 0; i < arreglo.length; i++) {
           lista = lista + arreglo[i] + ",";
        }

    }
    
    public void mostrarLista(){
        String arreglo[]= lista.split(",");
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
    
}
