package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto3;

public abstract class Vehicle {
    protected VehicleType tipo;
    protected Category categoria;
    protected Model modelo;
    protected int velocidadMaxima; 
    protected long precio; 
    protected String equipamiento;

    public Vehicle(VehicleType tipo, Category categoria, Model modelo, int velocidadMaxima, long precio, String equipamiento) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.precio = precio;
        this.equipamiento = equipamiento;
    }

    public VehicleType getTipo() { return tipo; }
    public Category getCategoria() { return categoria; }
    public Model getModelo() { return modelo; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public long getPrecio() { return precio; }
    public String getEquipamiento() { return equipamiento; }

    @Override
    public String toString() {
        return String.format("Tipo: %s%nCategoria: %s%nVelocidad maxima: %d km/h%nPrecio: %,d%nEquipamiento: %s",
                tipo.name(), categoria.name(), velocidadMaxima, precio, equipamiento);
    }
}
