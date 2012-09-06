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
import sys.shop.entity.LojLoja;

/**
 *
 * @author paulo
 */
public class LojLojaJpaController implements Serializable {

    public LojLojaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LojLoja lojLoja) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lojLoja);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLojLoja(lojLoja.getLojId()) != null) {
                throw new PreexistingEntityException("LojLoja " + lojLoja + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LojLoja lojLoja) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lojLoja = em.merge(lojLoja);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lojLoja.getLojId();
                if (findLojLoja(id) == null) {
                    throw new NonexistentEntityException("The lojLoja with id " + id + " no longer exists.");
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
            LojLoja lojLoja;
            try {
                lojLoja = em.getReference(LojLoja.class, id);
                lojLoja.getLojId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lojLoja with id " + id + " no longer exists.", enfe);
            }
            em.remove(lojLoja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LojLoja> findLojLojaEntities() {
        return findLojLojaEntities(true, -1, -1);
    }

    public List<LojLoja> findLojLojaEntities(int maxResults, int firstResult) {
        return findLojLojaEntities(false, maxResults, firstResult);
    }

    private List<LojLoja> findLojLojaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LojLoja.class));
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

    public LojLoja findLojLoja(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LojLoja.class, id);
        } finally {
            em.close();
        }
    }

    public int getLojLojaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LojLoja> rt = cq.from(LojLoja.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
