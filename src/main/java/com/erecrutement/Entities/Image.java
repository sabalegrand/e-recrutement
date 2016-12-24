package com.erecrutement.Entities;

import javax.persistence.*;

/**
 * Created by saba on 13/12/16.
 */
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "data")
    private byte[] data;

    public Image() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
