package domain;

import dao.Identified;

/**
 * Created by Andriana on 16.10.2016.
 */
public class IngredientsInSalad implements Identified<Integer> {
    private Integer id;
    private Integer weight;
    private Salad salad;
    private Ingredient ingredient;

    @Override
    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(int id) {
        this.weight = weight;
    }
    public Salad getSaladId() {
        return salad;
    }
    public void setSaladId(Salad salad) {
        this.salad = salad;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

}
