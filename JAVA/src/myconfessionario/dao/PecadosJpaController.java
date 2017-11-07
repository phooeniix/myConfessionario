/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconfessionario.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import myconfessionario.dao.exceptions.NonexistentEntityException;
import myconfessionario.model.Pecados;

/**
 *
 * @author ahcar
 */
public class PecadosJpaController implements Serializable {

    public PecadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pecados pecados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pecados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pecados pecados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pecados = em.merge(pecados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pecados.getId();
                if (findPecados(id) == null) {
                    throw new NonexistentEntityException("The pecados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pecados pecados;
            try {
                pecados = em.getReference(Pecados.class, id);
                pecados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pecados with id " + id + " no longer exists.", enfe);
            }
            em.remove(pecados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pecados> findPecadosEntities() {
        return findPecadosEntities(true, -1, -1);
    }

    public List<Pecados> findPecadosEntities(int maxResults, int firstResult) {
        return findPecadosEntities(false, maxResults, firstResult);
    }

    private List<Pecados> findPecadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pecados.class));
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

    public Pecados findPecados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pecados.class, id);
        } finally {
            em.close();
        }
    }

    public int getPecadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pecados> rt = cq.from(Pecados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
