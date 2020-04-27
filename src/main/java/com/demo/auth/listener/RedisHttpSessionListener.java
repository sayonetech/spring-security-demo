package com.demo.auth.listener;

import com.demo.auth.event.UserLoginEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;


@Component
public class RedisHttpSessionListener implements HttpSessionListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("new session created with id =" + event.getSession().getId());
        applicationEventPublisher.publishEvent(new UserLoginEvent(event.getSession().getId()));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("new destroyed created with id =" + event.getSession().getId());
    }
}
