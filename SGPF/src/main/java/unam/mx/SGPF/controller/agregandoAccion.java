package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.controller.AccionJpaController;

public class agregandoAccion extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombreAccion = request.getParameter("nombreAccion");
        String movDatos = request.getParameter("movDatos");
        String descripcion = request.getParameter("descripcion");
        Short activo = 1;
        
        Accion accion = new Accion();
        accion.setNomAccion(nombreAccion);
        accion.setMovDatos(movDatos);
        accion.setDescripcion(descripcion);
        accion.setActivo(activo);
        
    	AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
    	try{
            ajpa.create(accion);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("acciones");
        }
       
    }
}
