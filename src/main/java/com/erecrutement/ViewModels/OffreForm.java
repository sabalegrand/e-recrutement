package com.erecrutement.ViewModels;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by saba on 26/12/16.
 */
@Component
public class OffreForm {

    private String title;

    private String place;

    private String description;

//    private Date dateEnd;

    private String remuneration;

    private String missions;

    private String requis;

    private String secteur;

    private String duration;

    private String poste;

    private boolean preembauche;

    private String metier;

    private String niveau;

    private String type;

    public String getRequis() {
        return requis;
    }

    public void setRequis(String requis) {
        this.requis = requis;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public boolean isPreembauche() {
        return preembauche;
    }

    public void setPreembauche(boolean preembauche) {
        this.preembauche = preembauche;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions(String missions) {
        this.missions = missions;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
