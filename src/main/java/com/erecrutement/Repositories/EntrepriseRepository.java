package com.erecrutement.Repositories;

import com.erecrutement.Entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saba on 06/12/16.
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

    public Entreprise findByUsername(String username);
}
