
package com.mycompany.casoempresaxyz.Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProductoGUI extends JFrame{
  
    private JTextField txtNombre, txtCantidad, txtPrecio;
    private JButton btnRegistrarProducto;
    private final JTextField txtId;

    public ProductoGUI() {
        // Configuración básica de la ventana
        setTitle("Registrar Nuevo Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLocationRelativeTo(null); // Centra la ventana

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Etiquetas y campos de texto
        panel.add(new JLabel("Id:"));
        txtId = new JTextField();
        panel.add(txtId);
        
        panel.add(new JLabel("Nombre del Producto:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Cantidad Inicial:"));
        txtCantidad = new JTextField();
        panel.add(txtCantidad);

        panel.add(new JLabel("Precio de Venta:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        // Botón de registrar producto
        btnRegistrarProducto = new JButton("Registrar Producto");
        panel.add(btnRegistrarProducto);

        // Añadimos el panel a la ventana
        add(panel, BorderLayout.CENTER);
    }

    // Métodos para acceder a los campos
    public String getNombreProducto() {
        return txtNombre.getText();
    }

    public int getCantidadProducto() {
        return Integer.parseInt(txtCantidad.getText());
    }

    public double getPrecioProducto() {
        return Double.parseDouble(txtPrecio.getText());
    }

    // Método para añadir el ActionListener al botón
    public void addRegistrarProductoListener(ActionListener listener) {
        btnRegistrarProducto.addActionListener(listener);
    }
    
    public int getIdProducto(){
        return Integer.parseInt(txtId.getText());
    }
    
}
