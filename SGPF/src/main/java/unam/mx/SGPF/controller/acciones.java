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


public class acciones extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		AccionJpaController ajpa = new AccionJpaController(EntityProvider.provider());
		List<Accion> ac = ajpa.findAccionEntities();
		session.setAttribute("action",ac);
		
		response.sendRedirect("acciones.jsp");
	}
}
