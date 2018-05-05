package unam.mx.SGPF.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;


public class eliminarProyecto extends HttpServlet {
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String redireccion = "";
	        int idProy = Integer.parseInt(request.getParameter("idProyecto"));
	       
	       // HttpSession session = request.getSession(true);
	        //Usuario u = (Usuario) session.getAttribute("usuario");

	        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
	        //short a = 1;
	        //BigDecimal big = new BigDecimal(0.24);
	        Proyecto p = pjpa.findProyecto(idProy);
	        short estado=1;
	        p.setEstatus(estado);
	        
	        try {
	            pjpa.edit(p);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            redireccion = "detalleProyecto.jsp";
	            return;
	        } finally {
	            redireccion = "proyectos.jsp";
	            response.sendRedirect(redireccion);
	        }
	    }
}
