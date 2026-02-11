package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

import java.math.BigDecimal;
import java.util.Objects;

public final class Ingredient {
    private final String nombre;
    private final BigDecimal precio;

    public Ingredient(String nombre, BigDecimal precio) {
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
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio);
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
