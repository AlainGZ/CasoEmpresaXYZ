
package com.mycompany.casoempresaxyz.Modelo;

public class Producto {
    
private int id_producto;
private String nombre;
private double precio_venta;
private int cantidad_disponible;

    public Producto(int id_producto, String nombre, double precio_venta, int cantidad_disponible) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }


    
}
