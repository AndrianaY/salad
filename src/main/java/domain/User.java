package domain;

import dao.Identified;

/**
 * Created by Andriana on 12.10.2016.
 */
public class User implements Identified<Integer> {
    private Integer id;
    private String firstName;
    private String lastName;



    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }
}
