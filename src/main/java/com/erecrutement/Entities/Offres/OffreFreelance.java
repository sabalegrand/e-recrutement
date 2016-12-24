package com.erecrutement.Entities.Offres;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
public class OffreFreelance extends Offre {

    @Column(name = "duration")
    private int duration;

    public OffreFreelance() {
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
