package com.erecrutement.Services;

import com.erecrutement.Entities.Experience;
import com.erecrutement.Repositories.ExperienceRepository;

import java.util.List;

/**
 * Created by saba on 14/12/16.
 */
public interface IExperienceService{
    public Experience save(Experience experience);
    public Experience findById(int id);
    public List<Experience> findAll();
}
