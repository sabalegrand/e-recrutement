package com.erecrutement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by saba on 19/12/16.
 */
@Entity
public class Reference {

    @Id
    private int id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "contact")
    private String contact;

    public Reference() {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
