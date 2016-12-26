package com.erecrutement.Entities;

import com.erecrutement.Entities.Offres.Offre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
public class Entreprise  extends User {

    @Column(name = "companyName", nullable = true)
    private String companyName;

    //  voir relation
// @Column(name = "adress", nullable = false)
//    public String adress;
//
    @Column(name = "rcNumber", nullable = true, unique = true)
    private String rcNumber;

    @Column(name = "activitySector", nullable = true)
    private String activitySector;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "webSite")
    private String webSite;

    @Column(name = "logo")
    private String logo;

    @Column(name = "professionalPhoneNumber")
    private String professionalPhoneNumber;

    @Column(name = "fax")
    private String fax;

    @OneToMany(mappedBy = "entreprise")
    private Collection<Offre> offres;

    public Entreprise() {
        offres = new ArrayList<>();
    }

    public Entreprise(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);
    }

    public String getActivitySector() {
        return activitySector;
    }

    public void setActivitySector(String activitySector) {
        this.activitySector = activitySector;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getProfessionalPhoneNumber() {
        return professionalPhoneNumber;
    }

    public void setProfessionalPhoneNumber(String professionalPhoneNumber) {
        this.professionalPhoneNumber = professionalPhoneNumber;
    }

    public String getRcNumber() {
        return rcNumber;
    }

    public void setRcNumber(String rcNumber) {
        this.rcNumber = rcNumber;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Collection<Offre> getOffres() {
        return offres;
    }

    public void setOffres(Collection<Offre> offres) {
        this.offres = offres;
    }
}