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
import sys.shop.entity.VenVenda;

/**
 *
 * @author paulo
 */
public class VenVendaJpaController implements Serializable {

    public VenVendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VenVenda venVenda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(venVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVenVenda(venVenda.getVenId()) != null) {
                throw new PreexistingEntityException("VenVenda " + venVenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VenVenda venVenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            venVenda = em.merge(venVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venVenda.getVenId();
                if (findVenVenda(id) == null) {
                    throw new NonexistentEntityException("The venVenda with id " + id + " no longer exists.");
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
            VenVenda venVenda;
            try {
                venVenda = em.getReference(VenVenda.class, id);
                venVenda.getVenId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venVenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(venVenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VenVenda> findVenVendaEntities() {
        return findVenVendaEntities(true, -1, -1);
    }

    public List<VenVenda> findVenVendaEntities(int maxResults, int firstResult) {
        return findVenVendaEntities(false, maxResults, firstResult);
    }

    private List<VenVenda> findVenVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VenVenda.class));
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

    public VenVenda findVenVenda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VenVenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getVenVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VenVenda> rt = cq.from(VenVenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
