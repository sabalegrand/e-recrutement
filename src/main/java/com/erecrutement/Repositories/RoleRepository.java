package com.erecrutement.Repositories;

import com.erecrutement.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saba on 06/12/16.
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
