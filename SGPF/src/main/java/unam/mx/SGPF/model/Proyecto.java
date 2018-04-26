/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.mx.SGPF.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(catalog = "SGPF", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdproyecto", query = "SELECT p FROM Proyecto p WHERE p.idproyecto = :idproyecto")
    , @NamedQuery(name = "Proyecto.findByNomProy", query = "SELECT p FROM Proyecto p WHERE p.nomProy = :nomProy")
    , @NamedQuery(name = "Proyecto.findByAnioProy", query = "SELECT p FROM Proyecto p WHERE p.anioProy = :anioProy")
    , @NamedQuery(name = "Proyecto.findByOperProy", query = "SELECT p FROM Proyecto p WHERE p.operProy = :operProy")
    , @NamedQuery(name = "Proyecto.findByDuraProy", query = "SELECT p FROM Proyecto p WHERE p.duraProy = :duraProy")
    , @NamedQuery(name = "Proyecto.findByEsfuTotProy", query = "SELECT p FROM Proyecto p WHERE p.esfuTotProy = :esfuTotProy")
    , @NamedQuery(name = "Proyecto.findByEsfuPlaneProy", query = "SELECT p FROM Proyecto p WHERE p.esfuPlaneProy = :esfuPlaneProy")
    , @NamedQuery(name = "Proyecto.findByEsfuEsReqProy", query = "SELECT p FROM Proyecto p WHERE p.esfuEsReqProy = :esfuEsReqProy")
    , @NamedQuery(name = "Proyecto.findByEsfuAnaDisProy", query = "SELECT p FROM Proyecto p WHERE p.esfuAnaDisProy = :esfuAnaDisProy")
    , @NamedQuery(name = "Proyecto.findByEsfuConstProy", query = "SELECT p FROM Proyecto p WHERE p.esfuConstProy = :esfuConstProy")
    , @NamedQuery(name = "Proyecto.findByEsfuPrueProy", query = "SELECT p FROM Proyecto p WHERE p.esfuPrueProy = :esfuPrueProy")
    , @NamedQuery(name = "Proyecto.findByEsfuImpleDesProy", query = "SELECT p FROM Proyecto p WHERE p.esfuImpleDesProy = :esfuImpleDesProy")
    , @NamedQuery(name = "Proyecto.findByCostTotProy", query = "SELECT p FROM Proyecto p WHERE p.costTotProy = :costTotProy")
    , @NamedQuery(name = "Proyecto.findByCostEsReqProy", query = "SELECT p FROM Proyecto p WHERE p.costEsReqProy = :costEsReqProy")
    , @NamedQuery(name = "Proyecto.findByCostAnaDisProy", query = "SELECT p FROM Proyecto p WHERE p.costAnaDisProy = :costAnaDisProy")
    , @NamedQuery(name = "Proyecto.findByCostConstProy", query = "SELECT p FROM Proyecto p WHERE p.costConstProy = :costConstProy")
    , @NamedQuery(name = "Proyecto.findByCostPrueProy", query = "SELECT p FROM Proyecto p WHERE p.costPrueProy = :costPrueProy")
    , @NamedQuery(name = "Proyecto.findByCostImpleDesProy", query = "SELECT p FROM Proyecto p WHERE p.costImpleDesProy = :costImpleDesProy")
    , @NamedQuery(name = "Proyecto.findByTamFunProy", query = "SELECT p FROM Proyecto p WHERE p.tamFunProy = :tamFunProy")
    , @NamedQuery(name = "Proyecto.findByFpAjusProy", query = "SELECT p FROM Proyecto p WHERE p.fpAjusProy = :fpAjusProy")
    , @NamedQuery(name = "Proyecto.findByMedidorCertProy", query = "SELECT p FROM Proyecto p WHERE p.medidorCertProy = :medidorCertProy")
    , @NamedQuery(name = "Proyecto.findByExpeMedMetProy", query = "SELECT p FROM Proyecto p WHERE p.expeMedMetProy = :expeMedMetProy")
    , @NamedQuery(name = "Proyecto.findByUsoCase", query = "SELECT p FROM Proyecto p WHERE p.usoCase = :usoCase")
    , @NamedQuery(name = "Proyecto.findByCertModelo", query = "SELECT p FROM Proyecto p WHERE p.certModelo = :certModelo")
    , @NamedQuery(name = "Proyecto.findByComCertModelo", query = "SELECT p FROM Proyecto p WHERE p.comCertModelo = :comCertModelo")
    , @NamedQuery(name = "Proyecto.findByCostPlanProy", query = "SELECT p FROM Proyecto p WHERE p.costPlanProy = :costPlanProy")
    , @NamedQuery(name = "Proyecto.findByConfInfo", query = "SELECT p FROM Proyecto p WHERE p.confInfo = :confInfo")
    , @NamedQuery(name = "Proyecto.findByArqProyecto", query = "SELECT p FROM Proyecto p WHERE p.arqProyecto = :arqProyecto")
    , @NamedQuery(name = "Proyecto.findByMetDesarrollo", query = "SELECT p FROM Proyecto p WHERE p.metDesarrollo = :metDesarrollo")
    , @NamedQuery(name = "Proyecto.findByMetMedicion", query = "SELECT p FROM Proyecto p WHERE p.metMedicion = :metMedicion")
    , @NamedQuery(name = "Proyecto.findBySisOpe", query = "SELECT p FROM Proyecto p WHERE p.sisOpe = :sisOpe")
    , @NamedQuery(name = "Proyecto.findByTipoDesarrollo", query = "SELECT p FROM Proyecto p WHERE p.tipoDesarrollo = :tipoDesarrollo")
    , @NamedQuery(name = "Proyecto.findByLenguaje", query = "SELECT p FROM Proyecto p WHERE p.lenguaje = :lenguaje")
    , @NamedQuery(name = "Proyecto.findByModCalidad", query = "SELECT p FROM Proyecto p WHERE p.modCalidad = :modCalidad")
    , @NamedQuery(name = "Proyecto.findByBaseDatos", query = "SELECT p FROM Proyecto p WHERE p.baseDatos = :baseDatos")
    , @NamedQuery(name = "Proyecto.findBySecOrg", query = "SELECT p FROM Proyecto p WHERE p.secOrg = :secOrg")
    , @NamedQuery(name = "Proyecto.findByEstatus", query = "SELECT p FROM Proyecto p WHERE p.estatus = :estatus")
    , @NamedQuery(name = "Proyecto.findByTipoOrg", query = "SELECT p FROM Proyecto p WHERE p.tipoOrg = :tipoOrg")
    , @NamedQuery(name = "Proyecto.findByTipoCapOrg", query = "SELECT p FROM Proyecto p WHERE p.tipoCapOrg = :tipoCapOrg")
    , @NamedQuery(name = "Proyecto.findByTamOrgDes", query = "SELECT p FROM Proyecto p WHERE p.tamOrgDes = :tamOrgDes")
    , @NamedQuery(name = "Proyecto.findByTamOrgUsa", query = "SELECT p FROM Proyecto p WHERE p.tamOrgUsa = :tamOrgUsa")
    , @NamedQuery(name = "Proyecto.findByMarcoPosUsa", query = "SELECT p FROM Proyecto p WHERE p.marcoPosUsa = :marcoPosUsa")
    , @NamedQuery(name = "Proyecto.findByEscala", query = "SELECT p FROM Proyecto p WHERE p.escala = :escala")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idproyecto;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String nomProy;
    @Basic(optional = false)
    @Column(nullable = false, length = 4)
    private String anioProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private short operProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int duraProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuTotProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuPlaneProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuEsReqProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuAnaDisProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuConstProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuPrueProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int esfuImpleDesProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costTotProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costEsReqProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costAnaDisProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costConstProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costPrueProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int costImpleDesProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int tamFunProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int fpAjusProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private short medidorCertProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private int expeMedMetProy;
    @Basic(optional = false)
    @Column(nullable = false)
    private short usoCase;
    @Basic(optional = false)
    @Column(nullable = false)
    private short certModelo;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String comCertModelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal costPlanProy;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String confInfo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String arqProyecto;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String metDesarrollo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String metMedicion;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sisOpe;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipoDesarrollo;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String lenguaje;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String modCalidad;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String baseDatos;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String secOrg;
    @Basic(optional = false)
    @Column(nullable = false)
    private short estatus;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipoOrg;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tipoCapOrg;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tamOrgDes;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String tamOrgUsa;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String marcoPosUsa;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String escala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<InterUP> interUPList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<ProcesoFuncional> procesoFuncionalList;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Proyecto(Integer idproyecto, String nomProy, String anioProy, short operProy, int duraProy, int esfuTotProy, int esfuPlaneProy, int esfuEsReqProy, int esfuAnaDisProy, int esfuConstProy, int esfuPrueProy, int esfuImpleDesProy, int costTotProy, int costEsReqProy, int costAnaDisProy, int costConstProy, int costPrueProy, int costImpleDesProy, int tamFunProy, int fpAjusProy, short medidorCertProy, int expeMedMetProy, short usoCase, short certModelo, String comCertModelo, BigDecimal costPlanProy, String confInfo, String arqProyecto, String metDesarrollo, String metMedicion, String sisOpe, String tipoDesarrollo, String lenguaje, String modCalidad, String baseDatos, String secOrg, short estatus, String tipoOrg, String tipoCapOrg, String tamOrgDes, String tamOrgUsa, String marcoPosUsa, String escala) {
        this.idproyecto = idproyecto;
        this.nomProy = nomProy;
        this.anioProy = anioProy;
        this.operProy = operProy;
        this.duraProy = duraProy;
        this.esfuTotProy = esfuTotProy;
        this.esfuPlaneProy = esfuPlaneProy;
        this.esfuEsReqProy = esfuEsReqProy;
        this.esfuAnaDisProy = esfuAnaDisProy;
        this.esfuConstProy = esfuConstProy;
        this.esfuPrueProy = esfuPrueProy;
        this.esfuImpleDesProy = esfuImpleDesProy;
        this.costTotProy = costTotProy;
        this.costEsReqProy = costEsReqProy;
        this.costAnaDisProy = costAnaDisProy;
        this.costConstProy = costConstProy;
        this.costPrueProy = costPrueProy;
        this.costImpleDesProy = costImpleDesProy;
        this.tamFunProy = tamFunProy;
        this.fpAjusProy = fpAjusProy;
        this.medidorCertProy = medidorCertProy;
        this.expeMedMetProy = expeMedMetProy;
        this.usoCase = usoCase;
        this.certModelo = certModelo;
        this.comCertModelo = comCertModelo;
        this.costPlanProy = costPlanProy;
        this.confInfo = confInfo;
        this.arqProyecto = arqProyecto;
        this.metDesarrollo = metDesarrollo;
        this.metMedicion = metMedicion;
        this.sisOpe = sisOpe;
        this.tipoDesarrollo = tipoDesarrollo;
        this.lenguaje = lenguaje;
        this.modCalidad = modCalidad;
        this.baseDatos = baseDatos;
        this.secOrg = secOrg;
        this.estatus = estatus;
        this.tipoOrg = tipoOrg;
        this.tipoCapOrg = tipoCapOrg;
        this.tamOrgDes = tamOrgDes;
        this.tamOrgUsa = tamOrgUsa;
        this.marcoPosUsa = marcoPosUsa;
        this.escala = escala;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getNomProy() {
        return nomProy;
    }

    public void setNomProy(String nomProy) {
        this.nomProy = nomProy;
    }

    public String getAnioProy() {
        return anioProy;
    }

    public void setAnioProy(String anioProy) {
        this.anioProy = anioProy;
    }

    public short getOperProy() {
        return operProy;
    }

    public void setOperProy(short operProy) {
        this.operProy = operProy;
    }

    public int getDuraProy() {
        return duraProy;
    }

    public void setDuraProy(int duraProy) {
        this.duraProy = duraProy;
    }

    public int getEsfuTotProy() {
        return esfuTotProy;
    }

    public void setEsfuTotProy(int esfuTotProy) {
        this.esfuTotProy = esfuTotProy;
    }

    public int getEsfuPlaneProy() {
        return esfuPlaneProy;
    }

    public void setEsfuPlaneProy(int esfuPlaneProy) {
        this.esfuPlaneProy = esfuPlaneProy;
    }

    public int getEsfuEsReqProy() {
        return esfuEsReqProy;
    }

    public void setEsfuEsReqProy(int esfuEsReqProy) {
        this.esfuEsReqProy = esfuEsReqProy;
    }

    public int getEsfuAnaDisProy() {
        return esfuAnaDisProy;
    }

    public void setEsfuAnaDisProy(int esfuAnaDisProy) {
        this.esfuAnaDisProy = esfuAnaDisProy;
    }

    public int getEsfuConstProy() {
        return esfuConstProy;
    }

    public void setEsfuConstProy(int esfuConstProy) {
        this.esfuConstProy = esfuConstProy;
    }

    public int getEsfuPrueProy() {
        return esfuPrueProy;
    }

    public void setEsfuPrueProy(int esfuPrueProy) {
        this.esfuPrueProy = esfuPrueProy;
    }

    public int getEsfuImpleDesProy() {
        return esfuImpleDesProy;
    }

    public void setEsfuImpleDesProy(int esfuImpleDesProy) {
        this.esfuImpleDesProy = esfuImpleDesProy;
    }

    public int getCostTotProy() {
        return costTotProy;
    }

    public void setCostTotProy(int costTotProy) {
        this.costTotProy = costTotProy;
    }

    public int getCostEsReqProy() {
        return costEsReqProy;
    }

    public void setCostEsReqProy(int costEsReqProy) {
        this.costEsReqProy = costEsReqProy;
    }

    public int getCostAnaDisProy() {
        return costAnaDisProy;
    }

    public void setCostAnaDisProy(int costAnaDisProy) {
        this.costAnaDisProy = costAnaDisProy;
    }

    public int getCostConstProy() {
        return costConstProy;
    }

    public void setCostConstProy(int costConstProy) {
        this.costConstProy = costConstProy;
    }

    public int getCostPrueProy() {
        return costPrueProy;
    }

    public void setCostPrueProy(int costPrueProy) {
        this.costPrueProy = costPrueProy;
    }

    public int getCostImpleDesProy() {
        return costImpleDesProy;
    }

    public void setCostImpleDesProy(int costImpleDesProy) {
        this.costImpleDesProy = costImpleDesProy;
    }

    public int getTamFunProy() {
        return tamFunProy;
    }

    public void setTamFunProy(int tamFunProy) {
        this.tamFunProy = tamFunProy;
    }

    public int getFpAjusProy() {
        return fpAjusProy;
    }

    public void setFpAjusProy(int fpAjusProy) {
        this.fpAjusProy = fpAjusProy;
    }

    public short getMedidorCertProy() {
        return medidorCertProy;
    }

    public void setMedidorCertProy(short medidorCertProy) {
        this.medidorCertProy = medidorCertProy;
    }

    public int getExpeMedMetProy() {
        return expeMedMetProy;
    }

    public void setExpeMedMetProy(int expeMedMetProy) {
        this.expeMedMetProy = expeMedMetProy;
    }

    public short getUsoCase() {
        return usoCase;
    }

    public void setUsoCase(short usoCase) {
        this.usoCase = usoCase;
    }

    public short getCertModelo() {
        return certModelo;
    }

    public void setCertModelo(short certModelo) {
        this.certModelo = certModelo;
    }

    public String getComCertModelo() {
        return comCertModelo;
    }

    public void setComCertModelo(String comCertModelo) {
        this.comCertModelo = comCertModelo;
    }

    public BigDecimal getCostPlanProy() {
        return costPlanProy;
    }

    public void setCostPlanProy(BigDecimal costPlanProy) {
        this.costPlanProy = costPlanProy;
    }

    public String getConfInfo() {
        return confInfo;
    }

    public void setConfInfo(String confInfo) {
        this.confInfo = confInfo;
    }

    public String getArqProyecto() {
        return arqProyecto;
    }

    public void setArqProyecto(String arqProyecto) {
        this.arqProyecto = arqProyecto;
    }

    public String getMetDesarrollo() {
        return metDesarrollo;
    }

    public void setMetDesarrollo(String metDesarrollo) {
        this.metDesarrollo = metDesarrollo;
    }

    public String getMetMedicion() {
        return metMedicion;
    }

    public void setMetMedicion(String metMedicion) {
        this.metMedicion = metMedicion;
    }

    public String getSisOpe() {
        return sisOpe;
    }

    public void setSisOpe(String sisOpe) {
        this.sisOpe = sisOpe;
    }

    public String getTipoDesarrollo() {
        return tipoDesarrollo;
    }

    public void setTipoDesarrollo(String tipoDesarrollo) {
        this.tipoDesarrollo = tipoDesarrollo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getModCalidad() {
        return modCalidad;
    }

    public void setModCalidad(String modCalidad) {
        this.modCalidad = modCalidad;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getSecOrg() {
        return secOrg;
    }

    public void setSecOrg(String secOrg) {
        this.secOrg = secOrg;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public String getTipoOrg() {
        return tipoOrg;
    }

    public void setTipoOrg(String tipoOrg) {
        this.tipoOrg = tipoOrg;
    }

    public String getTipoCapOrg() {
        return tipoCapOrg;
    }

    public void setTipoCapOrg(String tipoCapOrg) {
        this.tipoCapOrg = tipoCapOrg;
    }

    public String getTamOrgDes() {
        return tamOrgDes;
    }

    public void setTamOrgDes(String tamOrgDes) {
        this.tamOrgDes = tamOrgDes;
    }

    public String getTamOrgUsa() {
        return tamOrgUsa;
    }

    public void setTamOrgUsa(String tamOrgUsa) {
        this.tamOrgUsa = tamOrgUsa;
    }

    public String getMarcoPosUsa() {
        return marcoPosUsa;
    }

    public void setMarcoPosUsa(String marcoPosUsa) {
        this.marcoPosUsa = marcoPosUsa;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    @XmlTransient
    public List<InterUP> getInterUPList() {
        return interUPList;
    }

    public void setInterUPList(List<InterUP> interUPList) {
        this.interUPList = interUPList;
    }

    @XmlTransient
    public List<ProcesoFuncional> getProcesoFuncionalList() {
        return procesoFuncionalList;
    }

    public void setProcesoFuncionalList(List<ProcesoFuncional> procesoFuncionalList) {
        this.procesoFuncionalList = procesoFuncionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproyecto != null ? idproyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idproyecto == null && other.idproyecto != null) || (this.idproyecto != null && !this.idproyecto.equals(other.idproyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unam.mx.SGPF.model.Proyecto[ idproyecto=" + idproyecto + " ]";
    }

}
