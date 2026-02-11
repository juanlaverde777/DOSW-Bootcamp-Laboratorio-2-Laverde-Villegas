package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class Chocolate extends ToppingDecorator {
    private static final double PRECIO = 1500.0;
    
    public Chocolate(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Chocolate";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO;
    }
}
