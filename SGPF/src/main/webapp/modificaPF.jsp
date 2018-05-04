<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     	ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
  		%>
        <h1>Detalle del Proceso funcional</h1>
        <form action="actualizarPF" method="POST">
            <table>
            <tr>
                <td>Id: </td><td><input type="text" value="<%=detalle.getIdprocesoFuncional()%>" name="idProcesoFuncional"> </td>
            </tr>    
            <tr>
                <td>Nombre: </td><td><input type="text" value="<%=detalle.getNomPF()%>" name="nombreProcesoFuncional"> </td>
            </tr>
            <tr>
                <td>Descripción: </td><td><input type="text" value="<%=detalle.getDescripcion()%>" name="descripcionPF"> </td>
            </tr>
             <tr>
                <td>Evento Desencadenante: </td><td><input type="text" value="<%=detalle.geteventoDes()%>" name="eventoDes"> </td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td><td></td>
            </tr>
        </table>
        </form>
    </body>
</html>
