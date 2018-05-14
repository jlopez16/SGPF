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
@Table(name = "usuarioFuncional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioFuncional.findAll", query = "SELECT u FROM UsuarioFuncional u")
    , @NamedQuery(name = "UsuarioFuncional.findByIdusuarioFuncional", query = "SELECT u FROM UsuarioFuncional u WHERE u.idusuarioFuncional = :idusuarioFuncional")
    , @NamedQuery(name = "UsuarioFuncional.findByNomUF", query = "SELECT u FROM UsuarioFuncional u WHERE u.nomUF = :nomUF")})
public class UsuarioFuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idusuarioFuncional;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomUF;
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Column(nullable = false)
    private short activo;
    public UsuarioFuncional(Integer idusuarioFuncional, String nomUF, String descripcion, short activo,
			List<SubProceso> subProcesoList) {
		super();
		this.idusuarioFuncional = idusuarioFuncional;
		this.nomUF = nomUF;
		this.descripcion = descripcion;
		this.activo = activo;
		this.subProcesoList = subProcesoList;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public short getActivo() {
		return activo;
	}

	public void setActivo(short activo) {
		this.activo = activo;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuarioFuncional")
    private List<SubProceso> subProcesoList;

    public UsuarioFuncional() {
    }

    public UsuarioFuncional(Integer idusuarioFuncional) {
        this.idusuarioFuncional = idusuarioFuncional;
    }

    public UsuarioFuncional(Integer idusuarioFuncional, String nomUF) {
        this.idusuarioFuncional = idusuarioFuncional;
        this.nomUF = nomUF;
    }

    public Integer getIdusuarioFuncional() {
        return idusuarioFuncional;
    }

    public void setIdusuarioFuncional(Integer idusuarioFuncional) {
        this.idusuarioFuncional = idusuarioFuncional;
    }

    public String getNomUF() {
        return nomUF;
    }

    public void setNomUF(String nomUF) {
        this.nomUF = nomUF;
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
        hash += (idusuarioFuncional != null ? idusuarioFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioFuncional)) {
            return false;
        }
        UsuarioFuncional other = (UsuarioFuncional) object;
        if ((this.idusuarioFuncional == null && other.idusuarioFuncional != null) || (this.idusuarioFuncional != null && !this.idusuarioFuncional.equals(other.idusuarioFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.UsuarioFuncional[ idusuarioFuncional=" + idusuarioFuncional + " ]";
    }

}
