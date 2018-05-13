package unam.mx.SGPF;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.UsuarioJpaController;


public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Aquí recibe los parámetros del formulario de inicio de sesión
		String usuario = request.getParameter("uname");
		String pass = request.getParameter("psw");

		// Clase de metodos para el crud
		// Objeto que establece la conexión ujpa de tabla USUARIO
		UsuarioJpaController ujpa = new UsuarioJpaController(EntityProvider.provider());
		Usuario u = ujpa.getUsuarioByUserAndPass(usuario, pass);
                
		if (u == null) {
			response.sendRedirect("index.html");
		} else {
			// Objeto que establece la sesión
                        HttpSession session = request.getSession(true);
                        int tipoUsuario;
                        if(u.getUsuTipo1()!=null){
                            tipoUsuario =  1;
                        }else{
                            if(u.getUsuTipo2()!=null){
                                tipoUsuario = 2;
                            }
                            else{
                                tipoUsuario = 3;
                            }
                        }
                        session.setAttribute("tipoUsuario", tipoUsuario);

			InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
			List<InterUP> inters = ijpa.getProyectosUsuario(u);
			// Apuntador al objeto u
			session.setAttribute("usuario", u);
			session.setAttribute("inters", inters);

			response.sendRedirect("proyectos.jsp");
		}

	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
