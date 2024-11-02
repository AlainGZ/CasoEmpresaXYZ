
package com.mycompany.casoempresaxyz.Modelo;

import java.sql.Date;
import java.time.LocalDate;


public class Venta {
    
private int id_venta;
private LocalDate fecha;
private int id_producto;
private int cantidad;
private double precio_venta;

    public Venta(int id_venta, LocalDate fecha, int id_producto, int cantidad, double precio_venta) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }


    
}
