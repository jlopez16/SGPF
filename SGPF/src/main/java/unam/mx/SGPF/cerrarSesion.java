package unam.mx.SGPF;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.Usuario;

public class cerrarSesion extends HttpServlet {
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            Usuario u = new Usuario();
            InterUP inters = new InterUP();
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", u);
            session.setAttribute("inters", inters);
            response.sendRedirect("index.html");
    }
}
