package com.demo.auth;

import com.demo.auth.model.user.User;
import com.demo.auth.model.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringAuthApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		User admin = new User("admin", "123456");
		admin.setSuperuser(true);
		userRepository.save(admin);

		User guest = new User("test", "123456");
		userRepository.save(guest);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringAuthApplication.class);
	}
}
