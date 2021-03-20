package fi.pju.Bikeshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.pju.Bikeshop.domain.Bike;
import fi.pju.Bikeshop.domain.BikeRepository;
import fi.pju.Bikeshop.domain.SingleBike;
import fi.pju.Bikeshop.domain.SingleBikeRepository;
import fi.pju.Bikeshop.domain.AppUser;
import fi.pju.Bikeshop.domain.AppUserRepository;

@SpringBootApplication
public class BikeshopApplication {
	
	//private static final Logger log = LoggerFactory.getLogger(BikeshopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BikeshopApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner bikeDemo(BikeRepository bRepository, SingleBikeRepository sRepository, AppUserRepository uRepository) {
		return (args) -> {
			log.info("Save bikes");
			
			Bike giant = new Bike("Giant","MTB", 2013, "AB000456");
			Bike cannondale = new Bike("Cannondale", "SuperSix Evo", 1870, "XY000123");
			
			bRepository.save(giant);
			bRepository.save(cannondale);
			sRepository.save(new SingleBike("L", bRepository.findByBrand("Cannondale")));
			sRepository.save(new SingleBike("L", bRepository.findByBrand("Cannondale")));
			sRepository.save(new SingleBike("L", bRepository.findByBrand("Cannondale")));
			sRepository.save(new SingleBike("M", bRepository.findByBrand("Cannondale")));
			sRepository.save(new SingleBike("L", bRepository.findByBrand("Giant")));
			sRepository.save(new SingleBike("L", bRepository.findByBrand("Giant")));
			sRepository.save(new SingleBike("M", bRepository.findByBrand("Giant")));
			sRepository.save(new SingleBike("S", bRepository.findByBrand("Giant")));
			sRepository.save(new SingleBike("S", bRepository.findByBrand("Giant")));
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);
			
			log.info("Fetch bikes");
			for (SingleBike bike : sRepository.findAll()) {
				log.info(bike.toString());
			}
		};
	}*/

}
