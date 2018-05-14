<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- 
Falta que al agregar sólo lo hahrá en caso de que no exista ya el NOMBRE DE LA
ACTIVIDAD CON EL PF, de no ser así mandar ERROR.

Validad ID del PF con ....
-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Actividad</title>
        <%
            List<SubProceso> ListaSubprocesos = (List<SubProceso>) session.getAttribute("ListaSubprocesos");
            %>
    </head>
    <body><marquee direction="left">
        <h1>Agregar Actividad</h1></marquee>
    <form action="agregandoActividad" method="POST">
    <table>
        <tr>
            <td>
                Actividad:
            </td>
            <td>
            <% if(ListaSubprocesos.isEmpty()){
            %>  
                <input type="hidden" name="actividad" value="Inicio de Proceso Funcional">
                Inicio de Proceso Funcional
            <%
                }else{
            %>
                <input type="text" name="actividad" required>    
            <% } %>
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
    </table>
    <br>
    <br>
    <input type="submit" value="Agregar Actividad"/></a>
    </form>
    <br>
    <br>
    <a href="detallePF.jsp"><input type="submit" value="Cancelar"></a>
    </body>
</html>
