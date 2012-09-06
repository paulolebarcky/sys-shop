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
import sys.shop.entity.VedVendedor;

/**
 *
 * @author paulo
 */
public class VedVendedorJpaController implements Serializable {

    public VedVendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VedVendedor vedVendedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vedVendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVedVendedor(vedVendedor.getVedId()) != null) {
                throw new PreexistingEntityException("VedVendedor " + vedVendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VedVendedor vedVendedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vedVendedor = em.merge(vedVendedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vedVendedor.getVedId();
                if (findVedVendedor(id) == null) {
                    throw new NonexistentEntityException("The vedVendedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            VedVendedor vedVendedor;
            try {
                vedVendedor = em.getReference(VedVendedor.class, id);
                vedVendedor.getVedId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vedVendedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(vedVendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VedVendedor> findVedVendedorEntities() {
        return findVedVendedorEntities(true, -1, -1);
    }

    public List<VedVendedor> findVedVendedorEntities(int maxResults, int firstResult) {
        return findVedVendedorEntities(false, maxResults, firstResult);
    }

    private List<VedVendedor> findVedVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VedVendedor.class));
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

    public VedVendedor findVedVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VedVendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getVedVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VedVendedor> rt = cq.from(VedVendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
