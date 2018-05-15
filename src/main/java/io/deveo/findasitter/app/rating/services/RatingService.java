package io.deveo.findasitter.app.rating.services;

import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.rating.repositories.RatingRepository;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import io.deveo.findasitter.app.user.services.AuthService;
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

  public Rating createRating(int rating, String message, Authentication authentication, int ratingTo) {
    User userFrom = userRepository.findByEmail(authentication.getName());
    User userTo = userRepository.findById(ratingTo);
    System.out.println(userFrom.getRole().getId());
    System.out.println(userTo.getRole().getId());

      if(userFrom.getRole().getId() == userTo.getRole().getId()) {
        System.out.println("hit");
        return null;
      }

      Rating rating1 = new Rating();

      rating1.setRating(rating);
      rating1.setMessage(message);
      rating1.setRatingFrom(userFrom);
      rating1.setRatingTo(userTo);

      return ratingRepository.save(rating1);
  }

}
