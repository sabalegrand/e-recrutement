package com.erecrutement.Entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by nunna on 19/01/17.
 */
@Entity
public class Domaine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  int id;

    @Column(name = "titre")
    private String titre;
    @OneToMany(mappedBy = "domaine")
    private Collection<Metier> metiers;

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

    public Collection<Metier> getMetiers() {
        return metiers;
    }

    public void setMetiers(Collection<Metier> metiers) {
        this.metiers = metiers;
    }
}
