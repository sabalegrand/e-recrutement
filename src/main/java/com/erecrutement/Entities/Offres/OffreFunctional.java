package com.erecrutement.Entities.Offres;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
public class OffreFunctional extends Offre {

    @Column(name = "convetion")
    private boolean convention;

    @Column(name = "duration")
    private String duration;

    public OffreFunctional() {
    }

    public boolean isConvention() {
        return convention;
    }

    public void setConvention(boolean convention) {
        this.convention = convention;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}