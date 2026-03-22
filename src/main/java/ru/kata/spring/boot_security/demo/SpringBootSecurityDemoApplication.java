package ru.kata.spring.boot_security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   RoleRepository roleRepository,
						   PasswordEncoder passwordEncoder) {
		return args -> {

			Role adminRole = new Role(null, "ROLE_ADMIN");
			Role userRole = new Role(null, "ROLE_USER");

			roleRepository.save(adminRole);
			roleRepository.save(userRole);

			User admin = new User();
			admin.setName("admin");
			admin.setEmail("admin@mail.com");
			admin.setPassword(passwordEncoder.encode("123"));

			admin.setRoles(Set.of(adminRole));

			userRepository.save(admin);
		};
	}
}
