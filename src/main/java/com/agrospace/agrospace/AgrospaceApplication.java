package com.agrospace.agrospace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.agrospace.agrospace.Models.Role;
import com.agrospace.agrospace.Models.User;
import com.agrospace.agrospace.repository.UserRepository;

@SpringBootApplication
public class AgrospaceApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgrospaceApplication.class, args);
	}

	public void run(String... args){
		User userAdminAccount = userRepository.findByRole(Role.ADMIN);

		if (userAdminAccount == null) {
			User user = new User();

			user.setEmail("vergez@gmail.com");
			user.setFirstName("Vergez");
			user.setLastName("Kenfack");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("adminpass"));
			userRepository.save(user);
		}
	}

}
