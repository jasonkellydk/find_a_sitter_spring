package io.deveo.findasitter.app.rating.repositories;

import io.deveo.findasitter.app.rating.entities.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
