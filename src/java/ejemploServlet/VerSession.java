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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Este servlet recupera la session
public class VerSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //tenemos que recuperar la sesion
        HttpSession misession = (HttpSession) request.getSession();
// A través del atributo del objeto session recuperamos el valor, que 
        //en este caso es un objeto. 
        Camarero miCamarero = (Camarero) misession.getAttribute("ejemploSesion");

        PrintWriter pw = response.getWriter();
        pw.println("<html><body>" + miCamarero.getIdCamarero()+ "," + miCamarero.getNombre() + "," + miCamarero.getApellido());
        pw.println("<h2>"+misession.getCreationTime()+"</h2>");
        pw.println("<h2>"+misession.isNew()+"</h2>");
        pw.println("<h2>"+misession.getLastAccessedTime()+"</h2>");
        pw.println("<h2>"+misession.getId()+"</h2>");
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
