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
import sys.shop.entity.MerMercadoria;

/**
 *
 * @author paulo
 */
public class MerMercadoriaJpaController implements Serializable {

    public MerMercadoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MerMercadoria merMercadoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(merMercadoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMerMercadoria(merMercadoria.getMerId()) != null) {
                throw new PreexistingEntityException("MerMercadoria " + merMercadoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MerMercadoria merMercadoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            merMercadoria = em.merge(merMercadoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = merMercadoria.getMerId();
                if (findMerMercadoria(id) == null) {
                    throw new NonexistentEntityException("The merMercadoria with id " + id + " no longer exists.");
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
            MerMercadoria merMercadoria;
            try {
                merMercadoria = em.getReference(MerMercadoria.class, id);
                merMercadoria.getMerId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The merMercadoria with id " + id + " no longer exists.", enfe);
            }
            em.remove(merMercadoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MerMercadoria> findMerMercadoriaEntities() {
        return findMerMercadoriaEntities(true, -1, -1);
    }

    public List<MerMercadoria> findMerMercadoriaEntities(int maxResults, int firstResult) {
        return findMerMercadoriaEntities(false, maxResults, firstResult);
    }

    private List<MerMercadoria> findMerMercadoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MerMercadoria.class));
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

    public MerMercadoria findMerMercadoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MerMercadoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getMerMercadoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MerMercadoria> rt = cq.from(MerMercadoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
