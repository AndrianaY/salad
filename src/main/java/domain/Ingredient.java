package domain;

import dao.Identified;

/**
 * Created by Andriana on 12.10.2016.
 */
public class Ingredient implements Identified<Integer> {
    private int id;
    private String name;
    private int kalories;
    private int fats;

    @Override
    public Integer getId() {
        return 0;
    }
}
