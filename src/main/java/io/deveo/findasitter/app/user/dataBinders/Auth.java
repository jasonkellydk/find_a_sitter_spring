package io.deveo.findasitter.app.user.dataBinders;

public class Auth {
  private String email;

  private String password;

  public Auth() {}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}