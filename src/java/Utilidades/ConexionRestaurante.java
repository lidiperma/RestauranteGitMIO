
package Utilidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public  class ConexionRestaurante {

private static Connection conexion;

//este metodo devuelve un objeto de tipo conexion
public static Connection conexionRestaurante() throws ClassNotFoundException, SQLException{
    
    String classname="com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/resturante";
    String user = "root";
    String password = "root";
    
   Class.forName(classname);
   conexion=DriverManager.getConnection(url,user,password);
    
    if(conexion !=null){
        
        System.out.println("Conexion establecida");
    } else{
        
        System.out.println("Conexion abortada");
    }
    return conexion;
}



public static  void cerrarConexion() throws ClassNotFoundException, SQLException{

    if(conexion !=null){
    conexion.close();
    System.out.println("Conexion Cerrada");
   }else{
      System.out.println("Se ha producido un error");  
    }
     
}
}
