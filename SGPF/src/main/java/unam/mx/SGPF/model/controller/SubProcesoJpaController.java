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
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author miguel
 */
public class SubProcesoJpaController implements Serializable {

    public SubProcesoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SubProceso subProceso) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Accion idaccion = subProceso.getIdaccion();
            if (idaccion != null) {
                idaccion = em.getReference(idaccion.getClass(), idaccion.getIdaccion());
                subProceso.setIdaccion(idaccion);
            }
            GrupoDato idgrupoDato = subProceso.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato = em.getReference(idgrupoDato.getClass(), idgrupoDato.getIdgrupoDato());
                subProceso.setIdgrupoDato(idgrupoDato);
            }
            ProcesoFuncional idprocesoFuncional = subProceso.getIdprocesoFuncional();
            if (idprocesoFuncional != null) {
                idprocesoFuncional = em.getReference(idprocesoFuncional.getClass(), idprocesoFuncional.getIdprocesoFuncional());
                subProceso.setIdprocesoFuncional(idprocesoFuncional);
            }
            UsuarioFuncional idusuarioFuncional = subProceso.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional = em.getReference(idusuarioFuncional.getClass(), idusuarioFuncional.getIdusuarioFuncional());
                subProceso.setIdusuarioFuncional(idusuarioFuncional);
            }
            em.persist(subProceso);
            if (idaccion != null) {
                idaccion.getSubProcesoList().add(subProceso);
                idaccion = em.merge(idaccion);
            }
            if (idgrupoDato != null) {
                idgrupoDato.getSubProcesoList().add(subProceso);
                idgrupoDato = em.merge(idgrupoDato);
            }
            if (idprocesoFuncional != null) {
                idprocesoFuncional.getSubProcesoList().add(subProceso);
                idprocesoFuncional = em.merge(idprocesoFuncional);
            }
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getSubProcesoList().add(subProceso);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SubProceso subProceso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SubProceso persistentSubProceso = em.find(SubProceso.class, subProceso.getIdsubProceso());
            Accion idaccionOld = persistentSubProceso.getIdaccion();
            Accion idaccionNew = subProceso.getIdaccion();
            GrupoDato idgrupoDatoOld = persistentSubProceso.getIdgrupoDato();
            GrupoDato idgrupoDatoNew = subProceso.getIdgrupoDato();
            ProcesoFuncional idprocesoFuncionalOld = persistentSubProceso.getIdprocesoFuncional();
            ProcesoFuncional idprocesoFuncionalNew = subProceso.getIdprocesoFuncional();
            UsuarioFuncional idusuarioFuncionalOld = persistentSubProceso.getIdusuarioFuncional();
            UsuarioFuncional idusuarioFuncionalNew = subProceso.getIdusuarioFuncional();
            if (idaccionNew != null) {
                idaccionNew = em.getReference(idaccionNew.getClass(), idaccionNew.getIdaccion());
                subProceso.setIdaccion(idaccionNew);
            }
            if (idgrupoDatoNew != null) {
                idgrupoDatoNew = em.getReference(idgrupoDatoNew.getClass(), idgrupoDatoNew.getIdgrupoDato());
                subProceso.setIdgrupoDato(idgrupoDatoNew);
            }
            if (idprocesoFuncionalNew != null) {
                idprocesoFuncionalNew = em.getReference(idprocesoFuncionalNew.getClass(), idprocesoFuncionalNew.getIdprocesoFuncional());
                subProceso.setIdprocesoFuncional(idprocesoFuncionalNew);
            }
            if (idusuarioFuncionalNew != null) {
                idusuarioFuncionalNew = em.getReference(idusuarioFuncionalNew.getClass(), idusuarioFuncionalNew.getIdusuarioFuncional());
                subProceso.setIdusuarioFuncional(idusuarioFuncionalNew);
            }
            subProceso = em.merge(subProceso);
            if (idaccionOld != null && !idaccionOld.equals(idaccionNew)) {
                idaccionOld.getSubProcesoList().remove(subProceso);
                idaccionOld = em.merge(idaccionOld);
            }
            if (idaccionNew != null && !idaccionNew.equals(idaccionOld)) {
                idaccionNew.getSubProcesoList().add(subProceso);
                idaccionNew = em.merge(idaccionNew);
            }
            if (idgrupoDatoOld != null && !idgrupoDatoOld.equals(idgrupoDatoNew)) {
                idgrupoDatoOld.getSubProcesoList().remove(subProceso);
                idgrupoDatoOld = em.merge(idgrupoDatoOld);
            }
            if (idgrupoDatoNew != null && !idgrupoDatoNew.equals(idgrupoDatoOld)) {
                idgrupoDatoNew.getSubProcesoList().add(subProceso);
                idgrupoDatoNew = em.merge(idgrupoDatoNew);
            }
            if (idprocesoFuncionalOld != null && !idprocesoFuncionalOld.equals(idprocesoFuncionalNew)) {
                idprocesoFuncionalOld.getSubProcesoList().remove(subProceso);
                idprocesoFuncionalOld = em.merge(idprocesoFuncionalOld);
            }
            if (idprocesoFuncionalNew != null && !idprocesoFuncionalNew.equals(idprocesoFuncionalOld)) {
                idprocesoFuncionalNew.getSubProcesoList().add(subProceso);
                idprocesoFuncionalNew = em.merge(idprocesoFuncionalNew);
            }
            if (idusuarioFuncionalOld != null && !idusuarioFuncionalOld.equals(idusuarioFuncionalNew)) {
                idusuarioFuncionalOld.getSubProcesoList().remove(subProceso);
                idusuarioFuncionalOld = em.merge(idusuarioFuncionalOld);
            }
            if (idusuarioFuncionalNew != null && !idusuarioFuncionalNew.equals(idusuarioFuncionalOld)) {
                idusuarioFuncionalNew.getSubProcesoList().add(subProceso);
                idusuarioFuncionalNew = em.merge(idusuarioFuncionalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = subProceso.getIdsubProceso();
                if (findSubProceso(id) == null) {
                    throw new NonexistentEntityException("The subProceso with id " + id + " no longer exists.");
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
            SubProceso subProceso;
            try {
                subProceso = em.getReference(SubProceso.class, id);
                subProceso.getIdsubProceso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The subProceso with id " + id + " no longer exists.", enfe);
            }
            Accion idaccion = subProceso.getIdaccion();
            if (idaccion != null) {
                idaccion.getSubProcesoList().remove(subProceso);
                idaccion = em.merge(idaccion);
            }
            GrupoDato idgrupoDato = subProceso.getIdgrupoDato();
            if (idgrupoDato != null) {
                idgrupoDato.getSubProcesoList().remove(subProceso);
                idgrupoDato = em.merge(idgrupoDato);
            }
            ProcesoFuncional idprocesoFuncional = subProceso.getIdprocesoFuncional();
            if (idprocesoFuncional != null) {
                idprocesoFuncional.getSubProcesoList().remove(subProceso);
                idprocesoFuncional = em.merge(idprocesoFuncional);
            }
            UsuarioFuncional idusuarioFuncional = subProceso.getIdusuarioFuncional();
            if (idusuarioFuncional != null) {
                idusuarioFuncional.getSubProcesoList().remove(subProceso);
                idusuarioFuncional = em.merge(idusuarioFuncional);
            }
            em.remove(subProceso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SubProceso> findSubProcesoEntities() {
        return findSubProcesoEntities(true, -1, -1);
    }

    public List<SubProceso> findSubProcesoEntities(int maxResults, int firstResult) {
        return findSubProcesoEntities(false, maxResults, firstResult);
    }

    private List<SubProceso> findSubProcesoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SubProceso.class));
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

    public SubProceso findSubProceso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SubProceso.class, id);
        } finally {
            em.close();
        }
    }

    public int getSubProcesoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SubProceso> rt = cq.from(SubProceso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
