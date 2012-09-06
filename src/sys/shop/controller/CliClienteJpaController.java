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
import sys.shop.entity.CliCliente;

/**
 *
 * @author paulo
 */
public class CliClienteJpaController implements Serializable {

    public CliClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CliCliente cliCliente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cliCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliCliente(cliCliente.getCliId()) != null) {
                throw new PreexistingEntityException("CliCliente " + cliCliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CliCliente cliCliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cliCliente = em.merge(cliCliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliCliente.getCliId();
                if (findCliCliente(id) == null) {
                    throw new NonexistentEntityException("The cliCliente with id " + id + " no longer exists.");
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
            CliCliente cliCliente;
            try {
                cliCliente = em.getReference(CliCliente.class, id);
                cliCliente.getCliId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliCliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(cliCliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CliCliente> findCliClienteEntities() {
        return findCliClienteEntities(true, -1, -1);
    }

    public List<CliCliente> findCliClienteEntities(int maxResults, int firstResult) {
        return findCliClienteEntities(false, maxResults, firstResult);
    }

    private List<CliCliente> findCliClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CliCliente.class));
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

    public CliCliente findCliCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CliCliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getCliClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CliCliente> rt = cq.from(CliCliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
