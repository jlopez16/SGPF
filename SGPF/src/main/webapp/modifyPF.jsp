<%@page import="unam.mx.SGPF.model.ProcesoFuncional"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Modifica Proceso Funcional</title>
    </head>
    <body>
        <h1>Modifica Proceso Funcional</h1>
        <div>
            <%
                ProcesoFuncional detalle = (ProcesoFuncional) session.getAttribute("pfDetalle");
            %>
            <form action="actualizarPF" method="POST">
            <table border="1">
                <tr>
                        <td>Nombre Proceso Funcional:</td>
                        <td>
                            <input type="hidden" name="idProcesoFuncional" value="<%=detalle.getIdprocesoFuncional()%>">
                            <input type="text" name="nombreProcesoFuncional" value="<%=detalle.getNomPF()%>" required></td>
                </tr>
                <tr>
                        <td>Descripción:</td>
                        <td><input type="text" name="descripcionPF" value="<%=detalle.getDescripcion()%>" required></td>
                </tr>
              <tr>
                <td>Evento desencadenante:</td>
                <td><input type="text" name="eventoDes" value="<%=detalle.geteventoDes()%>" required></td>
              </tr>
              <tr>
                  <td>
                      <input type="submit" value="Guardar"/>
                      </form>
                  </td>
                  <td>
                      <form action="BuscaProcesoFuncional?idprocesoFuncional=<%=detalle.getIdprocesoFuncional()%>" method="POST">
                        <input type="submit" value="Cancelar"/>
                      </form>
                  </td>
              </tr>
            </table>
              
        </div>
    </body>
</html>
