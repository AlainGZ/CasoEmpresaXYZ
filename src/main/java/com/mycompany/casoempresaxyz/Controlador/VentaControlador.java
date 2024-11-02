
package com.mycompany.casoempresaxyz.Controlador;

import com.mycompany.casoempresaxyz.Dao.VentaDao;
import com.mycompany.casoempresaxyz.Modelo.Venta;
import com.mycompany.casoempresaxyz.Vista.VentaGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class VentaControlador {
    
    private VentaGUI vista;
    private VentaDao ventaDao;

    public VentaControlador(VentaGUI vista, VentaDao ventaDao) {
        this.vista = vista;
        this.ventaDao = ventaDao;

        // Añadir ActionListener al botón de registrar venta
        this.vista.addRegistrarVentaListener((ActionListener) new RegistrarVentaListener());
    }

    // Listener para manejar el evento del botón
    class RegistrarVentaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idVenta = vista.getIdVenta();
                int idProducto = vista.getIdProducto();
                int cantidad = vista.getCantidad();
                double precio = vista.getPrecio();
                LocalDate fecha = LocalDate.now(); // Fecha actual

                // Crear objeto Venta
                Venta venta = new Venta(idVenta, fecha, idProducto, cantidad, precio);

                // Insertar en la base de datos
                ventaDao.registrarVenta(venta);

                // Mensaje de éxito
                JOptionPane.showMessageDialog(vista, "Venta registrada correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vista, "Error al registrar la venta: " + ex.getMessage());
            }
        }
    }
    
}
