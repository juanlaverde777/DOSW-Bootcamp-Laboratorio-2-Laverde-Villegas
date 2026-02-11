package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class ToppingPersonalizado extends ToppingDecorator {
    private String nombre;
    private double precio;
    
    public ToppingPersonalizado(Cafe cafe, String nombre, double precio) {
        super(cafe);
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + " + nombre;
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + precio;
    }
}
