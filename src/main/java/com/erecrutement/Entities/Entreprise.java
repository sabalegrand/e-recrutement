package com.erecrutement.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by saba on 04/12/16.
 */
@Entity
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

    public Entreprise() {
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
}
