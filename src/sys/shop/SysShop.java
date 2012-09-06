/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop;

import java.util.logging.Level;
import java.util.logging.Logger;
import sys.shop.controller.EstEstadoJpaController;
import sys.shop.controller.exceptions.PreexistingEntityException;
import sys.shop.entity.EstEstado;

/**
 *
 * @author paulo
 */
public class SysShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Entering Tests");
        
        EstEstadoJpaController estado = new EstEstadoJpaController();
        EstEstado estEstado = new EstEstado(); 
        estEstado.setEstId(2);
        estEstado.setEstNome("Espirito Santo");
        estEstado.setEstSigla("ES");
        try {
            estado.create(estEstado);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
