package com.erecrutement.Entities.Offres;

import com.erecrutement.Entities.Entreprise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by nunna on 24/12/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "place")
    private String place;

    @Column(name = "description")
    private String description;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "datePublished", nullable = false)
    private Date datePublished;

    @Column(name = "dateEnd")
    private Date dateEnd;

    @Column(name = "remuneration")
    private float remuneration;

    @Column(name = "missions")
    private String missions;

    @Column(name = "requis")
    private String requis;

    @Column(name = "domain")
    private String domain;

    @Column(name = "metier")
    private String metier;

    @Column(name = "niveau")
    private String niveau;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "offre")
    private Collection<OffreCandidat> offreCandidats;

    public Offre() {
        offreCandidats =new ArrayList<>();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Collection<OffreCandidat> getOffreCandidats() {
        return offreCandidats;
    }

    public void setOffreCandidats(Collection<OffreCandidat> offreCandidats) {
        this.offreCandidats = offreCandidats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public float getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(float remuneration) {
        this.remuneration = remuneration;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions(String missions) {
        this.missions = missions;
    }

    public String getRequis() {
        return requis;
    }

    public void setRequis(String requis) {
        this.requis = requis;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offre offre = (Offre) o;

        return id == offre.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
