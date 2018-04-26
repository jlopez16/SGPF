/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miguel
 */
@Entity
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterUP.findAll", query = "SELECT i FROM InterUP i")
    , @NamedQuery(name = "InterUP.findByIdinterUP", query = "SELECT i FROM InterUP i WHERE i.idinterUP = :idinterUP")})
public class InterUP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idinterUP;
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idproyecto;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public InterUP() {
    }

    public InterUP(Integer idinterUP) {
        this.idinterUP = idinterUP;
    }

    public Integer getIdinterUP() {
        return idinterUP;
    }

    public void setIdinterUP(Integer idinterUP) {
        this.idinterUP = idinterUP;
    }

    public Proyecto getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Proyecto idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinterUP != null ? idinterUP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterUP)) {
            return false;
        }
        InterUP other = (InterUP) object;
        if ((this.idinterUP == null && other.idinterUP != null) || (this.idinterUP != null && !this.idinterUP.equals(other.idinterUP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.InterUP[ idinterUP=" + idinterUP + " ]";
    }

}
