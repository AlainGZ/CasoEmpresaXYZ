
package com.mycompany.casoempresaxyz.Controlador;

import com.mycompany.casoempresaxyz.Dao.ProductoDao;
import com.mycompany.casoempresaxyz.Modelo.Producto;
import com.mycompany.casoempresaxyz.Vista.ProductoGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ProductoControlador {
    
    private ProductoGUI vista;
    private ProductoDao productoDao;

    public ProductoControlador(ProductoGUI vista, ProductoDao productoDao) {
        this.vista = vista;
        this.productoDao = productoDao;

        // Añadir ActionListener al botón de registrar producto
        this.vista.addRegistrarProductoListener((ActionListener) new RegistrarProductoListener());
    }

    // Listener para manejar el evento del botón
    class RegistrarProductoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idProducto = vista.getIdProducto();
                String nombre = vista.getNombreProducto();
                int cantidad = vista.getCantidadProducto();
                double precio = vista.getPrecioProducto();

                // Crear objeto Producto
                Producto producto = new Producto(idProducto, nombre, cantidad, (int) precio);

                // Insertar en la base de datos
                productoDao.agregarProducto(producto);

                // Mensaje de éxito
                JOptionPane.showMessageDialog(vista, "Producto registrado correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al registrar el producto: " + ex.getMessage());
            }
        }
    }
}

