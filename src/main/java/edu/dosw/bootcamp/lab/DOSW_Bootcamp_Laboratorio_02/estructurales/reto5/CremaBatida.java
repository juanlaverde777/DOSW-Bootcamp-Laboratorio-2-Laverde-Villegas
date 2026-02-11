package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public class CremaBatida extends ToppingDecorator {
    private static final double PRECIO = 2000.0;
    
    public CremaBatida(Cafe cafe) {
        super(cafe);
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion() + " + Crema Batida";
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio() + PRECIO;
    }
}
