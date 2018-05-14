package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.InterUP;
import unam.mx.SGPF.model.ProcesoFuncional;
import unam.mx.SGPF.model.Proyecto;
import unam.mx.SGPF.model.Usuario;
import unam.mx.SGPF.model.controller.InterUPJpaController;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;

public class eliminaProyecto extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//VARIABLES QUE PROVIENEN DEL FORM modificaPF.jsp
        String redireccion = "";
        int idProyecto = Integer.parseInt(request.getParameter("idProyecto"));
        ProyectoJpaController pjpa = new ProyectoJpaController(EntityProvider.provider());
        Proyecto proyecto = pjpa.findProyecto(idProyecto);
        short a=0;
        if(proyecto.getEstatus()==1)
            proyecto.setEstatus(a);
        else{
            a=1;
            proyecto.setEstatus(a);
        }
        HttpSession session = request.getSession(true);
        Usuario idUsuario = (Usuario) session.getAttribute("usuario");
        InterUPJpaController ijpa = new InterUPJpaController(EntityProvider.provider());
            
        try {
            
            pjpa.edit(proyecto);
            
        } catch (Exception e) {
            redireccion = "index.html";
            return;
        } finally {
            List<InterUP> inters = ijpa.getProyectosUsuario(idUsuario);
            session.setAttribute("usuario", idUsuario);
            session.setAttribute("inters", inters);
            redireccion="proyectos.jsp";
            response.sendRedirect(redireccion);
        }
    }
}
