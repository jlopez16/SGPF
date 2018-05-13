<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modifica UF</title>
    </head>
    <body>
        <h1>Modifica Usuario Funcional!</h1>
        <% UsuarioFuncional uf = (UsuarioFuncional) session.getAttribute("usuarioFuncionalMod");%>
        <form action="modificandoUF" method="post">
        <table>
            <tr>
                <td>Nombre del Usuario Funcional:</td>
                <td>
                    <input type="hidden" name="idUF" value="<%=uf.getIdusuarioFuncional()%>">
                    <input type="text" name="nombreUF" value="<%=uf.getNomUF()%>">
                </td>
            </tr>
            <tr>
                <td>Descripción:</td>
                <td><input type="text" name="descripcionUF" value="<%=uf.getDescripcion()%>"></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Guardar">
                </td></form>
                <td>
                    <a href="usuarioFuncional.jsp">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>                    
        </table>
    </body>
</html>
