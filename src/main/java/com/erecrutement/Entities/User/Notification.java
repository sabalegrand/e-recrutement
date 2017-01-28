package com.erecrutement.Entities.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by saba on 27/01/17.
 */
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "receivedAt")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date receivedAt;

    @Column(name = "seen")
    private boolean seen;

    @Column(name = "redirect_url")
    private String redirectUrl;

    @Column(name = "type")
    private String type;

    public Notification() {
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
