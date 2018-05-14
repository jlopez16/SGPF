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
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.exceptions.IllegalOrphanException;
import unam.mx.SGPF.model.controller.exceptions.NonexistentEntityException;

public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getInterUPList() == null) {
            usuario.setInterUPList(new ArrayList<InterUP>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<InterUP> attachedInterUPList = new ArrayList<InterUP>();
            for (InterUP interUPListInterUPToAttach : usuario.getInterUPList()) {
                interUPListInterUPToAttach = em.getReference(interUPListInterUPToAttach.getClass(), interUPListInterUPToAttach.getIdinterUP());
                attachedInterUPList.add(interUPListInterUPToAttach);
            }
            usuario.setInterUPList(attachedInterUPList);
            em.persist(usuario);
            for (InterUP interUPListInterUP : usuario.getInterUPList()) {
                Usuario oldIdusuarioOfInterUPListInterUP = interUPListInterUP.getIdusuario();
                interUPListInterUP.setIdusuario(usuario);
                interUPListInterUP = em.merge(interUPListInterUP);
                if (oldIdusuarioOfInterUPListInterUP != null) {
                    oldIdusuarioOfInterUPListInterUP.getInterUPList().remove(interUPListInterUP);
                    oldIdusuarioOfInterUPListInterUP = em.merge(oldIdusuarioOfInterUPListInterUP);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdusuario());
            List<InterUP> interUPListOld = persistentUsuario.getInterUPList();
            List<InterUP> interUPListNew = usuario.getInterUPList();
            List<String> illegalOrphanMessages = null;
            for (InterUP interUPListOldInterUP : interUPListOld) {
                if (!interUPListNew.contains(interUPListOldInterUP)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain InterUP " + interUPListOldInterUP + " since its idusuario field is not nullable.");
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
            usuario.setInterUPList(interUPListNew);
            usuario = em.merge(usuario);
            for (InterUP interUPListNewInterUP : interUPListNew) {
                if (!interUPListOld.contains(interUPListNewInterUP)) {
                    Usuario oldIdusuarioOfInterUPListNewInterUP = interUPListNewInterUP.getIdusuario();
                    interUPListNewInterUP.setIdusuario(usuario);
                    interUPListNewInterUP = em.merge(interUPListNewInterUP);
                    if (oldIdusuarioOfInterUPListNewInterUP != null && !oldIdusuarioOfInterUPListNewInterUP.equals(usuario)) {
                        oldIdusuarioOfInterUPListNewInterUP.getInterUPList().remove(interUPListNewInterUP);
                        oldIdusuarioOfInterUPListNewInterUP = em.merge(oldIdusuarioOfInterUPListNewInterUP);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuario.getIdusuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdusuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<InterUP> interUPListOrphanCheck = usuario.getInterUPList();
            for (InterUP interUPListOrphanCheckInterUP : interUPListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the InterUP " + interUPListOrphanCheckInterUP + " in its interUPList field has a non-nullable idusuario field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Usuario getUsuarioByUserAndPass(String usuario, String password) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Usuario.findByUSuarioAndPassword")
                .setParameter("usuario", usuario)
                .setParameter("password", password);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Usuario) q.getSingleResult();
    }

}
