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
import myconfessionario.model.Confissao;

/**
 *
 * @author ahcar
 */
public class ConfissaoJpaController implements Serializable {

    public ConfissaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Confissao confissao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(confissao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Confissao confissao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            confissao = em.merge(confissao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = confissao.getId();
                if (findConfissao(id) == null) {
                    throw new NonexistentEntityException("The confissao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Confissao confissao;
            try {
                confissao = em.getReference(Confissao.class, id);
                confissao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The confissao with id " + id + " no longer exists.", enfe);
            }
            em.remove(confissao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Confissao> findConfissaoEntities() {
        return findConfissaoEntities(true, -1, -1);
    }

    public List<Confissao> findConfissaoEntities(int maxResults, int firstResult) {
        return findConfissaoEntities(false, maxResults, firstResult);
    }

    private List<Confissao> findConfissaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Confissao.class));
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

    public Confissao findConfissao(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Confissao.class, id);
        } finally {
            em.close();
        }
    }

    public int getConfissaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Confissao> rt = cq.from(Confissao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
