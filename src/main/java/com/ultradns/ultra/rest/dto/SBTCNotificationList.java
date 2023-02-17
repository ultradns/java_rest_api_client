/*
 * User: nupadhyay
 * Date: Apr 1, 2014
 * Time: 6:33:30 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
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
