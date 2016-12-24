package com.erecrutement.Entities.Offres;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
public class OffrePFE extends Offre {

    @Column(name = "duration")
    private int duration;

    @Column(name = "preembauche")
    private boolean preembauche;

    public OffrePFE() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isPreembauche() {
        return preembauche;
    }

    public void setPreembauche(boolean preembauche) {
        this.preembauche = preembauche;
    }
}
