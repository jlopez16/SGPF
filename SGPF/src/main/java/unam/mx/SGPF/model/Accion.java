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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accion.findAll", query = "SELECT a FROM Accion a")
    , @NamedQuery(name = "Accion.findByIdaccion", query = "SELECT a FROM Accion a WHERE a.idaccion = :idaccion")
    , @NamedQuery(name = "Accion.findByNomAccion", query = "SELECT a FROM Accion a WHERE a.nomAccion = :nomAccion")})
public class Accion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idaccion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomAccion;
    @Column(nullable = false, length = 1)
    private String movDatos;
    public String getMovDatos() {
		return movDatos;
	}

	public void setMovDatos(String movDatos) {
		this.movDatos = movDatos;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idaccion")
    private List<SubProceso> subProcesoList;

    public Accion() {
    }

    public Accion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public Accion(Integer idaccion, String nomAccion) {
        this.idaccion = idaccion;
        this.nomAccion = nomAccion;
    }

    public Integer getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public String getNomAccion() {
        return nomAccion;
    }

    public void setNomAccion(String nomAccion) {
        this.nomAccion = nomAccion;
    }

    @XmlTransient
    public List<SubProceso> getSubProcesoList() {
        return subProcesoList;
    }

    public void setSubProcesoList(List<SubProceso> subProcesoList) {
        this.subProcesoList = subProcesoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccion != null ? idaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accion)) {
            return false;
        }
        Accion other = (Accion) object;
        if ((this.idaccion == null && other.idaccion != null) || (this.idaccion != null && !this.idaccion.equals(other.idaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Accion[ idaccion=" + idaccion + " ]";
    }

}
