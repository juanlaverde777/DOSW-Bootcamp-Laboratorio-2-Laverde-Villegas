package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ChefApp {
    private static final int OPCION_PERSONALIZADA = 7;
    private static final Map<Integer, Ingredient> MENU = crearMenuBase();
    private static final NumberFormat FORMATO = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mostrarMenu();
        List<Integer> selecciones = leerSelecciones(scanner);
        List<Ingredient> ingredientes = construirIngredientes(selecciones, scanner);

        Burger burger = new BurgerChef().prepararBurger(ingredientes);
        imprimirResultado(burger);
    }

    private static Map<Integer, Ingredient> crearMenuBase() {
        Map<Integer, Ingredient> menu = new LinkedHashMap<>();
        menu.put(1, new Ingredient("Pan", BigDecimal.valueOf(3000)));
        menu.put(2, new Ingredient("Carne", BigDecimal.valueOf(10000)));
        menu.put(3, new Ingredient("Queso", BigDecimal.valueOf(5000)));
        menu.put(4, new Ingredient("Lechuga", BigDecimal.valueOf(2000)));
        menu.put(5, new Ingredient("Tomate", BigDecimal.valueOf(2000)));
        menu.put(6, new Ingredient("Salsa especial", BigDecimal.valueOf(3000)));
        return menu;
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione ingredientes para su hamburguesa:");
        MENU.forEach((opcion, ingrediente) ->
                System.out.println(opcion + ". " + ingrediente.getNombre() + " (" + FORMATO.format(ingrediente.getPrecio()) + ")"));
        System.out.println(OPCION_PERSONALIZADA + ". Agregar un nuevo ingrediente");
        System.out.print("Ingrese los numeros separados por coma: ");
    }

    private static List<Integer> leerSelecciones(Scanner scanner) {
        String entrada = scanner.nextLine();
        return Arrays.stream(entrada.split(","))
                .map(String::trim)
                .filter(valor -> !valor.isEmpty())
                .map(ChefApp::parsearEntero)
                .filter(Objects::nonNull)
                .toList();
    }

    private static Integer parsearEntero(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException ex) {
            System.out.println("Opcion invalida ignorada: " + valor);
            return null;
        }
    }

    private static List<Ingredient> construirIngredientes(List<Integer> selecciones, Scanner scanner) {
        List<Ingredient> ingredientes = new ArrayList<>();
        for (Integer seleccion : selecciones) {
            if (seleccion == null) continue;
            if (seleccion == OPCION_PERSONALIZADA) {
                ingredientes.add(leerIngredientePersonalizado(scanner));
                continue;
            }
            Ingredient base = MENU.get(seleccion);
            if (base != null) {
                ingredientes.add(base);
            }
        }
        return ingredientes;
    }

    private static Ingredient leerIngredientePersonalizado(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo ingrediente: ");
        String nombre = scanner.nextLine().trim();
        BigDecimal precio = leerPrecio(scanner);
        return new Ingredient(nombre, precio);
    }

    private static BigDecimal leerPrecio(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el precio del ingrediente: ");
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                return new BigDecimal(entrada);
            } catch (NumberFormatException ex) {
                System.out.println("Precio invalido, intente de nuevo.");
            }
        }
    }

    private static void imprimirResultado(Burger burger) {
        System.out.println("\n--- HAMBURGUESA PERSONALIZADA ---");
        if (burger.getIngredientes().isEmpty()) {
            System.out.println("Sin ingredientes seleccionados");
        } else {
            System.out.println("Ingredientes seleccionados: " + burger.listarIngredientes());
        }
        System.out.println("Precio total: " + FORMATO.format(burger.calcularPrecioTotal()));
        System.out.println("--------------------------------");
        System.out.println("¡Disfrute su hamburguesa!");
    }
}
