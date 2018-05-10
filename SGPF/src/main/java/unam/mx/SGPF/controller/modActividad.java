package unam.mx.SGPF.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class modActividad extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int aux = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController subProceso = new SubProcesoJpaController(EntityProvider.provider());
        SubProceso MiSubProceso = subProceso.findSubProceso(aux);
        HttpSession session = request.getSession(true);
        session.setAttribute("subProcesoMod", MiSubProceso);
        
        
        response.sendRedirect("modificaActividad.jsp");
        
    }

}
