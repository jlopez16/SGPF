package unam.mx.SGPF.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.UsuarioFuncional;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T17:14:51")
@StaticMetamodel(SubProceso.class)
public class SubProceso_ { 

    public static volatile SingularAttribute<SubProceso, String> descripcion;
    public static volatile SingularAttribute<SubProceso, Accion> idaccion;
    public static volatile SingularAttribute<SubProceso, UsuarioFuncional> idusuarioFuncional;
    public static volatile SingularAttribute<SubProceso, Integer> idsubProceso;
    public static volatile SingularAttribute<SubProceso, Short> flujoAl;
    public static volatile SingularAttribute<SubProceso, GrupoDato> idgrupoDato;
    public static volatile SingularAttribute<SubProceso, ProcesoFuncional> idprocesoFuncional;

}