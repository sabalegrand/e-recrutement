package com.erecrutement.ViewModels;

import com.erecrutement.Entities.Offres.Offre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saba on 29/12/16.
 */
public class OffresViewModel {

    private List<OffreViewModel> offres;

    public OffresViewModel() {
        this.offres = new ArrayList<>();
    }

    public List<OffreViewModel> offres() {
        return offres;
    }

    public List<OffreViewModel> getOffres() {
        return offres;
    }

    public void setOffres(List<OffreViewModel> offres) {
        this.offres = offres;
    }
}
