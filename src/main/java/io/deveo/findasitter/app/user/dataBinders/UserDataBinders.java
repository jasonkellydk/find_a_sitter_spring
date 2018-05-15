package io.deveo.findasitter.app.user.dataBinders;

import io.deveo.findasitter.app.user.entities.Role;

public class UserDataBinders {

  private String email;

  private String name;

  private String password;

  private Role role;

  public UserDataBinders(){}

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
