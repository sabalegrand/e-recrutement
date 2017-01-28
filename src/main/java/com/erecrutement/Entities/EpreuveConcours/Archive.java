package com.erecrutement.Entities.EpreuveConcours;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by saba on 19/01/17.
 */
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    // test logique - test algo - test technique ....
    @Column(name = "type_archive")
    private String typeArchive;

    @Column(name = "institut")
    private String institut;

    @Column(name = "chemin")
    private String chemin;

    @Column(name = "type_fichier")
    private String typeFichier;

    public Archive() {
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeArchive() {
        return typeArchive;
    }

    public void setTypeArchive(String typeArchive) {
        this.typeArchive = typeArchive;
    }

    public String getTypeFichier() {
        return typeFichier;
    }

    public void setTypeFichier(String typeFichier) {
        this.typeFichier = typeFichier;
    }
}
