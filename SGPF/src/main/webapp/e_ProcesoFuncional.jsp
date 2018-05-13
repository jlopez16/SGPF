<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>POP Confirmación</title>
        <% 
            Proyecto proyecto = (Proyecto) session.getAttribute("idProyecto"); 
        %>
    </head>
    <body>
        <h1>Se ha eliminado el Proceso Funcional Correctamente!</h1>
        <a href="BuscaProyecto?idProyecto=<%=proyecto.getIdproyecto()%>"><input type="submit" value="Regresar"></a>
    </body>
</html>
