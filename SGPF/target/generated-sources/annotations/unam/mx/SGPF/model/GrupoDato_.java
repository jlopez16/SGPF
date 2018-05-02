package unam.mx.SGPF.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.SubProceso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T17:14:51")
@StaticMetamodel(GrupoDato.class)
public class GrupoDato_ { 

    public static volatile SingularAttribute<GrupoDato, Integer> idgrupoDato;
    public static volatile SingularAttribute<GrupoDato, String> nomGD;
    public static volatile ListAttribute<GrupoDato, SubProceso> subProcesoList;

}