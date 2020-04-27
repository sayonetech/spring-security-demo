package com.demo.auth.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserLoginListener implements ApplicationListener<UserLoginEvent> {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void onApplicationEvent(UserLoginEvent event) {
        logger.info("user logged in");
    }
}
