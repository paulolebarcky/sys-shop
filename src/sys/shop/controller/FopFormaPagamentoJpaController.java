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
import sys.shop.entity.FopFormaPagamento;

/**
 *
 * @author paulo
 */
public class FopFormaPagamentoJpaController implements Serializable {

    public FopFormaPagamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FopFormaPagamento fopFormaPagamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(fopFormaPagamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFopFormaPagamento(fopFormaPagamento.getFopId()) != null) {
                throw new PreexistingEntityException("FopFormaPagamento " + fopFormaPagamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FopFormaPagamento fopFormaPagamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            fopFormaPagamento = em.merge(fopFormaPagamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = fopFormaPagamento.getFopId();
                if (findFopFormaPagamento(id) == null) {
                    throw new NonexistentEntityException("The fopFormaPagamento with id " + id + " no longer exists.");
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
            FopFormaPagamento fopFormaPagamento;
            try {
                fopFormaPagamento = em.getReference(FopFormaPagamento.class, id);
                fopFormaPagamento.getFopId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fopFormaPagamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(fopFormaPagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FopFormaPagamento> findFopFormaPagamentoEntities() {
        return findFopFormaPagamentoEntities(true, -1, -1);
    }

    public List<FopFormaPagamento> findFopFormaPagamentoEntities(int maxResults, int firstResult) {
        return findFopFormaPagamentoEntities(false, maxResults, firstResult);
    }

    private List<FopFormaPagamento> findFopFormaPagamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FopFormaPagamento.class));
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

    public FopFormaPagamento findFopFormaPagamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FopFormaPagamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getFopFormaPagamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FopFormaPagamento> rt = cq.from(FopFormaPagamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
