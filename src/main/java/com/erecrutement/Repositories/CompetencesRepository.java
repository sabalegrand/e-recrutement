package com.erecrutement.Repositories;

import com.erecrutement.Entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saba on 28/01/17.
 */
public interface CompetencesRepository extends JpaRepository<Competence, Integer> {
}
