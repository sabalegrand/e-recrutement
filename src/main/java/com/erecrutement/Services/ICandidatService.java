package com.erecrutement.Services;

import com.erecrutement.Entities.Candidat;

/**
 * Created by saba on 10/12/16.
 */
public interface ICandidatService {
    public Candidat find(int id);
    public Candidat save(Candidat candidat);
    public Candidat update(Candidat candidat);
    public void delete(int id);
    public Candidat findByUsername(String username);
}
