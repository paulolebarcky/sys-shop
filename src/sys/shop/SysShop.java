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
        
        findAll();
    }

    public static void create() {
        System.out.println("Create entering Tests");

        EstEstado estEstado = new EstEstado();
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

        EstEstado estEstado = new EstEstado();
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

        EstEstado estEstado = new EstEstado();
        estEstado.setEstId(3);
        estEstado.setEstNome("Rio de Janeiro");
        estEstado.setEstSigla("RJ");

        EstadoController estado = new EstadoController(estEstado);

        try {
            List<EstEstado> listEstados = estado.findEntities();
            
            for (EstEstado estEstado1 : listEstados) {
                System.out.println(estEstado1.toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SysShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
