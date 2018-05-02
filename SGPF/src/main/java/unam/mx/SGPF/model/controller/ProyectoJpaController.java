/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;
import unam.mx.SGPF.model.controller.exceptions.PreexistingEntityException;


public class ProyectoJpaController implements Serializable {

    public ProyectoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proyecto proyecto) throws PreexistingEntityException, Exception {
        if (proyecto.getInterUPList() == null) {
            proyecto.setInterUPList(new ArrayList<InterUP>());
        }
        if (proyecto.getProcesoFuncionalList() == null) {
            proyecto.setProcesoFuncionalList(new ArrayList<ProcesoFuncional>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<InterUP> attachedInterUPList = new ArrayList<InterUP>();
            for (InterUP interUPListInterUPToAttach : proyecto.getInterUPList()) {
                interUPListInterUPToAttach = em.getReference(interUPListInterUPToAttach.getClass(), interUPListInterUPToAttach.getIdinterUP());
                attachedInterUPList.add(interUPListInterUPToAttach);
            }
            proyecto.setInterUPList(attachedInterUPList);
            List<ProcesoFuncional> attachedProcesoFuncionalList = new ArrayList<ProcesoFuncional>();
            for (ProcesoFuncional procesoFuncionalListProcesoFuncionalToAttach : proyecto.getProcesoFuncionalList()) {
                procesoFuncionalListProcesoFuncionalToAttach = em.getReference(procesoFuncionalListProcesoFuncionalToAttach.getClass(), procesoFuncionalListProcesoFuncionalToAttach.getIdprocesoFuncional());
                attachedProcesoFuncionalList.add(procesoFuncionalListProcesoFuncionalToAttach);
            }
            proyecto.setProcesoFuncionalList(attachedProcesoFuncionalList);
            em.persist(proyecto);
            for (InterUP interUPListInterUP : proyecto.getInterUPList()) {
                Proyecto oldIdproyectoOfInterUPListInterUP = interUPListInterUP.getIdproyecto();
                interUPListInterUP.setIdproyecto(proyecto);
                interUPListInterUP = em.merge(interUPListInterUP);
                if (oldIdproyectoOfInterUPListInterUP != null) {
                    oldIdproyectoOfInterUPListInterUP.getInterUPList().remove(interUPListInterUP);
                    oldIdproyectoOfInterUPListInterUP = em.merge(oldIdproyectoOfInterUPListInterUP);
                }
            }
            for (ProcesoFuncional procesoFuncionalListProcesoFuncional : proyecto.getProcesoFuncionalList()) {
                Proyecto oldIdproyectoOfProcesoFuncionalListProcesoFuncional = procesoFuncionalListProcesoFuncional.getIdproyecto();
                procesoFuncionalListProcesoFuncional.setIdproyecto(proyecto);
                procesoFuncionalListProcesoFuncional = em.merge(procesoFuncionalListProcesoFuncional);
                if (oldIdproyectoOfProcesoFuncionalListProcesoFuncional != null) {
                    oldIdproyectoOfProcesoFuncionalListProcesoFuncional.getProcesoFuncionalList().remove(procesoFuncionalListProcesoFuncional);
                    oldIdproyectoOfProcesoFuncionalListProcesoFuncional = em.merge(oldIdproyectoOfProcesoFuncionalListProcesoFuncional);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProyecto(proyecto.getIdproyecto()) != null) {
                throw new PreexistingEntityException("Proyecto " + proyecto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proyecto proyecto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proyecto persistentProyecto = em.find(Proyecto.class, proyecto.getIdproyecto());
            List<InterUP> interUPListOld = persistentProyecto.getInterUPList();
            List<InterUP> interUPListNew = proyecto.getInterUPList();
            List<ProcesoFuncional> procesoFuncionalListOld = persistentProyecto.getProcesoFuncionalList();
            List<ProcesoFuncional> procesoFuncionalListNew = proyecto.getProcesoFuncionalList();
            List<String> illegalOrphanMessages = null;
            for (InterUP interUPListOldInterUP : interUPListOld) {
                if (!interUPListNew.contains(interUPListOldInterUP)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain InterUP " + interUPListOldInterUP + " since its idproyecto field is not nullable.");
                }
            }
            for (ProcesoFuncional procesoFuncionalListOldProcesoFuncional : procesoFuncionalListOld) {
                if (!procesoFuncionalListNew.contains(procesoFuncionalListOldProcesoFuncional)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ProcesoFuncional " + procesoFuncionalListOldProcesoFuncional + " since its idproyecto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<InterUP> attachedInterUPListNew = new ArrayList<InterUP>();
            for (InterUP interUPListNewInterUPToAttach : interUPListNew) {
                interUPListNewInterUPToAttach = em.getReference(interUPListNewInterUPToAttach.getClass(), interUPListNewInterUPToAttach.getIdinterUP());
                attachedInterUPListNew.add(interUPListNewInterUPToAttach);
            }
            interUPListNew = attachedInterUPListNew;
            proyecto.setInterUPList(interUPListNew);
            List<ProcesoFuncional> attachedProcesoFuncionalListNew = new ArrayList<ProcesoFuncional>();
            for (ProcesoFuncional procesoFuncionalListNewProcesoFuncionalToAttach : procesoFuncionalListNew) {
                procesoFuncionalListNewProcesoFuncionalToAttach = em.getReference(procesoFuncionalListNewProcesoFuncionalToAttach.getClass(), procesoFuncionalListNewProcesoFuncionalToAttach.getIdprocesoFuncional());
                attachedProcesoFuncionalListNew.add(procesoFuncionalListNewProcesoFuncionalToAttach);
            }
            procesoFuncionalListNew = attachedProcesoFuncionalListNew;
            proyecto.setProcesoFuncionalList(procesoFuncionalListNew);
            proyecto = em.merge(proyecto);
            for (InterUP interUPListNewInterUP : interUPListNew) {
                if (!interUPListOld.contains(interUPListNewInterUP)) {
                    Proyecto oldIdproyectoOfInterUPListNewInterUP = interUPListNewInterUP.getIdproyecto();
                    interUPListNewInterUP.setIdproyecto(proyecto);
                    interUPListNewInterUP = em.merge(interUPListNewInterUP);
                    if (oldIdproyectoOfInterUPListNewInterUP != null && !oldIdproyectoOfInterUPListNewInterUP.equals(proyecto)) {
                        oldIdproyectoOfInterUPListNewInterUP.getInterUPList().remove(interUPListNewInterUP);
                        oldIdproyectoOfInterUPListNewInterUP = em.merge(oldIdproyectoOfInterUPListNewInterUP);
                    }
                }
            }
            for (ProcesoFuncional procesoFuncionalListNewProcesoFuncional : procesoFuncionalListNew) {
                if (!procesoFuncionalListOld.contains(procesoFuncionalListNewProcesoFuncional)) {
                    Proyecto oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional = procesoFuncionalListNewProcesoFuncional.getIdproyecto();
                    procesoFuncionalListNewProcesoFuncional.setIdproyecto(proyecto);
                    procesoFuncionalListNewProcesoFuncional = em.merge(procesoFuncionalListNewProcesoFuncional);
                    if (oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional != null && !oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional.equals(proyecto)) {
                        oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional.getProcesoFuncionalList().remove(procesoFuncionalListNewProcesoFuncional);
                        oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional = em.merge(oldIdproyectoOfProcesoFuncionalListNewProcesoFuncional);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = proyecto.getIdproyecto();
                if (findProyecto(id) == null) {
                    throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.");
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
            Proyecto proyecto;
            try {
                proyecto = em.getReference(Proyecto.class, id);
                proyecto.getIdproyecto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyecto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<InterUP> interUPListOrphanCheck = proyecto.getInterUPList();
            for (InterUP interUPListOrphanCheckInterUP : interUPListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proyecto (" + proyecto + ") cannot be destroyed since the InterUP " + interUPListOrphanCheckInterUP + " in its interUPList field has a non-nullable idproyecto field.");
            }
            List<ProcesoFuncional> procesoFuncionalListOrphanCheck = proyecto.getProcesoFuncionalList();
            for (ProcesoFuncional procesoFuncionalListOrphanCheckProcesoFuncional : procesoFuncionalListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proyecto (" + proyecto + ") cannot be destroyed since the ProcesoFuncional " + procesoFuncionalListOrphanCheckProcesoFuncional + " in its procesoFuncionalList field has a non-nullable idproyecto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proyecto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proyecto> findProyectoEntities() {
        return findProyectoEntities(true, -1, -1);
    }

    public List<Proyecto> findProyectoEntities(int maxResults, int firstResult) {
        return findProyectoEntities(false, maxResults, firstResult);
    }

    private List<Proyecto> findProyectoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proyecto.class));
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

    public Proyecto findProyecto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proyecto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proyecto> rt = cq.from(Proyecto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Proyecto findLastProyecto() {
        EntityManager em = getEntityManager();
        Query q = em.createNativeQuery("select * from proyecto order by idProyecto desc limit 1", Proyecto.class);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Proyecto) q.getSingleResult();
    }

}
