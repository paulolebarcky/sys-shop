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
import sys.shop.entity.MevMercadoriaVenda;
import sys.shop.entity.MevMercadoriaVendaPK;

/**
 *
 * @author paulo
 */
public class MevMercadoriaVendaJpaController implements Serializable {

    public MevMercadoriaVendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MevMercadoriaVenda mevMercadoriaVenda) throws PreexistingEntityException, Exception {
        if (mevMercadoriaVenda.getMevMercadoriaVendaPK() == null) {
            mevMercadoriaVenda.setMevMercadoriaVendaPK(new MevMercadoriaVendaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mevMercadoriaVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMevMercadoriaVenda(mevMercadoriaVenda.getMevMercadoriaVendaPK()) != null) {
                throw new PreexistingEntityException("MevMercadoriaVenda " + mevMercadoriaVenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MevMercadoriaVenda mevMercadoriaVenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mevMercadoriaVenda = em.merge(mevMercadoriaVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MevMercadoriaVendaPK id = mevMercadoriaVenda.getMevMercadoriaVendaPK();
                if (findMevMercadoriaVenda(id) == null) {
                    throw new NonexistentEntityException("The mevMercadoriaVenda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MevMercadoriaVendaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MevMercadoriaVenda mevMercadoriaVenda;
            try {
                mevMercadoriaVenda = em.getReference(MevMercadoriaVenda.class, id);
                mevMercadoriaVenda.getMevMercadoriaVendaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mevMercadoriaVenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(mevMercadoriaVenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MevMercadoriaVenda> findMevMercadoriaVendaEntities() {
        return findMevMercadoriaVendaEntities(true, -1, -1);
    }

    public List<MevMercadoriaVenda> findMevMercadoriaVendaEntities(int maxResults, int firstResult) {
        return findMevMercadoriaVendaEntities(false, maxResults, firstResult);
    }

    private List<MevMercadoriaVenda> findMevMercadoriaVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MevMercadoriaVenda.class));
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

    public MevMercadoriaVenda findMevMercadoriaVenda(MevMercadoriaVendaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MevMercadoriaVenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getMevMercadoriaVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MevMercadoriaVenda> rt = cq.from(MevMercadoriaVenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
