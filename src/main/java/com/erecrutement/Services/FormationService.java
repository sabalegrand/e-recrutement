package com.erecrutement.Services;

import com.erecrutement.Entities.Formation;
import com.erecrutement.Repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saba on 16/12/16.
 */
@Service
public class FormationService implements IFormationService {

    private FormationRepository formationRepository;

    @Autowired
    public FormationService(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @Override
    public Formation save(Formation experience) {
        return formationRepository.save(experience);
    }

    @Override
    public Formation findById(int id) {
        return formationRepository.findById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }
}
