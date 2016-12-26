package com.erecrutement.Entities.Offres;

import com.erecrutement.Entities.Candidat;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
public class OffreCandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Offre offre;

    @ManyToOne
    private Candidat candidat;

    @Column(name = "datePostul")
    private Date datePostul;

    @Column(name = "state")
    private String state;

    public OffreCandidat() {
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Date getDatePostul() {
        return datePostul;
    }

    public void setDatePostul(Date datePostul) {
        this.datePostul = datePostul;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
