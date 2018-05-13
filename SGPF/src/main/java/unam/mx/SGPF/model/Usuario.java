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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByNomUsuario", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "Usuario.findByPwdUsuario", query = "SELECT u FROM Usuario u WHERE u.pwdUsuario = :pwdUsuario")
    , @NamedQuery(name = "Usuario.findByUsuTipo1", query = "SELECT u FROM Usuario u WHERE u.usuTipo1 = :usuTipo1")
    , @NamedQuery(name = "Usuario.findByUsuTipo2", query = "SELECT u FROM Usuario u WHERE u.usuTipo2 = :usuTipo2")
    , @NamedQuery(name = "Usuario.findByUsuTipo3", query = "SELECT u FROM Usuario u WHERE u.usuTipo3 = :usuTipo3")
    , @NamedQuery(name = "Usuario.findByUSuarioAndPassword", query = "SELECT u from Usuario u WHERE u.nomUsuario = :usuario and u.pwdUsuario = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idusuario;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nomUsuario;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String pwdUsuario;
    private Short usuTipo1;
    private Short usuTipo2;
    private Short usuTipo3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<InterUP> interUPList;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String nomUsuario, String pwdUsuario) {
        this.idusuario = idusuario;
        this.nomUsuario = nomUsuario;
        this.pwdUsuario = pwdUsuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public Short getUsuTipo1() {
        return usuTipo1;
    }

    public void setUsuTipo1(Short usuTipo1) {
        this.usuTipo1 = usuTipo1;
    }

    public Short getUsuTipo2() {
        return usuTipo2;
    }

    public void setUsuTipo2(Short usuTipo2) {
        this.usuTipo2 = usuTipo2;
    }

    public Short getUsuTipo3() {
        return usuTipo3;
    }

    public void setUsuTipo3(Short usuTipo3) {
        this.usuTipo3 = usuTipo3;
    }

    @XmlTransient
    public List<InterUP> getInterUPList() {
        return interUPList;
    }

    public void setInterUPList(List<InterUP> interUPList) {
        this.interUPList = interUPList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Usuario[ idusuario=" + idusuario + " ]";
    }

}
