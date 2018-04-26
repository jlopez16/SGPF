/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unam.mx.SGPF.model.SubProceso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class UsuarioFuncionalJpaController implements Serializable {

    public UsuarioFuncionalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioFuncional usuarioFuncional) {
        if (usuarioFuncional.getSubProcesoList() == null) {
            usuarioFuncional.setSubProcesoList(new ArrayList<SubProceso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SubProceso> attachedSubProcesoList = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListSubProcesoToAttach : usuarioFuncional.getSubProcesoList()) {
                subProcesoListSubProcesoToAttach = em.getReference(subProcesoListSubProcesoToAttach.getClass(), subProcesoListSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoList.add(subProcesoListSubProcesoToAttach);
            }
            usuarioFuncional.setSubProcesoList(attachedSubProcesoList);
            em.persist(usuarioFuncional);
            for (SubProceso subProcesoListSubProceso : usuarioFuncional.getSubProcesoList()) {
                UsuarioFuncional oldIdusuarioFuncionalOfSubProcesoListSubProceso = subProcesoListSubProceso.getIdusuarioFuncional();
                subProcesoListSubProceso.setIdusuarioFuncional(usuarioFuncional);
                subProcesoListSubProceso = em.merge(subProcesoListSubProceso);
                if (oldIdusuarioFuncionalOfSubProcesoListSubProceso != null) {
                    oldIdusuarioFuncionalOfSubProcesoListSubProceso.getSubProcesoList().remove(subProcesoListSubProceso);
                    oldIdusuarioFuncionalOfSubProcesoListSubProceso = em.merge(oldIdusuarioFuncionalOfSubProcesoListSubProceso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioFuncional usuarioFuncional) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioFuncional persistentUsuarioFuncional = em.find(UsuarioFuncional.class, usuarioFuncional.getIdusuarioFuncional());
            List<SubProceso> subProcesoListOld = persistentUsuarioFuncional.getSubProcesoList();
            List<SubProceso> subProcesoListNew = usuarioFuncional.getSubProcesoList();
            List<String> illegalOrphanMessages = null;
            for (SubProceso subProcesoListOldSubProceso : subProcesoListOld) {
                if (!subProcesoListNew.contains(subProcesoListOldSubProceso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SubProceso " + subProcesoListOldSubProceso + " since its idusuarioFuncional field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<SubProceso> attachedSubProcesoListNew = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListNewSubProcesoToAttach : subProcesoListNew) {
                subProcesoListNewSubProcesoToAttach = em.getReference(subProcesoListNewSubProcesoToAttach.getClass(), subProcesoListNewSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoListNew.add(subProcesoListNewSubProcesoToAttach);
            }
            subProcesoListNew = attachedSubProcesoListNew;
            usuarioFuncional.setSubProcesoList(subProcesoListNew);
            usuarioFuncional = em.merge(usuarioFuncional);
            for (SubProceso subProcesoListNewSubProceso : subProcesoListNew) {
                if (!subProcesoListOld.contains(subProcesoListNewSubProceso)) {
                    UsuarioFuncional oldIdusuarioFuncionalOfSubProcesoListNewSubProceso = subProcesoListNewSubProceso.getIdusuarioFuncional();
                    subProcesoListNewSubProceso.setIdusuarioFuncional(usuarioFuncional);
                    subProcesoListNewSubProceso = em.merge(subProcesoListNewSubProceso);
                    if (oldIdusuarioFuncionalOfSubProcesoListNewSubProceso != null && !oldIdusuarioFuncionalOfSubProcesoListNewSubProceso.equals(usuarioFuncional)) {
                        oldIdusuarioFuncionalOfSubProcesoListNewSubProceso.getSubProcesoList().remove(subProcesoListNewSubProceso);
                        oldIdusuarioFuncionalOfSubProcesoListNewSubProceso = em.merge(oldIdusuarioFuncionalOfSubProcesoListNewSubProceso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioFuncional.getIdusuarioFuncional();
                if (findUsuarioFuncional(id) == null) {
                    throw new NonexistentEntityException("The usuarioFuncional with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioFuncional usuarioFuncional;
            try {
                usuarioFuncional = em.getReference(UsuarioFuncional.class, id);
                usuarioFuncional.getIdusuarioFuncional();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioFuncional with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SubProceso> subProcesoListOrphanCheck = usuarioFuncional.getSubProcesoList();
            for (SubProceso subProcesoListOrphanCheckSubProceso : subProcesoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UsuarioFuncional (" + usuarioFuncional + ") cannot be destroyed since the SubProceso " + subProcesoListOrphanCheckSubProceso + " in its subProcesoList field has a non-nullable idusuarioFuncional field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuarioFuncional);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioFuncional> findUsuarioFuncionalEntities() {
        return findUsuarioFuncionalEntities(true, -1, -1);
    }

    public List<UsuarioFuncional> findUsuarioFuncionalEntities(int maxResults, int firstResult) {
        return findUsuarioFuncionalEntities(false, maxResults, firstResult);
    }

    private List<UsuarioFuncional> findUsuarioFuncionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioFuncional.class));
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

    public UsuarioFuncional findUsuarioFuncional(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioFuncional.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioFuncionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioFuncional> rt = cq.from(UsuarioFuncional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
