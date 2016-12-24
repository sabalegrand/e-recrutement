package com.erecrutement.Entities.Offres;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
public class OffreCDD extends Offre {

    @Column(name = "duration")
    private int duration;

    @Column(name = "poste")
    private String poste;

    public OffreCDD() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
