
package com.mycompany.casoempresaxyz.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    
    private static final String url = "jdbc:mysql://localhost:3306/xyz";
    private static final String user = "root";
    private static final String password = "admin";
    
    public static Connection getConnection(){
        Connection connection = null;
         try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion establecida");
        }catch(SQLException e){
            System.out.println("Error en la conexion");
            System.err.println(e.getMessage());
        }
        return connection;
    }
    
}
