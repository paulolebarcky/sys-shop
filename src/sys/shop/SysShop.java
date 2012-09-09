/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sys.shop.controller.EstadoController;
import sys.shop.controller.exceptions.PreexistingEntityException;
import sys.shop.entity.Estado;

/**
 *
 * @author paulo
 */
public class SysShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create();
        remove();
        
    }

    public static void create() {
        System.out.println("Create entering Tests");

        Estado estEstado = new Estado();
        estEstado.setEstId(3);
        estEstado.setEstNome("Rio de Janeiro");
        estEstado.setEstSigla("RJ");

        EstadoController estado = new EstadoController(estEstado);

        try {
            estado.create();
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void remove() {
        System.out.println("Remove entering Tests");

        Estado estEstado = new Estado();
        estEstado.setEstId(3);
        estEstado.setEstNome("Rio de Janeiro");
        estEstado.setEstSigla("RJ");

        EstadoController estado = new EstadoController(estEstado);

        try {
            estado.remove(3);
        } catch (Exception ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void findAll() {
        System.out.println("Remove entering Tests");

        Estado estEstado = new Estado();
        estEstado.setEstId(3);
        estEstado.setEstNome("Rio de Janeiro");
        estEstado.setEstSigla("RJ");

        EstadoController estado = new EstadoController(estEstado);

        try {
            List<Estado> listEstados = estado.findEntities();
            
            for (Estado estEstado1 : listEstados) {
                System.out.println(estEstado1.toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
