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
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.SubProceso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

public class ProcesoFuncionalJpaController implements Serializable {

    public ProcesoFuncionalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProcesoFuncional procesoFuncional) {
        if (procesoFuncional.getSubProcesoList() == null) {
            procesoFuncional.setSubProcesoList(new ArrayList<SubProceso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto idproyecto = procesoFuncional.getIdproyecto();
            if (idproyecto != null) {
                idproyecto = em.getReference(idproyecto.getClass(), idproyecto.getIdproyecto());
                procesoFuncional.setIdproyecto(idproyecto);
            }
            List<SubProceso> attachedSubProcesoList = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListSubProcesoToAttach : procesoFuncional.getSubProcesoList()) {
                subProcesoListSubProcesoToAttach = em.getReference(subProcesoListSubProcesoToAttach.getClass(), subProcesoListSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoList.add(subProcesoListSubProcesoToAttach);
            }
            procesoFuncional.setSubProcesoList(attachedSubProcesoList);
            em.persist(procesoFuncional);
            if (idproyecto != null) {
                idproyecto.getProcesoFuncionalList().add(procesoFuncional);
                idproyecto = em.merge(idproyecto);
            }
            for (SubProceso subProcesoListSubProceso : procesoFuncional.getSubProcesoList()) {
                ProcesoFuncional oldIdprocesoFuncionalOfSubProcesoListSubProceso = subProcesoListSubProceso.getIdprocesoFuncional();
                subProcesoListSubProceso.setIdprocesoFuncional(procesoFuncional);
                subProcesoListSubProceso = em.merge(subProcesoListSubProceso);
                if (oldIdprocesoFuncionalOfSubProcesoListSubProceso != null) {
                    oldIdprocesoFuncionalOfSubProcesoListSubProceso.getSubProcesoList().remove(subProcesoListSubProceso);
                    oldIdprocesoFuncionalOfSubProcesoListSubProceso = em.merge(oldIdprocesoFuncionalOfSubProcesoListSubProceso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProcesoFuncional procesoFuncional) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProcesoFuncional persistentProcesoFuncional = em.find(ProcesoFuncional.class, procesoFuncional.getIdprocesoFuncional());
            Proyecto idproyectoOld = persistentProcesoFuncional.getIdproyecto();
            Proyecto idproyectoNew = procesoFuncional.getIdproyecto();
            List<SubProceso> subProcesoListOld = persistentProcesoFuncional.getSubProcesoList();
            List<SubProceso> subProcesoListNew = procesoFuncional.getSubProcesoList();
            List<String> illegalOrphanMessages = null;
            for (SubProceso subProcesoListOldSubProceso : subProcesoListOld) {
                if (!subProcesoListNew.contains(subProcesoListOldSubProceso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SubProceso " + subProcesoListOldSubProceso + " since its idprocesoFuncional field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idproyectoNew != null) {
                idproyectoNew = em.getReference(idproyectoNew.getClass(), idproyectoNew.getIdproyecto());
                procesoFuncional.setIdproyecto(idproyectoNew);
            }
            List<SubProceso> attachedSubProcesoListNew = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListNewSubProcesoToAttach : subProcesoListNew) {
                subProcesoListNewSubProcesoToAttach = em.getReference(subProcesoListNewSubProcesoToAttach.getClass(), subProcesoListNewSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoListNew.add(subProcesoListNewSubProcesoToAttach);
            }
            subProcesoListNew = attachedSubProcesoListNew;
            procesoFuncional.setSubProcesoList(subProcesoListNew);
            procesoFuncional = em.merge(procesoFuncional);
            if (idproyectoOld != null && !idproyectoOld.equals(idproyectoNew)) {
                idproyectoOld.getProcesoFuncionalList().remove(procesoFuncional);
                idproyectoOld = em.merge(idproyectoOld);
            }
            if (idproyectoNew != null && !idproyectoNew.equals(idproyectoOld)) {
                idproyectoNew.getProcesoFuncionalList().add(procesoFuncional);
                idproyectoNew = em.merge(idproyectoNew);
            }
            for (SubProceso subProcesoListNewSubProceso : subProcesoListNew) {
                if (!subProcesoListOld.contains(subProcesoListNewSubProceso)) {
                    ProcesoFuncional oldIdprocesoFuncionalOfSubProcesoListNewSubProceso = subProcesoListNewSubProceso.getIdprocesoFuncional();
                    subProcesoListNewSubProceso.setIdprocesoFuncional(procesoFuncional);
                    subProcesoListNewSubProceso = em.merge(subProcesoListNewSubProceso);
                    if (oldIdprocesoFuncionalOfSubProcesoListNewSubProceso != null && !oldIdprocesoFuncionalOfSubProcesoListNewSubProceso.equals(procesoFuncional)) {
                        oldIdprocesoFuncionalOfSubProcesoListNewSubProceso.getSubProcesoList().remove(subProcesoListNewSubProceso);
                        oldIdprocesoFuncionalOfSubProcesoListNewSubProceso = em.merge(oldIdprocesoFuncionalOfSubProcesoListNewSubProceso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = procesoFuncional.getIdprocesoFuncional();
                if (findProcesoFuncional(id) == null) {
                    throw new NonexistentEntityException("The procesoFuncional with id " + id + " no longer exists.");
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
            ProcesoFuncional procesoFuncional;
            try {
                procesoFuncional = em.getReference(ProcesoFuncional.class, id);
                procesoFuncional.getIdprocesoFuncional();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The procesoFuncional with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SubProceso> subProcesoListOrphanCheck = procesoFuncional.getSubProcesoList();
            for (SubProceso subProcesoListOrphanCheckSubProceso : subProcesoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ProcesoFuncional (" + procesoFuncional + ") cannot be destroyed since the SubProceso " + subProcesoListOrphanCheckSubProceso + " in its subProcesoList field has a non-nullable idprocesoFuncional field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proyecto idproyecto = procesoFuncional.getIdproyecto();
            if (idproyecto != null) {
                idproyecto.getProcesoFuncionalList().remove(procesoFuncional);
                idproyecto = em.merge(idproyecto);
            }
            em.remove(procesoFuncional);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProcesoFuncional> findProcesoFuncionalEntities() {
        return findProcesoFuncionalEntities(true, -1, -1);
    }

    public List<ProcesoFuncional> findProcesoFuncionalEntities(int maxResults, int firstResult) {
        return findProcesoFuncionalEntities(false, maxResults, firstResult);
    }

    private List<ProcesoFuncional> findProcesoFuncionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProcesoFuncional.class));
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

    public ProcesoFuncional findProcesoFuncional(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProcesoFuncional.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<ProcesoFuncional> findPFByIdProyectoActivo(Integer id) {
        EntityManager em = getEntityManager();
        Proyecto p = new Proyecto(id);
        Short b=1;
        Query q = em.createNamedQuery("ProcesoFuncional.findByIdProyectoActivo")
    			     .setParameter("idproyecto", p).setParameter("activo", b);
        return q.getResultList();
    }
    
    public void eliminaPF(ProcesoFuncional PF) {
        EntityManager em = getEntityManager();
        Short b=0;
        Query q = em.createNamedQuery("ProcesoFuncional.eliminaPF")
    			    .setParameter("idPF", PF.getIdprocesoFuncional())
                            .setParameter("activo", b);
    }
    public List<ProcesoFuncional> findPFByIdProyecto(Integer idProyecto){
    	EntityManager em = getEntityManager();
    	Proyecto p = new Proyecto(idProyecto);
    	Query q = em.createNamedQuery("ProcesoFuncional.findByIdproyecto")
    			     .setParameter("idproyecto", p);
    	return q.getResultList();
    }

    public int getProcesoFuncionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProcesoFuncional> rt = cq.from(ProcesoFuncional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
