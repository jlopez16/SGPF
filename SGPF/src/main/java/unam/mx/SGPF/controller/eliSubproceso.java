package unam.mx.SGPF.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import unam.mx.SGPF.model.EntityProvider;
import unam.mx.SGPF.model.controller.ProcesoFuncionalJpaController;
import unam.mx.SGPF.model.controller.SubProcesoJpaController;

public class eliSubproceso extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String redireccion="";
        int idSubProceso = Integer.parseInt(request.getParameter("idSubProceso"));
        
        SubProcesoJpaController SubProcesoJPA = new SubProcesoJpaController(EntityProvider.provider());
        
        try{
            int idPF = SubProcesoJPA.findSubProceso(idSubProceso).getIdprocesoFuncional().getIdprocesoFuncional();
            SubProcesoJPA.destroy(idSubProceso);
            HttpSession session = request.getSession(true);
            session.setAttribute("idPF", idPF);
            redireccion = "eliminadoSubProceso.jsp";
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            response.sendRedirect(redireccion);   
        }
    }
}
