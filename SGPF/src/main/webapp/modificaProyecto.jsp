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
        <h1>Hello World!</h1>
        <form action="actualizaRproyectO" method="POST">
            <table>
            <tr>
                <td>Id: </td><td><input type="text" value="<%=p.getIdproyecto()%>" name="idProyecto"> </td>
            </tr>    
            <tr>
                <td>Nombre: </td><td><input type="text" value="<%=p.getNomProy()%>" name="nombreProyecto"> </td>
            </tr>
            <tr>
                <td><input type="submit" value="SavE"/></td><td></td>
            </tr>
        </table>
        </form>
    </body>
</html>
