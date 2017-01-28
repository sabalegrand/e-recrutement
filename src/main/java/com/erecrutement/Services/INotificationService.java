package com.erecrutement.Services;

import com.erecrutement.Entities.User.Notification;

/**
 * Created by saba on 28/01/17.
 */
public interface INotificationService {
    public Notification save(Notification notification);
    public Notification find(int id);
    public Notification update(Notification notification);
}
