
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="unam.mx.SGPF.model.UsuarioFuncional"%>
<%@page import="unam.mx.SGPF.model.Accion"%>
<%@page import="unam.mx.SGPF.model.GrupoDato"%>
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
    <div>
    	<%
     	ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
        List<SubProceso> spList = (List<SubProceso>) session.getAttribute("subProc");

  		%>
        <h1>Detalle de Proceso Funcional</h1>
        <table border="1">
    	<tr>
        	<td>Nombre Proceso Funcional:</td>
        	<td><%=detalle.getNomPF()%></td>
      	</tr>
      	<tr>
        	<td>Descripción:</td>
        	<td><%=detalle.getDescripcion()%></td>
      	</tr>
      <tr>
        <td>Evento desencadenante:</td>
        <td><%=detalle.geteventoDes()%></td>
      </tr>
      <tr>
      	<td><a href="modificaProyecto.jsp"><input type="submit" value="Modificar"/></a> </td>
      	<form action="eliminarProyecto" method="post">
      		<input type="submit" value="Eliminar"/>
      	</form>
      </tr>
    </table>
     <br>
        <a href="modificaPF.jsp"><input type="submit" value="Modificar"/></a>
    </div>
        <div>
        <h2>Lista de Actividades</h2>
        <br>
        <a href="addActividad.jsp"><input type="submit" value="Agregar Actividad"/></a>
        <br>
    	<table border="1">
    		<%
      		for (SubProceso inter : spList) {
      			UsuarioFuncional uf=new UsuarioFuncional();
      			Accion acc=new Accion();
      			GrupoDato gd=new GrupoDato();
      			uf=inter.getIdusuarioFuncional();
      			acc=inter.getIdaccion();
      			gd=inter.getIdgrupoDato();
    		%>
    		<tr><%if(inter.getIndice()==1){ %>
    			<td><%=inter.getActividad()%></td>
    			<td><%=uf.getNomUF()%></td>
    			<td><%=acc.getNomAccion()%></td>
        		<td><%=inter.getDescripcion()%></td>
        		<td><%=gd.getNomGD()%></td>
        		<td>
        			<a href="modActividad"><input type="submit" value="Modificar Actividad"/></a>
        			<a href="addSubProceso"><input type="submit" value="Agregar Subproceso"/></a>
        			<a href="eliActividad"><input type="submit" value="Eliminar Actividad" /></a>
        		</td> 
        		<% }else{%>
        		<td></td>
    			<td><%=uf.getNomUF()%></td>
    			<td><%=acc.getNomAccion()%></td>
        		<td><%=inter.getDescripcion()%></td>
        		<td><%=gd.getNomGD()%></td>
        		<td>
        			<a href="eliSubproceso"><input type="submit" value="Eliminar"/></a>
        		</td>
        		<%} %>
     		</tr>
    		<%
      		}
    		%>
     	</table>
        </div>
        
        
        
       
        
    </body>
</html>
