/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Notifications.
 */
public class SBTCNotificationList {
    private final List<SBTCNotification> notifications;

    public SBTCNotificationList() {
        super();
        notifications = new ArrayList<>();
    }

    public List<SBTCNotification> getNotifications() {
        return notifications;
    }

    public void add(SBTCNotification notification) {
        notifications.add(notification);
    }

    public SBTCNotification getNotification(String email) {
        int idx = notifications.indexOf(new SBTCNotification(email));
        return idx < 0 ? null : notifications.get(idx);
    }

}
