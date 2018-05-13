<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agregar UF</title>
    </head>
    <body>
        <h1>Agregar Usuario Funcional!</h1>
        <table>
            <form action="agregandoUF" method="post">
            <tr>
                <td>Nombre del Usuario Funcional:</td>
                <td><input type="text" name="nombreUF" required></td>
            </tr>
            <tr>
                <td>Descripción del Usuario Funcional:</td>
                <td><input type="text" name="descripcionUF" required></td>
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
