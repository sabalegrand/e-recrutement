package com.erecrutement.Services;

import com.erecrutement.Entities.User;

/**
 * Created by saba on 10/12/16.
 */
public interface IUserService {
    public User findByUsername(String username);
    public void delete(String username);
}
