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
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class GrupoDatoJpaController implements Serializable {

    public GrupoDatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(GrupoDato grupoDato) {
        if (grupoDato.getSubProcesoList() == null) {
            grupoDato.setSubProcesoList(new ArrayList<SubProceso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<SubProceso> attachedSubProcesoList = new ArrayList<SubProceso>();
            for (SubProceso subProcesoListSubProcesoToAttach : grupoDato.getSubProcesoList()) {
                subProcesoListSubProcesoToAttach = em.getReference(subProcesoListSubProcesoToAttach.getClass(), subProcesoListSubProcesoToAttach.getIdsubProceso());
                attachedSubProcesoList.add(subProcesoListSubProcesoToAttach);
            }
            grupoDato.setSubProcesoList(attachedSubProcesoList);
            em.persist(grupoDato);
            for (SubProceso subProcesoListSubProceso : grupoDato.getSubProcesoList()) {
                GrupoDato oldIdgrupoDatoOfSubProcesoListSubProceso = subProcesoListSubProceso.getIdgrupoDato();
                subProcesoListSubProceso.setIdgrupoDato(grupoDato);
                subProcesoListSubProceso = em.merge(subProcesoListSubProceso);
                if (oldIdgrupoDatoOfSubProcesoListSubProceso != null) {
                    oldIdgrupoDatoOfSubProcesoListSubProceso.getSubProcesoList().remove(subProcesoListSubProceso);
                    oldIdgrupoDatoOfSubProcesoListSubProceso = em.merge(oldIdgrupoDatoOfSubProcesoListSubProceso);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(GrupoDato grupoDato) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            GrupoDato persistentGrupoDato = em.find(GrupoDato.class, grupoDato.getIdgrupoDato());
            List<SubProceso> subProcesoListOld = persistentGrupoDato.getSubProcesoList();
            List<SubProceso> subProcesoListNew = grupoDato.getSubProcesoList();
            List<String> illegalOrphanMessages = null;
            for (SubProceso subProcesoListOldSubProceso : subProcesoListOld) {
                if (!subProcesoListNew.contains(subProcesoListOldSubProceso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SubProceso " + subProcesoListOldSubProceso + " since its idgrupoDato field is not nullable.");
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
            grupoDato.setSubProcesoList(subProcesoListNew);
            grupoDato = em.merge(grupoDato);
            for (SubProceso subProcesoListNewSubProceso : subProcesoListNew) {
                if (!subProcesoListOld.contains(subProcesoListNewSubProceso)) {
                    GrupoDato oldIdgrupoDatoOfSubProcesoListNewSubProceso = subProcesoListNewSubProceso.getIdgrupoDato();
                    subProcesoListNewSubProceso.setIdgrupoDato(grupoDato);
                    subProcesoListNewSubProceso = em.merge(subProcesoListNewSubProceso);
                    if (oldIdgrupoDatoOfSubProcesoListNewSubProceso != null && !oldIdgrupoDatoOfSubProcesoListNewSubProceso.equals(grupoDato)) {
                        oldIdgrupoDatoOfSubProcesoListNewSubProceso.getSubProcesoList().remove(subProcesoListNewSubProceso);
                        oldIdgrupoDatoOfSubProcesoListNewSubProceso = em.merge(oldIdgrupoDatoOfSubProcesoListNewSubProceso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = grupoDato.getIdgrupoDato();
                if (findGrupoDato(id) == null) {
                    throw new NonexistentEntityException("The grupoDato with id " + id + " no longer exists.");
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
            GrupoDato grupoDato;
            try {
                grupoDato = em.getReference(GrupoDato.class, id);
                grupoDato.getIdgrupoDato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupoDato with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SubProceso> subProcesoListOrphanCheck = grupoDato.getSubProcesoList();
            for (SubProceso subProcesoListOrphanCheckSubProceso : subProcesoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This GrupoDato (" + grupoDato + ") cannot be destroyed since the SubProceso " + subProcesoListOrphanCheckSubProceso + " in its subProcesoList field has a non-nullable idgrupoDato field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(grupoDato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<GrupoDato> findGrupoDatoEntities() {
        return findGrupoDatoEntities(true, -1, -1);
    }

    public List<GrupoDato> findGrupoDatoEntities(int maxResults, int firstResult) {
        return findGrupoDatoEntities(false, maxResults, firstResult);
    }

    private List<GrupoDato> findGrupoDatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(GrupoDato.class));
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

    public GrupoDato findGrupoDato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(GrupoDato.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrupoDatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<GrupoDato> rt = cq.from(GrupoDato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
