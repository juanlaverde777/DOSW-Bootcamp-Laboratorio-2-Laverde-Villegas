package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;

public class DiscountNuevo implements DiscountStrategy {
    @Override
    public BigDecimal calcularDescuento(BigDecimal subtotal) {
        return subtotal.multiply(BigDecimal.valueOf(0.05));
    }
}
