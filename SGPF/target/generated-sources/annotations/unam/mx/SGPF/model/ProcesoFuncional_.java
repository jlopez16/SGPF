package unam.mx.SGPF.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.SubProceso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T17:14:51")
@StaticMetamodel(ProcesoFuncional.class)
public class ProcesoFuncional_ { 

    public static volatile SingularAttribute<ProcesoFuncional, String> nomPF;
    public static volatile SingularAttribute<ProcesoFuncional, String> descripcion;
    public static volatile SingularAttribute<ProcesoFuncional, String> eventoDes;
    public static volatile SingularAttribute<ProcesoFuncional, Integer> tamPF;
    public static volatile SingularAttribute<ProcesoFuncional, Proyecto> idproyecto;
    public static volatile ListAttribute<ProcesoFuncional, SubProceso> subProcesoList;
    public static volatile SingularAttribute<ProcesoFuncional, Integer> idprocesoFuncional;

}