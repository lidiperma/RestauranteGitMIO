/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploServlet;

import entidades.Camarero;
import entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreaSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Creamos una sesion y a la asociamos al usuario
        //En la sesion se guardan objetos, listas, variables
        
        HttpSession sesionRestaurante=request.getSession(true);

        Camarero ultimo_camarero=new Camarero();
        ultimo_camarero.setIdCamarero("1");
        ultimo_camarero.setNombre("josefff");
        ultimo_camarero.setApellido("warner");
        
     
        
          //coloca el objeto en la session
        sesionRestaurante.setAttribute("ejemploSesion", ultimo_camarero);
       
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session");
        pw.println("<h2>"+sesionRestaurante.isNew()+"</h2>");
        pw.close();
    }


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
