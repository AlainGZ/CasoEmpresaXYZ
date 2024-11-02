
package com.mycompany.casoempresaxyz.Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentaGUI extends JFrame {
    private JTextField txtIdProducto, txtCantidad, txtPrecio;
    private JButton btnRegistrarVenta;
    private final JTextField txtIdVenta;

    public VentaGUI() {
        // Configuración básica de la ventana
        setTitle("Registrar Venta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLocationRelativeTo(null); // Centra la ventana

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Etiquetas y campos de texto
        panel.add(new JLabel("ID venta:"));
        txtIdVenta = new JTextField();
        panel.add(txtIdVenta);
        
        panel.add(new JLabel("ID Producto:"));
        txtIdProducto = new JTextField();
        panel.add(txtIdProducto);

        panel.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panel.add(txtCantidad);

        panel.add(new JLabel("Precio de Venta:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        // Botón de registrar venta
        btnRegistrarVenta = new JButton("Registrar Venta");
        panel.add(btnRegistrarVenta);

        // Añadimos el panel a la ventana
        add(panel, BorderLayout.CENTER);
    }

    // Métodos para acceder a los campos
    public int getIdProducto() {
        return Integer.parseInt(txtIdProducto.getText());
    }

    public int getCantidad() {
        return Integer.parseInt(txtCantidad.getText());
    }

    public double getPrecio() {
        return Double.parseDouble(txtPrecio.getText());
    }

    // Método para añadir el ActionListener al botón
    public void addRegistrarVentaListener(ActionListener listener) {
        btnRegistrarVenta.addActionListener(listener);
    }

    public int getIdVenta() {
    return Integer.parseInt(txtIdVenta.getText());
    }
    
}
