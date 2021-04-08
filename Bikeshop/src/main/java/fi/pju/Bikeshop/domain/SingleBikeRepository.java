package fi.pju.Bikeshop.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SingleBikeRepository extends CrudRepository<SingleBike, Long> {
	@Query(value="SELECT * FROM single_bike WHERE id NOT IN (SELECT id FROM order_row)", nativeQuery = true)
	List<SingleBike> findFree();
}

