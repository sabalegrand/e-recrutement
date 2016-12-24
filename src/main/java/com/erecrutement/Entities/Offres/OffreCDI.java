package com.erecrutement.Entities.Offres;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by nunna on 24/12/16.
 */
@Entity

public class OffreCDI extends Offre {

    @Column(name = "poste")
   private String poste;

    public OffreCDI() {
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
