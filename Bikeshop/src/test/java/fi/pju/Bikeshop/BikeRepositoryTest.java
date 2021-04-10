package fi.pju.Bikeshop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.pju.Bikeshop.domain.BikeRepository;
import fi.pju.Bikeshop.domain.SingleBike;
import fi.pju.Bikeshop.domain.SingleBikeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BikeRepositoryTest {
	@Autowired 
	private BikeRepository bikeRepo;
	
	@Autowired
	private SingleBikeRepository sBikeRepo;
	
	@Test
	public void insertSingleBike() {
		SingleBike bike = new SingleBike("M", bikeRepo.findByBrand("Cannondale"));
		sBikeRepo.save(bike);
		assertThat(bike.getId()).isNotNull();
	}
	
	@Test 
	public void deleteBike() {
		SingleBike bike = new SingleBike("M", bikeRepo.findByBrand("Cannondale"));
		sBikeRepo.save(bike);
		List<SingleBike> bikes = sBikeRepo.findBySize("M");
		sBikeRepo.deleteById(bikes.get(0).getId());
		bikes = sBikeRepo.findBySize("M");
		assertThat(bikes).hasSize(0);
	}

}
