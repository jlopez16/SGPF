<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agregar Grupo de Datos</title>
    </head>
    <body>
        <h1>Agregar Grupo de Datos!</h1>
        <table>
            <form action="agregandoGrupoDato" method="post">
            <tr>
                <td>Nombre del grupo de datos:</td>
                <td><input type="text" name="nombreGD"></td>
            </tr>
            <tr>
                <td>Descripción del grupo de datos:</td>
                <td><input type="text" name="descripcionGD"></td>
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
