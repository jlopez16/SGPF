package unam.mx.SGPF.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import unam.mx.SGPF.model.InterUP;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T19:39:18")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> pwdUsuario;
    public static volatile SingularAttribute<Usuario, Short> usuTipo3;
    public static volatile ListAttribute<Usuario, InterUP> interUPList;
    public static volatile SingularAttribute<Usuario, Short> usuTipo1;
    public static volatile SingularAttribute<Usuario, Short> usuTipo2;
    public static volatile SingularAttribute<Usuario, String> nomUsuario;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;

}