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
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;


public class AccionJpaController implements Serializable {

    public AccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Accion accion) {
        if (accion.getSubProcesoList() == null) {
            accion.setSubProcesoList(new ArrayList<SubProceso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SubProceso> attachedSubProcesoList = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListSubProcesoToAttach : accion.getSubProcesoList()) {
                subProcesoListSubProcesoToAttach = em.getReference(subProcesoListSubProcesoToAttach.getClass(), subProcesoListSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoList.add(subProcesoListSubProcesoToAttach);
            }
            accion.setSubProcesoList(attachedSubProcesoList);
            em.persist(accion);
            for (SubProceso subProcesoListSubProceso : accion.getSubProcesoList()) {
                Accion oldIdaccionOfSubProcesoListSubProceso = subProcesoListSubProceso.getIdaccion();
                subProcesoListSubProceso.setIdaccion(accion);
                subProcesoListSubProceso = em.merge(subProcesoListSubProceso);
                if (oldIdaccionOfSubProcesoListSubProceso != null) {
                    oldIdaccionOfSubProcesoListSubProceso.getSubProcesoList().remove(subProcesoListSubProceso);
                    oldIdaccionOfSubProcesoListSubProceso = em.merge(oldIdaccionOfSubProcesoListSubProceso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Accion accion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accion persistentAccion = em.find(Accion.class, accion.getIdaccion());
            List<SubProceso> subProcesoListOld = persistentAccion.getSubProcesoList();
            List<SubProceso> subProcesoListNew = accion.getSubProcesoList();
            List<String> illegalOrphanMessages = null;
            for (SubProceso subProcesoListOldSubProceso : subProcesoListOld) {
                if (!subProcesoListNew.contains(subProcesoListOldSubProceso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SubProceso " + subProcesoListOldSubProceso + " since its idaccion field is not nullable.");
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
            accion.setSubProcesoList(subProcesoListNew);
            accion = em.merge(accion);
            for (SubProceso subProcesoListNewSubProceso : subProcesoListNew) {
                if (!subProcesoListOld.contains(subProcesoListNewSubProceso)) {
                    Accion oldIdaccionOfSubProcesoListNewSubProceso = subProcesoListNewSubProceso.getIdaccion();
                    subProcesoListNewSubProceso.setIdaccion(accion);
                    subProcesoListNewSubProceso = em.merge(subProcesoListNewSubProceso);
                    if (oldIdaccionOfSubProcesoListNewSubProceso != null && !oldIdaccionOfSubProcesoListNewSubProceso.equals(accion)) {
                        oldIdaccionOfSubProcesoListNewSubProceso.getSubProcesoList().remove(subProcesoListNewSubProceso);
                        oldIdaccionOfSubProcesoListNewSubProceso = em.merge(oldIdaccionOfSubProcesoListNewSubProceso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = accion.getIdaccion();
                if (findAccion(id) == null) {
                    throw new NonexistentEntityException("The accion with id " + id + " no longer exists.");
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
            Accion accion;
            try {
                accion = em.getReference(Accion.class, id);
                accion.getIdaccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The accion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SubProceso> subProcesoListOrphanCheck = accion.getSubProcesoList();
            for (SubProceso subProcesoListOrphanCheckSubProceso : subProcesoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                //Se debe colocar un mensaje de error de que la acción está siendo utilizada por un subproceso
                illegalOrphanMessages.add("This Accion (" + accion + ") cannot be destroyed since the SubProceso " + subProcesoListOrphanCheckSubProceso + " in its subProcesoList field has a non-nullable idaccion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(accion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Accion> findAccionEntities() {
        return findAccionEntities(true, -1, -1);
    }

    public List<Accion> findAccionEntities(int maxResults, int firstResult) {
        return findAccionEntities(false, maxResults, firstResult);
    }

    private List<Accion> findAccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Accion.class));
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

    public Accion findAccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Accion.class, id);
        } finally {
            em.close();
        }
    }
    

    public int getAccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Accion> rt = cq.from(Accion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
