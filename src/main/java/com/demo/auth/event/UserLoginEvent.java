package com.demo.auth.event;

import org.springframework.context.ApplicationEvent;

public class UserLoginEvent extends ApplicationEvent {

    private final String sessionId;

    public UserLoginEvent(String sessionId) {
        super(sessionId);
        this.sessionId =sessionId;
    }
}
