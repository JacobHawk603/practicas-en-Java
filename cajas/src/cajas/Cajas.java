/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajas;

import javax.swing.JOptionPane;

/**
 *
 * @author Jacob
 */
public class Cajas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String inputValue;
        float valor;
        
        JOptionPane.showMessageDialog(null, "hello there", "Obi wan dice:", JOptionPane.INFORMATION_MESSAGE);
        String grievus = JOptionPane.showInputDialog("que le contesta Grievus?");
        JOptionPane.showMessageDialog(null, grievus, "Grievus contesta", JOptionPane.INFORMATION_MESSAGE);  
        
        
        do{
            inputValue=JOptionPane.showInputDialog("un curado de");
        }while(inputValue==null || inputValue.equals(""));

        valor = Float.parseFloat(inputValue);
        
        valor += 100.0F;
        
        JOptionPane.showMessageDialog(null, valor, "solapa", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
