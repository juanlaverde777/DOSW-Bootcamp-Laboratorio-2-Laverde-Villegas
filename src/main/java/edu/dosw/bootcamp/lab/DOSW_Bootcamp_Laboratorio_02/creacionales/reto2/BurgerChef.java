package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

import java.util.List;

public class BurgerChef {
    public Burger prepararBurger(List<Ingredient> ingredientesSeleccionados) {
        BurgerBuilder builder = new CustomBurgerBuilder();
        ingredientesSeleccionados.forEach(builder::addIngredient);
        return builder.build();
    }
}
