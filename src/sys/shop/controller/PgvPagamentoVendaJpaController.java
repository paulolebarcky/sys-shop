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
import sys.shop.entity.PgvPagamentoVenda;
import sys.shop.entity.PgvPagamentoVendaPK;

/**
 *
 * @author paulo
 */
public class PgvPagamentoVendaJpaController implements Serializable {

    public PgvPagamentoVendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PgvPagamentoVenda pgvPagamentoVenda) throws PreexistingEntityException, Exception {
        if (pgvPagamentoVenda.getPgvPagamentoVendaPK() == null) {
            pgvPagamentoVenda.setPgvPagamentoVendaPK(new PgvPagamentoVendaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pgvPagamentoVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPgvPagamentoVenda(pgvPagamentoVenda.getPgvPagamentoVendaPK()) != null) {
                throw new PreexistingEntityException("PgvPagamentoVenda " + pgvPagamentoVenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PgvPagamentoVenda pgvPagamentoVenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pgvPagamentoVenda = em.merge(pgvPagamentoVenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PgvPagamentoVendaPK id = pgvPagamentoVenda.getPgvPagamentoVendaPK();
                if (findPgvPagamentoVenda(id) == null) {
                    throw new NonexistentEntityException("The pgvPagamentoVenda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PgvPagamentoVendaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PgvPagamentoVenda pgvPagamentoVenda;
            try {
                pgvPagamentoVenda = em.getReference(PgvPagamentoVenda.class, id);
                pgvPagamentoVenda.getPgvPagamentoVendaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pgvPagamentoVenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(pgvPagamentoVenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PgvPagamentoVenda> findPgvPagamentoVendaEntities() {
        return findPgvPagamentoVendaEntities(true, -1, -1);
    }

    public List<PgvPagamentoVenda> findPgvPagamentoVendaEntities(int maxResults, int firstResult) {
        return findPgvPagamentoVendaEntities(false, maxResults, firstResult);
    }

    private List<PgvPagamentoVenda> findPgvPagamentoVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PgvPagamentoVenda.class));
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

    public PgvPagamentoVenda findPgvPagamentoVenda(PgvPagamentoVendaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PgvPagamentoVenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getPgvPagamentoVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PgvPagamentoVenda> rt = cq.from(PgvPagamentoVenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
