package fi.pju.databasedemo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.pju.databasedemo.domain.Customer;
import fi.pju.databasedemo.domain.CustomerRepository;

@SpringBootApplication
public class DatabasedemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DatabasedemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DatabasedemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner customerDemo(CustomerRepository repository) {
		return (args) -> {
			log.info("Save some customers");
			repository.save(new Customer("Aleksis Kivi", "Järvitie 100, Tuusula"));
			repository.save(new Customer("Lucinda Riley", "23rd Street, New York"));
			
			log.info("Fetch customers");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			
			}
		};
	}
}