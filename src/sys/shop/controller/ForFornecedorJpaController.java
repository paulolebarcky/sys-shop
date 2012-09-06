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
import sys.shop.entity.ForFornecedor;

/**
 *
 * @author paulo
 */
public class ForFornecedorJpaController implements Serializable {

    public ForFornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ForFornecedor forFornecedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(forFornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findForFornecedor(forFornecedor.getForId()) != null) {
                throw new PreexistingEntityException("ForFornecedor " + forFornecedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ForFornecedor forFornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            forFornecedor = em.merge(forFornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = forFornecedor.getForId();
                if (findForFornecedor(id) == null) {
                    throw new NonexistentEntityException("The forFornecedor with id " + id + " no longer exists.");
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
            ForFornecedor forFornecedor;
            try {
                forFornecedor = em.getReference(ForFornecedor.class, id);
                forFornecedor.getForId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The forFornecedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(forFornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ForFornecedor> findForFornecedorEntities() {
        return findForFornecedorEntities(true, -1, -1);
    }

    public List<ForFornecedor> findForFornecedorEntities(int maxResults, int firstResult) {
        return findForFornecedorEntities(false, maxResults, firstResult);
    }

    private List<ForFornecedor> findForFornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ForFornecedor.class));
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

    public ForFornecedor findForFornecedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ForFornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getForFornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ForFornecedor> rt = cq.from(ForFornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
