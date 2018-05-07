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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByIdproyecto", query = "SELECT p FROM Proyecto p WHERE p.idproyecto = :idproyecto and p.estatus=0")
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idproyecto;
    @Column(nullable = false, length = 60)
    private String nomProy;
    @Column(nullable = false, length = 4)
    private String anioProy;
    @Column(nullable = false)
    private short operProy;
    @Column(nullable = false)
    private BigDecimal duraProy;
    @Column(nullable = false)
    private BigDecimal esfuTotProy;
    @Column(nullable = false)
    private BigDecimal esfuPlaneProy;
    @Column(nullable = false)
    private BigDecimal esfuEsReqProy;
    @Column(nullable = false)
    private BigDecimal esfuAnaDisProy;
    @Column(nullable = false)
    private BigDecimal esfuConstProy;
    @Column(nullable = false)
    private BigDecimal esfuPrueProy;
    @Column(nullable = false)
    private BigDecimal esfuImpleDesProy;
    @Column(nullable = false)
    private BigDecimal costTotProy;
    @Column(nullable = false)
    private BigDecimal costEsReqProy;
   @Column(nullable = false)
    private BigDecimal costAnaDisProy;
    @Column(nullable = false)
    private BigDecimal costConstProy;
    @Column(nullable = false)
    private BigDecimal costPrueProy;
    @Column(nullable = false)
    private BigDecimal costImpleDesProy;
    @Column(nullable = false)
    private BigDecimal tamFunProy;
    @Column(nullable = false)
    private BigDecimal fpAjusProy;
    @Column(nullable = false)
    private short medidorCertProy;
    @Column(nullable = false)
    private int expeMedMetProy;
    @Column(nullable = false)
    private short usoCase;
    @Column(nullable = false)
    private short certModelo;
    @Column(nullable = false, length = 250)
    private String comCertModelo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal costPlanProy;
    @Column(nullable = false, length = 45)
    private String confInfo;
    @Column(nullable = false, length = 45)
    private String arqProyecto;
    @Column(nullable = false, length = 45)
    private String metDesarrollo;
    @Column(nullable = false, length = 45)
    private String metMedicion;
    @Column(nullable = false, length = 45)
    private String sisOpe;
    @Column(nullable = false, length = 45)
    private String tipoDesarrollo;
    @Column(nullable = false, length = 45)
    private String lenguaje;
    @Column(nullable = false, length = 45)
    private String modCalidad;
    @Column(nullable = false, length = 45)
    private String baseDatos;
    @Column(nullable = false, length = 45)
    private String secOrg;
    @Column(nullable = false)
    private short estatus;
    @Column(nullable = false, length = 45)
    private String tipoOrg;
    @Column(nullable = false, length = 45)
    private String tipoCapOrg;
    @Column(nullable = false, length = 45)
    private String tamOrgDes;
    @Column(nullable = false, length = 45)
    private String tamOrgUsa;
    @Column(nullable = false, length = 45)
    private String marcoPosUsa;
    @Column(nullable = false, length = 45)
    private String escala;
    @Column(nullable = false, length = 45)
    private String capDes;
	@Column(nullable = false, length = 250)
    private String proposito;
    @Column(nullable = false, length = 250)
    private String alcance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<InterUP> interUPList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproyecto")
    private List<ProcesoFuncional> procesoFuncionalList;

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

   
    public Proyecto(Integer idproyecto, String nomProy, String anioProy, short operProy, BigDecimal duraProy,
			BigDecimal esfuTotProy, BigDecimal esfuPlaneProy, BigDecimal esfuEsReqProy, BigDecimal esfuAnaDisProy,
			BigDecimal esfuConstProy, BigDecimal esfuPrueProy, BigDecimal esfuImpleDesProy, BigDecimal costTotProy,
			BigDecimal costEsReqProy, BigDecimal costAnaDisProy, BigDecimal costConstProy, BigDecimal costPrueProy,
			BigDecimal costImpleDesProy, BigDecimal tamFunProy, BigDecimal fpAjusProy, short medidorCertProy,
			int expeMedMetProy, short usoCase, short certModelo, String comCertModelo, BigDecimal costPlanProy,
			String confInfo, String arqProyecto, String metDesarrollo, String metMedicion, String sisOpe,
			String tipoDesarrollo, String lenguaje, String modCalidad, String baseDatos, String secOrg, short estatus,
			String tipoOrg, String tipoCapOrg, String tamOrgDes, String tamOrgUsa, String marcoPosUsa, String escala,
			String capDes, String proposito, String alcance, List<InterUP> interUPList,
			List<ProcesoFuncional> procesoFuncionalList) {
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
		this.capDes = capDes;
		this.proposito = proposito;
		this.alcance = alcance;
		this.interUPList = interUPList;
		this.procesoFuncionalList = procesoFuncionalList;
	}
    public Proyecto( String nomProy, String anioProy, short operProy, BigDecimal duraProy,
			BigDecimal esfuTotProy, BigDecimal esfuPlaneProy, BigDecimal esfuEsReqProy, BigDecimal esfuAnaDisProy,
			BigDecimal esfuConstProy, BigDecimal esfuPrueProy, BigDecimal esfuImpleDesProy, BigDecimal costTotProy,
			BigDecimal costEsReqProy, BigDecimal costAnaDisProy, BigDecimal costConstProy, BigDecimal costPrueProy,
			BigDecimal costImpleDesProy, BigDecimal tamFunProy, BigDecimal fpAjusProy, short medidorCertProy,
			int expeMedMetProy, short usoCase, short certModelo, String comCertModelo, BigDecimal costPlanProy,
			String confInfo, String arqProyecto, String metDesarrollo, String metMedicion, String sisOpe,
			String tipoDesarrollo, String lenguaje, String modCalidad, String baseDatos, String secOrg, short estatus,
			String tipoOrg, String tipoCapOrg, String tamOrgDes, String tamOrgUsa, String marcoPosUsa, String escala,
			String capDes, String proposito, String alcance) {
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
		this.capDes = capDes;
		this.proposito = proposito;
		this.alcance = alcance;
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

	public BigDecimal getDuraProy() {
		return duraProy;
	}

	public void setDuraProy(BigDecimal duraProy) {
		this.duraProy = duraProy;
	}

	public BigDecimal getEsfuTotProy() {
		return esfuTotProy;
	}

	public void setEsfuTotProy(BigDecimal esfuTotProy) {
		this.esfuTotProy = esfuTotProy;
	}

	public BigDecimal getEsfuPlaneProy() {
		return esfuPlaneProy;
	}

	public void setEsfuPlaneProy(BigDecimal esfuPlaneProy) {
		this.esfuPlaneProy = esfuPlaneProy;
	}

	public BigDecimal getEsfuEsReqProy() {
		return esfuEsReqProy;
	}

	public void setEsfuEsReqProy(BigDecimal esfuEsReqProy) {
		this.esfuEsReqProy = esfuEsReqProy;
	}

	public BigDecimal getEsfuAnaDisProy() {
		return esfuAnaDisProy;
	}

	public void setEsfuAnaDisProy(BigDecimal esfuAnaDisProy) {
		this.esfuAnaDisProy = esfuAnaDisProy;
	}

	public BigDecimal getEsfuConstProy() {
		return esfuConstProy;
	}

	public void setEsfuConstProy(BigDecimal esfuConstProy) {
		this.esfuConstProy = esfuConstProy;
	}

	public BigDecimal getEsfuPrueProy() {
		return esfuPrueProy;
	}

	public void setEsfuPrueProy(BigDecimal esfuPrueProy) {
		this.esfuPrueProy = esfuPrueProy;
	}

	public BigDecimal getEsfuImpleDesProy() {
		return esfuImpleDesProy;
	}

	public void setEsfuImpleDesProy(BigDecimal esfuImpleDesProy) {
		this.esfuImpleDesProy = esfuImpleDesProy;
	}

	public BigDecimal getCostTotProy() {
		return costTotProy;
	}

	public void setCostTotProy(BigDecimal costTotProy) {
		this.costTotProy = costTotProy;
	}

	public BigDecimal getCostEsReqProy() {
		return costEsReqProy;
	}

	public void setCostEsReqProy(BigDecimal costEsReqProy) {
		this.costEsReqProy = costEsReqProy;
	}

	public BigDecimal getCostAnaDisProy() {
		return costAnaDisProy;
	}

	public void setCostAnaDisProy(BigDecimal costAnaDisProy) {
		this.costAnaDisProy = costAnaDisProy;
	}

	public BigDecimal getCostConstProy() {
		return costConstProy;
	}

	public void setCostConstProy(BigDecimal costConstProy) {
		this.costConstProy = costConstProy;
	}

	public BigDecimal getCostPrueProy() {
		return costPrueProy;
	}

	public void setCostPrueProy(BigDecimal costPrueProy) {
		this.costPrueProy = costPrueProy;
	}

	public BigDecimal getCostImpleDesProy() {
		return costImpleDesProy;
	}

	public void setCostImpleDesProy(BigDecimal costImpleDesProy) {
		this.costImpleDesProy = costImpleDesProy;
	}

	public BigDecimal getTamFunProy() {
		return tamFunProy;
	}

	public void setTamFunProy(BigDecimal tamFunProy) {
		this.tamFunProy = tamFunProy;
	}

	public BigDecimal getFpAjusProy() {
		return fpAjusProy;
	}

	public void setFpAjusProy(BigDecimal fpAjusProy) {
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

	public String getCapDes() {
		return capDes;
	}

	public void setCapDes(String capDes) {
		this.capDes = capDes;
	}

	public String getProposito() {
		return proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
