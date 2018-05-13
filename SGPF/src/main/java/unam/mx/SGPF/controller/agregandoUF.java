package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.GrupoDato;
import unam.mx.SGPF.model.UsuarioFuncional;
import unam.mx.SGPF.model.controller.AccionJpaController;
import unam.mx.SGPF.model.controller.GrupoDatoJpaController;
import unam.mx.SGPF.model.controller.UsuarioFuncionalJpaController;

public class agregandoUF extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nombreUF = request.getParameter("nombreUF");
        String descripcionUF = request.getParameter("descripcionUF");
        Short activo = 1;
        
        UsuarioFuncional usuarioFuncional = new UsuarioFuncional();
        usuarioFuncional.setNomUF(nombreUF);
        usuarioFuncional.setDescripcion(descripcionUF);
        usuarioFuncional.setActivo(activo);
        
    	UsuarioFuncionalJpaController ufjpa = new UsuarioFuncionalJpaController(EntityProvider.provider());
    	try{
            ufjpa.create(usuarioFuncional);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect("usuarioFuncional");
        }
       
    }
}
