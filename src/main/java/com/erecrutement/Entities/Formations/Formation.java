package com.erecrutement.Entities.Formations;

import com.erecrutement.Entities.Domaine;
import com.erecrutement.Entities.Metier;

import javax.persistence.*;
import javax.sound.midi.MetaEventListener;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.Date;

/**
 * Created by nunna on 19/01/17.
 */
@Entity
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "date_debut")
    private Date dateD;

    @Column(name = "date_fin")
    private Date dateF;

    @OneToMany
    private Collection<Domaine> domaines;

    @OneToMany
    private Collection<Metier> metiers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateD() {
        return dateD;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public Collection<Domaine> getDomaines() {
        return domaines;
    }

    public void setDomaines(Collection<Domaine> domaines) {
        this.domaines = domaines;
    }

    public Collection<Metier> getMetiers() {
        return metiers;
    }

    public void setMetiers(Collection<Metier> metiers) {
        this.metiers = metiers;
    }
}
