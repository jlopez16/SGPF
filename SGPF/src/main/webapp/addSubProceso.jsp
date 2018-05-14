<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agregar SubProceso</title>
    </head>
    <body>
        <h1>Agregar Sub-Proceso</h1>
    <form action="agregandoSubProceso" method="POST">
    <table>
        <tr>
            <td>
                Actividad:
            </td>
            <td>
                <% SubProceso SubProceso = (SubProceso) session.getAttribute("SubProceso"); %>
                <input type="hidden" name="actividad" value="<%=SubProceso.getActividad()%>">
                <%=SubProceso.getActividad()%>
            </td>
            <td>
                Descripción:
            </td>
            <td>
                <input type="text" name="descripcion" required>
            </td>
            <td>
                Usuario Funcional:
            </td>
            <td>
                <select name="usuarioFuncional" required>
                    <%
                        List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
                        for (UsuarioFuncional usuarioF : usuarioFuncionalCat){
                            if(usuarioF.getActivo()==1){
                                %>
                            <option value="<%=usuarioF.getIdusuarioFuncional()%>">
                                <%=usuarioF.getNomUF()%> -- <%=usuarioF.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>
            <td>
                Acción:
            </td>
            <td>
                <select name="accion" required>
                    <%
                        List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
                        for (Accion accion : accionesCat){
                            if(accion.getActivo()==1){
                                %>
                            <option value="<%=accion.getIdaccion()%>">
                                <%=accion.getNomAccion()%> -- <%=accion.getMovDatos()%> -- <%=accion.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>
            <td>
                Grupo de Datos:
            </td>
            <td>
                <select name="grupoDatos" required>
                    <%
                        List<GrupoDato> grupoDatoCat = (List<GrupoDato>)session.getAttribute("grupoDatosCatalogo");
                        for (GrupoDato grupoDato : grupoDatoCat){ 
                            if(grupoDato.getActivo()==1){ 
                                %>
                            <option value="<%=grupoDato.getIdgrupoDato()%>">
                                <%=grupoDato.getNomGD()%> -- <%=grupoDato.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>

            <td>
                Flujo Alterno
            </td>
            <td>
                <input type="checkbox" name="flujoAl" value="true">
            </td>
        </tr>
        <tr><td>
                <input type="submit" value="Agregar SubProceso"/></td></form>
    <td>
        <form action="BuscaProcesoFuncional" method="POST">
                <input type="hidden" name="idprocesoFuncional" value="<%=SubProceso.getIdprocesoFuncional().getIdprocesoFuncional()%>" />
                <input type="submit" value="Cancelar Cambios"/></form>
    </td>
    </tr>
    </body>
</html>
