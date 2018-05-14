<%@page import="unam.mx.SGPF.model.Usuario"%>
<%@page import="unam.mx.SGPF.model.controller.UsuarioJpaController"%>
<%@page import="unam.mx.SGPF.model.EntityProvider"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modifica Usuario</title>
        <% Usuario usuario = (Usuario) session.getAttribute("usuarioMod"); %>
    </head>
    <body>
        <h1>Edita Usuario!</h1>
        <table>
            <form action="modificaUsuario" method="post">
            <tr>
                <td>
                    Usuario:
                </td>
                <td>
                    <input type="hidden" name="IdUsuario" value="<%=usuario.getIdusuario()%>">
                    <input type="text" name="nomUsuario" value="<%=usuario.getNomUsuario()%>" required>
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type="password" name="pwdUsuario" value="<%=usuario.getPwdUsuario()%>" required>
                </td>
            </tr>
            <tr>
                <td>
                    Tipo de usuario: 
                </td>
                <td>
                <%if(usuario.getUsuTipo1()!=null){%>
                <select name="usuTipo">
                    <option value="1" selected>Administrador</option>
                    <option value="2">Gestor de Proyecto</option>
                    <option value="3">Consultor</option>
                </select>
                <%}else{if(usuario.getUsuTipo2()!=null){%>
                <select name="usuTipo">
                    <option value="1">Administrador</option>
                    <option value="2" selected>Gestor de Proyecto</option>
                    <option value="3">Consultor</option>
                </select>
                <%}else{%>
                <select name="usuTipo">
                    <option value="1">Administrador</option>
                    <option value="2">Gestor de Proyecto</option>
                    <option value="3" selected>Consultor</option>
                </select>
                <%}}%>
                </td>
            </tr>
            <tr>
                <td>
                    ¿Eliminar Usuario?
                </td>
                <td>
                     <input type="checkbox" name="eliminaUsuario" value="yes">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Aceptar"></form>
                </td>
                <td>
                    <a href="gestionUsuarios">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>
