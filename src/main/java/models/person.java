package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by informatica on 12/12/15.
 */
@Entity
public class person {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private String lastName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public person(Long id, String name, String lastName) {
        Id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public person() {
    }
}
