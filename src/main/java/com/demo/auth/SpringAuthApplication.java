package com.demo.auth;

import com.demo.auth.model.user.Addresses;
import com.demo.auth.model.user.User;
import com.demo.auth.model.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthApplication.class);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringAuthApplication.class);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository){
		return (args -> {
			User admin = new User("admin", "123456");
			admin.setSuperuser(true);
			userRepository.save(admin);

			User guest = new User("test", "123456");
			Addresses address = new Addresses();
			address.setAddressLine1("Sayone Technologies");
			address.setAddressLine2("Unit no 501");
			address.setCity("Kochi");
			address.setState("Kerala");
			address.setZipCode("586020");
			address.setCountry("India");
			guest.getUserAddresses().add(address);
			userRepository.save(guest);

		});

	}
}
