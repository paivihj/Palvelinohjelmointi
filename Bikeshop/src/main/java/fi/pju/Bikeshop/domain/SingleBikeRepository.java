package fi.pju.Bikeshop.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SingleBikeRepository extends CrudRepository<SingleBike, Long> {
	//@Query("SELECT SingleBike FROM SingleBike WHERE size='L'")
	//List<SingleBike> singleBikesOnce();
}

//SingleBike=(SELECT DISTINCT id,size FROM SingleBike)