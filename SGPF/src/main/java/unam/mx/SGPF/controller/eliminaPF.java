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
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;

public class eliminaPF extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	//VARIABLES QUE PROVIENEN DEL FORM modificaPF.jsp
        String redireccion = "";
        int idPF = Integer.parseInt(request.getParameter("idPF"));
        ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        ProcesoFuncional procesoFuncional = pfjpa.findProcesoFuncional(idPF);
        try {
            short a=0;
            procesoFuncional.setActivo(a);
            pfjpa.edit(procesoFuncional);
            HttpSession session = request.getSession(true);
            session.setAttribute("idProyecto", procesoFuncional.getIdproyecto());
            redireccion = "e_ProcesoFuncional.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            redireccion = "proyectos.jsp";
            return;
        } finally {
            response.sendRedirect(redireccion);
        }
    }
}
