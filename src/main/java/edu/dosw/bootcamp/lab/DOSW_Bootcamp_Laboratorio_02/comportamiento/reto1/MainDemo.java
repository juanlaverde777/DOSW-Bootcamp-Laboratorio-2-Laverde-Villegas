package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;

public class MainDemo {
    public static void main(String[] args) {
        Producto camiseta = new Producto("Camiseta", BigDecimal.valueOf(20000));
        Producto pantalon = new Producto("Pantalon", BigDecimal.valueOf(50000));
        Producto galletas = new Producto("Galletas", BigDecimal.valueOf(500));
        Producto jugo = new Producto("Jugo Natural", BigDecimal.valueOf(3000));

        Carrito carrito = new Carrito(new DiscountFrecuente());
        carrito.addProducto(camiseta, 2);
        carrito.addProducto(galletas, 3);
        carrito.addProducto(jugo, 5);

        ReceiptGenerator rg = new ReceiptGenerator();
        System.out.println(rg.generar(carrito, "Frecuente"));

        Carrito carrito2 = new Carrito(new DiscountNuevo());
        carrito2.addProducto(camiseta, 1);
        carrito2.addProducto(pantalon, 1);
        System.out.println(rg.generar(carrito2, "Nuevo"));
    }
}
