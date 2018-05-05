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
import unam.mx.SGPF.model.SubProceso;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.ProyectoJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;
public class BuscaProcesoFuncional extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Integer idPf= Integer.parseInt(request.getParameter("idprocesoFuncional"));
    	
    	
        HttpSession session = request.getSession(true);
        
        ////////
    	ProcesoFuncionalJpaController pfjpa = new ProcesoFuncionalJpaController(EntityProvider.provider());
        ProcesoFuncional pfDetalle = pfjpa.findProcesoFuncional(idPf);
        session.setAttribute("pfDetalle", pfDetalle);
        ////
        
        SubProcesoJpaController spjpa = new SubProcesoJpaController(EntityProvider.provider());
        List<SubProceso> sp = spjpa.findSPByIdProcesoFuncional(idPf);
        session.setAttribute("subProc", sp);
       
        response.sendRedirect("detallePF.jsp");
    }
}
