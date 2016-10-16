package mentor.salad.sketch.saladmaker;

import mentor.salad.sketch.ingredients.Ingredient;
import java.util.*;

/**
 * Created by Andriana on 06.10.2016.
 */
public class Salad {
    Map<Ingredient, Integer> ingredients = new TreeMap<>();
    private String name;

    public Salad(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object object){
        if(object == this)
            return true;
        if((object instanceof Salad) && (((Salad) object).name.equals(this.name)))
            return true;
        else
            return false;
    }
    @Override
    public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            return result;
    }
    String getName(){
        return name;
    }
    public void makeSalad(){
        if(ingredients!=null){
            System.out.println("salad " + name + " was made");
            for (Map.Entry<Ingredient, Integer> i:ingredients.entrySet()) {
                System.out.println(i.getKey().getName());
            }
        }

        else
            System.out.println("there are no ingredients added");

    }

    public void sortSalad(Comparator<Ingredient> comparator){
        System.out.println("sorting " + name + " salad");
    }
    public void calculateCalories(){    }
    public void findIngredientByCalories(int calories){

    }
    public void findIngredientByCalories(int smallerCalorie, int biggerCalorie){

    }
    public void removeIngredientWithCaloriety(int calories){

    }
    public void removeIngredientWithCaloriety(int smallerCalorie, int biggerCalorie){

    }
    public void addIngredient(Ingredient ingredient, int weight){
        if(!ingredients.keySet().contains(ingredient))
            ingredients.put(ingredient, weight);
        else{
            int prevWeight = ingredients.get(ingredient);
            ingredients.put(ingredient, (prevWeight + weight));
        }
    }

    public void removeIngredient(Ingredient ingredient){

    }
    public void decreaseIngredientWeightFor(Ingredient ingredient, int weight){
        if (ingredients.get(ingredient).equals(weight)){
            removeIngredient(ingredient);
        }
        else{

        }
    }
}
