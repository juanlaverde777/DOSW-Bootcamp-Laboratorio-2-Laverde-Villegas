package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.estructurales.reto5;

public abstract class ToppingDecorator implements Cafe {
    protected Cafe cafe;
    
    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }
    
    @Override
    public String getDescripcion() {
        return cafe.getDescripcion();
    }
    
    @Override
    public double getPrecio() {
        return cafe.getPrecio();
    }
}
