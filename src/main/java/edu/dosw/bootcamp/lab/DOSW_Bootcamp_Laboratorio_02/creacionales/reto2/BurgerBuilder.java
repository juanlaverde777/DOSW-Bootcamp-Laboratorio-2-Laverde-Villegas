package edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.creacionales.reto2;

public interface BurgerBuilder {
    BurgerBuilder addIngredient(Ingredient ingredient);
    Burger build();
}
