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
import sys.shop.entity.TivTipoVenda;

/**
 *
 * @author paulo
 */
public class TivTipoVendaJpaController implements Serializable {

    public TivTipoVendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TivTipoVenda tivTipoVenda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tivTipoVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTivTipoVenda(tivTipoVenda.getTivId()) != null) {
                throw new PreexistingEntityException("TivTipoVenda " + tivTipoVenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TivTipoVenda tivTipoVenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tivTipoVenda = em.merge(tivTipoVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tivTipoVenda.getTivId();
                if (findTivTipoVenda(id) == null) {
                    throw new NonexistentEntityException("The tivTipoVenda with id " + id + " no longer exists.");
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
            TivTipoVenda tivTipoVenda;
            try {
                tivTipoVenda = em.getReference(TivTipoVenda.class, id);
                tivTipoVenda.getTivId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tivTipoVenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(tivTipoVenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TivTipoVenda> findTivTipoVendaEntities() {
        return findTivTipoVendaEntities(true, -1, -1);
    }

    public List<TivTipoVenda> findTivTipoVendaEntities(int maxResults, int firstResult) {
        return findTivTipoVendaEntities(false, maxResults, firstResult);
    }

    private List<TivTipoVenda> findTivTipoVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TivTipoVenda.class));
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

    public TivTipoVenda findTivTipoVenda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TivTipoVenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getTivTipoVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TivTipoVenda> rt = cq.from(TivTipoVenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
