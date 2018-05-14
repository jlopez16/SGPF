<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
    </head>
    <body>
        <h1>Agregar Usuario!</h1>
        <table>
            <form action="agregarUsuario" method="post">
            <tr>
                <td>Nombre del usuario:</td>
                <td><input type="text" name="nomUsuario" required></td>
            </tr>
            <tr>
                <td>Contraseña:</td>
                <td><input type="password" name="pwdUsuario" required></td>
            </tr>
            <tr>
                <td>Tipo de usuario:</td>
                <td>
                    <select name="usuTipo" required>
                        <option value="1">Administrador</option>
                        <option value="2">Gestor de Proyecto</option>
                        <option value="3">Consultor</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Guardar">
                </td></form>
                <td>
                    <a href="gestionUsuarios.jsp">
                        <input type="submit" value="Cancelar">
                    </a>
                </td>
            </tr>
        </table>
    </body>
</html>
