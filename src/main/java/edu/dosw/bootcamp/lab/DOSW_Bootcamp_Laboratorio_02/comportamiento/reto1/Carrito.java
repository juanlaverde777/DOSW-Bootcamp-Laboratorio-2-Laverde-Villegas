package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private final List<CartItem> items = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public Carrito(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addProducto(Producto p, int cantidad) {
        items.add(new CartItem(p, cantidad));
    }

    public void removeProducto(int index) {
        if (index >= 0 && index < items.size()) items.remove(index);
    }

    public List<CartItem> getItems() {
        return List.copyOf(items);
    }

    public BigDecimal getSubtotal() {
        return items.stream()
                .map(CartItem::getLineaTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getDescuento() {
        return discountStrategy.calcularDescuento(getSubtotal());
    }

    public BigDecimal getTotal() {
        return getSubtotal().subtract(getDescuento());
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }
}
