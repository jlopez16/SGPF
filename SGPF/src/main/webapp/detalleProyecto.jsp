<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page import="java.util.List"%>
<%@page import="unam.mx.SGPF.model.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Detalles proyecto</title>
  </head>
  <%
     //InterUP inters = (List<InterUP>) session.getAttribute("inters");
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
    </table>




  </body>
</html>
