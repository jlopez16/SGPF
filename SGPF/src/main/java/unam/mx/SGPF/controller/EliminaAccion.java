package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.Accion;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.controller.AccionJpaController;


public class EliminaAccion extends HttpServlet {
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
	    	Integer idAccion = Integer.parseInt(request.getParameter("idAccion"));
	    	
	    	AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
	    	//Accion ac = ajpa.findAccion(idAccion);
	    	try {
	    		ajpa.destroy(idAccion);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		//Aqui debe mandar un mensaje de error 
	    	}
	    	HttpSession session = request.getSession(true);
			
			List<Accion> ac = ajpa.findAccionEntities();
			session.setAttribute("action",ac);
	        response.sendRedirect("acciones.jsp");
	    }

}