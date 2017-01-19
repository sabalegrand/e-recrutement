package com.erecrutement.Entities;

import javax.persistence.*;

/**
 * Created by nunna on 19/01/17.
 */
@Entity
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "titre")
    private String titre;

    @ManyToOne
    private  Domaine domaine;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}
