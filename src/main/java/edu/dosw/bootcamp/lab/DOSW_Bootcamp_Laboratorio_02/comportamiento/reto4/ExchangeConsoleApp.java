package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.comportamiento.reto4;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExchangeConsoleApp {
    private static final DecimalFormat DF;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DF = new DecimalFormat("#,##0.00");
        DF.setDecimalFormatSymbols(symbols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversionService service = new ConversionService(new ConverterFactory());

        System.out.print("Ingrese numero de transacciones: ");
        int cantidad = leerEntero(scanner);
        List<TransactionInput> transacciones = new ArrayList<>();

        IntStream.rangeClosed(1, cantidad).forEach(idx -> {
            System.out.println("\n---- Transaccion " + idx + " ----");
            BigDecimal monto = leerMonto(scanner);
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String origen = scanner.nextLine().trim().toUpperCase();
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            List<String> destinos = leerDestinos(scanner);
            transacciones.add(new TransactionInput(monto, origen, destinos));
        });

        List<ConversionResult> resultados = transacciones.stream()
                .map(service::convert)
                .toList();

        imprimirResultados(resultados, service.aggregateTotals(resultados));
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException ex) {
                System.out.print("Numero invalido, intente de nuevo: ");
            }
        }
    }

    private static BigDecimal leerMonto(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese monto: ");
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                return new BigDecimal(entrada);
            } catch (NumberFormatException ex) {
                System.out.println("Monto invalido, intente de nuevo.");
            }
        }
    }

    private static List<String> leerDestinos(Scanner scanner) {
        String entrada = scanner.nextLine();
        return Arrays.stream(entrada.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(String::toUpperCase)
                .toList();
    }

    private static void imprimirResultados(List<ConversionResult> resultados, Map<String, BigDecimal> totales) {
        IntStream.range(0, resultados.size()).forEach(idx -> {
            ConversionResult result = resultados.get(idx);
            System.out.println("\nTransaccion " + (idx + 1) + ": " + DF.format(result.getOriginalAmount()) + " " + result.getOriginalCurrency());
            result.getConvertedByCurrency().forEach((currency, amount) ->
                    System.out.println("Convertido a " + currency + ": " + DF.format(amount) + " " + currency));
        });

        System.out.println("\n---- Totales por moneda ----");
        totales.forEach((currency, amount) ->
                System.out.println(currency + ": " + DF.format(amount) + " " + currency));
    }
}
