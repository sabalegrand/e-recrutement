package com.erecrutement.ViewModels;

import org.springframework.stereotype.Component;

/**
 * Created by saba on 14/12/16.
 */
@Component
public class XeditableForm {
    private String pk;
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
