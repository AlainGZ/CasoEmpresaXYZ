
package com.mycompany.casoempresaxyz.Dao;

import com.mycompany.casoempresaxyz.Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductoDao {
    private Connection connection;

    public ProductoDao(Connection connection) {
        this.connection = connection;
    }

    // Agregar un producto
    public void agregarProducto(Producto producto) throws SQLException {
        String query = "INSERT INTO Productos (id_producto, nombre, precio_venta, cantidad_disponible) VALUES (?,?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, producto.getId_producto());
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecio_venta());
            stmt.setInt(4, producto.getCantidad_disponible());
            stmt.executeUpdate();
        }
    }

    // Obtener producto por ID
    public Producto obtenerProductoPorId(int idProducto) throws SQLException {
        String query = "SELECT * FROM Productos WHERE id_producto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("cantidad_disponible")
                    );
                }
            }
        }
        return null;
    }

    // Actualizar producto
    public void actualizarProducto(Producto producto) throws SQLException {
        String query = "UPDATE Productos SET nombre = ?, precio_venta = ?, cantidad_disponible = ? WHERE id_producto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio_venta());
            stmt.setInt(3, producto.getCantidad_disponible());
            stmt.setInt(4, producto.getId_producto());
            stmt.executeUpdate();
        }
    }

    // Eliminar producto
    public void eliminarProducto(int idProducto) throws SQLException {
        String query = "DELETE FROM Productos WHERE id_producto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            stmt.executeUpdate();
        }
    }

    // Listar todos los productos
    public List<Producto> listarProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Productos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio_venta"),
                    rs.getInt("cantidad_disponible")
                ));
            }
        }
        return productos;
    }
}
