package io.deveo.findasitter.app.rating.commands;

import com.github.javafaker.Faker;
import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.rating.repositories.RatingRepository;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class GenerateRatingsCommand {

  private UserRepository userRepository;

  private RatingRepository ratingRepository;

  @Autowired
  public GenerateRatingsCommand(UserRepository userRepository, RatingRepository ratingRepository) {
    this.userRepository = userRepository;
    this.ratingRepository = ratingRepository;
  }

  @ShellMethod("Generate random ratings")
  public String generate_ratings() {
    List<User> users = userRepository.findAll();
    List<Rating> ratings = new ArrayList();

    for (User user : users) {
      for (int i = 0; i < 10; i++) {
        Faker faker = new Faker(new Locale("da-DK"));
        Rating rating = new Rating();
        rating.setMessage(faker.yoda().quote());
        rating.setRating(faker.random().nextInt(1, 5));
        rating.setRatingFrom(user);
        rating.setRatingTo(user);

        ratings.add(rating);
      }

      ratingRepository.saveAll(ratings);
      ratings.clear();
    }

    return "Your ratings have been generated <3";
  }
}
