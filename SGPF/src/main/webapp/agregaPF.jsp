<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agrega PF</title>
        <%
            Proyecto p = (Proyecto) session.getAttribute("proy");
        %>
    </head>
    <body>
        <h1>Agrega Proceso Funcional!</h1>
        <form action="agregarPF" method="POST">
        <table>
            <tr>
                <td>Nombre del Proceso Funcional: </td>
                <td><input type="text" name="nombrePF"></td>
            </tr>
            <tr>
                <td>Descripción: </td>
                <td><input type="text" name="descripcioPF"></td>
            </tr>
            <tr>
                <td>Evento Desencadenante: </td>
                <td>
                    <input type="text" name="eventoDes">
                    <input type="hidden" name="idProyecto" value="<%=p.getIdproyecto()%>">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Aceptar">
                    </form>
                </td>
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
