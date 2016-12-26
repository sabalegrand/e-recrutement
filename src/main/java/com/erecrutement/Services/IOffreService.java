package com.erecrutement.Services;

import com.erecrutement.Entities.Offres.Offre;

import java.util.List;

/**
 * Created by nunna on 24/12/16.
 */
public interface IOffreService {
    public Offre save(Offre offre);
    public void delete(int id);
    public Offre find(int id);
    public Offre update(Offre offre);
    public List<Offre> findAll();
}
