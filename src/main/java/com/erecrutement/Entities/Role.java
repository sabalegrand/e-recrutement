package com.erecrutement.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by saba on 06/12/16.
 */
@Entity
public class Role implements Serializable {

    @Id
    private String role;

    private String description;

    public Role() {
    }

    public Role(String role,String description) {
        this.description = description;
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
