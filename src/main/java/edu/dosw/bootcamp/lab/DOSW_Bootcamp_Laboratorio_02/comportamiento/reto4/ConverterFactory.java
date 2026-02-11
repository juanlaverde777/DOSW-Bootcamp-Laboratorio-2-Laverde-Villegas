package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

public class ConverterFactory {
    public CurrencyConverter create(String fromCurrency) {
        return new BaseRateConverter(fromCurrency);
    }
}
