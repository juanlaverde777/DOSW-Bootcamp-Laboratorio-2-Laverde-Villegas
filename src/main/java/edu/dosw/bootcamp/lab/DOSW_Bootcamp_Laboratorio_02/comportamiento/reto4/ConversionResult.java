package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;
import java.util.Map;

public class ConversionResult {
    private final BigDecimal originalAmount;
    private final String originalCurrency;
    private final Map<String, BigDecimal> convertedByCurrency;

    public ConversionResult(BigDecimal originalAmount, String originalCurrency, Map<String, BigDecimal> convertedByCurrency) {
        this.originalAmount = originalAmount;
        this.originalCurrency = originalCurrency;
        this.convertedByCurrency = Map.copyOf(convertedByCurrency);
    }

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public Map<String, BigDecimal> getConvertedByCurrency() {
        return convertedByCurrency;
    }
}
