/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.shop.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sys.shop.controller.exceptions.NonexistentEntityException;
import sys.shop.controller.exceptions.PreexistingEntityException;
import sys.shop.entity.EstEstado;

/**
 *
 * @author paulo
 */
public class EstEstadoJpaController extends PersistenceManager implements Serializable {
    
    public void create(EstEstado estEstado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estEstado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstEstado(estEstado.getEstId()) != null) {
                throw new PreexistingEntityException("EstEstado " + estEstado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstEstado estEstado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estEstado = em.merge(estEstado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estEstado.getEstId();
                if (findEstEstado(id) == null) {
                    throw new NonexistentEntityException("The estEstado with id " + id + " no longer exists.");
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
            EstEstado estEstado;
            try {
                estEstado = em.getReference(EstEstado.class, id);
                estEstado.getEstId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estEstado with id " + id + " no longer exists.", enfe);
            }
            em.remove(estEstado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstEstado> findEstEstadoEntities() {
        return findEstEstadoEntities(true, -1, -1);
    }

    public List<EstEstado> findEstEstadoEntities(int maxResults, int firstResult) {
        return findEstEstadoEntities(false, maxResults, firstResult);
    }

    private List<EstEstado> findEstEstadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstEstado.class));
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

    public EstEstado findEstEstado(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstEstado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstEstadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstEstado> rt = cq.from(EstEstado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
