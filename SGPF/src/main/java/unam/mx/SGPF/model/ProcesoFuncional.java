/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author miguel
 */
@Entity
@Table(name="procesofuncional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoFuncional.findAll", query = "SELECT p FROM ProcesoFuncional p")
    , @NamedQuery(name = "ProcesoFuncional.findByIdprocesoFuncional", query = "SELECT p FROM ProcesoFuncional p WHERE p.idprocesoFuncional = :idprocesoFuncional")
    , @NamedQuery(name = "ProcesoFuncional.findByIdproyecto", query = "SELECT p FROM ProcesoFuncional p WHERE p.idproyecto = :idproyecto")
    , @NamedQuery(name = "ProcesoFuncional.findByNomPF", query = "SELECT p FROM ProcesoFuncional p WHERE p.nomPF = :nomPF")
    , @NamedQuery(name = "ProcesoFuncional.findByDescripcion", query = "SELECT p FROM ProcesoFuncional p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProcesoFuncional.findByeventoDes", query = "SELECT p FROM ProcesoFuncional p WHERE p.eventoDes = :eventoDes")
    , @NamedQuery(name = "ProcesoFuncional.findByTamPF", query = "SELECT p FROM ProcesoFuncional p WHERE p.tamPF = :tamPF")})
public class ProcesoFuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idprocesoFuncional;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomPF;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String eventoDes;
    @Basic(optional = false)
    @Column(nullable = false)
    private int tamPF;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprocesoFuncional")
    private List<SubProceso> subProcesoList;
    @JoinColumn(name = "idproyecto", referencedColumnName = "idproyecto", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idproyecto;

    public ProcesoFuncional() {
    }

    public ProcesoFuncional(Integer idprocesoFuncional) {
        this.idprocesoFuncional = idprocesoFuncional;
    }

    public ProcesoFuncional(Integer idprocesoFuncional, String nomPF, String descripcion, String eventoDes, int tamPF) {
        this.idprocesoFuncional = idprocesoFuncional;
        this.nomPF = nomPF;
        this.descripcion = descripcion;
        this.eventoDes = eventoDes;
        this.tamPF = tamPF;
    }

    public Integer getIdprocesoFuncional() {
        return idprocesoFuncional;
    }

    public void setIdprocesoFuncional(Integer idprocesoFuncional) {
        this.idprocesoFuncional = idprocesoFuncional;
    }

    public String getNomPF() {
        return nomPF;
    }

    public void setNomPF(String nomPF) {
        this.nomPF = nomPF;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String geteventoDes() {
        return eventoDes;
    }

    public void seteventoDes(String eventoDes) {
        this.eventoDes = eventoDes;
    }

    public int getTamPF() {
        return tamPF;
    }

    public void setTamPF(int tamPF) {
        this.tamPF = tamPF;
    }

    @XmlTransient
    public List<SubProceso> getSubProcesoList() {
        return subProcesoList;
    }

    public void setSubProcesoList(List<SubProceso> subProcesoList) {
        this.subProcesoList = subProcesoList;
    }

    public Proyecto getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Proyecto idproyecto) {
        this.idproyecto = idproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprocesoFuncional != null ? idprocesoFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoFuncional)) {
            return false;
        }
        ProcesoFuncional other = (ProcesoFuncional) object;
        if ((this.idprocesoFuncional == null && other.idprocesoFuncional != null) || (this.idprocesoFuncional != null && !this.idprocesoFuncional.equals(other.idprocesoFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.ProcesoFuncional[ idprocesoFuncional=" + idprocesoFuncional + " ]";
    }

}
