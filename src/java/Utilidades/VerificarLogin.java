/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author martaperal
 */
public class VerificarLogin {
    
    public static boolean comprobarLogin(String usuario,String password) throws ClassNotFoundException, SQLException{
       
      //esta variable no hace nada
        String pruebaGit2;  
        String prueba2;
        boolean nRegistro = false;
        String sql="select * from logeados where usuario='"+usuario+"' AND password='"+password+"'";
        Connection con=ConexionRestaurante.conexionRestaurante();
        PreparedStatement comprobarLogin=con.prepareStatement(sql);
        
        ResultSet rs=comprobarLogin.executeQuery(sql);
       
       if(rs.next()){
          // si devuelve resultados el login es correcto 
          nRegistro=true;
          
       }
        
        return nRegistro;
        
    }   
    
}
        