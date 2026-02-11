package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public final class Burger {
    private final List<Ingredient> ingredientes;

    public Burger(List<Ingredient> ingredientes) {
        this.ingredientes = List.copyOf(ingredientes);
    }

    public List<Ingredient> getIngredientes() {
        return ingredientes;
    }

    public BigDecimal calcularPrecioTotal() {
        return ingredientes.stream()
                .map(Ingredient::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String listarIngredientes() {
        return ingredientes.stream()
                .map(Ingredient::getNombre)
                .collect(Collectors.joining(", "));
    }
}
