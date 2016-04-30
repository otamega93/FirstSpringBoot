package hello.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

/**
 * Created by informatica on 29/04/16.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    Long id;

    String username;

    String authorities;

    String password;

    public Account(Long id, String username, String authorities, String password) {
        this.id = id;
        this.username = username;
        this.authorities = authorities;
        this.password = password;
    }

    public Account() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
