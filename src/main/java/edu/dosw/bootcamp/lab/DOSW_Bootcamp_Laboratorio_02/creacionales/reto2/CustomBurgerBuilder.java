package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

import java.util.ArrayList;
import java.util.List;

public class CustomBurgerBuilder implements BurgerBuilder {
    private final List<Ingredient> ingredientes = new ArrayList<>();

    @Override
    public BurgerBuilder addIngredient(Ingredient ingredient) {
        ingredientes.add(ingredient);
        return this;
    }

    @Override
    public Burger build() {
        return new Burger(ingredientes);
    }
}
