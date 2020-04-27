package com.demo.auth.listener;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;


@Component
public class RedisHttpSessionListener implements HttpSessionListener {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.info("new session created with id =" + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("new destroyed created with id =" + event.getSession().getId());
    }
}
