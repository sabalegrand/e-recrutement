package com.erecrutement.ViewModels;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by saba on 09/01/17.
 */
@Component
public class EntrepriseOffreDetailsViewModel {

    private int id;
    private int offreCandidatId;
    private String firstName;
    private String lastName;
    private String personalPhoneNumber;
    private String username;
    private String state;
    private Date datePostul;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOffreCandidatId() {
        return offreCandidatId;
    }

    public void setOffreCandidatId(int offreCandidatId) {
        this.offreCandidatId = offreCandidatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatePostul() {
        return datePostul;
    }

    public void setDatePostul(Date datePostul) {
        this.datePostul = datePostul;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
