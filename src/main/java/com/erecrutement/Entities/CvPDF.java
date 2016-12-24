package com.erecrutement.Entities;

import javax.persistence.*;

/**
 * Created by saba on 19/12/16.
 */
@Entity
public class CvPDF extends Cv{

    @Column(name = "name")
    private String name;

    @Column(name = "data", nullable = false)
    @Lob
    private byte[] data;

    public CvPDF() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
