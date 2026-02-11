package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class BaseRateConverter implements CurrencyConverter {
    private static final Map<String, BigDecimal> USD_PER_UNIT = Map.of(
            "USD", BigDecimal.valueOf(1.0),
            "EUR", BigDecimal.valueOf(1.10),
            "JPY", BigDecimal.valueOf(0.0066667),
            "COP", BigDecimal.valueOf(0.00025)
    );

    private final String fromCurrency;

    public BaseRateConverter(String fromCurrency) {
        this.fromCurrency = fromCurrency.toUpperCase();
    }

    @Override
    public BigDecimal convert(BigDecimal amount, String toCurrency) {
        String target = toCurrency.toUpperCase();
        BigDecimal fromRate = USD_PER_UNIT.get(fromCurrency);
        BigDecimal toRate = USD_PER_UNIT.get(target);
        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Moneda no soportada: " + fromCurrency + " o " + target);
        }
        BigDecimal amountInUsd = amount.multiply(fromRate);
        return amountInUsd.divide(toRate, 4, RoundingMode.HALF_UP);
    }
}
