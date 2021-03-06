package io.deveo.findasitter.app.rating.controllers;

import io.deveo.findasitter.app.rating.entities.Rating;
import io.deveo.findasitter.app.rating.dataBinders.RatingDataBinder;
import io.deveo.findasitter.app.rating.services.RatingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RatingController {

  @Autowired
  RatingService ratingService;

  @PostMapping(value = "/ratings")
  public @ResponseBody
  Rating createRating(@RequestBody RatingDataBinder rating, Authentication authentication) {
    return ratingService.createRating(
            rating.getRating(),
            rating.getMessage(),
            authentication,
            rating.getRatingTo()
    );
  }

  @GetMapping(value = "/ratings")
  public @ResponseBody
  List<Rating> findByRatingTo(@RequestParam(required = true) String userId) {
    return ratingService.findByRatingTo(userId);
  }
}
