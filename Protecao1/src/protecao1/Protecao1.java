/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protecao1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elio_alves
 */
public class Protecao1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Janela jan1 = new Janela();
        
        while(true){
            try {
                long start = System.currentTimeMillis();
                jan1.repaint();
                long end = System.currentTimeMillis();
                Thread.sleep(55-(end-start));
            } catch (InterruptedException ex) {
                Logger.getLogger(Protecao1.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }
    }
    
}
