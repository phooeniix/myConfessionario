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
import myconfessionario.model.TiposPecado;

/**
 *
 * @author ahcar
 */
public class TiposPecadoJpaController implements Serializable {

    public TiposPecadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposPecado tiposPecado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tiposPecado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposPecado tiposPecado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tiposPecado = em.merge(tiposPecado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tiposPecado.getId();
                if (findTiposPecado(id) == null) {
                    throw new NonexistentEntityException("The tiposPecado with id " + id + " no longer exists.");
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
            TiposPecado tiposPecado;
            try {
                tiposPecado = em.getReference(TiposPecado.class, id);
                tiposPecado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposPecado with id " + id + " no longer exists.", enfe);
            }
            em.remove(tiposPecado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposPecado> findTiposPecadoEntities() {
        return findTiposPecadoEntities(true, -1, -1);
    }

    public List<TiposPecado> findTiposPecadoEntities(int maxResults, int firstResult) {
        return findTiposPecadoEntities(false, maxResults, firstResult);
    }

    private List<TiposPecado> findTiposPecadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposPecado.class));
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

    public TiposPecado findTiposPecado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposPecado.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposPecadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposPecado> rt = cq.from(TiposPecado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
