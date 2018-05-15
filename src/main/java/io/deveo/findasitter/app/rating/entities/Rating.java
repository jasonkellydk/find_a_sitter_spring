package io.deveo.findasitter.app.rating.entities;

import io.deveo.findasitter.app.user.entities.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ratings")
public class Rating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int rating;

  private String message;

  @ManyToOne
  private User ratingFrom;

  @ManyToOne
  private User ratingTo;

  public Rating(){}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public User getRatingFrom() {
    return ratingFrom;
  }

  public void setRatingFrom(User ratingFrom) {
    this.ratingFrom = ratingFrom;
  }

  public User getRatingTo() {
    return ratingTo;
  }

  public void setRatingTo(User ratingTo) {
    this.ratingTo = ratingTo;
  }
}
