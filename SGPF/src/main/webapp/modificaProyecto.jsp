<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%
  	 Proyecto p = (Proyecto) session.getAttribute("proy");
         %>
        <h1>Modifica el Proyecto</h1>
        <form action="actualizaRproyectO" method="POST">
            <table>
            <tr>
                <td>Id: </td><td>
                    <input type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
                    <%=p.getIdproyecto()%></td>
            </tr>    
            <tr>
                <td>Nombre: </td>
                <td><input type="text" name="nombreProyecto" value="<%=p.getNomProy()%>"> </td>
            </tr>
            
            <tr>
                <td><input type="submit" value="Guardar"/></td><td></td></form>
            <td>
                <form action="BuscaProyecto" method="POST">
                    <input type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
                    <input type="submit" value="Cancelar">
                </form>
            </td>
            </tr>
        </table>
        
    </body>
</html>
