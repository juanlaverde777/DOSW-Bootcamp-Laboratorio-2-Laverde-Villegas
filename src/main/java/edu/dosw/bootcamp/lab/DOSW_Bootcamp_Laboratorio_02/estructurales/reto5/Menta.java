package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class Menta extends ToppingDecorator {
    private static final double PRECIO = 1300.0;
    
    public Menta(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Menta";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO;
    }
}
