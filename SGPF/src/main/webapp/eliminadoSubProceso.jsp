
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Sub Proceso Eliminado</title>
    </head>
    <body>
        <h1>Se ha eliminado el SubProceso de una forma completamente exitosa,
            gracias por usar SGPF!</h1>
        <%
          int idPF = (Integer) session.getAttribute("idPF");
        %>
        <form action="BuscaProcesoFuncional?idprocesoFuncional=<%=idPF%>" method="POST">
            <input type="submit" value="Regresar"/>
        </form>
    </body>
</html>
