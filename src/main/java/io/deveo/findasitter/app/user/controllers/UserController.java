package io.deveo.findasitter.app.user.controllers;

import io.deveo.findasitter.app.user.models.UserModel;
import io.deveo.findasitter.app.user.entities.User;
import io.deveo.findasitter.app.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(value = "/users")
  public @ResponseBody
  User createUser(@RequestBody UserModel user) {
    return userService.createUser(user.getEmail(), user.getPassword(), user.getName());
  }

  @GetMapping(value = "/users")
  public @ResponseBody
  List<User> findAll() {
    return userService.findAll();
  }
}
