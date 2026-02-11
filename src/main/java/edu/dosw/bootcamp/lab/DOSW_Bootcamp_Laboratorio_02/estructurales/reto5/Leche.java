package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class Leche extends ToppingDecorator {
    private static final double PRECIO = 1000.0;
    
    public Leche(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Leche";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO;
    }
}
