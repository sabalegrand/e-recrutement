package com.erecrutement.Repositories;

import com.erecrutement.Entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saba on 14/12/16.
 */
public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
    public Experience findById(int id);
}
