package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class Caramelo extends ToppingDecorator {
    private static final double PRECIO = 1200.0;
    
    public Caramelo(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Caramelo";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO;
    }
}
