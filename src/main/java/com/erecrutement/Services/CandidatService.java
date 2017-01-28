package com.erecrutement.Services;

import com.erecrutement.Entities.User.Candidat;
import com.erecrutement.Repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by saba on 10/12/16.
 */
@Service
public class CandidatService implements ICandidatService{

    private CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public Candidat find(int id) {
        return candidatRepository.findOne(id);
    }

    @Override
    public Candidat save(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat update(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    @Override
    public void delete(int id) {
        candidatRepository.delete(id);
    }

    @Override
    public Candidat findByUsername(String username) {
        return candidatRepository.findByUsername(username);
    }


}
