<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Administración de UF</title>
    </head>
    <body>
        <h1>Administración de Usuarios Funcionales!</h1>
        <%
            List<UsuarioFuncional> uf = (List<UsuarioFuncional>) session.getAttribute("usuarioFuncional");
        %>
        <table>
            <tr>
                <td>Nombre del Usuario Funcional</td>
                <td>Descripción</td>
                <td>Activo</td>
            </tr>
        <%
    	for(UsuarioFuncional iter : uf) { 
        %>
            <tr>
                <td><%=iter.getNomUF()%></td>
                <td><%=iter.getDescripcion()%></td>
                <td><%if(iter.getActivo()==1){%>Si<%}else{%>No<%}%></td>
                <%if(iter.getActivo()==1){%>
                    <td>
                        <a href="EliminaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Eliminar</a>
                    </td>
                <% }else{ %>
                    <td>
                        <a href="EliminaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Activar</a>
                    </td>
                <% } %>
                <%if(iter.getActivo()==1){%>
                    <td>
                        <a href="modificaUF?idUF=<%=iter.getIdusuarioFuncional()%>">Modificar</a>
                    </td>
                <% } %>
            </tr>
            <%
                }
            %>
        </table>
    <table>
        <tr>
            <td>
                <a href="agregarUF.jsp"><input type="Submit" value="Agregar Usuario"/></a>
            </td>
            <td>
                <a href="crudCatalogos.jsp"><input type="submit" value="Regresar"></a>
            </td>
        </tr>
    </table>

    </body>
</html>
