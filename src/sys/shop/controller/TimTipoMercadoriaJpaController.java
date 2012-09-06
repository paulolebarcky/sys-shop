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
import sys.shop.entity.TimTipoMercadoria;

/**
 *
 * @author paulo
 */
public class TimTipoMercadoriaJpaController implements Serializable {

    public TimTipoMercadoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TimTipoMercadoria timTipoMercadoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(timTipoMercadoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTimTipoMercadoria(timTipoMercadoria.getTimId()) != null) {
                throw new PreexistingEntityException("TimTipoMercadoria " + timTipoMercadoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TimTipoMercadoria timTipoMercadoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            timTipoMercadoria = em.merge(timTipoMercadoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = timTipoMercadoria.getTimId();
                if (findTimTipoMercadoria(id) == null) {
                    throw new NonexistentEntityException("The timTipoMercadoria with id " + id + " no longer exists.");
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
            TimTipoMercadoria timTipoMercadoria;
            try {
                timTipoMercadoria = em.getReference(TimTipoMercadoria.class, id);
                timTipoMercadoria.getTimId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The timTipoMercadoria with id " + id + " no longer exists.", enfe);
            }
            em.remove(timTipoMercadoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TimTipoMercadoria> findTimTipoMercadoriaEntities() {
        return findTimTipoMercadoriaEntities(true, -1, -1);
    }

    public List<TimTipoMercadoria> findTimTipoMercadoriaEntities(int maxResults, int firstResult) {
        return findTimTipoMercadoriaEntities(false, maxResults, firstResult);
    }

    private List<TimTipoMercadoria> findTimTipoMercadoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TimTipoMercadoria.class));
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

    public TimTipoMercadoria findTimTipoMercadoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TimTipoMercadoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getTimTipoMercadoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TimTipoMercadoria> rt = cq.from(TimTipoMercadoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
