/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg18;

import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 */
public class Actividad18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int index;
        boolean condicion=true;
        float dato=0.0F;
        String validos = "0123456789";
        String validos2= "0123456789.";
        String entrada;
        
        try{
            do{
                entrada =JOptionPane.showInputDialog(
                          "1. Convertir farenheit a celsius.\n"
                        + "2. Convertir pesos a Dolares.\n"
                        + "3. Convertir pulgadas a centímetros.\n"
                        + "4. Salir"
                );
                
                if(validos.contains(entrada)){
                    index=Integer.parseInt(entrada);
                }else{
                    JOptionPane.showMessageDialog(null, "escribe un valor válido","cuidado", JOptionPane.ERROR_MESSAGE);
                    index=5;
                }
            }while(index<0 || index>4);

            while(condicion){
                switch(index){
                    case 1:
                        temperaturas temperatura = new temperaturas(0.0F);
                        entrada = JOptionPane.showInputDialog("cual es la temperatura en Farenheith?");
                        
                        for (int i = 0; i < entrada.length(); i++) {
                            if(validos2.indexOf(entrada.charAt(i))!=-1){
                                dato=Float.parseFloat(entrada);
                                condicion=false;
                            }else{
                                JOptionPane.showMessageDialog(null, "escribe un valor válido","cuidado", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    if(condicion==true)
                        break;
                    
                    temperatura.setF(dato);
                    JOptionPane.showMessageDialog(null, "La temperatura en Celsius es: "+temperatura.FarenheithToCelsius(),"temperatura", JOptionPane.INFORMATION_MESSAGE);

                    break;

                    case 2:
                        divisas moneda = new divisas(0.0F);
                        entrada = JOptionPane.showInputDialog("cual es la cantidad monetaria a convertir?");
                        for (int i = 0; i < entrada.length(); i++) {
                            if(validos2.indexOf(entrada.charAt(i))!=-1){
                                dato=Float.parseFloat(entrada);
                                condicion=false;
                            }else{
                                JOptionPane.showMessageDialog(null, "escribe un valor válido","cuidado", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    if(condicion==true)
                        break;
                        
                        moneda.setPesos(dato);
                        JOptionPane.showMessageDialog(null, "La cantidad monetaria en dolares es: "+moneda.pesosDolares(),"divisas:", JOptionPane.INFORMATION_MESSAGE);
                    break;

                    case 3:
                        mediciones medida = new mediciones(0.0F);
                        entrada = JOptionPane.showInputDialog("cual es la medida a convertir?");
                        for (int i = 0; i < entrada.length(); i++) {
                            if(validos2.indexOf(entrada.charAt(i))!=-1){
                                dato=Float.parseFloat(entrada);
                                condicion=false;
                            }else{
                                JOptionPane.showMessageDialog(null, "escribe un valor válido","cuidado", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    if(condicion==true)
                        break;
                        
                        
                        medida.setIn(dato);
                        JOptionPane.showMessageDialog(null, "La medida en centimetros es: "+medida.insToCm(),"medidas:", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    default: System.exit(0);
                }
            }
        }catch(Exception e){
            System.exit(0);
        }
}
    
}
