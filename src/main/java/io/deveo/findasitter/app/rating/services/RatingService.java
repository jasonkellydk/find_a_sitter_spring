package io.deveo.findasitter.app.rating.services;

import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.rating.repositories.RatingRepository;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import io.deveo.findasitter.app.user.services.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class RatingService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AuthService authService;

  @Autowired
  RatingRepository ratingRepository;

  /**
   * @param rating
   * @param message
   * @param authentication
   * @param ratingTo
   * @return
   */
  public Rating createRating(int rating, String message, Authentication authentication, int ratingTo) {
    User userFrom = userRepository.findByEmail(authentication.getName());
    User userTo = userRepository.findById(ratingTo);

    if(userFrom.getRole().getId() == userTo.getRole().getId()) {
      return null;
    }

    Rating ratingEntity = new Rating();

    ratingEntity.setRating(rating);
    ratingEntity.setMessage(message);
    ratingEntity.setRatingFrom(userFrom);
    ratingEntity.setRatingTo(userTo);

    return ratingRepository.save(ratingEntity);
  }

  /**
   * @param userId
   * @return
   */
  public List<Rating> findByRatingTo(String userId) {
    int id = Integer.parseInt(userId);
    User user = userRepository.findById(id);

    return ratingRepository.findAllByRatingTo(user);
  }
}
