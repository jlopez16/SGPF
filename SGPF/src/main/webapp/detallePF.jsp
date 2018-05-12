
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
      <a href="modifyPF.jsp">
        <input type="submit" value="Modificar"/>
      </a>
      </tr>
    </table>
     <br>
        <%--<a href="modificaPF.jsp"><input type="submit" value="Modificar"/></a> --%>
    </div>
        <div>
        <h2>Lista de Actividades</h2>
        <br>
        <form action="agregarActividad" method="post">
            <input type="hidden" name="idProcesoFuncional" value="<%=detalle.getIdprocesoFuncional()%>">
            <input type="submit" value="Agregar Actividad"/>
        </form>
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
                        <td bgcolor="#FF0000"><%=inter.getIdsubProceso()%></td>
                        <td><%=inter.getActividad()%></td>
    			<td><%=uf.getNomUF()%></td>
    			<td><%=acc.getNomAccion()%></td>
        		<td><%=inter.getDescripcion()%></td>
        		<td><%=gd.getNomGD()%></td>
        		<td>
        			<form action="modActividad" method ="POST">
                                    <input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>"/>
                                    <input type="submit" value="Modificar Actividad"/>
                                </form>
        			<form action="addSubProceso" method="POST">
                                    <input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>"/>
                                    <input type="submit" value="Agregar Subproceso"/>
                                </form>
                                <% if(inter.getActividad()=="Inicio de Proceso Funcional" && inter.getIndice()==1){
                                %>
                                <form action="eliActividad" method="POST">
                                    <input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>"/>
                                    <input type="submit" value="Eliminar Actividad" />
                                </form>
                                <%
                                }
                                %>
        		</td> 
        		<% }else{%>
                        <td bgcolor="#FF0000"><%=inter.getIdsubProceso()%></td>
                        <td bgcolor="#FF0000"><%=inter.getActividad()%></td>
    			<td><%=uf.getNomUF()%></td>
    			<td><%=acc.getNomAccion()%></td>
        		<td><%=inter.getDescripcion()%></td>
        		<td><%=gd.getNomGD()%></td>
        		<td>
                                <form action="eliSubproceso" method="POST">
                                    <input type="hidden" name="idSubProceso" value="<%=inter.getIdsubProceso()%>"/>
                                    <input type="submit" value="Eliminar" />
                                </form>
        		</td>
        		<%} %>
     		</tr>
    		<%
      		}
    		%>
     	</table>
        </div>
        <div>
            <a href="detalleProyecto.jsp"><input type="submit" value="Back to Project"></a>
        </div>
    </body>
</html>
