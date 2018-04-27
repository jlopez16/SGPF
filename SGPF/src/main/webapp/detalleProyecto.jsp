<%@page import="unam.mx.SGPF.model.InterUP"%>
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
     List<InterUP> inters = (List<InterUP>) session.getAttribute("inters");
  %>

  <body>
    <h1>Proyectos</h1>

    <%
      for (InterUP inter : inters) {
          Proyecto p = inter.getIdproyecto();
    %>

    <table border="1">
      <tr>
        <td>Nombre:</td>
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

    <%
      }
    %>




  </body>
</html>
