package com.a.redkovsky.carselling;

import com.a.redkovsky.carselling.model.Car;
import com.a.redkovsky.carselling.model.Role;
import com.a.redkovsky.carselling.model.User;
import com.a.redkovsky.carselling.repository.CarRepository;
import com.a.redkovsky.carselling.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarsellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsellingApplication.class, args);
	}

	@Bean
	public CommandLineRunner bootstrap(UserRepository repository, CarRepository carRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("Max", "1", Role.ROLE_ADMIN));
			repository.save(new User("Paul", "2", Role.ROLE_USER));
			repository.save(new User("Marie", "3", Role.ROLE_USER));
			repository.save(new User("Alex", "4", Role.ROLE_USER));
			repository.save(new User("Ilya", "5", Role.ROLE_USER));

			carRepository.save(new Car("BMW", 2000L, "new", repository.findByUsername("Max")));
			carRepository.save(new Car("Mazda", 1000L, "power", repository.findByUsername("Paul")));
			carRepository.save(new Car("Audi", 3000L, "speed", repository.findByUsername("Marie")));
			carRepository.save(new Car("Fiat", 4000L, "quality", repository.findByUsername("Alex")));
			carRepository.save(new Car("Nissan", 5000L, "design", repository.findByUsername("Ilya")));
		};
	}
}
