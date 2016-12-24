package com.erecrutement.Repositories;

import com.erecrutement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by saba on 06/12/16.
 */
public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsername(String username);

}
