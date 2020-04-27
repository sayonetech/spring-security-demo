package com.demo.auth.event;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        //by default No events will be published if authentication was unsuccessful, because this would generally be recorded via an AuthenticationManager-specific application event.
        //This is overrided by the security configuration
        logger.info("authentication failed with bad credentials");
    }
}
