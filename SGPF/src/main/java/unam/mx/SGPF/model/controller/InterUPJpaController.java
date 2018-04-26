/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class InterUPJpaController implements Serializable {

    public InterUPJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InterUP interUP) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto idproyecto = interUP.getIdproyecto();
            if (idproyecto != null) {
                idproyecto = em.getReference(idproyecto.getClass(), idproyecto.getIdproyecto());
                interUP.setIdproyecto(idproyecto);
            }
            Usuario idusuario = interUP.getIdusuario();
            if (idusuario != null) {
                idusuario = em.getReference(idusuario.getClass(), idusuario.getIdusuario());
                interUP.setIdusuario(idusuario);
            }
            em.persist(interUP);
            if (idproyecto != null) {
                idproyecto.getInterUPList().add(interUP);
                idproyecto = em.merge(idproyecto);
            }
            if (idusuario != null) {
                idusuario.getInterUPList().add(interUP);
                idusuario = em.merge(idusuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InterUP interUP) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InterUP persistentInterUP = em.find(InterUP.class, interUP.getIdinterUP());
            Proyecto idproyectoOld = persistentInterUP.getIdproyecto();
            Proyecto idproyectoNew = interUP.getIdproyecto();
            Usuario idusuarioOld = persistentInterUP.getIdusuario();
            Usuario idusuarioNew = interUP.getIdusuario();
            if (idproyectoNew != null) {
                idproyectoNew = em.getReference(idproyectoNew.getClass(), idproyectoNew.getIdproyecto());
                interUP.setIdproyecto(idproyectoNew);
            }
            if (idusuarioNew != null) {
                idusuarioNew = em.getReference(idusuarioNew.getClass(), idusuarioNew.getIdusuario());
                interUP.setIdusuario(idusuarioNew);
            }
            interUP = em.merge(interUP);
            if (idproyectoOld != null && !idproyectoOld.equals(idproyectoNew)) {
                idproyectoOld.getInterUPList().remove(interUP);
                idproyectoOld = em.merge(idproyectoOld);
            }
            if (idproyectoNew != null && !idproyectoNew.equals(idproyectoOld)) {
                idproyectoNew.getInterUPList().add(interUP);
                idproyectoNew = em.merge(idproyectoNew);
            }
            if (idusuarioOld != null && !idusuarioOld.equals(idusuarioNew)) {
                idusuarioOld.getInterUPList().remove(interUP);
                idusuarioOld = em.merge(idusuarioOld);
            }
            if (idusuarioNew != null && !idusuarioNew.equals(idusuarioOld)) {
                idusuarioNew.getInterUPList().add(interUP);
                idusuarioNew = em.merge(idusuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = interUP.getIdinterUP();
                if (findInterUP(id) == null) {
                    throw new NonexistentEntityException("The interUP with id " + id + " no longer exists.");
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
            InterUP interUP;
            try {
                interUP = em.getReference(InterUP.class, id);
                interUP.getIdinterUP();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The interUP with id " + id + " no longer exists.", enfe);
            }
            Proyecto idproyecto = interUP.getIdproyecto();
            if (idproyecto != null) {
                idproyecto.getInterUPList().remove(interUP);
                idproyecto = em.merge(idproyecto);
            }
            Usuario idusuario = interUP.getIdusuario();
            if (idusuario != null) {
                idusuario.getInterUPList().remove(interUP);
                idusuario = em.merge(idusuario);
            }
            em.remove(interUP);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InterUP> findInterUPEntities() {
        return findInterUPEntities(true, -1, -1);
    }

    public List<InterUP> findInterUPEntities(int maxResults, int firstResult) {
        return findInterUPEntities(false, maxResults, firstResult);
    }

    private List<InterUP> findInterUPEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InterUP.class));
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

    public InterUP findInterUP(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InterUP.class, id);
        } finally {
            em.close();
        }
    }

    public int getInterUPCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InterUP> rt = cq.from(InterUP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
