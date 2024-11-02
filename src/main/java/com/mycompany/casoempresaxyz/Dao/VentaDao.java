
package com.mycompany.casoempresaxyz.Dao;

import com.mycompany.casoempresaxyz.Modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    private Connection connection;

    public VentaDao(Connection connection) {
        this.connection = connection;
    }

    // Registrar una venta
    public void registrarVenta(Venta venta) throws SQLException {
        String query = "INSERT INTO Ventas (id_venta, fecha, id_producto, cantidad, precio_venta) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setInt(1, venta.getId_venta());
            stmt.setDate(2, Date.valueOf(venta.getFecha()));
            stmt.setInt(3, venta.getId_producto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setDouble(5, venta.getPrecio_venta());
            stmt.executeUpdate();
        }
    }

    // Obtener venta por ID
    public Venta obtenerVentaPorId(int idVenta) throws SQLException {
        String query = "SELECT * FROM Ventas WHERE id_venta = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVenta);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Venta(
                        rs.getInt("id_venta"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_venta")
                    );
                }
            }
        }
        return null;
    }

    // Listar todas las ventas
    public List<Venta> listarVentas() throws SQLException {
        List<Venta> ventas = new ArrayList<>();
        String query = "SELECT * FROM Ventas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ventas.add(new Venta(
                    rs.getInt("id_venta"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getInt("id_producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_venta")
                ));
            }
        }
        return ventas;
    }
}
