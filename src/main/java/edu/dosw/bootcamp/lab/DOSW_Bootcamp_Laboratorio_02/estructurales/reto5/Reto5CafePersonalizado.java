package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reto5CafePersonalizado {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Cafe> cafes = new ArrayList<>();
    
    public static void ejecutar() {
        System.out.println("\n=== ☕ CAFETERÍA CREATIVA ☕ ===\n");
        
        System.out.print("Número de cafés a personalizar: ");
        int numeroCafes = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 1; i <= numeroCafes; i++) {
            System.out.println("\n--- Café " + i + " ---");
            Cafe cafe = crearCafe();
            cafes.add(cafe);
        }
        
        mostrarResumen();
    }
    
    private static Cafe crearCafe() {
        Cafe cafe = new CafeBase();
        boolean agregarMas = true;
        
        while (agregarMas) {
            mostrarMenuToppings();
            
            System.out.print("Seleccione toppings (números separados por coma): ");
            String input = scanner.nextLine();
            
            String[] opciones = input.split(",");
            
            for (String opcion : opciones) {
                int seleccion = Integer.parseInt(opcion.trim());
                cafe = agregarTopping(cafe, seleccion);
            }
            
            agregarMas = false;
        }
        
        return cafe;
    }
    
    private static void mostrarMenuToppings() {
        System.out.println("\nLista de toppings disponibles (ejemplo)");
        System.out.println("Opción\t\tTopping\t\t\tPrecio");
        System.out.println("1\t\tLeche\t\t\t$1,000");
        System.out.println("2\t\tChocolate\t\t$1,500");
        System.out.println("3\t\tCaramelo\t\t$1,200");
        System.out.println("4\t\tCrema Batida\t\t$2,000");
        System.out.println("5\t\tMenta\t\t\t$1,300");
        System.out.println("6\t\tAgregar nuevo topping\tPrecio personalizado");
        System.out.println();
    }
    
    private static Cafe agregarTopping(Cafe cafe, int opcion) {
        switch (opcion) {
            case 1:
                return new Leche(cafe);
            case 2:
                return new Chocolate(cafe);
            case 3:
                return new Caramelo(cafe);
            case 4:
                return new CremaBatida(cafe);
            case 5:
                return new Menta(cafe);
            case 6:
                System.out.print("Ingrese nombre del nuevo topping: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese precio del topping: ");
                double precio = scanner.nextDouble();
                scanner.nextLine(); 
                return new ToppingPersonalizado(cafe, nombre, precio);
            default:
                System.out.println("Opción inválida. No se agregó topping.");
                return cafe;
        }
    }
    
    private static void mostrarResumen() {
        System.out.println("\n--- RESUMEN DE CAFÉ PERSONALIZADO ---\n");
        
        for (int i = 0; i < cafes.size(); i++) {
            Cafe cafe = cafes.get(i);
            System.out.println("Café " + (i + 1) + ":");
            System.out.println("Ingredientes: " + cafe.getDescripcion());
            System.out.printf("Precio total: $%.0f%n", cafe.getPrecio());
            System.out.println();
        }
        
        double totalGeneral = cafes.stream()
                .mapToDouble(Cafe::getPrecio)
                .sum();
        
        System.out.println("-----------------------------------");
        System.out.printf("Total a pagar por todos los cafés: $%.0f%n", totalGeneral);
        System.out.println("¡Disfrute su café!");
    }
}
