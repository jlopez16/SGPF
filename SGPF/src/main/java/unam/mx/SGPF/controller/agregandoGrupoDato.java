package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;

public class agregandoGrupoDato extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombre = request.getParameter("nombreGD");
        String descripcion = request.getParameter("descripcionGD");
        Short activo = 1;
        
        GrupoDato grupoDato = new GrupoDato();
        grupoDato.setNomGD(nombre);
        grupoDato.setDescripcion(descripcion);
        grupoDato.setActivo(activo);
        
    	GrupoDatoJpaController gdjpa = new GrupoDatoJpaController(EntityProvider.provider());
    	try{
            gdjpa.create(grupoDato);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("grupoDatos");
        }
       
    }
}
