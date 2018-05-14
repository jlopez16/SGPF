<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modifica Grupo de Datos</title>
        <% GrupoDato grupoDatoMod = (GrupoDato) session.getAttribute("grupoDatoMod"); %>
    </head>
    <body>
        <h1>Modifica Grupo de Datos!</h1>
        <form action="modificandoGrupoDato" method="post">
        <table>
            <tr>
                <td>
                    Nombre del Grupo:
                </td>
                <td>
                    <input type="hidden" name="idGD" value="<%=grupoDatoMod.getIdgrupoDato()%>">
                    <input type="text" name="nombreGD" value="<%=grupoDatoMod.getNomGD()%>" required>
                </td>
            </tr>
            <tr>
                <td>
                    Descripción:
                </td>
                <td>
                    <input type="text" name="descripcionGD" value="<%=grupoDatoMod.getDescripcion()%>" required>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Guardar">
                </td></form>
                <td>
                    <a href="grupoDatos.jsp">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>
