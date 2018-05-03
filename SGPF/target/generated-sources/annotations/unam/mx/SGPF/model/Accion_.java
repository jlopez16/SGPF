package unam.mx.SGPF.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.SubProceso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T19:39:18")
@StaticMetamodel(Accion.class)
public class Accion_ { 

    public static volatile SingularAttribute<Accion, Integer> idaccion;
    public static volatile SingularAttribute<Accion, String> nomAccion;
    public static volatile ListAttribute<Accion, SubProceso> subProcesoList;

}