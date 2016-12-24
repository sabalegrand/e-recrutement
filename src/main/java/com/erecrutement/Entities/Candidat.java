package com.erecrutement.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by saba on 04/12/16.
 */
@Entity
@AttributeOverrides({
        @AttributeOverride(name="email", column=@Column(name="email")),
        @AttributeOverride(name="firstName", column=@Column(name="firstName")),
        @AttributeOverride(name="lastName", column=@Column(name="lastName")),
        @AttributeOverride(name="password", column=@Column(name="password")),
        @AttributeOverride(name="personalPhoneNumber", column=@Column(name="personalPhoneNumber")),
        @AttributeOverride(name="country", column=@Column(name="country"))
})
public class Candidat extends User {

    @Column(name = "civility", nullable = true)
    private String civility;

    @Column(name = "function", nullable = true)
    private String function;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Cv> cvs;


    public Candidat() {
        this.cvs = new ArrayList<>();
    }


    public Collection<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(Collection<Cv> cvs) {
        this.cvs = cvs;
    }

    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
