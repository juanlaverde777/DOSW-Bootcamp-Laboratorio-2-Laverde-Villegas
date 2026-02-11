package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConversionService {
    private final ConverterFactory factory;

    public ConversionService(ConverterFactory factory) {
        this.factory = factory;
    }

    public ConversionResult convert(TransactionInput input) {
        CurrencyConverter converter = factory.create(input.getSourceCurrency());
        Map<String, BigDecimal> converted = input.getTargetCurrencies().stream()
                .collect(Collectors.toMap(
                        String::toUpperCase,
                        targetCurrency -> converter.convert(input.getAmount(), targetCurrency)
                ));
        return new ConversionResult(input.getAmount(), input.getSourceCurrency(), converted);
    }

    public Map<String, BigDecimal> aggregateTotals(List<ConversionResult> results) {
        Map<String, BigDecimal> totals = new HashMap<>();
        results.forEach(result -> result.getConvertedByCurrency().forEach((currency, amount) ->
                totals.merge(currency, amount, BigDecimal::add)));
        return totals;
    }
}
