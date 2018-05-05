<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
  <h1>Administración de Acciones </h1>
<%
   List<Accion> acciones = (List<Accion>) session.getAttribute("action");
%>
<h1>Catàlogo de Acciones</h1>

<table >
    <%
    	for(Accion accion : acciones) {
    %>
    <tr>
    	<td>Nombre:</td>
   		<td><%=accion.getNomAccion()%></td>
   		<td>Movimiento de datos:</td>
   		<td><%=accion.getMovDatos()%></td>
   		<td><a href="EliminaAccion?idAccion=<%=accion.getIdaccion()%>">Eliminar</a></td>
    </tr>
    
    <%
    	}
    %>
   
</table>
 <a href="agregarAccion.jsp"><input type="Submit" value="Agregar Acción"/></a>
</body>
</html>
