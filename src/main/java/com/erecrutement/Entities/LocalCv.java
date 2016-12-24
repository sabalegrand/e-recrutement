package com.erecrutement.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by saba on 14/12/16.
 */
@Entity
public class LocalCv extends Cv{

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Competence> competences;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Experience> experiences;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Formation> formations;


    public LocalCv() {
    }

    public Collection<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<Competence> competences) {
        this.competences = competences;
    }

    public Collection<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Collection<Experience> experiences) {
        this.experiences = experiences;
    }

    public Collection<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Collection<Formation> formations) {
        this.formations = formations;
    }
}
