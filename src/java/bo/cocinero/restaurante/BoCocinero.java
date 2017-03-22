/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.cocinero.restaurante;

import dao.cocinero.restaurante.DaoCocinero;
import static dao.cocinero.restaurante.DaoCocinero.insertarCocinero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoCocinero {
    
    
    public static void procesarPeticionInsertarCocinero(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
    
    Cocinero masterChef=new Cocinero();
    masterChef.setIdCocinero(Integer.parseInt(request.getParameter("idcocinero")));
    masterChef.setNombre(request.getParameter("nombre"));
    masterChef.setApellido(request.getParameter("apellido"));
    DaoCocinero.insertarCocinero(masterChef.getIdCocinero(), masterChef.getNombre(), masterChef.getApellido());
    response.sendRedirect("/Restaurante/mostrarServletCocinero");
    
    
}
}
