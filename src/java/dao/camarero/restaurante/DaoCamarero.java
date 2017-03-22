/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.camarero.restaurante;

import Utilidades.ConexionRestaurante;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martaperal
 */

//CRUD
public class DaoCamarero {
    
    public static void insertarCamarero(String idCamarero,String nombre,String apellido) throws SQLException, ClassNotFoundException{
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
    consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "')";
    int filas=sentencia.executeUpdate(consultaSQL);
    System.out.println("Numero de filas insertadas: "+filas);
    sentencia.close();
    ConexionRestaurante.cerrarConexion();
   //conexion.close();
    
}
    
    
    public static ResultSet verCamareros() throws ClassNotFoundException, SQLException{
    
      Connection conexion=ConexionRestaurante.conexionRestaurante();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idcamarero,nombre,apellido from camarero";
      ResultSet lista_camareros=sentencia.executeQuery(consultaSQL);
      ConexionRestaurante.cerrarConexion();
     return lista_camareros;
    
}
    //pasara a ser clase de negocio
    public static void procesarPeticionCamarero(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
    //orientacion a objetos
    Camarero camarero=new Camarero();
    camarero.setIdCamarero(request.getParameter("idcamarero"));
    camarero.setNombre(request.getParameter("nombre"));
    camarero.setApellido("apellido");
    insertarCamarero(camarero.getIdCamarero(), camarero.getNombre(), camarero.getApellido());
    response.sendRedirect("/Restaurante/mostrarServletCamarero");
     

}
    
    //fatan metodos update & delete
    
}
