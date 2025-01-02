
package com.mycompany.casoempresaxyz.Main;

import com.mycompany.casoempresaxyz.Controlador.ConexionBD;
import com.mycompany.casoempresaxyz.Controlador.ProductoControlador;
import com.mycompany.casoempresaxyz.Controlador.VentaControlador;
import com.mycompany.casoempresaxyz.Dao.ProductoDao;
import com.mycompany.casoempresaxyz.Dao.VentaDao;
import com.mycompany.casoempresaxyz.Vista.ProductoGUI;
import com.mycompany.casoempresaxyz.Vista.VentaGUI;
import java.sql.Connection;


public class Main {
 
     public static void main(String[] args) {
        // Obtener la conexión a la base de datos llamando la clase ConexionDB 
        Connection connection = ConexionBD.getConnection();
        
        if (connection == null) {
            System.err.println("Error al obtener la conexión a la base de datos.");
            return; // Salir si no se pudo obtener la conexión
        }
        
        // Pasar esa conexión a los DAOs
        VentaDao ventaDao = new VentaDao(connection);
        ProductoDao productoDao = new ProductoDao(connection);

        // Crear las interfaces gráficas
        VentaGUI ventaGUI = new VentaGUI();
        ProductoGUI productoGUI = new ProductoGUI();

        // Crear los controladores
        VentaControlador ventaControlador = new VentaControlador(ventaGUI, ventaDao);
        ProductoControlador productoControlador = new ProductoControlador(productoGUI, productoDao);

        // Mostrar ambas ventanas
        ventaGUI.setVisible(true);
        productoGUI.setVisible(true);
    }
    
}
