/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sys.shop.controller.exceptions.NonexistentEntityException;
import sys.shop.controller.exceptions.PreexistingEntityException;
import sys.shop.entity.MecMercadoriaCompra;
import sys.shop.entity.MecMercadoriaCompraPK;

/**
 *
 * @author paulo
 */
public class MecMercadoriaCompraJpaController implements Serializable {

    public MecMercadoriaCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MecMercadoriaCompra mecMercadoriaCompra) throws PreexistingEntityException, Exception {
        if (mecMercadoriaCompra.getMecMercadoriaCompraPK() == null) {
            mecMercadoriaCompra.setMecMercadoriaCompraPK(new MecMercadoriaCompraPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mecMercadoriaCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMecMercadoriaCompra(mecMercadoriaCompra.getMecMercadoriaCompraPK()) != null) {
                throw new PreexistingEntityException("MecMercadoriaCompra " + mecMercadoriaCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MecMercadoriaCompra mecMercadoriaCompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mecMercadoriaCompra = em.merge(mecMercadoriaCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MecMercadoriaCompraPK id = mecMercadoriaCompra.getMecMercadoriaCompraPK();
                if (findMecMercadoriaCompra(id) == null) {
                    throw new NonexistentEntityException("The mecMercadoriaCompra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MecMercadoriaCompraPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MecMercadoriaCompra mecMercadoriaCompra;
            try {
                mecMercadoriaCompra = em.getReference(MecMercadoriaCompra.class, id);
                mecMercadoriaCompra.getMecMercadoriaCompraPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mecMercadoriaCompra with id " + id + " no longer exists.", enfe);
            }
            em.remove(mecMercadoriaCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MecMercadoriaCompra> findMecMercadoriaCompraEntities() {
        return findMecMercadoriaCompraEntities(true, -1, -1);
    }

    public List<MecMercadoriaCompra> findMecMercadoriaCompraEntities(int maxResults, int firstResult) {
        return findMecMercadoriaCompraEntities(false, maxResults, firstResult);
    }

    private List<MecMercadoriaCompra> findMecMercadoriaCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MecMercadoriaCompra.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public MecMercadoriaCompra findMecMercadoriaCompra(MecMercadoriaCompraPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MecMercadoriaCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getMecMercadoriaCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MecMercadoriaCompra> rt = cq.from(MecMercadoriaCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
