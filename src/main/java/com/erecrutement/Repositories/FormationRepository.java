package com.erecrutement.Repositories;

import com.erecrutement.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saba on 16/12/16.
 */
public interface FormationRepository extends JpaRepository<Formation, Integer>{
    public Formation findById(int id);
}
