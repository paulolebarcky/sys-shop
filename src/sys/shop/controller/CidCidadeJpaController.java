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
import sys.shop.entity.CidCidade;

/**
 *
 * @author paulo
 */
public class CidCidadeJpaController implements Serializable {

    public CidCidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CidCidade cidCidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cidCidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCidCidade(cidCidade.getCidId()) != null) {
                throw new PreexistingEntityException("CidCidade " + cidCidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CidCidade cidCidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cidCidade = em.merge(cidCidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cidCidade.getCidId();
                if (findCidCidade(id) == null) {
                    throw new NonexistentEntityException("The cidCidade with id " + id + " no longer exists.");
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
            CidCidade cidCidade;
            try {
                cidCidade = em.getReference(CidCidade.class, id);
                cidCidade.getCidId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cidCidade with id " + id + " no longer exists.", enfe);
            }
            em.remove(cidCidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CidCidade> findCidCidadeEntities() {
        return findCidCidadeEntities(true, -1, -1);
    }

    public List<CidCidade> findCidCidadeEntities(int maxResults, int firstResult) {
        return findCidCidadeEntities(false, maxResults, firstResult);
    }

    private List<CidCidade> findCidCidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CidCidade.class));
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

    public CidCidade findCidCidade(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CidCidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getCidCidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CidCidade> rt = cq.from(CidCidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
