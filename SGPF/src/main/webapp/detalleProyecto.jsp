<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalles proyecto</title>
  </head>
  <%
     List<ProcesoFuncional> pfs = (List<ProcesoFuncional>) session.getAttribute("procFunc");
  	 Proyecto p = (Proyecto) session.getAttribute("proy");
  %>

  <body>
    <h1>Detalle proyecto</h1>
	<table border="1">

    <tr>
        <td>Nombre Proyecto:</td>
        <td><%=p.getNomProy()%></td>
      </tr>
      <tr>
        <td>Año:</td>
        <td><%=p.getAnioProy()%></td>
      </tr>
      <tr>
        <td>Duracion:</td>
        <td><%=p.getDuraProy()%></td>
      </tr>
      <tr>
      	<td><a href="modificaProyecto.jsp"><input type="submit" value="Modificar"/></a> </td>
      	<form action="eliminarProyecto" method="post">
      		<input type="submit" value="Eliminar"/>
      	</form>
      </tr>
    </table>
    <br>
    <h1>Procesos funcionales relacionados al Proyecto</h1>
    <br>
    <table border="1">
    <%
      for (ProcesoFuncional inter : pfs) {
          //ProcesoFuncional pf = inter.getIdprocesoFuncional();
    %>
    <tr>
        <td>Nombre del Proceso Funcional:</td>
        <td><a href="BuscaProcesoFuncional?idprocesoFuncional=<%=inter.getIdprocesoFuncional()%>"><%=inter.getNomPF()%></a></td>
      </tr>
  
    <%
      }
    %>
    
     </table>
    <br>
    <br>
    <a href="proyectos.jsp"><input type="submit" value="Back to Projects"</a>
  </body>
</html>
