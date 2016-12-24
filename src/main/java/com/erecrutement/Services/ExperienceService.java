package com.erecrutement.Services;

import com.erecrutement.Entities.Experience;
import com.erecrutement.Repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saba on 14/12/16.
 */
@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience findById(int id) {
        return experienceRepository.findById(id);
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }
}
