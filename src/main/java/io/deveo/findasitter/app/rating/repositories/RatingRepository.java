package io.deveo.findasitter.app.rating.repositories;

import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.user.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
  public List<Rating> findAllByRatingTo(User user);
}
