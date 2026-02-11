package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;
import java.util.Objects;

public final class Producto {
    private final String nombre;
    private final BigDecimal precio;

    public Producto(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public String toString() {
        return nombre + " - " + precio;
    }
}
