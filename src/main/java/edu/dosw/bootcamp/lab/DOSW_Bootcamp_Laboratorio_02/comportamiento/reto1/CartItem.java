package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;

public final class CartItem {
    private final Producto producto;
    private final int cantidad;

    public CartItem(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getLineaTotal() {
        return producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
    }
}
