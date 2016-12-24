package com.erecrutement.Repositories;

import com.erecrutement.Entities.Offres.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nunna on 24/12/16.
 */
@Repository

public interface OffreRepository extends JpaRepository<Offre, Integer> {

}
