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
import sys.shop.entity.ComCompra;

/**
 *
 * @author paulo
 */
public class ComCompraJpaController implements Serializable {

    public ComCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ComCompra comCompra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComCompra(comCompra.getComId()) != null) {
                throw new PreexistingEntityException("ComCompra " + comCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ComCompra comCompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comCompra = em.merge(comCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = comCompra.getComId();
                if (findComCompra(id) == null) {
                    throw new NonexistentEntityException("The comCompra with id " + id + " no longer exists.");
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
            ComCompra comCompra;
            try {
                comCompra = em.getReference(ComCompra.class, id);
                comCompra.getComId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comCompra with id " + id + " no longer exists.", enfe);
            }
            em.remove(comCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ComCompra> findComCompraEntities() {
        return findComCompraEntities(true, -1, -1);
    }

    public List<ComCompra> findComCompraEntities(int maxResults, int firstResult) {
        return findComCompraEntities(false, maxResults, firstResult);
    }

    private List<ComCompra> findComCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ComCompra.class));
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

    public ComCompra findComCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ComCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getComCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ComCompra> rt = cq.from(ComCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
