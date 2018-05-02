package unam.mx.SGPF.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.ProcesoFuncional;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T17:14:51")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> metDesarrollo;
    public static volatile SingularAttribute<Proyecto, String> tipoDesarrollo;
    public static volatile SingularAttribute<Proyecto, Short> certModelo;
    public static volatile SingularAttribute<Proyecto, Integer> idproyecto;
    public static volatile SingularAttribute<Proyecto, Integer> expeMedMetProy;
    public static volatile SingularAttribute<Proyecto, String> tipoCapOrg;
    public static volatile SingularAttribute<Proyecto, Integer> costEsReqProy;
    public static volatile SingularAttribute<Proyecto, Integer> esfuTotProy;
    public static volatile SingularAttribute<Proyecto, String> tipoOrg;
    public static volatile SingularAttribute<Proyecto, Integer> esfuImpleDesProy;
    public static volatile SingularAttribute<Proyecto, String> lenguaje;
    public static volatile SingularAttribute<Proyecto, Short> usoCase;
    public static volatile SingularAttribute<Proyecto, String> marcoPosUsa;
    public static volatile SingularAttribute<Proyecto, Integer> costTotProy;
    public static volatile SingularAttribute<Proyecto, Integer> costConstProy;
    public static volatile SingularAttribute<Proyecto, Integer> costPrueProy;
    public static volatile ListAttribute<Proyecto, ProcesoFuncional> procesoFuncionalList;
    public static volatile SingularAttribute<Proyecto, String> comCertModelo;
    public static volatile SingularAttribute<Proyecto, String> metMedicion;
    public static volatile SingularAttribute<Proyecto, Integer> esfuAnaDisProy;
    public static volatile SingularAttribute<Proyecto, Integer> esfuPlaneProy;
    public static volatile SingularAttribute<Proyecto, String> baseDatos;
    public static volatile SingularAttribute<Proyecto, String> escala;
    public static volatile SingularAttribute<Proyecto, Integer> esfuConstProy;
    public static volatile SingularAttribute<Proyecto, String> tamOrgUsa;
    public static volatile SingularAttribute<Proyecto, Integer> esfuEsReqProy;
    public static volatile SingularAttribute<Proyecto, Integer> costImpleDesProy;
    public static volatile SingularAttribute<Proyecto, Integer> costAnaDisProy;
    public static volatile SingularAttribute<Proyecto, String> nomProy;
    public static volatile SingularAttribute<Proyecto, Integer> esfuPrueProy;
    public static volatile ListAttribute<Proyecto, InterUP> interUPList;
    public static volatile SingularAttribute<Proyecto, String> secOrg;
    public static volatile SingularAttribute<Proyecto, Integer> fpAjusProy;
    public static volatile SingularAttribute<Proyecto, Short> medidorCertProy;
    public static volatile SingularAttribute<Proyecto, String> tamOrgDes;
    public static volatile SingularAttribute<Proyecto, Integer> tamFunProy;
    public static volatile SingularAttribute<Proyecto, String> confInfo;
    public static volatile SingularAttribute<Proyecto, String> anioProy;
    public static volatile SingularAttribute<Proyecto, String> arqProyecto;
    public static volatile SingularAttribute<Proyecto, Short> estatus;
    public static volatile SingularAttribute<Proyecto, BigDecimal> costPlanProy;
    public static volatile SingularAttribute<Proyecto, Short> operProy;
    public static volatile SingularAttribute<Proyecto, Integer> duraProy;
    public static volatile SingularAttribute<Proyecto, String> modCalidad;
    public static volatile SingularAttribute<Proyecto, String> sisOpe;

}