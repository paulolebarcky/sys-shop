package sys.shop.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author paulo
 */
public class PersistenceManager {

    public static final boolean DEBUG = true;
    /**
     *
     */
    private EntityManagerFactory emf;

    public PersistenceManager() {
    }

    public EntityManager getEntityManager() {

        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf.createEntityManager();
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG) {
                System.out.println("n*** Persistence finished at " + new java.util.Date());
            }
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("sys-shopPU");
        if (DEBUG) {
            System.out.println("n*** Persistence started at " + new java.util.Date());
        }
    }
}