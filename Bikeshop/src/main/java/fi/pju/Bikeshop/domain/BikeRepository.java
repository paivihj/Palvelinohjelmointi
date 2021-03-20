package fi.pju.Bikeshop.domain;

import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, Long> {

	Bike findByBrand(String brand);
}
