<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Agregar Nuevo Proyecto</title>
    </head>
    <body>
        <h1>Nuevo</h1>
        <form action="AgregarProyecto" method="POST">
            <table>
            <tr>
                <td>Nombre: <input type="text" name="nombreProyecto" required></td>
                <td> <input type="submit" value="Submit"> </td>
            </tr>
        </table>
        </form>
        
    </body>
</html>
