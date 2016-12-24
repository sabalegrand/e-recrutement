package com.erecrutement.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by saba on 14/12/16.
 */
@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "debut")
    private Date debut;

    @Temporal(TemporalType.DATE)
    @Column(name = "fin")
    private Date fin;

    @Column(name = "titre")
    private String titre;

    @Column(name = "lieu")
    private String lieu;

    @Column(name = "description")
    private String description;

    @OneToMany
    private Collection<Reference> references;

    public Experience() {
    }

    public Collection<Reference> getReferences() {
        return references;
    }

    public void setReferences(Collection<Reference> references) {
        this.references = references;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
