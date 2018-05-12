package unam.mx.SGPF.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class agregarActividad extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProcesoFuncional =  Integer.parseInt(request.getParameter("idProcesoFuncional"));
        
        SubProcesoJpaController sjpa = new SubProcesoJpaController(EntityProvider.provider());
        List<SubProceso> ListaSubprocesos = sjpa.findSPByActividadyIdPF("Inicio de Proceso Funcional", idProcesoFuncional);
        HttpSession session = request.getSession(true);
        session.setAttribute("ListaSubprocesos", ListaSubprocesos);
        
        response.sendRedirect("addActividad.jsp");
    }
    
}
