package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;
import java.util.List;

public class TransactionInput {
    private final BigDecimal amount;
    private final String sourceCurrency;
    private final List<String> targetCurrencies;

    public TransactionInput(BigDecimal amount, String sourceCurrency, List<String> targetCurrencies) {
        this.amount = amount;
        this.sourceCurrency = sourceCurrency.toUpperCase();
        this.targetCurrencies = List.copyOf(targetCurrencies);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public List<String> getTargetCurrencies() {
        return targetCurrencies;
    }
}
