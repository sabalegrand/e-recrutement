package com.erecrutement.Entities;

import javax.persistence.Entity;

/**
 * Created by saba on 24/12/16.
 */
@Entity
public class CvPortfolio extends Cv {

    private String url;

    public CvPortfolio() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
