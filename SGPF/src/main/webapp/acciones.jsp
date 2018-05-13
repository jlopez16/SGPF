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
    <tr>
        <td>Nombre de la acción</td>
        <td>Movimiento de datos</td>
        <td>Descripción</td>
        <td>Activo</td>
    </tr>
    <%
    	for(Accion accion : acciones) {
    %>
    <tr>
   	<td><%=accion.getNomAccion()%></td>
   	<td><%=accion.getMovDatos()%></td>
        <td><%=accion.getDescripcion()%></td>
        <td><%if(accion.getActivo()==1){%>Si<%}else{%>No<%}%></td>
        <%if(accion.getActivo()==1){
            %>
   	<td><a href="EliminaAccion?idAccion=<%=accion.getIdaccion()%>">Eliminar</a></td>
        <% }else{ %>
        <td><a href="EliminaAccion?idAccion=<%=accion.getIdaccion()%>">Activar</a></td>
        <% } %>
        <%if(accion.getActivo()==1){%>
        <td><a href="modificaAccion?idAccion=<%=accion.getIdaccion()%>">Modificar</a></td>
        <% } %>
    </tr>
    
    <%
    	}
    %>
   
</table>
    <table>
        <tr>
            <td>
                <a href="agregarAccion.jsp"><input type="Submit" value="Agregar Acción"/></a>
            </td>
            <td>
                <a href="crudCatalogos.jsp"><input type="submit" value="Regresar"></a>
            </td>
        </tr>
    </table>
 
</body>
</html>
