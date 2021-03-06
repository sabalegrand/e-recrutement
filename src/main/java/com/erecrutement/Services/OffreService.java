package com.erecrutement.Services;

import com.erecrutement.Entities.Offres.Offre;
import com.erecrutement.Repositories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nunna on 24/12/16.
 */
@Service
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
    public Offre update(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public List<Offre> findAll() {
        return offreRepository.findAll();
    }

    @Override
    public Page<Offre> findAll(Pageable pageable) {
        return offreRepository.findAll(pageable);
    }
}
