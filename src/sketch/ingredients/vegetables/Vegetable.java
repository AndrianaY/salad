package mentor.salad.sketch.ingredients.vegetables;

import mentor.salad.sketch.ingredients.Ingredient;
import mentor.salad.sketch.ingredients.Usage;

/**
 * Created by Andriana on 06.10.2016.
 */
public abstract class Vegetable implements Ingredient{
    String name;
    Usage usage = Usage.RAW;
    int caloriesGrammPerKg;
    int fatsGrammPerKg;

    public Vegetable(String name){
        this.name = name;
    }
    public Vegetable(String name, Usage usage){
        this.name = name;
        this.usage = usage;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getCalories() {
        return 0;
    }

    @Override
    public int getFats() {
        return 0;
    }

    @Override
    public Usage getUsage() {
        return null;
    }

}
