package domain;

import dao.Identified;

import java.util.Map;

/**
 * Created by Andriana on 12.10.2016.
 */
public class Salad implements Identified<Integer> {
    private Integer id;
    private String name;
//    private Map<Integer, Integer> ingredientsInSalad; //ingredientId, weight
    private User user;



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

}
