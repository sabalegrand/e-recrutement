package com.erecrutement.Entities.User;


import com.erecrutement.Entities.Image;
import com.erecrutement.Entities.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String passwordConfirm;

    @Column(name = "country", nullable = true)
    private String country;

    @NotNull
    @Column(name = "personalPhoneNumber")
    private String personalPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Image avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES")
    private Collection<Role> roles;

    @OneToMany
    private Collection<Notification> notifications;

    public User() {
        this.roles = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public User(User u) {
        this.username = u.username;
        this.firstName = u.firstName;
        this.lastName = u.lastName;
        this.password = u.password;

        this.roles = new ArrayList<>();
    }

    public User(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        this.roles = new ArrayList<>();
    }

    public User(String country, String firstName, String lastName, String password, String personalPhoneNumber, Collection<Role> roles, String username) {
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.personalPhoneNumber = personalPhoneNumber;
        this.roles = roles;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Collection<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Collection<Notification> notifications) {
        this.notifications = notifications;
    }
}
