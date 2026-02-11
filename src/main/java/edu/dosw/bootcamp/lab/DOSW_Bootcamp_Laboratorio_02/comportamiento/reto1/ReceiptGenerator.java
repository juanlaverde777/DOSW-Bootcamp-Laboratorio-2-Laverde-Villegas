package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class ReceiptGenerator {
    private final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));

    public String generar(Carrito carrito, String tipoCliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RECIBO DE COMPRA =====\n");
        sb.append("Cliente: ").append(tipoCliente).append("\n\n");
        carrito.getItems().forEach(item -> {
            sb.append(item.getProducto().getNombre())
              .append(" x").append(item.getCantidad())
              .append(" -> ").append(format(item.getLineaTotal())).append("\n");
        });
        sb.append("\n");
        BigDecimal subtotal = carrito.getSubtotal();
        BigDecimal descuento = carrito.getDescuento();
        BigDecimal total = carrito.getTotal();
        sb.append("Subtotal: ").append(format(subtotal)).append("\n");
        sb.append("Descuento aplicado: ").append(format(descuento)).append("\n");
        sb.append("Total a pagar: ").append(format(total)).append("\n");
        sb.append("============================\n");
        return sb.toString();
    }

    private String format(BigDecimal value) {
        return nf.format(value);
    }
}
