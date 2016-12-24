package com.erecrutement.Services;

import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Repositories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nunna on 24/12/16.
 */
public class OffreService implements IOffreService {

    private OffreRepository offreRepository;

    @Autowired
    public OffreService(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    @Override
    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void delete(int id) {
         offreRepository.delete(id);
    }

    @Override
    public Offre find(int id) {
        return offreRepository.findOne(id);
    }

    @Override
    public List<Offre> findAll() {
        return offreRepository.findAll();
    }
}
