<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Acción</title>
    </head>
    <body>
        <h1>Agregar Acción</h1>
        
        <table><form action="agregandoAccion" method="post">
                <tr>
                    <td>
                        Nombre de la acción:
                    </td>
                    <td>
                        <input type="text" name="nombreAccion" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Movimiento de datos:
                    </td>
                    <td>
                        <select name="movDatos">
                            <option value="E">E</option>
                            <option value="X">X</option>
                            <option value="R">R</option>
                            <option value="W">W</option>
                            <option value="M">X*</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Descripción:
                    </td>
                    <td>
                        <input type="text" name="descripcion" required>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Aceptar"></td></form>
                    <td>
                        <a href="acciones.jsp">
                            <input type="submit" value="Cancelar">
                        </a>
                    </td>
                </tr>
        </table>
    </body>
</html>
