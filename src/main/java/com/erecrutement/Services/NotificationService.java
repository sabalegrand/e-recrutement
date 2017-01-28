package com.erecrutement.Services;

import com.erecrutement.Entities.User.Notification;
import com.erecrutement.Repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by saba on 28/01/17.
 */
@Service
public class NotificationService implements INotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification find(int id) {
        return notificationRepository.findOne(id);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }
}
