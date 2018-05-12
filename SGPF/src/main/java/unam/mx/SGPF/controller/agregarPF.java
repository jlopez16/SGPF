package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;

public class agregarPF extends HttpServlet{
         @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException { 
             
		String nombrePF = request.getParameter("nombrePF");
                String descripcioPF = request.getParameter("descripcioPF");
                String eventoDes = request.getParameter("eventoDes");
	    	Integer idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
	    	
	    	ProcesoFuncionalJpaController PFjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
                ProyectoJpaController proyectoJpa = new ProyectoJpaController(EntityProvider.provider());
                Proyecto proyecto = proyectoJpa.findProyecto(idProyecto);
                
                ProcesoFuncional aux = new ProcesoFuncional();
                aux.setNomPF(nombrePF);
                aux.setDescripcion(descripcioPF);
                aux.seteventoDes(eventoDes);
                aux.setIdproyecto(proyecto);
                aux.setTamPF(0);
                System.out.println(aux.toString());
	    	try {
	    		PFjpa.create(aux);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		//Aqui debe mandar un mensaje de error 
	    	}
	    	HttpSession session = request.getSession(true);
		
                List<ProcesoFuncional> pf = PFjpa.findPFByIdProyecto(proyecto.getIdproyecto());
                session.setAttribute("procFunc", pf);
	        response.sendRedirect("detalleProyecto.jsp");
	    }
}
