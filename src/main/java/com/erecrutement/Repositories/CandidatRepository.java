package com.erecrutement.Repositories;

import com.erecrutement.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by saba on 04/12/16.
 */

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer>{

    public Candidat findByUsername(String username);
}
