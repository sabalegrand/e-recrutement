package com.erecrutement.ViewModels;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by saba on 29/12/16.
 */
@Component
public class OffreViewModel {

    private String title;
    private Date datePublished;
    private byte[] logo;
    private String type;
    private String entreprise;

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
