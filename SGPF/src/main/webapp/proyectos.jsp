<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de proyectos</title>
    </head>
    <%
        List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
    %>
    <body>
        <h1>Proyectos</h1>
        <a href="crudCatalogos.jsp"><input type="Submit" value="Modificar Catálogos"/></a>

        <table border="1">
            <%
                for (InterUP inter : inters) {
                    Proyecto p = inter.getIdproyecto();
            %>
            <tr>
                <td>Nombre Proyecto:</td>
                <td><a href="BuscaProyecto?idProyecto=<%=p.getIdproyecto()%>"><%=p.getNomProy()%></a></td>
            </tr>
            <%
                }
            %>
            <tr>
            	<td><a href="agregarProyecto.jsp"><input type="Submit" value="Agregar Nuevo Proyecto"/></a></td>
            </tr>
        </table>
    </body>
</html>
