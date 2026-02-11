package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationReto3 {
    private static final DecimalFormat DF = new DecimalFormat("#,###");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> carrito = new ArrayList<>();
        boolean seguir = true;

        System.out.println("Bienvenido al Reino de los Vehículos!");

        while (seguir) {
            VehicleType tipo = seleccionarTipo(sc);
            Category categoria = seleccionarCategoria(sc);
            Model modelo = seleccionarModeloPorTipo(sc, tipo);

            Vehicle v = VehicleFactory.createVehicle(tipo, categoria, modelo);
            carrito.add(v);
            System.out.println("Vehículo agregado al carrito.\n");

            System.out.print("¿Desea agregar otro vehículo? (si/no): ");
            String r = sc.nextLine().trim().toLowerCase();
            seguir = r.equals("si") || r.equals("s");
            System.out.println();
        }

   
        System.out.println("\n--- RESUMEN DE COMPRA ---");
        int i = 1;
        for (Vehicle v : carrito) {
            System.out.println("Vehículo " + (i++));
            System.out.println(v.toString());
            System.out.println();
        }

        long subtotal = carrito.stream().mapToLong(Vehicle::getPrecio).sum();
        double descuento = (subtotal > 200_000_000L) ? subtotal * 0.05 : 0.0;
        double total = subtotal - descuento;

        System.out.println("Subtotal: " + DF.format(subtotal));
        System.out.println("Descuento aplicado: " + DF.format((long)descuento));
        System.out.println("Total a pagar: " + DF.format((long)total));
        System.out.println("\n¡Gracias por su compra en El Reino de los Vehículos!");
    }

    private static VehicleType seleccionarTipo(Scanner sc) {
        while (true) {
            System.out.println("Seleccione el tipo de vehículo:");
            System.out.println("1) Tierra  2) Acuático  3) Aéreo");
            System.out.print("Ingrese opción: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": return VehicleType.TIERRA;
                case "2": return VehicleType.ACUATICO;
                case "3": return VehicleType.AEREO;
                default: System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static Category seleccionarCategoria(Scanner sc) {
        while (true) {
            System.out.println("Seleccione la categoría del vehículo:");
            System.out.println("1) Económico  2) Lujo  3) Usado");
            System.out.print("Ingrese opción: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": return Category.ECONOMICO;
                case "2": return Category.LUJO;
                case "3": return Category.USADO;
                default: System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static Model seleccionarModeloPorTipo(Scanner sc, VehicleType tipo) {
        while (true) {
            System.out.println("Seleccione el modelo del vehículo:");
            if (tipo == VehicleType.TIERRA) {
                System.out.println("1) Auto  2) Bicicleta  3) Moto");
                System.out.print("Ingrese opción: ");
                String opt = sc.nextLine().trim();
                switch (opt) {
                    case "1": return Model.AUTO;
                    case "2": return Model.BICICLETA;
                    case "3": return Model.MOTO;
                    default: System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else if (tipo == VehicleType.ACUATICO) {
                System.out.println("1) Lancha  2) Velero  3) JetSki");
                System.out.print("Ingrese opción: ");
                String opt = sc.nextLine().trim();
                switch (opt) {
                    case "1": return Model.LANCHA;
                    case "2": return Model.VELERO;
                    case "3": return Model.JETSKI;
                    default: System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else { // AEREO
                System.out.println("1) Avión  2) Avioneta  3) Helicóptero");
                System.out.print("Ingrese opción: ");
                String opt = sc.nextLine().trim();
                switch (opt) {
                    case "1": return Model.AVION;
                    case "2": return Model.AVIONETA;
                    case "3": return Model.HELICOPTERO;
                    default: System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
        }
    }
}
