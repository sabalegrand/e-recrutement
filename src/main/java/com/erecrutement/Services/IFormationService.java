package com.erecrutement.Services;

import com.erecrutement.Entities.Formation;

import java.util.List;

/**
 * Created by saba on 16/12/16.
 */
public interface IFormationService {
    public Formation save(Formation experience);
    public Formation findById(int id);
    public List<Formation> findAll();
}
