package io.deveo.findasitter.app.user.models;

import io.deveo.findasitter.app.user.entities.Role;

public class UserModel {

  private String email;

  private String name;

  private String password;

  private Role role;

  public UserModel(){}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
