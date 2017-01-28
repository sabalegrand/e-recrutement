package com.erecrutement.Services;

import com.erecrutement.Entities.User.User;

/**
 * Created by saba on 10/12/16.
 */
public interface IUserService {
    public User findByUsername(String username);
    public void delete(String username);
    public User save(User user);
    public User update(User user);
}
