<%@page import="unam.mx.SGPF.model.GrupoDato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Grupos de Datos</title>
        <% List<GrupoDato> grupoDatos = (List<GrupoDato>) session.getAttribute("grupoDatos"); %>
    </head>
    <body>
        <h1>Grupos de Datos!</h1>
        <table>
            <tr>
                <td>
                    Nombre del Grupo
                </td>
                <td>
                    Descripción
                </td>
                <td>
                    Activo
                </td>
            </tr>
            <% for(GrupoDato iter : grupoDatos){  %>
            <tr>
                <td>
                    <%=iter.getNomGD()%>
                </td>
                <td>
                    <%=iter.getDescripcion()%>
                </td>
                <% if(iter.getActivo()==1){%>
                    <td>
                        Si
                    </td>
                    <td>
                        <a href="EliminaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Eliminar</a>
                    </td>
                    <td>
                        <a href="modificaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Modificar</a>
                    </td>
                <%}else{%>
                    <td>
                        No
                    </td>
                    <td>
                        <a href="EliminaGrupoDato?idGrupoDato=<%=iter.getIdgrupoDato()%>">Activar</a>
                    </td>
                <% } %>
            </tr>
            <% } %>
        </table>
        <br>
        <table>
            <tr>
                <td>
                    <a href="agregarGrupoDatos.jsp"><input type="Submit" value="Agregar Grupo"/></a>
                </td>
                <td>
                    <a href="crudCatalogos.jsp"><input type="submit" value="Regresar"></a>
                </td>
            </tr>
        </table>

    </body>
</html>
