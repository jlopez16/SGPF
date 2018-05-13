<%@page import="unam.mx.SGPF.model.InterUP"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de proyectos</title>
        	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
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
                <td> Estatus: <%=p.getEstatus()%></td>
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
