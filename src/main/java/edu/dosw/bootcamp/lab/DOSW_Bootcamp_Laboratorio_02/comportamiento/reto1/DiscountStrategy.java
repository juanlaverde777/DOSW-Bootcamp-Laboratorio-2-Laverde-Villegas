package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto1;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal calcularDescuento(BigDecimal subtotal);
}
