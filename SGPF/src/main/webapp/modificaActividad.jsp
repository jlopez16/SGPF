<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page import="unam.mx.SGPF.model.controller.SubProcesoJpaController"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Actividad</title>
    </head>
    <body>
        <%  SubProceso subProcesoMod = (SubProceso) session.getAttribute("subProcesoMod"); 
            int idUF = subProcesoMod.getIdusuarioFuncional().getIdusuarioFuncional();
            int idAccion = subProcesoMod.getIdaccion().getIdaccion();
            int idGrupoDato = subProcesoMod.getIdgrupoDato().getIdgrupoDato();
        %>
        <h1>Modifica Actividad</h1>
        <form action="modificandoActividad" method="POST">
        <table border="1">
        <tr>
            <td>
                Actividad:
            </td>
            <td>
                <input type="text" name="actividad" value ="<%=subProcesoMod.getActividad()%>">
            </td>
            <td>
                Descripción:
            </td>
            <td>
                <input type="text" name="descripcion" value="<%=subProcesoMod.getDescripcion()%>">
            </td>
            <td>
                Usuario Funcional:
            </td>
            <td>
                <select name="usuarioFuncional">
                    <%
                        List<UsuarioFuncional> usuarioFuncionalCat = (List<UsuarioFuncional>) session.getAttribute("ufCatalogo");
                        for (UsuarioFuncional usuarioF : usuarioFuncionalCat){
                            if(usuarioF.getActivo()==1){
                                if(usuarioF.getIdusuarioFuncional()==idUF){
                                %>
                                    <option value="<%=usuarioF.getIdusuarioFuncional()%>" selected="true">
                                <%   
                                }else{
                               %>
                                    <option value="<%=usuarioF.getIdusuarioFuncional()%>">
                                <%
                                    }
                                %>
                                <%=usuarioF.getNomUF()%> -- <%=usuarioF.getDescripcion()%>
                                </option>
                       <%
                           }//IF ACTIVO
                        }//FOR
                        %>
                </select>
            </td>
            <td>
                Acción:
            </td>
            <td>
                <select name="accion">
                    <%
                        List<Accion> accionesCat = (List<Accion>) session.getAttribute("accCatalogo");
                        for (Accion accion : accionesCat){
                            if(accion.getActivo()==1){
                                if(accion.getIdaccion()==idAccion){
                                %>
                                    <option value="<%=accion.getIdaccion()%>" selected="true">
                                <%
                                }else{
                                %>
                                    <option value="<%=accion.getIdaccion()%>">
                                <%
                                    }
                                %>
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
                <select name="grupoDatos">
                    <%
                        List<GrupoDato> grupoDatoCat = (List<GrupoDato>)session.getAttribute("grupoDatosCatalogo");
                        for (GrupoDato grupoDato : grupoDatoCat){ 
                            if(grupoDato.getActivo()==1){ 
                                if(grupoDato.getIdgrupoDato()==idGrupoDato){
                                %>
                                    <option value="<%=grupoDato.getIdgrupoDato()%>" selected="true">
                                <% 
                                   }else{
                                %>
                                    <option value="<%=grupoDato.getIdgrupoDato()%>">
                                <% 
                                }
                                %>
                                <%=grupoDato.getNomGD()%> -- <%=grupoDato.getDescripcion()%>
                            </option>
                       <%
                           }
                        }
                        %>
                </select>
            </td>
            <td>
                Flujo Alterno:
            </td>
            <td>
                <% if(subProcesoMod.getFlujoAl()==1){ %>
                <input type="checkbox" name="flujoAl" value="true" checked>
                <%
                    }else{
                %>
                <input type="checkbox" name="flujoAl" value="true">
                <%
                }
                %>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td valign="middle"><input type="submit" value="Guardar Cambios"/></td> </form>
            <td  valign="middle">
            <form action="BuscaProcesoFuncional" method="POST">
                <input type="hidden" name="idprocesoFuncional" value="<%=subProcesoMod.getIdprocesoFuncional().getIdprocesoFuncional()%>" />
                <input type="submit" value="Cancelar Cambios"/></form>
            </td>
        </tr>
    </table>
   
    </body>
</html>
