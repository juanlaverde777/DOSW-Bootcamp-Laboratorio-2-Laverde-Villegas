package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;

public interface CurrencyConverter {
    BigDecimal convert(BigDecimal amount, String toCurrency);
}
