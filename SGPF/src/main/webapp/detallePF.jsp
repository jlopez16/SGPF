
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="unam.mx.SGPF.model.SubProceso"%>
<%@page import="java.util.List"%>
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
        List<SubProceso> spList = (List<SubProceso>) session.getAttribute("subProc");

  		%>
        <h1>Detalle de Proceso Funcional</h1>
        <%=detalle.getNomPF()%>
        <%=detalle.getDescripcion()%>
        <%=detalle.geteventoDes()%>
        <br>
        <a href="modificaPF.jsp"><input type="submit" value="Modificar"/></a>
        <h2>Lista de SUB-PROCESOS</h2>
        <br>
    	<table border="1">
    		<%
      		for (SubProceso inter : spList) {
    		%>
    		<tr>
    			<td><%=inter.getIdusuarioFuncional()%></td>
    			<td><%=inter.getIdaccion()%></td>
        		<td><%=inter.getDescripcion()%></td>
        		<td><%=inter.getIdgrupoDato()%></td>
     		</tr>
    		<%
      		}
    		%>
     	</table>
    </body>
</html>
