
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%
     	ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
  		%>
        <h1>Detalle de Proceso Funcional</h1>
        <%=detalle.getNomPF()%>
        <%=detalle.getDescripcion()%>
        <%=detalle.geteventoDes()%>
        <br>
        <a href="modificaPF.jsp"><input type="submit" value="Modificar"/></a>
        <h2>Lista de SUB-PROCESOS</h2>
    </body>
</html>
