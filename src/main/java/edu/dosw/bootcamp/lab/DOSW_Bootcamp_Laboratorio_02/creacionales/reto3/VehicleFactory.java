package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto3;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType tipo, Category categoria, Model modelo) {
        int velocidad = 0;
        long precioBase = 0;
        String equipamiento = "Basico";

        switch (modelo) {
            case AUTO:
                velocidad = categoryValue(categoria, 120, 180, 100);
                precioBase = categoryValueLong(categoria, 25_000_000L, 50_000_000L, 15_000_000L);
                equipamiento = (categoria == Category.LUJO) ? "Aire acondicionado + GPS" : "Aire acondicionado";
                return new Car(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case BICICLETA:
                velocidad = 40;
                precioBase = categoryValueLong(categoria, 2_000_000L, 5_000_000L, 500_000L);
                equipamiento = "Sin equipamiento";
                return new Bicycle(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case MOTO:
                velocidad = categoryValue(categoria, 140, 160, 120);
                precioBase = categoryValueLong(categoria, 8_000_000L, 15_000_000L, 5_000_000L);
                equipamiento = "Casco incluido";
                return new Motorcycle(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case LANCHA:
                velocidad = categoryValue(categoria, 80, 120, 60);
                precioBase = categoryValueLong(categoria, 30_000_000L, 70_000_000L, 20_000_000L);
                equipamiento = "Equipo de seguridad";
                return new Boat(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case VELERO:
                velocidad = 50;
                precioBase = categoryValueLong(categoria, 40_000_000L, 90_000_000L, 25_000_000L);
                equipamiento = "Instrumentos de navegación";
                return new Boat(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case JETSKI:
                velocidad = 100;
                precioBase = categoryValueLong(categoria, 10_000_000L, 25_000_000L, 7_000_000L);
                equipamiento = "Equipo de seguridad";
                return new JetSki(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case AVION:
                velocidad = 500;
                precioBase = categoryValueLong(categoria, 120_000_000L, 250_000_000L, 80_000_000L);
                equipamiento = "Instrumentos de vuelo avanzados";
                return new Airplane(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case AVIONETA:
                velocidad = 250;
                precioBase = categoryValueLong(categoria, 60_000_000L, 120_000_000L, 40_000_000L);
                equipamiento = "Instrumentos de vuelo basicos";
                return new Avioneta(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            case HELICOPTERO:
                velocidad = 260;
                precioBase = categoryValueLong(categoria, 90_000_000L, 180_000_000L, 60_000_000L);
                equipamiento = "Instrumentos de vuelo basicos";
                return new Helicopter(tipo, categoria, modelo, velocidad, precioBase, equipamiento);

            default:
                return new Car(tipo, categoria, Model.AUTO, 100, 10_000_000L, "Basico");
        }
    }

    private static int categoryValue(Category cat, int econ, int lujo, int usado) {
        if (cat == Category.ECONOMICO) return econ;
        if (cat == Category.LUJO) return lujo;
        return usado;
    }

    private static long categoryValueLong(Category cat, long econ, long lujo, long usado) {
        if (cat == Category.ECONOMICO) return econ;
        if (cat == Category.LUJO) return lujo;
        return usado;
    }
}
