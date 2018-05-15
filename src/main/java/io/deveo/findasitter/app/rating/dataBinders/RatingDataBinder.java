package io.deveo.findasitter.app.rating.dataBinders;

public class RatingDataBinder {

  private int rating;

  private String message;

  private int ratingTo;

  public RatingDataBinder(){}

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

  public int getRatingTo() {
    return ratingTo;
  }

  public void setRatingTo(int ratingTo) {
    this.ratingTo = ratingTo;
  }
}
